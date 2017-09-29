package se.kth.cnlib;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ConnectionTest {
  @Test
  public void connectionTest() {
    ChessServer server = new ChessServer();
    ChessClient client = new ChessClient("127.0.0.1");

    /*boolean connected;
    try {
      server.accept();
      client.connect();
      connected = true;
    } catch (IOException e) {
      connected = false;
    }

    assertTrue(connected);*/
  }
}
