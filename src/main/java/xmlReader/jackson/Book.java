package xmlReader.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * xml内包含string int 和bool三种类型
 * json包含string number bool array object
 * sql包含string int double bool date等
 *
 *  针对xml的pojo最好只有string int bool进行序列化
 * @author Yang
 */

@Getter
@Setter
@ToString

@JacksonXmlRootElement(localName = "book")
public class Book {
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private int id;
    private String name;
    private String author;
    @JacksonXmlElementWrapper(localName = "tags")
    @JacksonXmlProperty(localName = "tag")
    private List<Tag> tags;
    private Isbn isbn;
}
