package info.unterstein.model;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class BasketArticle {
  public Long id;
  public String name;
  public Double price;
  public Integer quantity;

  public BasketArticle(Long id, String name, Double price, Integer quantity) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
}
