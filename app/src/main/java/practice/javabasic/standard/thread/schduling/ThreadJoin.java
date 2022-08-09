package practice.javabasic.standard.thread.schduling;

/**
 * join()는 쓰레드 자신이 하던 작업을 잠시 멈추고 다른 쓰레드가 지정된 시간동안
 * 작업을 수행하도록 한다. 시간을 지정하지 않으면 다른 쓰레드가 작업을 모두 마칠 때 까지 기다린다.
 * join()은 sleep() 처럼 interrupt()를 호출하면 대기상태에 벗어날 수 있다.
 */
public class ThreadJoin {
    static long startTime = 0;

    public static void main(String[] args) {
        Thread th1 = new Thread1("-");
        Thread th2 = new Thread1("|");

        th1.start();
        th2.start();

        startTime = System.currentTimeMillis();

        try {
            th1.join(); // main쓰레드가 th1의 작업이 끝날때 까지 기다린다
            th2.join();
        } catch (InterruptedException e) {}

        System.out.println("소요시간" + (System.currentTimeMillis() - ThreadJoin.startTime));
    }

    private static class Thread1 extends Thread {
        public Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print(getName());
            }
            System.out.println();
        }
    }
}
