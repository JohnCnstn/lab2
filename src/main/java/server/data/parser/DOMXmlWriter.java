package server.data.parser;

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

    public static void write(){
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

            // добавляем первый дочерний элемент к корневому
            rootElement.appendChild(getProfile(doc, "1", "Pavel", "Khankevich",
                    "BSUIR", "6"));

            //добавляем второй дочерний элемент к корневому
            rootElement.appendChild(getProfile(doc, "2", "Bogdan", "Fedorenko",
                    "BSUIR", "7"));

            //создаем объект TransformerFactory для печати в консоль
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // для красивого вывода в консоль
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //печатаем в консоль или файл
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("D:/JohnCnstn/BSUIR/3k1s/java/lab2/xml/profiles.xml"));

            //записываем данные
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Создание XML файла закончено");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // метод для создания нового узла XML-файла
    private static Node getProfile(Document doc, String id, String firstName, String secondName,
                                   String university, String avgScore) {

        Element studentProfile = doc.createElement("Student");

        // устанавливаем атрибут id
        studentProfile.setAttribute("id", id);

        // создаем элемент name
        studentProfile.appendChild(getLanguageElements(doc, studentProfile, "firstName", firstName));

        studentProfile.appendChild(getLanguageElements(doc, studentProfile, "secondName", secondName));

        studentProfile.appendChild(getLanguageElements(doc, studentProfile, "university", university));

        studentProfile.appendChild(getLanguageElements(doc, studentProfile, "avgScore", avgScore));

        return studentProfile;
    }


    // утилитный метод для создание нового узла XML-файла
    private static Node getLanguageElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
