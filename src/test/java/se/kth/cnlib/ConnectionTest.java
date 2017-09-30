package se.kth.cnlib;

import java.io.IOException;
import org.junit.Test;
import se.kth.cnlib.protobuf.ChessActionOuterClass.ChessAction;
import se.kth.cnlib.protobuf.ChessActionOuterClass.ChessAction.Turn;

import static org.junit.Assert.assertTrue;

public class ConnectionTest {

  @Test
  public void connectionTest() {
//    ChessServer server = new ChessServer() {
//      @Override
//      public void run() {
//        try {
//          accept();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    };
//    ChessClient client = new ChessClient("127.0.0.1") {
//      @Override
//      public void run() {
//        try {
//          connect();
//        } catch (IOException e) {
//          e.printStackTrace();
//        }
//      }
//    };
//
//    try {
//      server.start();
//      Thread.sleep(10);
//      client.start();
//    } catch (Exception e) {
//    }
//
//    while (server.isAlive() || client.isAlive()) {
//      try {
//        Thread.sleep(1);
//      } catch (InterruptedException e) {}
//    }
//
//    assertTrue(server.getSocket().isConnected());
//    assertTrue(client.getSocket().isConnected());
//
//    try {
//      server.getSocket().close();
//      client.getSocket().close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
