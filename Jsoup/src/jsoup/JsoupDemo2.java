package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo2 {
   /* public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取Student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取document树\
        Document document = Jsoup.parse(new File(path),"utf-8");
        //3.获取元素对象
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        //4.获取第一个Element对象
        Element element = elements.get(0);
        String name = element.text();
        System.out.println(name);
    }*/

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
        Document document = Jsoup.parse(url,10000);
        System.out.println(document);
    }

}
