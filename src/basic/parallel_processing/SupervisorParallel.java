package basic.parallel_processing;

public class SupervisorParallel{
    public static void main(String[] args){
    ParallelWorker1 p1 = new ParallelWorker1();
    ParallelWorker2 p2 = new ParallelWorker2();
    p1.start();
    p2.start();
    }
}
class ParallelWorker1 extends Thread{
    @Override
    public void run(){
        for(int i=1; i<=10; i++){
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Parallel Worker1 is executing the task: "+i);
        }
    }
}
class ParallelWorker2 extends Thread{
    @Override
    public void run(){
        for(int i=1; i<=10; i++){
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Parallel Worker2 is executing the task: "+i);
        }
    }
}
