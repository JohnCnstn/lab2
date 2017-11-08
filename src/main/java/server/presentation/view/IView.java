package server.presentation.view;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface IView {
    void setViewForUser(PrintWriter out, BufferedReader in);
    void setChoice(int i);
    int getChoice();
}
