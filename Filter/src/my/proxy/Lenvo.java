package my.proxy;

//联想公司真实类,真实类的真实对象要被代理类的代理对象代理
public class Lenvo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"买了一台电脑");
        return "联想电脑";
    }


    @Override
    public void show() {
        System.out.println("展示电脑……");
    }
}
