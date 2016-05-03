package info.unterstein.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class Basket {
  private List<BasketArticle> articles = new ArrayList<>();

  public void addArticle(BasketArticle article) {
    for (BasketArticle basketArticle : articles) {
      if (basketArticle.id.equals(article.id)) {
        basketArticle.quantity += article.quantity;
        return;
      }
    }
    articles.add(article);
  }

  public void removeArticle(Long id) {
    BasketArticle articleToRemove = null;
    for (BasketArticle article : articles) {
      if (article.id.equals(id)) {
        articleToRemove = article;
        break;
      }
    }
    articles.remove(articleToRemove);
  }
}
