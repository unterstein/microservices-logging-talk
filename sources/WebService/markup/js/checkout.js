$(function() {
  $.get("/basket/", function(data) {
    var viewModel = ko.mapping.fromJS(data);
    ko.applyBindings(viewModel);

    var sum = 0;
    data.articles.each(function() {
      sum += price * quantity;
    });
    $(".sum").val(sum);
  });
});
