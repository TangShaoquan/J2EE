package my.Web.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个对象，在内存中生产图片，验证码图片
        int width = 100;
        int height = 50;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//使用RGB类型


        //美化图像，加横线、背景色之类的
        /*2.1 填充背景色*/
        //画笔对象
        Graphics graphics = bufferedImage.getGraphics();
        //设置画笔颜色
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,100-1,50);//开始坐标，宽高

        //2.2 画边框
        //选择框，选择颜色
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,100-1,50-1);//图片里的坐标，宽高-1是为了覆盖原来的一个像素边框

        //设置String集合
        String string="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            //生成随机角标

            int index = random.nextInt(string.length());
            //获取字符
            char ch = string.charAt(index);
            //2.3 写验证码
            graphics.drawString(ch+"",width/5*i+1,25);
        }
        //2.4 画干扰线
        graphics.setColor(Color.RED);
        /*生成随机的干扰线*/

        for (int i = 0; i <10 ; i++) {
            /*随机生产坐标点*/
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            graphics.drawLine(x1,y1,x2,y2);
        }


        //输出到页面进行展示
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
