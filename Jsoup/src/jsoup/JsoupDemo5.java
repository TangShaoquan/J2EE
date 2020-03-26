package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {

    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo5.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.擦寻name标签
        Elements name = document.select("name");
        System.out.println(name);
        System.out.println("______________________________");

        //查询id=id的元素
        Elements id = document.select("#id");
        System.out.println(id);

        System.out.println("______________________________");
        //获取student标签，且number=002
        Elements stu = document.select("student[number='001']");
        System.out.println(stu);

        System.out.println("______________________________");

        //获取student标签，且number=002
        Elements st = document.select("student[number='001'] > age");
        System.out.println(st);
        String text = st.get(0).text();
        System.out.println(text);

    }

}
