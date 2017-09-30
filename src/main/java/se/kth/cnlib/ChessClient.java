package se.kth.cnlib;

import java.io.IOException;
import java.net.Socket;

public class ChessClient extends ChessProtocol {

  private String host;

  public ChessClient(String host, int port) {
    this.setPort(port);
  }

  public ChessClient(String host) {
    this(host, DEFAULT_PORT);
  }

  public String getHost() {
    return this.host;
  }

  /**
   *
   * @param host
   */
  private void setHost(String host) {
    this.host = host;
  }

  /**
   *
   * @throws IOException
   */
  public void connect() throws IOException {
    this.setSocket(
        new Socket(this.getHost(), this.getPort())
    );
  }

  @Override
  public void run() {}
}
