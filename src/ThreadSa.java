import java.util.ArrayList;

public class ThreadSa extends Thread{
    int seq;

    public ThreadSa(int seq){
        this.seq = seq;
    }

    public void run(){
        System.out.println(this.seq + " thread start.");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
        }
        System.out.println(this.seq + "thread end.");// 쓰레드 종료
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i =0; i< 10; i++){
            Thread t = new ThreadSa(i);
            t.start();
            threads.add(t);
        }
        for(int i =0; i<threads.size(); i++){
            Thread t = threads.get(i);
            try{
                t.join();// t쓰레드가 종료될때 까지 기다린다.
            }catch(Exception e){}
        }
        System.out.println("main end.");
    }
}