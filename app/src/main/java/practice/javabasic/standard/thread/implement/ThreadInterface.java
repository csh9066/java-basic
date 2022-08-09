package practice.javabasic.standard.thread.implement;

/**
 * 자바에서 스레드를 구현하는 방법은 상속과, 인터페이스 방법이 있음
 * 상속받으면 다른 클래스에서 상속을 받을 수 없기때문에 일반적으로 Runnable 인터페이스를 사용함
 */
public class ThreadInterface implements Runnable{

    /**
     * 상속을 받으면 현재 쓰레드의 name일 확인할 수 있지만 인터페이스는
     * 구현체가 없으므로 Thread 클래스의 static 메소드 getName()을 사용하면 된다.
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
