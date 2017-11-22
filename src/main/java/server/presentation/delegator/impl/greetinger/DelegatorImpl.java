package server.presentation.delegator.impl.greetinger;

import server.presentation.delegator.Delegator;
import server.presentation.view.IView;
import server.presentation.view.admin.AdminView;
import server.presentation.view.greetinger.GreetingView;
import server.presentation.view.headadmin.HeadAdminView;
import server.presentation.view.reader.ReaderView;
import server.presentation.view.student.StudentView;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class DelegatorImpl extends Delegator {

    PrintWriter out;
    BufferedReader in;

    private IView view;

    @Override
    public IView whatView(int i) {
        if (view instanceof GreetingView) {
            setRoleView(i);
        }
        return view;
    }

    private void setRoleView(int i) {
        switch (i) {
            case 1: {
                view = new ReaderView(out, in);
                break;
            }
            case 2: {
                view = new StudentView(out, in);
                break;
            }
            case 3: {
                view = new AdminView(out, in);
                break;
            }
            case 4: {
                view = new HeadAdminView(out, in);
                break;
            }
        }
    }

    public DelegatorImpl(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
        view = new GreetingView(out, in);
    }
}
