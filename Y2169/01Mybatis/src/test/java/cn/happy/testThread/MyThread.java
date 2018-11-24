package cn.happy.testThread;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i =0; i<20;i++){
            System.out.println(Thread.currentThread().getName()+"----->"+i);
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

    }

}
