package practice.javabasic.standard.thread.implement;

/**
 * 자바에서 스레드를 구현하는 방법은 상속과, 인터페이스 방법이 있음
 * 상속받으면 다른 클래스에서 상속을 받을 수 없기때문에 일반적으로 Runnable 인터페이스를 사용함
 */

public class ThreadExtend extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());
        }
    }
}
