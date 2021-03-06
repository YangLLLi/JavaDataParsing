package xmlReader.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.net.URL;

/**
 * 使用jackson解析xml
 */
public class JacksonXmlDemo {
    public static void main(String[] args) {
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void test() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        URL resource = JacksonXmlDemo.class.getResource("test.xml");
        Book book = xmlMapper.readValue(resource, Book.class);
        System.out.println(book);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(book);
        System.out.println(s);
    }
}
