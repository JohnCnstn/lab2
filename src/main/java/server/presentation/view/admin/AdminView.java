package server.presentation.view.admin;

import server.presentation.view.View;

import java.io.PrintWriter;

public class AdminView extends View {

    public AdminView(PrintWriter out) {
        super(out);
    }

    @Override
    public void setViewForUser(PrintWriter out) {
        out.println(1);
        out.println("Your role is admin (you can modify profile)");
    }
}
