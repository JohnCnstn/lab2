package server.presentation.view.greetinger;

import server.presentation.view.View;

import java.io.PrintWriter;

public class GreetingView extends View {

    public GreetingView(PrintWriter out) {
        super(out);
    }

    @Override
    public void setViewForUser(PrintWriter out) {
        out.println(5);
        out.println("Hello again Walker ;) \nWrite your role for me pls \nPress 1 for role Reader" +
                "\nPress 2 for role Student \nPress 3 for role Admin");
    }
}
