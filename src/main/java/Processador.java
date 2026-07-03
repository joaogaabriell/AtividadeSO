import java.util.concurrent.atomic.AtomicInteger;

public class Processador implements ProcessadorInterface {
    private final String nome;
    private final AtomicInteger pacotesProcessados = new AtomicInteger();

    public Processador(String nome) {
        this.nome = nome;
    }

    @Override
    public void processar(PacoteRede pacote) {
        // Simula o custo de processamento proporcional ao tamanho do pacote
        try {
            Thread.sleep(Math.max(1, pacote.getTamanhoBytes() / 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        pacotesProcessados.incrementAndGet();
        System.out.println("[" + nome + "] processou " + pacote);
    }

    @Override
    public int getPacotesProcessados() {
        return pacotesProcessados.get();
    }
}
