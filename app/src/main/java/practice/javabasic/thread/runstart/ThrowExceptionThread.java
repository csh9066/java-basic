package practice.javabasic.thread.runstart;

public class ThrowExceptionThread extends Thread{
    @Override
    public void run() {
        throwException();
    }

    private void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
