package udp;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class AppCliente {
  static final String IP = "255.0.0.1";
  static final int PUERTO = 4444;

  public static void main(String[] args) throws IOException {
    MulticastSocket multicastSocket = new MulticastSocket(PUERTO);
    InetAddress inetAddress = InetAddress.getByName(IP);
    multicastSocket.joinGroup(inetAddress);
    String mensaje = "patata";

    DatagramPacket datagramPacket = new DatagramPacket(mensaje.getBytes(), mensaje.length(), inetAddress, PUERTO);

    multicastSocket.send(datagramPacket);

    multicastSocket.close();

  }
}
