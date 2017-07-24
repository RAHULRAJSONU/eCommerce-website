<!-- Title -->
<div class="container">

	<div class="row">

		<div class="col-lg-12">
			<c:if test="${userClickCategoryProduct==true}">
				<script>
					window.categoryId = '${category.id}';
				</script>
				<ol class="breadcrumb">
					<li><a href="${contextRoot}/home">Home</a></li>
					<li class="active">Category</li>
					<li class="active">${category.name}</li>
				</ol>
			</c:if>
			<h3>Latest Features</h3>

		</div>
		<!-- /.row -->

		<!-- Page Features -->
		<div class="row text-center">
			<div class="col-md-3">
				<%@include file="./shared/sidebar.jsp"%>
			</div>
			<div class="col-lg-9">
				<table id="tableProduct" class="table table-striped table-borderd">
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty. Available</th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Brand</th>
							<th>Price</th>
							<th>Qty. Available</th>
							<th></th>
						</tr>
					</tfoot>
				</table>
			</div>

		</div>
	</div>
</div>