var contextPath = "[[@{/}]]"

$('#loginSave').on('click', (e) => {
	var form = $('#loginForm')[0];

	var email = $('#loginEmail');
	var fName = $('#fName');
	var lName = $('#lName')
	var username = $('#loginUsername');
	var pass = $('#loginPass');

	$.ajax({
		url: "user/login",
		success: function(data) {
			console.log(data)
			
		},
		error: function(err){
			console.log(err)
		}
	})
})

$('#registerSave').on('click', (e) => {
	var form = $('#registerForm')[0];

	var email = $('#regEmail').val();
	var fName = $('#regfName').val();
	var lName = $('#reglName').val();
	var json = {
		email : email,
		fName : fName,
		lName : lName
	}
	contextPath + "/login/checkUser";
	$.ajax({
		url: "user/login/checkUser",
		data: $.param(json),
		success: function(data) {
			console.log(data)
			
		},
		error: function(err){
			console.log(err)
		}
	})
})