package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * Se debe lanzar primero tcp.AppServidor y depués tcp.AppCliente.
 * Enviará un mensaje al Servidor y esperará su contestación.
 */
public class AppCliente {
  static final String IP = "localhost";
  static final int PUERTO = 4444;

  public static void main(String[] args) throws IOException, InterruptedException {
    String mensaje = "patata";

    // Creamos el socket que vamos a utilizar para enviar datos
    DatagramSocket socketUdp = new DatagramSocket();

    // Preparamos el paquete de datos
    InetAddress inetAddressServidor = InetAddress.getByName(IP);
    DatagramPacket paqueteDeDatos = new DatagramPacket(mensaje.getBytes(), mensaje.length(), inetAddressServidor, PUERTO);

    // Enviamos el paquete de datos
    socketUdp.send(paqueteDeDatos);

    // Recibimos el paquete de datos
    // Para ello debemos definir el tamaño máximo de los mensajes.
    byte[] bufer = new byte[1000];
    DatagramPacket paqueteRespuesta =
        new DatagramPacket(bufer, bufer.length);
    socketUdp.receive(paqueteRespuesta);

    // Mostramos el mensaje por pantalla
    String mensajeRespuesta = new String(paqueteRespuesta.getData(), StandardCharsets.UTF_8);
    System.out.println("Mensaje recibido: " + mensajeRespuesta);

    // Cerramos la conexión
    socketUdp.close();
  }
}
