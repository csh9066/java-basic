package practice.javabasic.thread.runstart;

public class ThreadStart {

    public static void main(String[] args) {
        Thread t1 = new ThrowExceptionThread();

        /**
         * Thread의 start 메소드는 새로운 쓰레드를 생성한다.
         * 익셉션 로그의 호출 스택에 따라가보면 main에 예외가 터진게 아니라 새로 생긴 쓰레드에 예외가 터졌다.
         */
        t1.start();
    }
}
