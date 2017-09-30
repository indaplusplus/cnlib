package se.kth.cnlib;

import java.io.IOException;
import java.net.ServerSocket;

public class ChessServer extends ChessProtocol {
  /**
   * aaa
   * @throws IOException Exception.
   */
  public ChessServer() {
    this(DEFAULT_PORT);
  }

  /**
   * @param port Port number.
   * @throws IOException Exception.
   */
  public ChessServer(int port)  {
    this.setPort(port);
  }

  /**
   *
   */
  public void accept() throws IOException {
    ServerSocket serverSocket = new ServerSocket(this.getPort());
    this.setSocket(serverSocket.accept());
  }

  @Override
  public void run() {}
}
