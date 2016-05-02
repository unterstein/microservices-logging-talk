package info.unterstein;

import org.jooby.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class ServiceCommons {

  private static final Logger log = LoggerFactory.getLogger(ServiceCommons.class);

  public static void beforeRequest(Request req) {
    MDC.put("requestId", ("" + req.header("X-Request-Id")).replace("[", "").replace("]", ""));
    MDC.put("sessionId", ("" + req.header("X-Session-Id")).replace("[", "").replace("]", ""));
    log.info("Service called for request " + req);
  }

  public static void afterRequest(Request req) {
    MDC.clear();
  }

}
