public class App {

    //Runner runner1 = new Runner("Jacinto");

    public static void main(String[] args) {

        Runner runner1 = new Runner("Jacinto");
        Runner runner2 = new Runner("Anastasia");
        Runner runner3 = new Runner("Emilio");
        Runner runner4 = new Runner("Esperanza");

        Thread thread1 = new Thread(new RunnerRunnable(runner1));
        Thread thread2 = new Thread(new RunnerRunnable(runner2));
        Thread thread3 = new Thread(new RunnerRunnable(runner3));
        Thread thread4 = new Thread(new RunnerRunnable(runner4));
     
        

        


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        
    }

    

    

}
