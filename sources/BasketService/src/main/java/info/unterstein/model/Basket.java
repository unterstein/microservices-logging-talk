package info.unterstein.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class Basket {
  private Map<Long, BasketArticle> articles = new HashMap<>();

  public void addArticle(BasketArticle article) {
    articles.put(article.id, article);
  }

  public void removeArticle(Long id) {
    articles.remove(id);
  }
}
