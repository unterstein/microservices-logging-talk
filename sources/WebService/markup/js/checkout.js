$(function() {
  $.get("/basket/", function(data) {
    var enrichtedArticles = data.articles.map(function(element) {
      var articleName = ko.observable();
      var articlePrice = ko.observable();
      $.get("/articles/" + element.id, function(article) {
        articleName(article.name);
        articlePrice(article.price);
      });
      return {
        id: element.id,
        quantity: element.quantity,
        name: articleName,
        price: articlePrice
      };
    });
    ko.applyBindings(ko.mapping.fromJS({articles: enrichtedArticles, sum: ko.pureComputed(function() {
      return enrichtedArticles.reduce(function(sum, currentArticle) { return sum + currentArticle.quantity * currentArticle.price();}, 0);
    })}));
  });
  $(".submit").click(function(e) {
    var customer = {
      firstname: $("#firstname").val(),
      name: $("#name").val(),
      street: $("#street").val(),
      zip: $("#zip").val(),
      city: $("#city").val()
    };
    $.post("/checkout/", customer, function(e) {
      window.location.href = "/index.html";
    });
  });
});
