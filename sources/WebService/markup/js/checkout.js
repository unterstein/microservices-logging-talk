$(function() {
  $.get("/basket/", function(data) {
    var viewModel = ko.mapping.fromJS(data);
    ko.applyBindings(viewModel);

    var sum = 0;
    $(data.articles).each(function() {
      sum += this.price * this.quantity;
    });
    $(".sum").text(sum);
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
