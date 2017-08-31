package contactbook;

import contactbook.model.Contact;
import contactbook.persistence.de_serialization.ContactBookDeserializer;
import contactbook.persistence.de_serialization.ContactBookDeserializerFromXML;

import java.util.ArrayList;
import java.util.List;

public class StartApp {

    public static void main(String[] args) {
//        AppRunner runner = new AppRunner();
//        runner.runApp();

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<contactbook>\n" +
                "  <contact>\n" +
                "    <person>\n" +
                "      <firstName>Max</firstName>\n" +
                "      <lastName>Salliwan</lastName>\n" +
                "    </person>\n" +
                "    <phoneNumbers>\n" +
                "      <phoneNumber>999888777</phoneNumber>\n" +
                "    </phoneNumbers>\n" +
                "    <email>max@salliwan.com</email>\n" +
                "  </contact>\n" +
                "  <contact>\n" +
                "    <person>\n" +
                "      <firstName>Nad</firstName>\n" +
                "      <lastName>Stark</lastName>\n" +
                "    </person>\n" +
                "    <phoneNumbers>\n" +
                "      <phoneNumber>333222555</phoneNumber>\n" +
                "      <phoneNumber>777666333</phoneNumber>\n" +
                "    </phoneNumbers>\n" +
                "    <email>nad.stark@war.end</email>\n" +
                "  </contact>\n" +
                "</contactbook>\n";
        List<String> contactsInXML = new ArrayList<>();
        contactsInXML.add(xml);

        ContactBookDeserializer deserialiser = new ContactBookDeserializerFromXML();
        List<Contact> contactList = deserialiser.turnIntoContactBook(contactsInXML);
        System.out.println(contactList);
    }

}
