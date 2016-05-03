package info.unterstein.model;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class Article {
  public Long id;
  public String name;
  public Double price;
  public Integer inStock;

  public Article(Long id, String name, Double price, Integer inStock) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.inStock = inStock;
  }
}
