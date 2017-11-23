package server.objects.presentation.view.admin;

import org.springframework.stereotype.Component;
import server.objects.data.profile.EditProfileData;
import server.objects.presentation.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AdminView extends View implements EditProfileData {

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        int i = 1 + getXmlFileDao().getNumberOfElements() + 1;
        out.println(i);
        out.println("Your role is Admin (you can modify profiles)");
        getXmlFileDao().read(out);
        editProfileData(out, in);

        i = getXmlFileDao().getNumberOfElements();
        out.println(i);
        getXmlFileDao().read(out);
    }

    @Override
    public void editProfileData(PrintWriter out, BufferedReader in) {
        try {
            out.println("Write id of profile you want to modify");
            int id = Integer.parseInt(in.readLine());
            out.println(1);
            out.println("Write name of field you want to modify");
            String name = in.readLine();
            out.println(1);
            out.println("Write value you want to set");
            String value = in.readLine();
            getXmlFileDao().modify(id, name, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
