package server.presentation.view.greetinger;

import server.presentation.view.View;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class GreetingView extends View {

    public GreetingView(PrintWriter out, BufferedReader in) {
        super(out, in);
    }

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        out.println(6);
        out.println("Hello again Walker ;) \nWrite your role for me pls \nPress 1 for role Reader" +
                "\nPress 2 for role Student \nPress 3 for role Admin \nPress 4 for role Head Admin");
    }
}
