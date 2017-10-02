package se.kth.cnlib.examples;

import se.kth.cnlib.ChessClient;

public class ExampleClient extends ChessClient {

  public ExampleClient() {
    super("127.0.0.1");
  }

  public void run() {
    while(!this.isInterrupted()) {
      try {
        if (this.getSocket() == null) {
          connect();
        } else if (this.getSocket().isConnected()) {
          this.send("", "", true);
          Thread.sleep(100);
          //client.getSocket().close();
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
