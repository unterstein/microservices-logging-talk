package info.unterstein.model;

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
