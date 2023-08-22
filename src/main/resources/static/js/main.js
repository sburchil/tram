function change(x) {
  x.classList.toggle("change");
  $('#menu').toggle('collapse');
}

$(document).ready(() => {
	setTimeout(clearAlerts, 5000);

	$('#login').on('click', function() {
	  $('#loginModal').modal('show');
	});
	
	$('#register').on('click', function() {
	  $('#registerModal').modal('show');
	}); 
})

function clearAlerts(elm) {
	// Execute the function
	setTimeout(() => {
		if(elm.css('opacity') == 0.8){
			elm.animate({
				opacity: 0
			}, 500, () => {
				elm.html("");
			});
		}
	}, 5000)
	
  };