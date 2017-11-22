package server.presentation.view;

import server.data.dao.Dao;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface IView {
    void setViewForUser(PrintWriter out, BufferedReader in);
    Dao getXmlFileDao();
}
