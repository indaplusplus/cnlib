package se.kth.cnlib;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import se.kth.cnlib.events.ConnectEvent;
import se.kth.cnlib.protobuf.ChessActionOuterClass.ChessAction;

public class ChessProtocol {

  public static final int DEFAULT_PORT = 0xdad; //3501

  private Socket socket;
  private int port;
  private List events = new ArrayList();


  /*
    this.addConnectEvent(
      () -> {
        System.out.println("a");
      }
    );
   */
  public void addConnectEvent(ConnectEvent event) {
    this.events.add(event);
  }

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  public Socket getSocket() {
    return this.socket;
  }

  /**
   *
   * @return
   */
  public int getPort() {
    return this.port;
  }

  /**
   *
   * @return
   */
  private List getEvents() {
    return this.events;
  }

  /**
   *
   * @param port
   */
  public void setPort(int port) {
    this.port = port;
  }

  /**
   *
   * @param move Move in chess notation.
   * @param debugMessage Message, use is mainly for debugging.
   * @param boardAfterMove String representation of what the board should look like after the move (also used for debugging).
   * @param player Which player executed the move.
   */
  public void send(String move, String debugMessage, String boardAfterMove, ChessAction.Turn player) throws IOException{
    ChessAction.Builder builder = ChessAction.newBuilder();
    builder.setMove(move);
    builder.setMessage(debugMessage);
    builder.setBoard(boardAfterMove);
    builder.setCurrentplayerValue(player.getNumber());

    ChessAction action = builder.build();
    action.writeDelimitedTo(this.getSocket().getOutputStream());

    //PrintWriter writer = new PrintWriter(this.getSocket().getOutputStream());

    this.getSocket().getOutputStream().flush();
  }

  /**
   *
   * @return
   * @throws IOException
   */
  public ChessAction recieve() throws IOException {
    return ChessAction.parseDelimitedFrom(this.getSocket().getInputStream());
  }
}
