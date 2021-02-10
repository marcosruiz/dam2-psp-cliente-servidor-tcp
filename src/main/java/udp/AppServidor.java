package udp;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class AppServidor {
  static final int PUERTO = 4444;
  public static void main(String[] args) throws IOException {
    MulticastSocket multicastSocket = new MulticastSocket(PUERTO);
//    DatagramPacket datagramPacket = new DatagramPacket();
//    multicastSocket.receive(datagramPacket);
//    String mensaje = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
  }
}
