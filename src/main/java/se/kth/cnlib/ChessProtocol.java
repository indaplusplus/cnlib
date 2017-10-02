package se.kth.cnlib;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import se.kth.cnlib.events.ConnectEvent;
import se.kth.inda17plusplus.MoveOuterClass.Move;

public abstract class ChessProtocol extends Thread {

  public static final int DEFAULT_PORT = 0xdad; //3501

  private Socket socket;
  private int port;
  private List events = new ArrayList();

  @Override
  public abstract void run();

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
   * @param move The move in Algebraic Notation, + for checks, # for checkmates, 1-0 / 0-1 / 1/2-1/2 for game end.
   * @param resultingState The state after the move in Forsyth-Edwards Notation.
   * @param lastMoveErrored Was the last move invalid?
   */
  public void send(String move, String resultingState, boolean lastMoveErrored) throws IOException{
    Move.Builder builder = Move.newBuilder();
    builder.setMove(move);
    builder.setResultingState(resultingState);
    builder.setLastMoveErrored(lastMoveErrored);

    Move action = builder.build();
    action.writeDelimitedTo(this.getSocket().getOutputStream());

    //PrintWriter writer = new PrintWriter(this.getSocket().getOutputStream());

    this.getSocket().getOutputStream().flush();
  }

  /**
   *
   * @return
   * @throws IOException
   */
  public Move receive() throws IOException {
    return Move.parseDelimitedFrom(this.getSocket().getInputStream());
  }
}
