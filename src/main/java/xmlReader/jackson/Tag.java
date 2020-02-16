package xmlReader.jackson;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yang
 */
@Setter
@Getter
@ToString
public class Tag {
    @JacksonXmlText
    private String value;
}
