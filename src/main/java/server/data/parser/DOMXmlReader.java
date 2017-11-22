package server.data.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import server.data.profile.impl.Profile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DOMXmlReader {

    public static void read(PrintWriter out) {
        String filepath = "D:/JohnCnstn/BSUIR/3k1s/java/lab2/xml/profiles.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());

            // получаем узлы с именем Archive
            // теперь XML полностью загружен в память
            // в виде объекта Document

            NodeList nodeList = document.getElementsByTagName("Student");

            // создадим из него список объектов Archive
            List<Profile> profileList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                profileList.add(getProfile(nodeList.item(i)));
            }

            // печатаем в консоль информацию по каждому объекту Archive
            for (Profile lang : profileList) {
                out.println(lang.toString());
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static int getNumberOfElements() {
        String filepath = "D:/JohnCnstn/BSUIR/3k1s/java/lab2/xml/profiles.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        int numberOfElements = 0;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());

            // получаем узлы с именем Archive
            // теперь XML полностью загружен в память
            // в виде объекта Document

            NodeList nodeList = document.getElementsByTagName("Student");

            numberOfElements = nodeList.getLength();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return numberOfElements;
    }

    private static Profile getProfile(Node node) {
        Profile profile = new Profile();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;

            profile.setId(Integer.parseInt(getTagValue("id", element)));
            profile.setFirstName(getTagValue("firstName", element));
            profile.setSecondName(getTagValue("secondName", element));
            profile.setUniversity(getTagValue("university", element));
            profile.setAvgScore(Byte.parseByte(getTagValue("avgScore", element)));
        }

        return profile;
    }

    public static Profile getProfileById(int id) {
        String filepath = "D:/JohnCnstn/BSUIR/3k1s/java/lab2/xml/profiles.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Profile profile = new Profile();
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());

            // получаем узлы с именем Archive
            // теперь XML полностью загружен в память
            // в виде объекта Document

            NodeList nodeList = document.getElementsByTagName("Student");

            profile = getProfile(nodeList.item(id));

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return profile;
    }

    // получаем значение элемента по указанному тегу
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

}
