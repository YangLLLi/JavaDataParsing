package xmlReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StaxDemo {
    public static void main(String[] args) {
        StaxDemo staxReader = new StaxDemo();
        InputStream input = staxReader.getClass().getResourceAsStream("test.xml");
        try {
            XMLStreamReader xmlStreamReader = getXmlStreamReader(input);
            Book book = new Book();
            while (xmlStreamReader.hasNext()) {
                int event = xmlStreamReader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    String localName = xmlStreamReader.getLocalName();
                    switch (localName) {
                        case "book":
                            String id = xmlStreamReader.getAttributeValue(null, "id");
                            book.setId(Integer.parseInt(id));
                            break;
                        default:
                            break;
                    }

                } else if (event == XMLStreamConstants.CHARACTERS) {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得xmlStreamReader
     * @param inputStream
     * @return
     * @throws XMLStreamException
     */
    public static XMLStreamReader getXmlStreamReader(InputStream inputStream) throws XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        return xmlInputFactory.createXMLStreamReader(inputStream);
    }
}
