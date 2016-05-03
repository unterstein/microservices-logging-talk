package info.unterstein.model;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class CheckoutCustomer {
  public String firstname;
  public String name;

  public String street;
  public String zip;
  public String city;

  public CheckoutCustomer(String firstname, String name, String street, String zip, String city) {
    this.firstname = firstname;
    this.name = name;
    this.street = street;
    this.zip = zip;
    this.city = city;
  }
}
