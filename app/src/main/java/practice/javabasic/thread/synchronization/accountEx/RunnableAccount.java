package practice.javabasic.thread.synchronization.accountEx;

public class RunnableAccount implements Runnable{
//    private NonSyncAccount acc = new NonSyncAccount();
    private SyncAccount acc = new SyncAccount();
    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            System.out.println(Thread.currentThread().getName()+"의 출금 금액 = " + money);
            acc.withdraw(money);
            System.out.println("출금 후 잔액" + acc.getBalance());
        }
    }
}
