package server.data.dao;

import server.data.parser.DOMXmlModifier;
import server.data.parser.DOMXmlReader;
import server.data.parser.DOMXmlWriter;
import server.data.profile.impl.Profile;

import java.io.PrintWriter;

public class XmlFileDao implements Dao {

    @Override
    public void create(String id, String firstName, String secondName, String university, String avgScore) {
        DOMXmlWriter.create(id, firstName, secondName, university, avgScore);
    }

    @Override
    public void write(String id, String firstName, String secondName, String university, String avgScore) {
        DOMXmlWriter.write(id, firstName, secondName, university, avgScore);
    }

    @Override
    public void read(PrintWriter out) {
        DOMXmlReader.read(out);
    }

    @Override
    public void modify(int id, String name, String value) {
        DOMXmlModifier.modify(id, name, value);
    }

    @Override
    public Profile getProfileById(int id) {
        return DOMXmlReader.getProfileById(id);
    }

    @Override
    public int getNumberOfElements() {
        return DOMXmlReader.getNumberOfElements();
    }
}
