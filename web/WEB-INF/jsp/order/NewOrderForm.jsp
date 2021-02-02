<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<div id="Catalog1">
		<form action="shippingForm" method="post" id="1">
	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td>
				<select name="order.cardType">
					<option value="Credit Card">Credit Card</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><input type="text" name="order.creditCard"> * Use a fake number!
			</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><input type="text" name="order.expiryDate"></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text" name="order.billToFirstName"></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="order.billToLastName"></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" name="order.billAddress1"></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" name="order.billAddress2"></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="order.billCity"></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" name="order.billState"></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" name="order.billZip"></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" name="order.billCountry"></td>
		</tr>

		<tr>
			<td colspan=2><input type="checkbox" name="shippingAddressRequired" id="shippingAddressRequired" onclick="next()">
			Ship to different address...</td>
		</tr>
	</table>
		</form>
	</div>

	<div id="Catalog2" style="display: none">

		<form action="shippingToConfirmForm" method="post" id="2">
			<table>
				<tr>
					<th colspan=2>Shipping Address</th>
				</tr>

				<tr>
					<td>First name:</td>
					<td><input type="text" name="order.shipToFirstName"></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><input type="text" name="order.shipToLastName"></td>
				</tr>
				<tr>
					<td>Address 1:</td>
					<td><input type="text" name="order.shipAddress1"></td>
				</tr>
				<tr>
					<td>Address 2:</td>
					<td><input type="text" name="order.shipAddress2"></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input type="text" name="order.shipCity"></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input type="text" name="order.shipState"></td>
				</tr>
				<tr>
					<td>Zip:</td>
					<td><input type="text" name="order.shipZip"></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><input type="text" name="order.shipCountry"></td>
				</tr>
			</table>
			<input type="button" name="newOrder" value="Continue" onclick="continue1()">
		</form>
	</div>
</div>

<script>
	var Cata1 = document.getElementById("Catalog1");
	var Cata2 = document.getElementById("Catalog2");
	function next(){
		if(document.getElementById('shippingAddressRequired').checked)
		Cata2.style.display = "block";
		else
			Cata2.style.display = "none";
	}
	function continue1(){
		document.getElementById('1').submit();
		document.getElementById('2').submit();
	}
</script>



<%@ include file="../common/IncludeBottom.jsp"%>