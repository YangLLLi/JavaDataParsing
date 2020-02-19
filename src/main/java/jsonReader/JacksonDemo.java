package jsonReader;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * * xml内包含string int 和bool三种类型
 * * json包含string number bool array object
 * * sql包含string int double bool date等
 *
 * @author Yang
 */
public class JacksonDemo {
    public static void main(String[] args) {
        try {
            objectMapperTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * objectMapper实现序列化
     * writeValue readValue
     */
    public static void objectMapperTest() throws IOException {
        Person person = new Person();
        person.setName("Yang");
        person.setAge(18);
        person.setMale(true);
        person.setFriends(new ArrayList<String>() {{
            add("A");
            add("B");
        }});
        person.setObj(new HashMap<String, String>() {{
            put("a", "x");
            put("b", "y");
        }});
        person.setMoney("xxx");
        person.setBirthday(LocalDate.of(2000, Month.JANUARY, 1));

        URL resource = JacksonDemo.class.getResource("test.json");
        String path = resource.getPath().substring(1);
        OutputStream out = new FileOutputStream(path);
//        json序列化
        ObjectMapper objectMapper = new ObjectMapper();
        jacksonConfig(objectMapper);
        objectMapper.writeValue(out, person);
        System.out.println(objectMapper.writeValueAsString(person));
//        json反序列化
        Person person1 = objectMapper.readValue(Paths.get(path).toFile(), Person.class);
        System.out.println(person1);
    }

    /**
     * 配置objectMapper
     *
     * @param objectMapper
     */
    public static void jacksonConfig(ObjectMapper objectMapper) {
        //在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //注册后支持jdk8中的事件api
        objectMapper.findAndRegisterModules();
        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ,原来的时间api
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //在序列化时忽略值为 null 的属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
