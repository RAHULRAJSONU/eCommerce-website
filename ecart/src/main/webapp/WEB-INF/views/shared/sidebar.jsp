
<p class="lead">Shop Name</p>
<div class="list-group">
	<c:forEach items="${categoryList}" var="category">
		<a class="list-group-item" id="a_${category.name}" href="${contextRoot}/show/category/${category.id}/products">${category.name}</a>
	</c:forEach>
</div>

