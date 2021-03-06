<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

<div id="Cart">

<h2>Shopping Cart</h2>
<form action="updateCart" method="post">
	<table>
		<tr>
			<th><b>Item ID</b></th>
			<th><b>Product ID</b></th>
			<th><b>Description</b></th>
			<th><b>In Stock?</b></th>
			<th><b>Quantity</b></th>
			<th><b>List Price</b></th>
			<th><b>Total Cost</b></th>
			<th>&nbsp;</th>
		</tr>

		<c:if test="${sessionScope.cart.numberOfItems == 0}">
			<tr>
				<td colspan="8"><b>Your cart is empty.</b></td>
			</tr>
		</c:if>

		<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
			<tr>
				<td>
					<a href="ViewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
				</td>
				<td>${cartItem.item.product.productId}</td>
				<td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
				${cartItem.item.attribute3} ${cartItem.item.attribute4}
				${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
				<td>${cartItem.inStock}</td>
				<td>
					<input type="text" name="${cartItem.item.itemId}" value="${cartItem.quantity}" onkeyup="k(${cartItem.item.listPrice},${cartItem.total})" id="num"/>
				</td>
				<td><fmt:formatNumber value="${cartItem.item.listPrice}"
					pattern="$#,##0.00" /></td>
				<td id="111"><fmt:formatNumber value="${cartItem.total}"
					pattern="$#,##0.00" /></td>
				<td>
					<a href="removeItemFromCart?workingItemId=${cartItem.item.itemId}" class="Button">Remove</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" id="222">Sub Total: <fmt:formatNumber
				value="${sessionScope.cart.subTotal}" pattern="$#,##0.00" />
			</td>
			<td>&nbsp</td>
		</tr>
	</table>
</form>

	<script>
		function k(listPrice,pretotal){
			var num = document.getElementById("num").value;
			var total = num * listPrice;
			pretotal = total;
			document.getElementById("111").innerText = "$" + total.toFixed(2);
			document.getElementById("222").innerText = "Sub Total: " + "$" + total.toFixed(2);
		}
	</script>


	<c:if test="${sessionScope.cart.numberOfItems > 0}">
		<a href="newOrderForm" class="Button">Proceed to Checkout</a>
</c:if></div>

<div id="MyList">
     <%@ include file="IncludeMyList.jsp"%>
</div>

<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>