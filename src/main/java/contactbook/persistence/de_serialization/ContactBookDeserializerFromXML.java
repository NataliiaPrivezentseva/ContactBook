package contactbook.persistence.de_serialization;

import contactbook.logic.builders.ContactBuilder;
import contactbook.logic.builders.PersonBuilder;
import contactbook.model.Contact;
import contactbook.model.EMail;
import contactbook.model.PhoneNumber;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactBookDeserializerFromXML implements ContactBookDeserializer {

    @Override
    public List<Contact> turnIntoContactBook(List<String> inputInStrings) {
        //todo выписать inputInStrings в файл и работать с этим файлом, может, создать временный файл, который будет
        //todo сам удаляться?
        List<Contact> contactBook = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            File file = new File("c:\\test_xml.xml");

            Document document = documentBuilder.parse(file);

            NodeList contactNodeList = document.getElementsByTagName("contact");
            for (int i = 0; i < contactNodeList.getLength(); i++) {
                if (contactNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element contactElement = (Element) contactNodeList.item(i);
                    ContactBuilder contactBuilder = new ContactBuilder();

                    NodeList childNodeList = contactElement.getChildNodes();
                    for (int j = 0; j < childNodeList.getLength(); j++) {
                        if (childNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNodeList.item(j);

                            switch (childElement.getNodeName()) {
                                case "person":
                                    NodeList personNodeList = childElement.getChildNodes();
                                    PersonBuilder personBuilder = new PersonBuilder();
                                    for (int k = 0; k < personNodeList.getLength(); k++) {
                                        if (personNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                                            Element personElement = (Element) personNodeList.item(k);

                                            switch (personElement.getNodeName()) {
                                                case "firstName":
                                                    personBuilder.withFirstName(personElement.getTextContent());
                                                    break;
                                                case "lastName":
                                                    personBuilder.withLastName(personElement.getTextContent());
                                                    break;
                                            }
                                        }
                                    }
                                    contactBuilder.withPerson(personBuilder.build());
                                    break;
                                case "phoneNumbers":
                                    NodeList phoneNumbersNodeList = childElement.getChildNodes();
                                    List<PhoneNumber> numbers = new ArrayList<>();
                                    for (int g = 0; g < phoneNumbersNodeList.getLength(); g++){
                                        if (phoneNumbersNodeList.item(g).getNodeType() == Node.ELEMENT_NODE){
                                            Element phoneNumbers = (Element) phoneNumbersNodeList.item(g);
                                            if (phoneNumbers.getNodeName() == "phoneNumber"){
                                                numbers.add(new PhoneNumber(phoneNumbers.getTextContent()));
                                            }
                                            contactBuilder.withPhoneNumbers(numbers);
                                        }
                                    }
                                    break;
                                case "email":
                                    contactBuilder.withEMail(new EMail(childElement.getTextContent()));
                                    break;
                            }
                        }
                    }

                    contactBook.add(contactBuilder.build());
                }
            }
        } catch (ParserConfigurationException | SAXException
                | IOException e) {
            e.printStackTrace();
//            Logger.getLogger(ContactBookDeserializerFromXML.class.getName())
//                    .log(Level.SEVERE, null, e);
        }

        return contactBook;
    }
}
