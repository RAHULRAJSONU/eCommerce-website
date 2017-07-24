<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			</div>
		</c:if>

		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body">
					<!-- FORM ADD PRODUCT -->
					<sf:form class="form-horizontal" method="POST"
						action="${contextRoot}/manage/products" modelAttribute="product"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Input
								Product Name</label>
							<div class="col-md-8">
								<sf:input type="text" id="name" path="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Input
								Brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" id="brand" path="brand"
									placeholder="Product Brand" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Input
								Product Description</label>
							<div class="col-md-8">
								<sf:textarea rows="4" id="description" path="description"
									placeholder="Product Description" class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Product
								Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" id="unitPrice" path="unitPrice"
									placeholder="Product unit price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Product
								Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" id="quantity" path="quantity"
									placeholder="Product quantity" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">select
								Product Category</label>
							<div class="col-md-8">
								<sf:select id="categoryId" path="categoryId"
									class="form-control" items="${categories}" itemLabel="name"
									itemValue="id" />
								<c:if test="${product.id==0}">
									<div class="text-right">
										<br />
										<button type="button" data-toggle="modal"
											data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add
											Category</button>
									</div>
								</c:if>
							</div>
						</div>

						<!-- File element for an image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image: </label>
							<div class="col-md-8">
								<sf:input type="file" id="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" id="submit" name="submit" value="submit"
									class="btn btn-success" />
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								<sf:hidden path="active" />
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<h3>Available Product</h3>
			<hr />
		</div>
		<div class="col-xs-12">
			<div style="overflow: auto">
				<div class="table-responsive">
					<!-- Products table for Admin -->
					<table id="adminProductsTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Brand</th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Unit Price</th>
								<th>Active</th>
								<th>Edit</th>
							</tr>
						</tfoot>
					</table>

				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog"
		tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- modal header -->
				<div class="modal-header"">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Add new Category</h4>
				</div>
				<!-- modal body -->
				<div class="modal-body">
					<!-- Category Form -->
					<sf:form modelAttribute="category" id="categoryForm" action="${contextRoot}/manage/category"
					method="POST" class="form-horizontal">
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category Name</label>
							<div class="col-md-8">
								<sf:input path="name" type="text" id="category_name" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Category description</label>
							<div class="col-md-8">
								<sf:textarea path="description" cols="" rows="5" id="category_description" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary"/>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>