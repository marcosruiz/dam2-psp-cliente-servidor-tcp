package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

/**
 * Se debe lanzar primero tcp.AppServidor y depués tcp.AppCliente
 * Cuando reciba el primer mensaje devolverá el mismo mensaje añadiendole texto delante.
 */
public class AppServidor {
  static final int PUERTO = 4444;

  public static void main(String[] args) throws IOException {
    // Debemos definir el tamaño máximo de los mensajes a recibir
    byte[] bufer = new byte[1000];
    DatagramPacket paquetePeticion =
        new DatagramPacket(bufer, bufer.length);

    DatagramSocket socketUdp = new DatagramSocket(PUERTO);
    System.out.println("Escuchando en el puerto " + PUERTO + " ...");
    socketUdp.receive(paquetePeticion);

    // Mostramos el mensaje por pantalla
    String mensaje = new String(paquetePeticion.getData(), StandardCharsets.UTF_8);
    System.out.println("Mensaje recibido: " + mensaje);

    // Preparamos el paquete de respuesta
    String mensajeDeRespuesta = "Tú si que eres " + mensaje;
    DatagramPacket paqueteRespuesta =
        new DatagramPacket(mensajeDeRespuesta.getBytes(), mensajeDeRespuesta.length(), paquetePeticion.getAddress(), paquetePeticion.getPort());

    // Enviamos la respuesta
    socketUdp.send(paqueteRespuesta);

    // Cerramos la conexión
    socketUdp.close();

  }
}
