package server.presentation.view;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class View implements IView {

    private int usersChoice;

    @Override
    public void setChoice(int i) {

    }

    @Override
    public int getChoice() {
        return usersChoice;
    }

    public View(PrintWriter out, BufferedReader in) {
        setViewForUser(out, in);
    }
}
