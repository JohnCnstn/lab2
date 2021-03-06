package server.objects.data.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMXmlWriter {

    public static void create(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            // создаем пустой объект Document, в котором будем
            // создавать наш xml-файл
            Document doc = builder.newDocument();
            // создаем корневой элемент
            Element rootElement =
                    doc.createElementNS("by.BSUIR", "Profiles");
            // добавляем корневой элемент в объект Document
            doc.appendChild(rootElement);

            //создаем объект TransformerFactory для печати в консоль
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // для красивого вывода в консоль
            DOMSource source = new DOMSource(doc);

            //печатаем в файл
            StreamResult file = new StreamResult(new File("xml/profiles.xml"));

            //записываем данные
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(String id, String firstName, String secondName, String university, String avgScore){
        String filepath = "xml/profiles.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Element element =
                    doc.getDocumentElement();

            element.appendChild(getProfile(doc, id, firstName, secondName,
                    university, avgScore));

            //создаем объект TransformerFactory для печати в консоль
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);

            //печатаем в файл
            StreamResult file = new StreamResult(new File("xml/profiles.xml"));

            //записываем данные
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // метод для создания нового узла XML-файла
    private static Node getProfile(Document doc, String id, String firstName, String secondName,
                                   String university, String avgScore) {

        Element studentProfile = doc.createElement("Student");

        studentProfile.setAttribute("id", id);

        studentProfile.appendChild(getProfileElements(doc, studentProfile, "id", id));

        studentProfile.appendChild(getProfileElements(doc, studentProfile, "firstName", firstName));

        studentProfile.appendChild(getProfileElements(doc, studentProfile, "secondName", secondName));

        studentProfile.appendChild(getProfileElements(doc, studentProfile, "university", university));

        studentProfile.appendChild(getProfileElements(doc, studentProfile, "avgScore", avgScore));

        return studentProfile;
    }

    // утилитный метод для создание нового узла XML-файла
    private static Node getProfileElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
