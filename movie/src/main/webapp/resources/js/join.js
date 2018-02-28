$(document).ready(function() {
	$('input[name="id"]').keyup(function() {
		var idCheckval = $('input[name="id"]').val();
		
		if(idCheckval !== "") {
			$.ajax ({
				type: "POST",
				url: "joinIdCheck",
				cache: false,
				data: {idCheck : idCheckval},
				dataType: 'JSON',
				success: function(result) {
					if(result == 0) {
						$('#join_idCheck').text("사용가능한 아이디 입니다");
					} else if(result == 1) {
						$('#join_idCheck').text("이미 사용중인 아이디 입니다");
					}
				},
				error:function(request,status,error){
				    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				 }
			});	
		} else {
			$('#join_idCheck').text("");
		}
		
	});
	
	$('input[name="password"], input[name="password_check"]').keyup(function() {
		var passwordval = $('input[name="password"]').val();
		var passwordCheckval = $('input[name="password_check"]').val();
		
		if(passwordval !== "" && passwordCheckval !== "") {
			if(passwordval === passwordCheckval) {
				$('#join_RepasswordCheck').text("비밀번호 확인 완료");
			} else if(passwordval !== passwordCheckval) {
				$('#join_RepasswordCheck').text("비밀번호 불일치");
			}
		} else {
			$('#join_RepasswordCheck').text("");
		}
	});
	
	$('input[name="name"]').keyup(function() {
		var nameCheckval = $('input[name="name"]').val();
		
		if(nameCheckval !== "") {
			$.ajax ({
				type: "POST",
				url: "joinNameCheck",
				cache: false,
				data: {nameCheck : nameCheckval},
				dataType: 'JSON',
				success: function(result) {
					if(result == 0) {
						$('#join_nameCheck').text("사용가능한 닉네임 입니다");
					} else if(result == 1) {
						$('#join_nameCheck').text("이미 사용중인 닉네임 입니다");
					}
				},
				error:function(request,status,error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		} else {
			$('#join_nameCheck').text("");
		}
	});
	
	$('input').on({
		"keyup" : function() {
			if($('#join_idCheck').text() === "사용가능한 아이디 입니다" && $('#join_RepasswordCheck').text() === "비밀번호 확인 완료" 
				&& $('#join_nameCheck').text() === "사용가능한 닉네임 입니다") {
				$('button[type="submit"]').removeAttr("disabled");
			} else {
				$('button[type="submit"]').attr('disabled', 'disabled');
			}
		},
		"mousemove" : function() {
			if($('#join_idCheck').text() === "사용가능한 아이디 입니다" && $('#join_RepasswordCheck').text() === "비밀번호 확인 완료" 
				&& $('#join_nameCheck').text() === "사용가능한 닉네임 입니다") {
				$('button[type="submit"]').removeAttr("disabled");
			} else {
				$('button[type="submit"]').attr('disabled', 'disabled');
			}
		}
	});
	
});