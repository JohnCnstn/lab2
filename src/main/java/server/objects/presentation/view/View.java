package server.objects.presentation.view;

import org.springframework.beans.factory.annotation.Autowired;
import server.objects.data.dao.Dao;

public abstract class View implements IView {

    @Autowired
    private Dao xmlFileDao;

    @Override
    public Dao getXmlFileDao() {
        return xmlFileDao;
    }
}
