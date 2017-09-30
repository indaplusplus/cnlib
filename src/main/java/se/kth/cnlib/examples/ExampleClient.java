package se.kth.cnlib.examples;

import se.kth.cnlib.ChessClient;
import se.kth.cnlib.protobuf.ChessActionOuterClass.ChessAction.Turn;

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
          this.send("A5-B6", "I'D LIKE TO SOLVE THE PUZZLE", "idk, you ask me", Turn.WHITE);
          Thread.sleep(100);
          //client.getSocket().close();
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
