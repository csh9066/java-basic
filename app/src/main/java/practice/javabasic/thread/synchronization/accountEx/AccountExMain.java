package practice.javabasic.thread.synchronization.accountEx;

public class AccountExMain {

    public static void main(String[] args) {
        Runnable r1 = new RunnableAccount();
//        Runnable r2 = new RunnableAccount();
        
        // 한개의 runnable 객체지만 2개의 쓰레드에서 한개의 r1의 인스턴스를 참조하게 됨 
        new Thread(r1).start();
        new Thread(r1).start();
    }
}
