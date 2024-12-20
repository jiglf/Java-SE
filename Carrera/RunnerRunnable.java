import java.util.Random;

public class RunnerRunnable implements Runnable {

    private final Runner runner;
    private static boolean hayGanador = false; // Asegura la visibilidad entre hilos

    public RunnerRunnable(Runner runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        final int META = 1500;
        Random random = new Random();

     

        while (!hayGanador) { // Solo seguimos si nadie ha ganado
         
            int steps = random.nextInt(50) + 1;
            runner.addProgress(steps); // Actualiza el progreso directamente en Runner

            System.out.println(runner.getName() + " avanza " + steps + " y lleva " + runner.getProgress());

            if (runner.getProgress() >= META && !hayGanador) {
                hayGanador = true;
                System.out.println("¡" + runner.getName() + " ha ganado!");
            }

            try {
                //simulo un tiempo de espera
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }


            
        }
    }
}