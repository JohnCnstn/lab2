package server.objects.data.dao;

import org.springframework.stereotype.Component;
import server.objects.data.parser.DOMXmlModifier;
import server.objects.data.parser.DOMXmlReader;
import server.objects.data.parser.DOMXmlWriter;
import server.objects.data.profile.impl.Profile;

import java.io.PrintWriter;

@Component
public class XmlFileDao implements Dao {

    @Override
    public void create() {
        DOMXmlWriter.create();
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
