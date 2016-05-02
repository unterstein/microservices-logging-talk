package info.unterstein;

import org.jooby.Request;
import org.slf4j.MDC;

public class ServiceCommons {

  public static void beforeRequest(Request req) {
    MDC.put("requestId", ("" + req.header("X-Request-Id")).replace("[", "").replace("]",""));
  }

  public static void afterRequest(Request req) {
    MDC.clear();
  }

}
