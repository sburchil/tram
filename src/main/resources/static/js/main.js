function change(x) {
  x.classList.toggle("change");
  $('#menu').toggle('collapse');
}

$('#login').click(function() {
  $('#loginModal').modal('show');
});
