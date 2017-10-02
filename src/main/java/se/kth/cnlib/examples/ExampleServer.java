package se.kth.cnlib.examples;

import java.io.IOException;
import se.kth.cnlib.ChessServer;
import se.kth.inda17plusplus.MoveOuterClass.Move;

public class ExampleServer extends ChessServer {

  @Override
  public void run() {
    while(!this.isInterrupted()) {
      try {
        if (this.getSocket() == null) {
          this.accept();
        }

        if (this.getSocket().isConnected()) {
          Move action = this.receive();
          System.out.println(action.getLastMoveErrored());
          Thread.sleep(100);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
}
