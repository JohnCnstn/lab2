package server.data.dao;

import server.data.profile.impl.Profile;

import java.io.PrintWriter;

public interface Dao {
    void create(String id, String firstName, String secondName, String university, String avgScore);
    void write(String id, String firstName, String secondName, String university, String avgScore);
    void read(PrintWriter out);
    void modify(int id, String name, String value);
    Profile getProfileById(int id);
    int getNumberOfElements();
}
