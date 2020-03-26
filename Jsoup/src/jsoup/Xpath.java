package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Xpath {

    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = Xpath.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //根据document对象来创建JXdocument
        JXDocument jxDocument = new JXDocument(document);

        //结合xpath语法查询student
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode: jxNodes) {
            System.out.println(jxNode);
            System.out.println("-------------------------");
        }

        //查student下的所有name标签
        System.out.println("-------------------------");
        jxNodes = jxDocument.selN("//student/name");
        for (JXNode jxNode: jxNodes) {
            System.out.println(jxNode);
            System.out.println("-------------------------");
        }

        //查所有student下带id属性的标签
        jxNodes = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode: jxNodes) {
            System.out.println(jxNode);
            System.out.println("-------------------------");
        }

        //所有student下带id=id属性的标签

        jxNodes = jxDocument.selN("//student/name[@id = 'id']");
        for (JXNode jxNode: jxNodes) {
            System.out.println(jxNode);
            System.out.println("-------------------------");
        }
    }

}
