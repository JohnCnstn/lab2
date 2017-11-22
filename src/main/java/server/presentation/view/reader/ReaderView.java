package server.presentation.view.reader;

import server.data.profile.GetProfileData;
import server.data.profile.impl.Profile;
import server.presentation.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReaderView extends View implements GetProfileData {

    private Profile profile;

    public ReaderView(PrintWriter out, BufferedReader in) {
        super(out, in);
    }

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        int i = 1 + getXmlFileDao().getNumberOfElements() + 1;
        out.println(i);
        out.println("Your role is Reader (you can read profile)");
        getXmlFileDao().read(out);

        getProfileData(out, in);

        out.println(2);

        out.println(profile.toString());
        out.println("exit");
    }

    @Override
    public void getProfileData(PrintWriter out, BufferedReader in) {
        try {
            profile = new Profile();
            out.println("Write profile you want to get by id");
            profile = getXmlFileDao().getProfileById(Integer.parseInt(in.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
