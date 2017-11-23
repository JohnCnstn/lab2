package server.objects.presentation.view.greetinger;

import org.springframework.stereotype.Component;
import server.objects.presentation.view.View;

import java.io.BufferedReader;
import java.io.PrintWriter;

@Component
public class GreetingView extends View {

    @Override
    public void setViewForUser(PrintWriter out, BufferedReader in) {
        out.println(5);
        out.println("Hello again Walker ;) \nWrite your role for me pls \nPress 1 for role Reader" +
                "\nPress 2 for role Student \nPress 3 for role Admin");
    }
}
