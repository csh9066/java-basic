package practice.javabasic.thread.daemon;

/**
 * 데몬 쓰레드는 다른 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행하는 쓰레드이다.
 * 일반 쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 종료된다. 그 이유는 데몬 쓰레드는
 * 일반 쓰레드를 보조역할을 수행하는 쓰레드이므로 일반 쓰레드가 종료되면 존재할 의미가 없기 때문이다.
 *
 */
public class DaemonThread implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new DaemonThread());

        /* 만약 데몬쓰레드를 true 설정했으면 쓰레드 t는 끝나지 않을 것이다.
            setDaemon은 start 메소드가 실행되기 전 설정해야 한다.
         */
        t.setDaemon(true);
        t.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            System.out.println(i);
            
            if (i == 5) {
                autoSave = true;
            }
        }

        System.out.println("프로그램을 종료합니다");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {}

            if (autoSave) {
                autoSave();
            }
        }
    }

    private void autoSave() {
        System.out.println("작업파일이 자동적으로되었습니다.");
    }
}
