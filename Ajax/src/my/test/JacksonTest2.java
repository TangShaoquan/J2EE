package my.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.domain.Person;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class JacksonTest2 {
    @Test
    public void test2() throws IOException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());

        ObjectMapper objectMapper = new ObjectMapper();

        //转换
        String string = objectMapper.writeValueAsString(person);
        System.out.println(string);

    }
}
