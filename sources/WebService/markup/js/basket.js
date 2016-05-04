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

    $(".remove-article").click(function(e) {
      var that = this;
      $.ajax({
        url: "/basket/" + $(that).data("id"),
        type: 'DELETE',
        success: function(result) {
            location.reload();
        }
      });
    });
  });
});
