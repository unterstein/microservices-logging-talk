$(function() {
  $.get("/basket/", function(data) {
    var viewModel = ko.mapping.fromJS(data);
    ko.applyBindings(viewModel);

    var sum = 0;
    $(".price").each(function() {
      sum += $(this).data("price").val();
    });
    $(".sum").val(sum);

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
