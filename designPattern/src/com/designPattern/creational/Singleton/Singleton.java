package src.com.designPattern.creational.Singleton;

/**
 * Created by hongjingjun on 16/2/13.
 */

//意图
//保证一个类仅有一个实例,并提供一个访问它的全局访问点


public class Singleton {

    private static volatile Singleton _instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if (null == _instance) {
            synchronized (Singleton.class) {
                if (null == _instance) {
                    _instance = new Singleton();
                }
            }
        }
        return _instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " : " + Singleton.getInstance().hashCode());
                }
            }).start();
        }
    }
}


