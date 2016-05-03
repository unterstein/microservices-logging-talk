package info.unterstein;

import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.json.Gzon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jooby generator
 */
public class BasketService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(BasketService.class);

  {
    use(new Gzon());

    before((req, rsp) -> {
      ServiceCommons.beforeRequest(req);
    });

    get("/", (req, rsp) -> {
      log.info("Hi basket!");
      rsp.send("Hi basket!");
    }).produces(MediaType.json);

    after((req, rsp, result) -> {
      ServiceCommons.afterRequest(req);
      return result;
    });
  }

  public static void main(final String[] args) throws Exception {
    run(BasketService::new, args);
  }

}
