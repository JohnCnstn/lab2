package server.presentation.view.student;

import server.data.parser.DOMXmlReader;
import server.data.parser.DOMXmlWriter;
import server.data.profile.SetProfileData;
import server.data.profile.Profile;
import server.presentation.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentView extends View implements SetProfileData {

    private Profile profile;

    public StudentView(PrintWriter out, BufferedReader in) {
        super(out, in);
    }

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        int i = 1 + DOMXmlReader.getNumberOfElements() + 1;
        out.println(i);
        out.println("Your role is Student (you can add your profile)");
        DOMXmlReader.read(out);

        setProfileData(out, in);

        DOMXmlWriter.write(String.valueOf(profile.getId()), profile.getFirstName(), profile.getSecondName(),
                profile.getUniversity(), String.valueOf(profile.getAvgScore()));

        i = DOMXmlReader.getNumberOfElements();
        out.println(i);
        DOMXmlReader.read(out);
    }

    @Override
    public void setProfileData(PrintWriter out, BufferedReader in) {
        try {
            profile = new Profile();
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
