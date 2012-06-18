$(function() {
  $(".pop-over").popover();
  $(".primary").click(function(e) {
    e.preventDefault();
    modal.show();
  });
});