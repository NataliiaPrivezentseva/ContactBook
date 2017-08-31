package contactbook.persistence.de_serialization;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import contactbook.model.Contact;
import contactbook.model.PhoneNumber;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactBookSerializerToXML implements ContactBookSerializer {

    @Override
    public List<String> turnIntoListOfStrings(List<Contact> contactBook) {
        List<String> contactsInXML = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;

        try {
            documentBuilder = factory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = documentBuilder.newDocument();
        Element contactBookEl = document.createElement("contactbook");
        document.appendChild(contactBookEl);

        for (Contact contact : contactBook) {
            Element contactEl = document.createElement("contact");
            contactBookEl.appendChild(contactEl);

            Element personEl = document.createElement("person");
            contactEl.appendChild(personEl);

            Element firstNameEl = document.createElement("firstName");
            personEl.appendChild(firstNameEl);

            Element lastNameEl = document.createElement("lastName");
            personEl.appendChild(lastNameEl);

            Element phoneNumbersEl = document.createElement("phoneNumbers");
            contactEl.appendChild(phoneNumbersEl);

            Element eMailEl = document.createElement("email");
            contactEl.appendChild(eMailEl);

            firstNameEl.appendChild(document.createTextNode(contact.getPerson().getFirstName()));
            lastNameEl.appendChild(document.createTextNode(contact.getPerson().getLastName()));

            List<PhoneNumber> nums = contact.getPhoneNumbers();
            for (PhoneNumber number : nums) {
                Element phoneNumberEl = document.createElement("phoneNumber");
                phoneNumbersEl.appendChild(phoneNumberEl);
                phoneNumberEl.appendChild(document.createTextNode(number.toString()));
            }

            eMailEl.appendChild(document.createTextNode(contact.getEMail().toString()));
        }

        String result;
        try {
            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);
            result = out.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        contactsInXML.add(result);
        return contactsInXML;
    }
}