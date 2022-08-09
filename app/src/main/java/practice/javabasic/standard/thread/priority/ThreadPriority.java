package practice.javabasic.standard.thread.priority;


/**
 * 쓰레드는 우선순위(priority)라는 속성을 가지고 있는데 우선순위 값에 따라 쓰레드가 얻는
 * 실행시간이 달라진다. 쓰레드가 수행하는 작업의 중요도에 따라 우선순위를 다르게 지정해 특정 쓰레드가
 * 더 많은 작업시간을 갖도록 할 수 있다.
 *
 * 우선순위는 1 ~ 10 으로 설정할 수 있으며 값이 높을 수록 우선순위를 많이 가지게 된다.
 *
 * 멀티코어에서는 우선순위에 따른 차이가 전혀 없다고 한다. 멀티코어에서는 그저 쓰레드에 높은
 * 우선순위를 주면 실행시간과 실행기회를 갖게 될 것이라고 기대할 수 없다 한다.
 *
 * 멀티코어라 해도 OS 마다 다른 방식으로 스케쥴링하기 때문에
 * 운영체제마다 스케쥴링 정책과 JVM의 벤더별 구현을 직접 확인해야한다.
 * 그러기 떄문에 우선순위를 부여하는 대신 작업에 우선순위를 두어 PriorityQueue에 저장해 놓고
 * 우선순위가 높은 작업이 먼저 처리되도록 하는 것이 나을 수 있다한다.
 */
public class ThreadPriority {
    
    /* main 쓰레드는 우선순위가 5이므로 main 메서드내에서 생성하는 기본 쓰레드의 우선순위는 5이다*/
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();

        t1.setPriority(7);

        System.out.println("t1 priority(-) " + t1.getPriority());
        // 우선순위를 설정을 안했으니 t2는 main 쓰레드의 우선순위인 5가 설정됨
        System.out.println("t2 priority(|) " + t2.getPriority());

        t1.start();
        t2.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("-");
                for (int j = 0; j < 1000000; j++) {

                }
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                System.out.print("|");
                for (int j = 0; j < 1000000; j++) {

                }
            }
        }
    }
}

