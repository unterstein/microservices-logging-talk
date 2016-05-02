package info.unterstein;

import org.jooby.Jooby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jooby generator
 */
public class BasketService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(BasketService.class);

  {
    before((req, rsp) -> {
      ServiceCommons.beforeRequest(req);
    });

    get("/", (req, rsp) -> {
      log.info("Hi basket!");
      rsp.send("Hi basket!");
    });

    after((req, rsp, result) -> {
      ServiceCommons.afterRequest(req);
      return result;
    });
  }

  public static void main(final String[] args) throws Exception {
    run(BasketService::new, args);
  }

}
