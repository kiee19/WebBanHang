<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/admin/common/taglib.jsp" %>
 <c:url var="categoryAPI" value="/api/category" />
 <c:url var="categoryURL" value="/category/list" />
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
							modelAttribute="model">
            <div class="card-body">
              <div class="form-group">
                <label for="inputName">Category Name</label>
                <form:input type="text" path="name" id="name" class="form-control"/>
              </div>
				<div class="form-group">
                <label for="inputName">Category Code</label>
                <form:input type="text" path="code" id="code" class="form-control"/>
              </div>
            </div>
            <form:hidden path="id" id="categoryId" />
            <div class="row">
		        <div class="col-md-12 m-2">
		          <a href="/admin/category/list" class="btn btn-secondary">Cancel</a>
		          <c:if test="${empty model.id}">
										<button class="btn btn-success" type="button"
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

	 	if( code=='' || name==''){
	 		Swal.fire({
	 			  icon: 'error',
	 			  title: 'FAILED',
	 			  text: 'Vui lòng kiểm tra lại!',
	 			})
	 	}else{
	 		e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) {
	         data[""+v.name+""] = v.value;
	     	});
			var id = $("#categoryId").val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
			}
			console.log(formData);
	 	}
		
	});
 function addNew(data) {
		$.ajax({
         url: '${categoryAPI}',
         type: 'POST',
         contentType: 'application/json', // gui tu clien -> servler
         data: JSON.stringify(data),		// chuyen từ js object -> JSON
         dataType: 'json',		//server - >client
         success: function (result) {
         	window.location.href = "${categoryURL}?message=insert_success";
         },
         error: function (error) {
         	//window.location.href = "${newURL}?page=1&limit=2&message=error_system";
         }
     });
	}

	function updateNew(data) {
		$.ajax({
         url: '${categoryAPI}',
         type: 'PUT',
         contentType: 'application/json',
         data: JSON.stringify(data),
         dataType: 'json',
         success: function (result) {
         	window.location.href = "${categoryURL}?message=update_success";
         },
         error: function (error) {

         }
     }); 
	}
</script>