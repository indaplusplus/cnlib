package se.kth.cnlib.examples;

import se.kth.cnlib.ChessClient;
import se.kth.cnlib.protobuf.ChessActionOuterClass.ChessAction.Turn;

public class ExampleClient implements Runnable {

  private boolean isRunning = true;
  private ChessClient client;

  public ExampleClient() {
    client = new ChessClient("127.0.0.1");
  }

  public void run() {
    while(this.isRunning) {
      try {
        if (this.client.getSocket() == null) {
          client.connect();
        }
        if (this.client.getSocket().isConnected()) {
          this.client.send("A5-B6", "I'D LIKE TO SOLVE THE PUZZLE", "idk, you ask me", Turn.WHITE);
          Thread.sleep(100);
          //client.getSocket().close();
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
