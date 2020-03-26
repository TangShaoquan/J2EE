package my.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.domain.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

public class JacksonTest3 {
    @Test
    //JSon转对象
    public void test3() throws IOException {
        String person = "{\"name\":\"张三\",\"age\":23,\"gender\":\"男\",\"birthday\":\"2020-03-16\"}";

        ObjectMapper objectMapper = new ObjectMapper();

        Person personclass = objectMapper.readValue(person, Person.class);

        System.out.println(personclass);

    }
}
