package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //获取document对象
        Document document = Jsoup.parse(new File(path),"utf-8");

        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        Elements elements = document.getElementsByAttributeValue("number","001");
        System.out.println(elements);
        Element element = document.getElementById("id");
        System.out.println(element);
    }

}
