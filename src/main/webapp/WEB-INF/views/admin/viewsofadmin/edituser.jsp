<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/admin/common/taglib.jsp" %>
 <c:url var="userAPI" value="/api/user" />
 <c:url var="userURL" value="/admin/user/list" />
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
	                <label for="inputName">Username</label>
	                <form:input type="text" path="username" id="username" required="true" class="form-control"/>
	              </div>
				  <div class="form-group">
	                <label for="inputName">password</label>
	                <form:input type="text" path="hashPassword" id="password" required="true" class="form-control" />
	              </div>
	              <div class="form-group">
	                <label for="inputName">re-password</label>
	                <input type="text" name="repass" id="repass" required="true" class="form-control" />
	              </div>
	              <div class="form-group">
	                <label for="inputName">fullname</label>
	                 <form:input type="text" path="fullname" id="fullname" required="true" class="form-control" />
	              </div>
	              <div class="form-group">
	                <label for="inputName">email</label>
	                <form:input type="text" path="email" required="email" id="quantity" class="form-control"/>
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
		                <label for="inputName">Role: </label>
		                <form:select path = "roleCode" id="roleCode" required="true">
		                       <form:options items = "${listRoleCode}" />
		                </form:select> 
		              </div>
            </div>
            </div>
            
            </div>
            <form:hidden path="id" id="userId" />
            <div class="row">
		        <div class="col-md-12 m-2">
		          <a href="/admin/user/list" class="btn btn-secondary">Cancel</a>
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
	 	var username = $("#username").val();
	 	var password = $("#password").val();
	 	var email = $("#email").val();
	 	var fullname = $("#fullname").val();
	 	var repass = $("#repass").val();
	 	if( username=='' || password==''|| email==''|| fullname=='' || repass==''){
	 		Swal.fire({
	 			  icon: 'error',
	 			  title: 'FAILED',
	 			  text: 'Vui lòng kiểm tra lại!',
	 			})
	 	}else if(password != repass){
	 	  alert("Password is not same!")
	 	}else{
	 		e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();	
			$.each(formData, function (i, v) {
	         data[""+v.name+""] = v.value;
	     });
			var id = $("#userId").val();
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
         url: '${userAPI}',
         type: 'POST',
         contentType: 'application/json', // gui tu clien -> servler
         data: JSON.stringify(data),		// chuyen từ js object -> JSON
         dataType: 'json',		//server - >client
         success: function (result) {
         	window.location.href = "${userURL}?message=insert_success";
         },
         error: function (error) {
        	 window.location.href = "/product/edit";
         }
     });
	}

	function updateNew(data) {
		$.ajax({
         url: '${userAPI}',
         type: 'PUT',
         contentType: 'application/json',
         data: JSON.stringify(data),
         dataType: 'json',
         success: function (result) {
         	window.location.href = "${userURL}?message=update_success";
         },
         error: function (error) {
         }
     }); 
	}
</script>