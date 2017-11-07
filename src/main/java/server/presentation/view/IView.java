package server.presentation.view;

import java.io.PrintWriter;

public interface IView {
    void setViewForUser(PrintWriter out);
    void setChoice(int i);
    int getChoice();
}
