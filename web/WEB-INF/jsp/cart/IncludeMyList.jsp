<c:if test="${!empty sessionScope.productList}">
	<p>Pet Favorites <br />
	Shop for more of your favorite pets here.</p>
	<ul>
		<c:forEach var="product" items="${sessionScope.productList}">
			<li>
				<a href="ViewProduct?productId=${product.productId}">${product.name}</a>
				(${product.productId})
			</li>
		</c:forEach>
	</ul>

</c:if>
