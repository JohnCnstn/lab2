package server.objects.presentation.view.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.objects.data.profile.SetProfileData;
import server.objects.data.profile.impl.Profile;
import server.objects.presentation.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class StudentView extends View implements SetProfileData {

    @Autowired
    private Profile profile;

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        int i = 1 + getXmlFileDao().getNumberOfElements() + 1;
        out.println(i);
        out.println("Your role is Student (you can add your profile)");

        getXmlFileDao().read(out);

        setProfileData(out, in);

        getXmlFileDao().write(String.valueOf(profile.getId()), profile.getFirstName(), profile.getSecondName(),
                profile.getUniversity(), String.valueOf(profile.getAvgScore()));

        i = getXmlFileDao().getNumberOfElements();
        out.println(i);
        getXmlFileDao().read(out);
    }

    @Override
    public void setProfileData(PrintWriter out, BufferedReader in) {
        try {
            out.println("Write your id pls");
            profile.setId(Integer.parseInt(in.readLine()));
            out.println(1);
            out.println("Write your FirstName pls");
            profile.setFirstName(in.readLine());
            out.println(1);
            out.println("Write your SecondName pls");
            profile.setSecondName(in.readLine());
            out.println(1);
            out.println("Write your University pls");
            profile.setUniversity(in.readLine());
            out.println(1);
            out.println("Write your AvgScore pls");
            profile.setAvgScore(Byte.parseByte(in.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
