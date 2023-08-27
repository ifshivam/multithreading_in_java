package basic;

public class RunnableExample{
    public static void main(String[] args){
        //Runnable using traditional approach
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                int sum=0;
                for(int i=0; i<10; i++){
                    sum+=i;
                }
                System.out.println("Traditional "+sum);
            }
        };
        new Thread(runnable).start();

        //Runnable using lambda approach
        Runnable runnable1 = ()->{
            int sum=0;
            for(int i=0; i<10; i++){
                sum+=i;
            }
            System.out.println("lambda "+sum);
        };
        new Thread(runnable1).start();
    }
}
