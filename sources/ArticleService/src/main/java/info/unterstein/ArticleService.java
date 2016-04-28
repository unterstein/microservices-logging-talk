package info.unterstein;

import org.jooby.Jooby;

/**
 * @author jooby generator
 */
public class ArticleService extends Jooby {

  {
    get("/", () -> "Hello World!");
  }

  public static void main(final String[] args) throws Exception {
    run(ArticleService::new, args);
  }

}
