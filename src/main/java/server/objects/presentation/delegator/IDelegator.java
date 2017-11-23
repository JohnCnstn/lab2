package server.objects.presentation.delegator;

import server.objects.presentation.view.IView;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface IDelegator {
    IView whatView(int i);
    void setGreetingView(PrintWriter out, BufferedReader in);
}
