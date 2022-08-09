package practice.javabasic.standard.thread.runstart;

public class ThreadRun {

    public static void main(String[] args) {
        Thread t1 = new ThrowExceptionThread();

        /**
         * run 메소드는 쓰레드를 생성하는 것이 아니라 단순히 클래스에 선언된 메소드를 호출하는 것 뿐이다
         * Exception 의 호출 스택을 보면 쓰레드에 할당 된게 아니라 main이 run을 실행하고 있다.
         */
        t1.run();
    }
}
