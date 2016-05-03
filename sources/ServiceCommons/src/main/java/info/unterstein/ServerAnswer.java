package info.unterstein;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class ServerAnswer {
  public ServerStatus status;

  public ServerAnswer(ServerStatus status) {
    this.status = status;
  }

  public static ServerAnswer ok() {
    return new ServerAnswer(ServerStatus.OK);
  }

  public static ServerAnswer failure() {
    return new ServerAnswer(ServerStatus.FAILURE);
  }

  public enum ServerStatus {
    OK, //
    FAILURE, //
    ;
  }
}
