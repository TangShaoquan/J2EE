package cn.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
/*
    简单的测试框架
    当主方法执行后，会自动执行被检测的所有方法（加了check注解方法），判断方法是否有异常，记录到文件中
 */
public class TestCheck {

    public static void main(String[] args) throws IOException {

        //1. 创建Caculator对象
        Calculator c = new Calculator();
        //2. 获取字节码文件对象
        Class cls = c.getClass();
        //3. 获取所有方法
        Method[] methods = cls.getMethods();

        int number = 0;//出现异常的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        System.out.println("测试");

        for (Method method : methods){
            //4. 判断是否有check注解
            if(method.isAnnotationPresent(Check.class)){
                //5. 有，就执行
                try{
                    method.invoke(c);
                    System.out.println("测试");
                }catch (Exception e){
                    //6. 捕获异常
                    number++;
                    //记录到文件
                    bw.write(method.getName() + "方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------------------");
                    bw.newLine();
                }

            }
        }

        bw.write("本次测试一共出现"+ number + "次异常");
        bw.flush();
        bw.close();
    }
}
