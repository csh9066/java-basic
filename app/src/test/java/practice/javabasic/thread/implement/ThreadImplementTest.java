package practice.javabasic.thread.implement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("쓰레드 구현")
class ThreadImplementTest {

    @Test
    void 사용법() {
        // 상속받은 쓰레드는 그냥 사용 가능
        ThreadExtend t1 = new ThreadExtend();

        // 인터페이스를 이용해 구현한 쓰레드는 먼저 run을 구현하고 Thread 생성자메소드의
        Runnable r = new ThreadInterface();
        Thread t2 = new Thread(r);

        /*
        * start기 호출 되었다고 바로 실행되는 것이 아니라. 실행되기 상태에 있다가 자신의
        * 차례가 되어야 실행된다.
        * 또한 한번 실행이 종료된 쓰레드는 다시 실핼할 수 없다. 만일 쓰레드 작업을 다시 수행한다면
        * 다시한번 새로운 쓰레드를 생성한다음 시작 해야한다.
        * */
        t1.start();
        t2.start();
    }

}