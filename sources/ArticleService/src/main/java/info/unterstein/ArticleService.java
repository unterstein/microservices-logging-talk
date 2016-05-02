package info.unterstein;

import com.google.gson.Gson;
import info.unterstein.model.Article;
import org.jooby.Jooby;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jooby generator
 */
public class ArticleService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(ArticleService.class);

  private Map<Long, Article> articles = initialData();

  private Gson gson = new Gson();

  {
    before((req, rsp) -> {
      ServiceCommons.beforeRequest(req);
    });

    get("/", (req, rsp) -> {
      rsp.send("{\"status\"=\"ok\"}");
    }).produces("json");

    get("/articles", (req, rsp) -> {
      rsp.send(gson.toJson(articles.values()));
    }).produces("json");

    get("/articles/:id", (req, rsp) -> {
      rsp.send(gson.toJson(articles.get(req.param("id").longValue())));
    }).produces("json");

    after((req, rsp, result) -> {
      ServiceCommons.afterRequest(req);
      return result;
    });
  }

  public static void main(final String[] args) throws Exception {
    run(ArticleService::new, args);
  }

  private static Map<Long, Article> initialData() {
    Map<Long, Article> result = new HashMap<>();
    result.put(1L, new Article(1L, "Flens", 1.19, 100));
    result.put(2L, new Article(2L, "Becks", 1.30, 100));
    result.put(3L, new Article(3L, "Astra", 1.00, 100));
    result.put(4L, new Article(4L, "Eschweger", 1.10, 100));
    result.put(5L, new Article(5L, "Störtebecker", 1.50, 100));
    result.put(6L, new Article(6L, "Bitburger", 1.40, 100));
    return result;
  }

}
