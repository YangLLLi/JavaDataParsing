package xmlReader;

import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang
 */
@Getter
@Setter
public class DomReader {

    public static void main(String[] args) {
        DomReader domReader = new DomReader();
        InputStream input = domReader.getClass().getResourceAsStream("test.xml");
        Element root = null;
        try {
            root = getXmlRoot(input);
            String id = root.getAttribute("id");
            Book book = new Book();
            book.setId(Integer.parseInt(id));
            List<Tag> tags = new ArrayList<>();
            book.setTags(tags);
            xmlReader(root,book);
            System.out.println(book);
        } catch (IOException |SAXException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获得xml的根节点
     *
     * @param input xml输入流
     * @return xml的根节点
     * @throws IOException
     * @throws SAXException
     */
    public static Element getXmlRoot(InputStream input) throws IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = documentBuilder.parse(input);
        return doc.getDocumentElement();
    }

    /**
     * 递归遍历子节点
     * @param root 根节点
     * @throws IOException
     * @throws SAXException
     */
    public static void xmlReader(Node root,Book book) throws IOException, SAXException {
        if (root == null) {
            return;
        }
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
//            只要element类型的node
            if (node instanceof Element) {
//                节点名
                Element item = (Element) node;
                String nodeName = item.getNodeName();
//                第一子节点，即为其节点内容
                Text text = (Text) item.getFirstChild();
                String nodeText = text.getData().trim();

                switch (nodeName) {
                    case "name":
                        book.setName(nodeText);
                        break;
                    case "author":
                        book.setAuthor(nodeText);
                        break;
                    case "isbn":
                        String lang = item.getAttribute("lang");
                        Isbn isbn=new Isbn();
                        isbn.setIsbn(nodeText);
                        isbn.setLang(lang);
                        book.setIsbn(isbn);
                        break;
                    case "tag":
                        Tag tag = new Tag();
                        tag.setTag(nodeText);
                        book.getTags().add(tag);
                        break;
                    default:
                        break;
                }
//                节点属性
//                NamedNodeMap attributes = item.getAttributes();
//                for (int j = 0; j < attributes.getLength(); j++) {
//                    Attr attr = (Attr) attributes.item(j);
//                    String attrName = attr.getName();
//                    String attrValue = attr.getValue();
//                }
                xmlReader(item,book);
            }
        }

    }


}


