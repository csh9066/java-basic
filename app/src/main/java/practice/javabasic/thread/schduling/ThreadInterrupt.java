package practice.javabasic.thread.schduling;

import javax.swing.*;

/**
 * interrupt()와 interrupted
 * 진핸 중인 쓰레드의 작업이 끝나기 전에 취소시켜야할 떄가 있다.
 * 예를 들어 큰 파일을 다운받을 떄 시간이 너무 오래 걸리면 중간에 다운로드를 포기하고 취소할 수 있어야한다.
 * interrupt()는 쓰레드에게 작업을 멈추 요청 한다. 요청만 하는 것일 뿐 쓰레드를 강제로 종료시키지 못한다.
 * interrupted 는 쓰레드에 대해 interrupt()가 호출되어 있는지 알려준다 interrupt()가 호출 되면 true 아니면 false
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread t1 = new Thread1();
        t1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신값은 " + input + "입니다.");
        t1.interrupt(); // interrupt()를 호출하면 interrupted가 true가 된다.
        System.out.println("isInterrupted : " + t1.isInterrupted());
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            int i = 10;
            
            /* sleep일 떄 interrupt()를 실행하면 InterruptedException를 던지고 sleep() 상태를 벗어남
            * 또한 interrupted 상태는 false로 자동 초기화 된다.
            * */
            while (i != 0 && !isInterrupted()) {
                System.out.println(i--);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    // interrupt()를 호출하면 카운터가 종료 됨
//                    interrupt();
                }
            }
            System.out.println("카운터가 종료되었습니다.");
        }
    }
}
