package info.unterstein;

import org.jooby.Jooby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jooby generator
 */
public class CheckoutService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(CheckoutService.class);

  {
    before((req, rsp) -> {
      ServiceCommons.beforeRequest(req);
    });

    get("/", (req, rsp) -> {
      log.info("Hi checkout!");
      rsp.send("Hi checkout!");
    });

    after((req, rsp, result) -> {
      ServiceCommons.afterRequest(req);
      return result;
    });
  }

  public static void main(final String[] args) throws Exception {
    run(CheckoutService::new, args);
  }

}
