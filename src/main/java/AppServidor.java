import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class AppServidor {
  static final int PUERTO = 4444;
  public static void main(String[] args) throws IOException {
    // Creamos el servidor
    ServerSocket servidor = new ServerSocket(PUERTO);
    System.out.println("Escuchando en el puerto " + PUERTO + " ...");

    // Aceptamos la primera petición de conexión que venga
    Socket socket = servidor.accept();

    // Obtenemos los canales de entrada de datos y de salida
    DataInputStream entrada = new DataInputStream(socket.getInputStream());
    DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

    // Leemos un mensaje y devolvemos el mismo mensaje
    String mensajeDelCliente = entrada.readUTF();
    System.out.println("Recibido mensaje del cliente: " + mensajeDelCliente);
    salida.writeUTF("Tú si que eres " + mensajeDelCliente);

    // Cerramos conexión
    socket.close();
    servidor.close();
  }
}
