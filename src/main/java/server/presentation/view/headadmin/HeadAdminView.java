package server.presentation.view.headadmin;

import server.data.profile.EditProfileData;
import server.data.profile.SetProfileData;
import server.data.profile.impl.Profile;
import server.presentation.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HeadAdminView extends View implements SetProfileData {

    private Profile profile;

    public HeadAdminView(PrintWriter out, BufferedReader in) {
        super(out, in);
    }

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        int i = 1 + 1;
        out.println(i);
        out.println("Your role is Head Admin (you can create archive)");

        setProfileData(out, in);

        getXmlFileDao().create(String.valueOf(profile.getId()), profile.getFirstName(), profile.getSecondName(),
                profile.getUniversity(), String.valueOf(profile.getAvgScore()));

        i = getXmlFileDao().getNumberOfElements();
        out.println(i);
        getXmlFileDao().read(out);
    }

    @Override
    public void setProfileData(PrintWriter out, BufferedReader in) {
        try {
            profile = new Profile();
            out.println("Write id you want to set");
            profile.setId(Integer.parseInt(in.readLine()));
            out.println(1);
            out.println("Write FirstName you want to set");
            profile.setFirstName(in.readLine());
            out.println(1);
            out.println("Write SecondName you want to set");
            profile.setSecondName(in.readLine());
            out.println(1);
            out.println("Write University you want to set");
            profile.setUniversity(in.readLine());
            out.println(1);
            out.println("Write AvgScore you want to set");
            profile.setAvgScore(Byte.parseByte(in.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
