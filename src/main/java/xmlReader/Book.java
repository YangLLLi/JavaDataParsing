package xmlReader;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Yang
 */

@Getter
@Setter
@ToString
public class Book {
    private int id;
    private String name;
    private String author;
    private transient List<Tag> tags;
    private transient Isbn isbn;

}
