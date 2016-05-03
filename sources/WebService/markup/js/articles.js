$(function() {
  $.get("/articles/", function(data) {
    var viewModel = ko.mapping.fromJS(data);
    ko.applyBindings(viewModel);

    $(".add-article").click(function(e) {
      var that = this;
      var article = {
        id: $(that).data("id"),
        name: $(that).data("name"),
        price: $(that).data("price"),
        quantity: 1
      };
      $.ajax({
        url: "/basket/",
        type: 'PUT',    
        data: JSON.stringify(article),
        contentType: 'json',
        success: function(result) {
            window.location.href = "/basket.html";
        }
      });
    });
  });
});
