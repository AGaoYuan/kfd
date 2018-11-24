package cn.happy.testThread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i =0; i<20;i++){
            System.out.println(Thread.currentThread().getName()+"----->"+i);
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new MyRunnable(),"线程1");
        Thread t2 = new Thread(new MyRunnable(),"线程2");

        t1.start();
        t2.start();

    }

}
