package my.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyTest {
    public static void main(String[] args) {
        //1. 创建真实对象
        Lenvo lenvo = new Lenvo();


        //动态代理增强lenvo对象
        /*
        三个参数
                1. 类加载器，真实对象 getClass().getClassLoader()
                2. 类接口数组，真实对象 getClass().getInterfaces()
                3. 处理器： new InvocationHandler()
        */


        //代理对象
        SaleComputer salecomputer = (SaleComputer) Proxy.newProxyInstance(lenvo.getClass().getClassLoader(), lenvo.getClass().getInterfaces(), new InvocationHandler() {
            //这个方法就是代理逻辑编写的方法：所有被代理对象调用的函数都会执行或者说触发该方法
            /*
            参数：
                1. proxy：代理对象
                2. method: 方法代理对象调用的方法被封装为的对象
                3. args: 代理对象调用方法时候传递的实际参数
            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("该方法被执行了");
                System.out.println(method.getName());


                //增强步骤
                //判断是不是sale方法
                if(method.getName().equals("sale")){
                    double money = (double)args[0];
                    money = money * 0.85;//回扣，村该参数

                    //真实对象的方法会执行
                    String invoke = (String)method.invoke(lenvo, money);
                    //增强返回值
                    return invoke+"和鼠标垫";
                }else {
                    //真实对象的方法会执行
                    Object invoke = method.invoke(lenvo, args);
                    return invoke;
                }


            }
        });


        String sale = salecomputer.sale(8000);
        System.out.println(sale);
    }
}
