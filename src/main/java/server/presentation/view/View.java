package server.presentation.view;

import server.data.dao.Dao;
import server.data.dao.XmlFileDao;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class View implements IView {

    private Dao xmlFileDao = new XmlFileDao();

    @Override
    public Dao getXmlFileDao() {
        return xmlFileDao;
    }

    public View(PrintWriter out, BufferedReader in) {
        setViewForUser(out, in);
    }
}
