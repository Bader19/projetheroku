//UserController
$(document).ready(function() {


		$.ajax({
			url: "UserController",
			data: { op: "load"},
			type: 'post',
		
			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data))
			 
			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);

			}

		});


	//role
	$("#add").click(function() {
		var Username = $("#Username").val();
		var email = $("#email").val();
		var Password = $("#Password").val();
		var Password2 = $("#Password2").val();
		var phoneNumber = $("#phoneNumber").val();
		var role = $("#role option:selected").val();
		var id = $(this).closest('tr').find('td').eq(0).text();



		$.ajax({
			url: "UserController",
			data: { Username1: Username, email1: email, Password1: Password, phoneNumber1: phoneNumber, role1: role },
			type: 'post',
		
			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data))
					
			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert(textStatus);

			}

		});
	});
	$("#log").click(function() {
		var Username = $("#nom").val();
		var pwd = $("#pass").val();
		$.ajax({
			url: "UserController",
			data: { op: "log", nom1: Username, pass1: pwd },
			type: 'post',

			success: function(data, textStatus, jqXHR) {
				console.log(JSON.stringify(data));
				if (data.length != 0) {
					window.location.href = "dashbord.jsp";
			   }
			},
			error: function(jqXHR, textStatus, errorthrown) {
				alert("une erreur est commite");

			},

		});
	});

 
	$("#contentadmin").on("click", ".valid", function() {
	 
		var id = $(this).closest('tr').find('td').eq(0).text();
		 ;
		$.ajax({
			url: "UserController",
			data: { op: "AdminValid", id: id, },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
			 
			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});
 
 
 
});