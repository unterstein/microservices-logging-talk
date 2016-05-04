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
    var viewModel = ko.mapping.fromJS({articles: enrichtedArticles});
    ko.applyBindings(viewModel);

    var sum = 0;
    $(data.articles).each(function() {
      sum += this.price * this.quantity;
    });
    $(".sum").text(sum);

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
