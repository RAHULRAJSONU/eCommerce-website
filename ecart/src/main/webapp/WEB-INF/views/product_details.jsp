<div class="container">

	<div class="row">
		<div class="row">
			<div class="col-xs-12">
				<ol class="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li><a href="${contextRoot}/show/category/${category.id}/products">${category.name}</a></li>
					<li class="active">${product.name}</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-lg-4">
				<img class="img-responsive"
					src="${contextRoot}/assets/bootstrap/images/products/${product.code}.jpg"
					alt="">
			</div>

			<div class="col-xs-12 col-lg-8">
				<h4><b>Price: </b><strong>&#8377; ${product.unitPrice} /-</strong></h4>
				<hr>
				<h4>
					<a href="#">${product.name}</a>
				</h4>
				<hr>
				<p><b>Product Description: </b>${product.description}</p>
				<hr>
				<security:authorize access="hasAuthority('USER')">
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<p><b>Quantity Available: </b><span style="color:red;">Out of Stock!</span></p>
					</c:when>
					<c:otherwise>
						<p><b>Quantity Available: </b>${product.quantity}</p>
					</c:otherwise>
				</c:choose>
				<hr>
				<c:choose>
					<c:when test="${product.quantity < 1}">
					<a class="btn btn-success disabled" href="javascript:void(0)"><strike><span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</strike></a>
					</c:when>
					<c:otherwise>
					<a class="btn btn-success" href="${contextRoot}/cart/add/${product.id}/product"><span class="glyphicon glyphicon-shopping-cart"></span> Add To Cart</a>
					</c:otherwise>
				</c:choose>
				</security:authorize>
				<security:authorize access="hasAuthority('ADMIN')">
					<a class="btn btn-warning" href="${contextRoot}/manage/${product.id}/product"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
				</security:authorize>
					<a class="btn btn-info" href="${contextRoot}/show/category/${category.id}/products">Back</a>
			</div>
		</div>
	</div>
</div>