package jsonReader;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 针对json的pojo包含string number bool array object进行序列化
 *
 */
@Getter
@Setter
@ToString
public class Person {
//    string
    @JsonProperty("Name")
    private String name;
//    int
    private int age;
//    bool
    private boolean male;
//    array
    private List<String> friends;
    //    object
    private Map<String, String> obj;

    @JsonIgnore
    private String money;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
