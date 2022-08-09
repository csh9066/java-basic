package practice.javabasic.standard.thread.synchronization.accountEx;

public class NonSyncAccount {
    // 잔액
    private int balance = 1000;

    /**
     * 동기화를 하지 않았을 경우 balnace의 값이 음수값이 떨어질 수 있다.
     */
    public void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            balance -= money;
        }
    }

    public int getBalance() {
        return balance;
    }
}
