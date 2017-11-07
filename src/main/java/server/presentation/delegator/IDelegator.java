package server.presentation.delegator;

import server.presentation.view.IView;

public interface IDelegator {
    IView whatView(int i);
}
