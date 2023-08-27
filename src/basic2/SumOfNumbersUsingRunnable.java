package basic2;

import java.util.stream.IntStream;

public class SumOfNumbersUsingRunnable{
    public static int[] arr =IntStream.rangeClosed(0,200).toArray();
    public static int sum = IntStream.rangeClosed(0,200).sum();
    public static int total =0;

    public static void main(String[] args) throws InterruptedException{
      ParallelWorker1 parallelWorker1 =new ParallelWorker1(arr);
      ParallelWorker2 parallelWorker2 =new ParallelWorker2(arr);
      Thread thread1 = new Thread(parallelWorker1);
      Thread thread2 = new Thread(parallelWorker2);
      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
        System.out.println("sum of integers in parallel is "+sum);
        System.out.println(" actual sum of integers for verification "+total);
    }
    public static void add(int toAdd){
        total+=toAdd;
    }
}
class ParallelWorker1 implements Runnable{
    int[]arr;
    int sum=0;
    public ParallelWorker1(int[]arr){
        this.arr=arr;
    }
    @Override
    public void run(){
        for(int i=0; i<arr.length/2; i++){
            sum+=arr[i];
        }SumOfNumbersUsingRunnable.add(sum);
    }
}
class ParallelWorker2 implements Runnable{
    int[]arr;
    int sum=0;
    public ParallelWorker2(int[]arr){
        this.arr=arr;
    }
    @Override
    public void run(){
        for(int i=arr.length/2; i<arr.length; i++){
            sum+=arr[i];
        }SumOfNumbersUsingRunnable.add(sum);
    }
}

