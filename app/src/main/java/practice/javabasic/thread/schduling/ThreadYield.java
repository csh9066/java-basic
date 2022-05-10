package practice.javabasic.thread.schduling;

/**
 * yield() 다른 쓰레드에게 양보
 * yield()는 쓰레드 자신에게 주어진 실행시간을 다음 차례의 쓰레드에게 양보한다.
 * 예를 들어 스케쥴러에 의해 1초의 실행시간을 할당받은 쓰레드가 0.5초의 시간동안 작업한 상태에서 yield()가 호출되면
 * 나머지 0.5는 포기하고 다시 실행대기상태가 된다.
 *
 * yield()와 interrupt()를 적절히 사용하면 프로그램의 응답성을 높이고 효율적이게 실행이 가능하게 할 수 있다.
 */
public class ThreadYield {

    public static void main(String[] args) {
        MyThead th1 = new MyThead("*");
        MyThead th2 = new MyThead("**");
        MyThead th3 = new MyThead("***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static class MyThead implements Runnable{
        private boolean suspended = false;
        private boolean stopped = false;

        Thread th;

        public MyThead(String name) {
            th = new Thread(this, name);
        }

        /**
         * 코드 설명
         * 1. 쓰레드가 실행되면 루프를 돈다
         * 2. suspend가 실행되면 suspended의 상태가 true로 가서 yield()를 실행해 다른 쓰레드에게 실행 순서를 양보한다.
         *  - suspended가 true면 차례가 와도 바로 yield() 를 호출해 차례를 넘김
         *  - 또한 suspend()는 내부적으로 interrupt()를 실행해  sleep() 상태여도 바로 sleep 상태에서 벗어난다.
         * 3. resume()가 실행되면 suspended 상태를 false로 바꾸어 다시 순서가 오면 실행할 수도록 한다. 
         * 4. 순서가 오면 다시 루프를 돈다 
         * 5. 루프를 돌다가 stop() 메소드가 호출되면 쓰레드(루프)가 종료된다
         */
        @Override
        public void run() {
            // 커스텀으로 stop과 supsend를 만듬 
            // suspended 가 true 면 yield로 다음 쓰레드 한테 양보
            while (!stopped) {
                if (!suspended) {
                    System.out.println(th.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(th.getName() + "- interrupted");
                    }
                } else {
                    Thread.yield();
                }
            }

            System.out.println(th.getName() + "- stopped");
        }

        public void suspend() {
            this.stopped = true;
            th.interrupt();
            System.out.println(th.getName() + " - interrupt() by suspend()");
        }

        public void stop() {
            this.stopped = true;
            th.interrupt();
            System.out.println(th.getName() + " - interrupt() by stop()");
        }

        public void resume() {
            suspended = false;
        }

        public void start() {
            th.start();
        }
    }

}
