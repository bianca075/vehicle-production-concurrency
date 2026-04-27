import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

class ClienteRemoto extends Thread {

    private final int id;
    private final int[] portas;
    private final Random random;
    private final GaragemCliente garagem;

    public ClienteRemoto(int id, int[] portas) {
        this.id = id;
        this.portas = portas;
        this.random = new Random();
        this.garagem = new GaragemCliente(id, 10);
    }

    @Override
    public void run() {
        try {
            int quantidadeCompras = random.nextInt(3) + 1;

            for (int i = 0; i < quantidadeCompras; i++) {

                int portaEscolhida = portas[random.nextInt(portas.length)];

                Socket socket = new Socket("localhost", portaEscolhida);

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.flush();

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                out.writeObject(id);
                out.flush();

                Object resposta = in.readObject();

                if (resposta instanceof Veiculo v) {
                    garagem.guardar(v);

                    System.out.println("Cliente " + id
                            + " comprou e guardou na garagem o veiculo " + v.getId()
                            + " da loja " + v.getLojaId());
                }

                socket.close();

                Thread.sleep((long) (Math.random() * 1500));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}