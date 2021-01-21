<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<p>Please enter your username and password.</p>
	<p> Username:<input type="text" name="username" id="username" value="j2ee"> <br/>
		Password: <input name="password" id="password" value="123"><br/>
		Verification code:<input name="verificationCode" id="verificationCode" value="">
	</p>
	<span id="isLogin"></span><br/>
		<p><img id="img" src="authImage" /></p>
		<p>	<a href='#' onclick="javascript:changeImg()" style="color:white;"><label style="color:black;">Click here to change</label></a></p>
		<input type="button" name="signOn" value="Login" onclick="javascript:validate()"><br/>
	Need a user name and password?
	<a href="viewRegister">Register Now!</a>
</div>

<script type="text/javascript">
	function changeImg(){
		var img = document.getElementById("img");
		img.src = "authImage?date=" + new Date();
	}
</script>

<script>
	var xhr;
	function validate(){
		var username = document.getElementById('username').value;
		var password = document.getElementById('password').value;
		var verificationCode = document.getElementById('verificationCode').value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = process;
		xhr.open("get","mainAfterLogin?username=" + username + "&password=" + password + "&verificationCode=" + verificationCode);
		xhr.send(null);
	}
	function process(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				var responseInfo = xhr.responseText;
				var msg = document.getElementById('isLogin');
				if(responseInfo === 'Success'){
					msg.classList.add('OKMsg');
					msg.innerText = 'success! 3 seconds to jump';
					setTimeout("test1()",3000);
				}
				else if(responseInfo === 'VerFail'){
					msg.classList.add('VerFailMsg');
					msg.innerText = 'VerFail!';
				}
				else if(responseInfo === 'accFail'){
					msg.classList.add('errorMsg');
					msg.innerText = 'Fail!';
				}
			}
		}
	}
	function test1(){
		window.location.href = 'main';
	}

</script>

<%@ include file="../common/IncludeBottom.jsp"%>

