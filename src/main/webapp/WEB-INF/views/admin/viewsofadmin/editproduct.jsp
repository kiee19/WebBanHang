<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/admin/common/taglib.jsp" %>
 <c:url var="productAPI" value="/api/product" />
 <c:url var="productURL" value="/admin/product/list" />
<!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-12">
        
        	<div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">General</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <form:form role="form" id="formSubmit"
							modelAttribute="model" enctype="multipart/form-data">
            <div class="card-body">
            <div class="row">
            		<div class="col-md-6">
            	<div class="form-group">
	                <label for="inputName">Name</label>
	                <form:input type="text" path="name" id="name" required="true" class="form-control"/>
	              </div>
				  <div class="form-group">
	                <label for="inputName">Code</label>
	                <form:input type="text" path="code" id="code" required="true" class="form-control" />
	              </div>
	              
	              <div class="form-group">
	                <label for="inputName">Price</label>
	                <form:hidden path="price" id="price"/>
	                <input type="text" id="priceTemp" required="true" value="<fmt:formatNumber type="number" pattern="#########" value="${model.price}"/>" class="form-control"/>
	              </div>
	              <div class="form-group">
	                <label for="inputName">Quantity</label>
	                <form:input type="text" path="quantity" required="true" id="quantity" class="form-control"/>
	              </div>
	              <div class="form-group">
	                <label for="inputName">Description</label>
	                <form:input type="text" path="description" class="form-control"/>
	              </div>
            </div>
            <div class="col-md-5 float-right">
            	<div class="form-group">
	                <label for="inputName">Image</label> <br>
	                <img id="showImg" src="${model.imgUrl}" width="90px">
	                <form:hidden path="imgUrl" id="imgUrl" />
	                <input type="file" id="fileUpload" name="fileUpload"  class="form-control-file mt-2"/>
	              </div>
	               <div class="form-group">
		                <label for="inputName">Status: </label>
		                <form:select path = "status" id="status" required="true">
		                       <form:options items = "${listStatus}" />
		                </form:select> 
		              </div>
		              <div class="form-group">
		                <label for="inputName">Category code: </label>
		                <form:select path = "categoryCode" id="categoryCode" required="true">
		                       <form:options items = "${listCategoryCode}" />
		                </form:select> 
		              </div>
            </div>
            </div>
            
            </div>
            <form:hidden path="id" id="productId" />
            <div class="row">
		        <div class="col-md-12 m-2">
		          <a href="/admin/product/list" class="btn btn-secondary">Cancel</a>
		          <c:if test="${empty model.id}">
										<button class="btn btn-success" type="submit"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm
										</button>
				</c:if>
				<c:if test="${not empty model.id}">
										<button class="btn btn-success" type="button"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật
										</button>
				</c:if>
		        </div>
		      </div>
            
            <!-- /.card-body -->
             </form:form>
          </div>
          <!-- /.card -->
       
          
        </div>
      </div>
      
    </section>
    <!-- /.content -->
    
 <script type="text/javascript">
 $('#btnAddOrUpdateNew').click(function(e) {
	 	var name = $("#name").val();
	 	var code = $("#code").val();
	 	var quantity = $("#quantity").val();
	 	var price = $("#priceTemp").val();
	 	var categoryCode = $("#categoryCode").val();
	 	var status = $("#status").val();
	 	var check = false;
	 	if( code=='' || name==''|| quantity==''|| price==''){
	 		Swal.fire({
	 			  icon: 'error',
	 			  title: 'FAILED',
	 			  text: 'Vui lòng kiểm tra lại!',
	 			})
	 	}else{
	 		e.preventDefault();
			var data = {};
			$('#price').val($('#priceTemp').val());
			var formData = $('#formSubmit').serializeArray();
			
			$.each(formData, function (i, v) {
	         data[""+v.name+""] = v.value;
	     });
			var id = $("#productId").val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
			console.log(formData);
	 	}
		
	}); 
 $(document).ready(function(){
		$("input[type=file]").change(function(){
			var formData = new FormData();
			var file = $('#fileUpload')[0].files[0];
			formData.append("file", file);
	        $.ajax({
		        url: '/api/uploadfile',
		        type: 'POST',
		        data: formData,
		        enctype: 'multipart/form-data',
		        processData: false,  // Important!
		        contentType: false,
		        cache: false,
		    }).then(function(data) {
			    $('#imgUrl').val(data.fileDownloadUri);
			    $('#showImg').attr('src', data.fileDownloadUri);
		    }).fail(function(error) {
				alert('Failed');
		    });
	    });
	}); 

 function addNew(data) {
		$.ajax({
         url: '${productAPI}',
         type: 'POST',
         contentType: 'application/json', // gui tu clien -> servler
         data: JSON.stringify(data),		// chuyen từ js object -> JSON
         dataType: 'json',		//server - >client
         success: function (result) {
         	window.location.href = "${productURL}?message=insert_success";
         },
         error: function (error) {
        	 window.location.href = "/product/edit";
         }
     });
	}

	function updateNew(data) {
		$.ajax({
         url: '${productAPI}',
         type: 'PUT',
         contentType: 'application/json',
         data: JSON.stringify(data),
         dataType: 'json',
         success: function (result) {
         	window.location.href = "${productURL}?message=update_success";
         },
         error: function (error) {
         }
     }); 
	}
</script>