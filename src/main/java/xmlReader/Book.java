package xmlReader;

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
public class Book {
    private int id;
    private String name;
    private String author;
    private transient List<Tag> tags;
    private transient Isbn isbn;
}
