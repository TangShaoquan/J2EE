package my.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ObjectIdMap;
import my.domain.Person;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class JacksonTest {
    @Test
    public void test1() throws IOException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");


        ObjectMapper objectMapper = new ObjectMapper();

        //转换
        String string = objectMapper.writeValueAsString(person);
        System.out.println(string);
        //把对象写入文件
        objectMapper.writeValue(new FileWriter("D://a.txt"),person);

        //将writeValue
    }
}
