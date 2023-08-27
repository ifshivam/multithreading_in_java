package basic;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallableExample{
    public static int[] arr =IntStream.rangeClosed(0,100).toArray();
    public static int total =IntStream.rangeClosed(0,100).sum();
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        Callable callable1 = ()->{
            int sum=0;
            for(int i=0; i<arr.length/2; i++){
                sum+=arr[i];
            }
            return sum;
        };
        Callable callable2 = ()->{
            int sum=0;
            for(int i=arr.length/2; i<arr.length; i++){
                sum+=arr[i];
            }
            return sum;
        };
        ExecutorService executorService =Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList =Arrays.asList(callable1,callable2);
        List<Future<Integer>> results = executorService.invokeAll(taskList);
        int k=0,sum=0;
        for(Future<Integer> result:results){
            sum =sum+result.get();
            System.out.println("sum of "+ ++k+" is "+result.get());
        }
        System.out.println("sum from the callable is "+sum);
        System.out.println("correct sum is "+total);
        executorService.shutdown();
    }
}
