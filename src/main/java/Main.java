import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static final int TOTAL_PACOTES = 20;
    private static final int NUM_PROCESSADORES = 3;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PacoteRede> fila = new LinkedBlockingQueue<>();
        Random random = new Random();

        for (int i = 1; i <= TOTAL_PACOTES; i++) {
            fila.add(new PacoteRede(i, "10.0.0." + random.nextInt(255),
                    "192.168.0." + random.nextInt(255), 500 + random.nextInt(9500)));
        }

        Processador[] processadores = new Processador[NUM_PROCESSADORES];
        Thread[] threads = new Thread[NUM_PROCESSADORES];

        for (int i = 0; i < NUM_PROCESSADORES; i++) {
            Processador processador = new Processador("Processador-" + (i + 1));
            processadores[i] = processador;
            threads[i] = new Thread(() -> {
                PacoteRede pacote;
                while ((pacote = fila.poll()) != null) {
                    processador.processar(pacote);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("\nResumo:");
        int total = 0;
        for (int i = 0; i < NUM_PROCESSADORES; i++) {
            int processados = processadores[i].getPacotesProcessados();
            total += processados;
            System.out.println("Processador-" + (i + 1) + ": " + processados + " pacotes");
        }
        System.out.println("Total processado: " + total + "/" + TOTAL_PACOTES);
    }
}
