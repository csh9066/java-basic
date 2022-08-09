package practice.javabasic.standard.thread.group;

/**
 * 모든 Thread는 ThreadGroup에 포함되어 관리되어야 한다.
 *
 * 자바 어플리케이션이 실행되면 jVM은 main과 system이라는 ThreadGroup을 만들고 관리한다.
 * main 이라는 쓰레드는 main 쓰레드 그룹에 속하고 가비지 컬렉션을 수행하는 Finalizer쓰레드는 system 그룹에 속한다.
 */
public class ThreadGroupPrint {

    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

        ThreadGroup subGrp = new ThreadGroup(grp1, "SubGroup1");

        grp1.setMaxPriority(3);

        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        };

        new Thread(grp1, r, "th1").start();
        new Thread(subGrp, r, "th2").start();
        new Thread(grp2, r, "th3").start();
        new Thread("babo").start();

        main.list();
    }
}
