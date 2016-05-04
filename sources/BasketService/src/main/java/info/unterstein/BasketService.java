package info.unterstein;

import info.unterstein.model.Basket;
import info.unterstein.model.BasketArticle;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.json.Gzon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class BasketService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(BasketService.class);

  private Map<String, Basket> baskets = new HashMap<>();

  {
    use(new Gzon());

    before((req, rsp) -> {
      ServiceCommons.beforeRequest(req);
    });

    get("/", (req, rsp) -> {
      String sessionId = ServiceCommons.getSessionId(req);
      Basket basket = baskets.get(sessionId);
      rsp.send(basket == null ? new Basket() : basket);
    }).produces(MediaType.json);

    post("/", (req, rsp) -> {
      String sessionId = ServiceCommons.getSessionId(req);
      Basket basket = req.body().to(Basket.class);
      // ignore if basket already exists
      baskets.put(sessionId, basket);

      log.info("Basket was created");

      rsp.send(ServerAnswer.ok());
    }).produces(MediaType.json);

    put("/", (req, rsp) -> {
      String sessionId = ServiceCommons.getSessionId(req);
      BasketArticle article = req.body().to(BasketArticle.class);

      Basket basket = baskets.get(sessionId);
      if (basket == null) {
        basket = new Basket();
        baskets.put(sessionId, basket);
      }

      basket.addArticle(article);
      log.info("Article " + article.id + " was added to basket");

      rsp.send(ServerAnswer.ok());
    }).produces(MediaType.json);

    delete("/", (req, rsp) -> {
      String sessionId = ServiceCommons.getSessionId(req);

      log.info("Basket was deleted");

      rsp.send(baskets.remove(sessionId));
    }).produces(MediaType.json);

    delete("/:id", (req, rsp) -> {
      String sessionId = ServiceCommons.getSessionId(req);

      Basket basket = baskets.get(sessionId);
      if (basket != null) {
        Long articleId = req.param("id").longValue();
        basket.removeArticle(articleId);
        log.info("Article was deleted from basket: " + articleId);
      }

      rsp.send(ServerAnswer.ok());
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
