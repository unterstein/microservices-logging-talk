package info.unterstein;

import com.google.gson.Gson;
import info.unterstein.model.Checkout;
import info.unterstein.model.CheckoutArticle;
import info.unterstein.model.CheckoutBasket;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jooby.Jooby;
import org.jooby.MediaType;
import org.jooby.json.Gzon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;

/**
 * @author Johannes Unterstein (unterstein@me.com)
 */
public class CheckoutService extends Jooby {

  private static final Logger log = LoggerFactory.getLogger(CheckoutService.class);

  {
    use(new Gzon());

    before((req, rsp) -> {
      ServiceCommons.beforeRequest(req);
    });

    get("/", (req, rsp) -> {
      rsp.send(ServerAnswer.ok());
    }).produces(MediaType.json);

    post("/", (req, rsp) -> {
      Gson gson = req.require(Gson.class);
      CloseableHttpClient client = HttpClients.createDefault();

      Checkout checkout = req.body().to(Checkout.class);

      // get basket and remove this one
      HttpDelete delete = new HttpDelete("http://basketService:8081/basket/");
      CloseableHttpResponse deleteResponse = client.execute(delete);
      CheckoutBasket checkoutBasket = gson.fromJson(new InputStreamReader(deleteResponse.getEntity().getContent()), CheckoutBasket.class);

      // change quantity of articles from stock
      for (CheckoutArticle article : checkoutBasket.articles) {
        HttpPost post = new HttpPost("http://articleService:8082/articles/checkout/" + article.id);
        post.setHeader("X-Request-Id", ServiceCommons.getRequestId(req)); // session id will be added automatically
        post.setEntity(new StringEntity(gson.toJson(article)));
        client.execute(post);
        // TODO transaction handling
      }

      log.info("Successful checkout: " + req.require(Gson.class).toJson(checkout));
      // do something with the checkout

      rsp.send(ServerAnswer.ok());
    }).produces(MediaType.json);

    after((req, rsp, result) -> {
      ServiceCommons.afterRequest(req);
      return result;
    });
  }

  public static void main(final String[] args) throws Exception {
    run(CheckoutService::new, args);
  }

}
