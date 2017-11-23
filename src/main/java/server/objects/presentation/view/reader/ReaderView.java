package server.objects.presentation.view.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.objects.data.profile.GetProfileData;
import server.objects.data.profile.impl.Profile;
import server.objects.presentation.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ReaderView extends View implements GetProfileData {

    @Autowired
    private Profile profile;

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
            out.println("Write profile you want to get by id");
            profile = getXmlFileDao().getProfileById(Integer.parseInt(in.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
