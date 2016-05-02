package info.unterstein;

import org.jooby.Jooby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @author jooby generator
 */
public class ArticleService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(ArticleService.class);

  {
    get("/", (req, rsp) -> {
      MDC.put("requestId", "" + req.header("X-Request-Id"));
      log.info("Hi articles!");
      rsp.send("Hi articles!");
      MDC.clear();
    });
  }

  public static void main(final String[] args) throws Exception {
    run(ArticleService::new, args);
  }

}
