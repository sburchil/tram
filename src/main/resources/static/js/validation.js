var contextPath = "user"

$('#loginSave').on('click', (e) => {
	var form = $('#loginForm')[0];

	var username = $('#loginUsername');
	var pass = $('#loginPass');

	$.ajax({
		url: contextPath+"/checkifexists",
		success: function(data) {
			form.submit();
			
		},
		error: function(err){
			console.log(err)
		}
	})
})

$('#registerForm').on('submit', (e) => {
	e.preventDefault();
	var form = $('#registerForm')[0];

	var email = $('#regEmail').val();
	var fName = $('#regfName').val();
	var lName = $('#reglName').val();
	
	if(email == "" || fName == "" || lName == ""){
		$('#err_msg').html(`<strong>Error!</strong> Please fill out all fields.`);
		$('#err_msg').animate({
			opacity: 0.8
		}, 500);
		return;
	}

	var json = {
		regEmail : email,
		regfName : fName,
		reglName : lName
	}


	$.ajax({
		url: contextPath+"/checkifexists",
		data: $.param(json),
		success: function(data) {
			if(data == "false"){
				$('#regEmail').addClass("is-invalid");

				if($('#err_msg').css('opacity') == 0){
					$('#err_msg').html(`<strong>Error!</strong> A user is already registered with this email address (<span style="text-decoration:underline;">${email}</span>). Please click here to <a href="#" onclick="openLoginModal();">login</a>.`);
					$('#err_msg').animate({
						opacity: 0.8
					}, 500, () => clearAlerts($('#err_msg')));
				}
				//alert("User already exists");
			} else {
				$('#regEmail').removeClass("is-invalid");
				
			}
		},
		error: function(err){
			console.log(err)
		}
	})
})