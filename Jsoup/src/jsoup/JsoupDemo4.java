package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {

    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements names = document.getElementsByTag("name");
        System.out.println(names);
        System.out.println("________________________");

        Element student = document.getElementsByTag("student").get(0);
        Elements name1 = document.getElementsByTag("name");
        System.out.println(student);
        System.out.println("+++++++++++++++++++++++++++++++++=");

        String number = student.attr("number");
        System.out.println(number);
        System.out.println("________________________");

        String text = name1.text();
        System.out.println(text);
    }

}
