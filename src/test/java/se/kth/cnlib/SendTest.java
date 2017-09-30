package se.kth.cnlib;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.Test;
import se.kth.cnlib.protobuf.ChessActionOuterClass.ChessAction.Turn;

public class SendTest {

  private String msgOne = "";
  private String msgTwo = "";

  @Test
  public void sendTest() {
    ChessServer server = new ChessServer() {
      @Override
      public void run() {
        try {
          accept();

          msgOne = this.receive().getMessage();
          Thread.sleep(100);

          msgTwo = this.receive().getMessage();
          Thread.sleep(100);

          getSocket().close();
        } catch (Exception e2) {
          e2.printStackTrace();
        }
      }
    };

    ChessClient client = new ChessClient("127.0.0.1") {
      @Override
      public void run() {
        try {
          connect();

          this.send("A5-B6", "CAT", "idk, you ask me", Turn.WHITE);
          Thread.sleep(100);

          this.send("A5-B6", "HAT", "idk, you ask me", Turn.BLACK);
          Thread.sleep(100);

          getSocket().close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };

    server.start();
    client.start();

    while (server.isAlive() || client.isAlive()) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {}
    }

    assertTrue(msgOne.equals("CAT"));
    assertTrue(msgTwo.equals("HAT"));
  }
}
