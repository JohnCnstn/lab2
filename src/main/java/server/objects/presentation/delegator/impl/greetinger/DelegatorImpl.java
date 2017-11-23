package server.objects.presentation.delegator.impl.greetinger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.objects.presentation.delegator.Delegator;
import server.objects.presentation.view.IView;
import server.objects.presentation.view.admin.AdminView;
import server.objects.presentation.view.greetinger.GreetingView;
import server.objects.presentation.view.reader.ReaderView;
import server.objects.presentation.view.student.StudentView;

import java.io.BufferedReader;
import java.io.PrintWriter;

@Component
public class DelegatorImpl extends Delegator {

    private PrintWriter out;
    private BufferedReader in;

    private IView view;

    @Autowired
    private GreetingView greetingView;

    @Autowired
    private ReaderView readerView;

    @Autowired
    private StudentView studentView;

    @Autowired
    private AdminView adminView;

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
                readerView.setViewForUser(out, in);
                view = readerView;
                break;
            }
            case 2: {
                studentView.setViewForUser(out, in);
                view = studentView;
                break;
            }
            case 3: {
                adminView.setViewForUser(out, in);
                view = adminView;
                break;
            }
        }
    }

    public void setGreetingView(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
        greetingView.setViewForUser(out, in);
        view = greetingView;
    }
}
