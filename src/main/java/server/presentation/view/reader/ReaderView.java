package server.presentation.view.reader;

import server.presentation.view.View;

import java.io.PrintWriter;

public class ReaderView extends View {

    public ReaderView(PrintWriter out) {
        super(out);
    }

    @Override
    public void setViewForUser(PrintWriter out) {
        out.println(1);
        out.println("Your role is reader (you can read profile)");
    }
}
