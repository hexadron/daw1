$(function() {
  $("table.empleados").tablesorter();
  $("table.empleados tr").click(function(e) {
    console.log($(this));
  });
  new GMaps({
    div: '#map',
    lat: -12.087185,
    lng: -77.050252
  });
});