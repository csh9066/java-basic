package practice.javabasic.thread.schduling;

/**
 * sleep 메소드는 일정시간동안 쓰레드를 멈추게 한다.
 * static void sleep(long millis, int nanos) 밀리 세컨도와 나노세컨드로
 * 시간단위를 세밀하게 값을 지정할 수 있지만 어느 정도 오차가 있다.
 */
public class ThreadSleep {

    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        // 메인이 제일 늦게 끝난다.
        System.out.println("<<main 종료>>");
    }


    static class Thread1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("-");
            }
            System.out.println("<<t1 종료>>");
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("|");
            }
            System.out.println("<<t2 종료>>");
        }
    }
}
