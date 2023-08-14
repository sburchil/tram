function change(x) {
  x.classList.toggle("change");
  $('#menu').toggle('collapse');
}

$(document).ready(() => {
	$('#login').on('click', function() {
	  $('#loginModal').modal('show');
	});
	
	$('#register').on('click', function() {
	  $('#registerModal').modal('show');
	}); 
})

