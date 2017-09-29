package se.kth.cnlib.examples;

import java.io.IOException;
import se.kth.cnlib.ChessServer;
import se.kth.cnlib.protobuf.ChessActionOuterClass.ChessAction;

public class ExampleServer implements Runnable {

  private boolean isRunning = true;
  private ChessServer server;

  public ExampleServer() {
    this.server = new ChessServer();
  }

  public void run() {
    while(this.isRunning) {
      try {
        if (this.server.getSocket() == null) {
          this.server.accept();
        }

        if (this.server.getSocket().isConnected()) {
          ChessAction action = this.server.recieve();
          System.out.println(action.getMessage());
          Thread.sleep(100);
          //this.server.getSocket().close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
}
