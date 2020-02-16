package xmlReader.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yang
 */
@Getter
@Setter
@ToString
public class Isbn {
    @JacksonXmlProperty(isAttribute = true)
    private String lang;
    @JacksonXmlText
    private String value;
}
