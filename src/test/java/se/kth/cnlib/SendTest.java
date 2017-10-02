package se.kth.cnlib;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SendTest {

  private boolean msgOne;
  private boolean msgTwo;

  @Test
  public void sendTest() {
    ChessServer server = new ChessServer() {
      @Override
      public void run() {
        try {
          accept();

          msgOne = this.receive().getLastMoveErrored();
          Thread.sleep(100);

          msgTwo = this.receive().getLastMoveErrored();
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

          this.send("", "", true);
          Thread.sleep(100);

          this.send("", "", false);
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

    assertTrue(msgOne);
    assertTrue(!msgTwo);
  }
}
