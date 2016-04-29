package info.unterstein;

import org.jooby.Jooby;

/**
 * @author jooby generator
 */
public class BasketService extends Jooby {

  {
    get("/", () -> "Hi baskets!");
  }

  public static void main(final String[] args) throws Exception {
    run(BasketService::new, args);
  }

}
