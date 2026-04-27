class GaragemCliente {

    private final BufferCircular garagem;
    private final int clienteId;

    public GaragemCliente(int clienteId, int capacidade) {
        this.clienteId = clienteId;
        this.garagem = new BufferCircular(capacidade);
    }

    public void guardar(Veiculo v) throws InterruptedException {
        int posicao = garagem.produzir(v);

        System.out.println("GARAGEM CLIENTE -> Cliente: " + clienteId
                + " | Veiculo guardado: " + v.getId()
                + " | Posicao na garagem: " + posicao);
    }
}