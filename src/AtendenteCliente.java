import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class AtendenteCliente extends Thread {

    private final Socket socket;
    private final Loja loja;

    public AtendenteCliente(Socket socket, Loja loja) {
        this.socket = socket;
        this.loja = loja;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            Object pedido = in.readObject();

            if (pedido instanceof Integer clienteId) {
                Veiculo v = loja.venderParaCliente(clienteId);

                out.writeObject(v);
                out.flush();
            }

            socket.close();

        } catch (Exception e) {
            System.out.println("Erro no atendimento do cliente.");
        }
    }
}