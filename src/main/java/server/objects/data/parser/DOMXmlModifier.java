package server.objects.data.parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMXmlModifier {

    public static void modify(int id, String name, String value) {
        String filepath = "xml/profiles.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // обновляем значения
            updateElementValue(doc, id, name, value);

            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            //печатаем в файл
            StreamResult file = new StreamResult(new File("xml/profiles.xml"));

            //записываем данные
            transformer.transform(source, file);

            System.out.println("XML успешно изменен!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    // изменяем значение существующего элемента name
    private static void updateElementValue(Document doc, int id, String node, String value) {
        NodeList languages = doc.getElementsByTagName("Student");
        Element profile;
        profile = (Element) languages.item(id);
        Node name = profile.getElementsByTagName(node).item(0).getFirstChild();
        name.setNodeValue(value);
    }
}
