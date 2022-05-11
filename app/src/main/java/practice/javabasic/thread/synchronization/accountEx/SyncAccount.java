package practice.javabasic.thread.synchronization.accountEx;

public class SyncAccount {
    // 잔액
    private int balance = 1000;

    /**
     *  public synchronized void withdraw 이런식으로 메소드에 선언할 수 있지만
     *  사용할 부분에 synchronized()를 사용하는걸 권장하고 있다.
     *  synchronized를 사용하면 synchronized을 사용한 임계 영역에 lock을 걸어놓고
     *  임계 영역의 코드를 수행하면 lock을 반환한다.
     */
    public void withdraw(int money) {
        synchronized (this) {
            if (balance >= money) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                balance -= money;
            }
        }
    }

    public int getBalance() {
        return balance;
    }
}
