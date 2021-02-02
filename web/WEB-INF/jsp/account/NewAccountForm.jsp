<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="Register" method="post">

	<h3>User Information</h3>

	<table>
		<tr>
			<td>User ID:</td>
			<td><input type="text" id="username" name="username" onkeyup="Exist()"></td>
		</tr>
		<tr>
			<td><span id="isExist"></span></td>
		</tr>
		<tr>
			<td>New password:</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td>Repeat password:</td>
			<td><input type="text" name="repeatedPassword"></td>
		</tr>
		<tr>
			<td>Verification code:</td>
			<td><input type="text" name="verificationCode"></td>
		</tr>
	</table>

	<%@ include file="IncludeAccountFields.jsp"%>

		<p>
			<img id="img" src="authImage" />
			<a href='#' onclick="javascript:changeImg()" style="color:white;"><label style="color:black;">Click here to change</label></a>
		</p>


	<input type="submit" name="newAccount" value="Save Account Information">
	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>

<script type="text/javascript">
	var xhr;
	function Exist() {
		var username = document.getElementById('username').value;
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = process;
		xhr.open("get","Register?username=" + username);
		xhr.send(null);
	}

	function changeImg(){
		var img = document.getElementById("img");
		img.src = "authImage?date=" + new Date();
	}

	function process(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				var responseInfo = xhr.responseText;
				var msg = document.getElementById('isExist');
				if(responseInfo === 'Success'){
					msg.classList.add('OKMsg');
					msg.innerText = 'The user name has not been used';
				}
				else if(responseInfo === 'Fail'){
					msg.classList.add('FailMsg');
					msg.innerText = 'The user name is already in use';
				}
			}
		}
	}

</script>