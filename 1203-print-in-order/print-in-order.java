import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
class Foo {
    private int turn=1;
    final ReentrantLock lock=new ReentrantLock();
    private final Condition condition=lock.newCondition();
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
         while(turn!=1){
            condition.await();
         }
            printFirst.run();
            turn=2;
            condition.signalAll();
        }finally{
         lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
         while(turn!=2){
            condition.await();
         }
            printSecond.run();
            turn=3;
            condition.signalAll();
        }finally{
         lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
         while(turn!=3){
            condition.await();
         }
            printThird.run();
        }finally{
         lock.unlock();
        }
    }
}