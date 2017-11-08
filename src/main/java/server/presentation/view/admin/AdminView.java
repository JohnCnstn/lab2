package server.presentation.view.admin;

import server.data.parser.DOMXmlModifier;
import server.data.parser.DOMXmlReader;
import server.data.parser.DOMXmlWriter;
import server.data.profile.EditProfileData;
import server.data.profile.Profile;
import server.presentation.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminView extends View implements EditProfileData {

    public AdminView(PrintWriter out, BufferedReader in) {
        super(out, in);
    }

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        int i = 1 + DOMXmlReader.getNumberOfElements() + 1;
        out.println(i);
        out.println("Your role is Admin (you can modify profiles)");
        DOMXmlReader.read(out);

        editProfileData(out, in);

        i = DOMXmlReader.getNumberOfElements();
        out.println(i);
        DOMXmlReader.read(out);
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
            DOMXmlModifier.modify(id, name, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
