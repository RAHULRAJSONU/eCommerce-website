$(function() {
	
	//fatching csrf token from page meta
	var token=$('meta[name="_csrf"]').attr('content');
	var header=$('meta[name="_csrf_header"]').attr('content');
	if(token.length > 0 && header.length > 0){
		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header,token);
		});
	}
	
	// code for product data table

	var $table = $('#tableProduct');

	if ($table.length) {
		var jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.categoryId + '/product';

		$table
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, 50 ],
							[ '3 Records', '5 Records', '10 Records',
									'50 Records' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img class="dataTableImg" src="'
											+ window.contextRoot
											+ '/assets/bootstrap/images/products/'
											+ data + '.jpg" />';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red;">Out of Stock!</span>';
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';

									str += '<a class="btn btn-info" href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
									if (row.quantity < 1) {
										str += '<a class="btn btn-success disabled" href="javascript:void(0)"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {
										if(userRole=='ADMIN'){
											str += '<a class="btn btn-warning" href="'+window.contextRoot+'/manage/'+data+'/product"><span class="glyphicon glyphicon-pencil"></span></a>';
										}else{
											str += '<a class="btn btn-success" href="'+window.contextRoot+'/cart/add/'+data+'/product"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										}
										
									}

									return str;
								}
							} ]
				});
	}

	// dismissing the alert after 3 second
	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}

	// handling activate product via switch
	// -------------------------------------------
	// data table for admin adminProductsTable
	// -------------------------------------------

	var $adminProductsTable = $('#adminProductsTable');

	if ($adminProductsTable.length) {
		var jsonUrl = window.contextRoot + '/json/data/admin/all/product';

		$adminProductsTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img class="adminDataTableImg" src="'
											+ window.contextRoot
											+ '/assets/bootstrap/images/products/'
											+ data + '.jpg" />';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red;">Out of Stock!</span>';
									}
									return data;
								}
							}, {
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							}, {
								data : 'active',
								bSortable:false,
								mRender: function(data,type,row){
									var str='';
									str+= '<label class="switch">'
									if(data){
										str+='<input type="checkbox" checked="checked" value="'+row.id+'"/>';
									}else{
										str+='<input type="checkbox" value="'+row.id+'"/>';
									}
									str+='<div class="slider"></div></label>';
									return str;
								}
							},
							{
								data:'id',
								bSortable: false,
								mRender: function(data, type, row){
									var str='';
									str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
									str+='<span class="glyphicon glyphicon-pencil"></span></a>';
									return str;
								}
							}
							],
							initComplete:function(){
								var api=this.api();
								api.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox.prop('checked');
											var dMsg = (checked) ? 'You want to activate this product?'
													: 'You want to deactivate this product?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,
														callback : function(confirmed) {
															if (confirmed) {
																console.log(value);
																var activationUrl = window.contextRoot+'/manage/product/'+value+'/activation'; 
																
																$.post(activationUrl, function(data){
																	bootbox.alert({
																		size : 'medium',
																		title : 'Information',
																		message : data
																	});
																});
														
															} else {
																checkbox.prop('checked', !checked);
															}
														}
													});

										});

							}
				});
	}

	// --------------------------------------------
	// validation code for category
	
	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		$categoryForm.validate({
			rules: {
				name: {
					required:true,
					minlength:2
				},
				
				description: {
					required:true
				}
			},
			
			message:{
				name:{
					required:'Please add the category name!',
					minlength:'The category name should not be less than 2 characters'
				},
				
				description:{
					required:'Please enter description about the category!'
				}
			},
			errorElement:'em',
			errorPlacement: function(error, element){
				//add the class of the help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
		});
	}
	//--------------------------
// validation code for Login
	
	var $loginForm = $('#loginForm');
	
	if($loginForm.length){
		$loginForm.validate({
			rules: {
				username: {
					required:true,
					email:true
				},
				
				password: {
					required:true
				}
			},
			
			message:{
				username:{
					required:'Please enter the username!',
					minlength:'Please enter a valid email address!'
				},
				
				password:{
					required:'Please enter your password!'
				}
			},
			errorElement:'em',
			errorPlacement: function(error, element){
				//add the class of the help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
		});
	}
	//--------------------------

});
