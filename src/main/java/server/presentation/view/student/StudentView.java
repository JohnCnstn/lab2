package server.presentation.view.student;

import server.presentation.view.View;

import java.io.PrintWriter;

public class StudentView extends View {

    public StudentView(PrintWriter out) {
        super(out);
    }

    @Override
    public void setViewForUser(PrintWriter out) {
        out.println(1);
        out.println("Your role is Student (you can add your profile)");
    }
}
