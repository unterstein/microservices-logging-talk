package info.unterstein;

import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.json.Gzon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jooby generator
 */
public class CheckoutService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(CheckoutService.class);

  {
    use(new Gzon());

    before((req, rsp) -> {
      ServiceCommons.beforeRequest(req);
    });

    get("/", (req, rsp) -> {
      log.info("Hi checkout!");
      rsp.send("Hi checkout!");
    }).produces(MediaType.json);

    after((req, rsp, result) -> {
      ServiceCommons.afterRequest(req);
      return result;
    });
  }

  public static void main(final String[] args) throws Exception {
    run(CheckoutService::new, args);
  }

}
