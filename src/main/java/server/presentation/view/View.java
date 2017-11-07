package server.presentation.view;

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

    public View(PrintWriter out) {
        setViewForUser(out);
    }
}
