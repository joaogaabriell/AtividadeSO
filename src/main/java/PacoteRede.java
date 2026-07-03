public class PacoteRede {
    private final int id;
    private final String origem;
    private final String destino;
    private final int tamanhoBytes;

    public PacoteRede(int id, String origem, String destino, int tamanhoBytes) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.tamanhoBytes = tamanhoBytes;
    }

    public int getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getTamanhoBytes() {
        return tamanhoBytes;
    }

    @Override
    public String toString() {
        return "Pacote #" + id + " (" + origem + " -> " + destino + ", " + tamanhoBytes + " bytes)";
    }
}
