<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/admin/common/taglib.jsp" %>
 <c:url var="userAPI" value="/api/user" />
 <c:url var="userURL" value="/admin/user/list" />
<!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="card">
        <div class="card-header">
         <div class="card-title">
         		<form action="/admin/user/search" method="post">
         				<div class="input-group input-group-sm">
		                  <input type="text" name="keyword" class="form-control" placeholder="Search">
		                  <div class="input-group-append">
		                    	<button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
		                  </div>
		                </div>
         		</form>
              </div>
          <div class="card-tools">
          	<c:url var="addUserUrl" value="/admin/user/edit"/>
            <a class="btn btn-warning btn-sm" href="${addUserUrl}">
                  <i class="fas fa-plus"></i>
                              Add
             </a>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
              <thead>
                  <tr>
                      <th >
                          Username
                      </th>
                      <th >
                          Image
                      </th>
                      <th>
                          Fullname
                      </th>
                      <th>
                          Email
                      </th>
                      <th  class="text-center">
                          Role
                      </th>
                      <th >
                      	
                      </th>
                  </tr>
              </thead>
              <tbody>
              <c:forEach var="item" items="${items}">
              		<tr>
                      <td>
							${item.username}
                      </td>
                      <td>
                          <img alt="Avatar" class="table-avatar" src="${item.imgUrl}">
                      </td>
                      <td>
							${item.fullname}
                      </td>
                      <td>
							${item.email}
                      </td>
                      <td class="project-state">
                          <span class="badge badge-success">${item.roleCode}</span>
                      </td>
                      <td class="project-actions text-right">
                           <c:url var="updateUserURL" value="/admin/user/edit">
								<c:param name="id" value="${item.id}"/>
							</c:url>
                          <a class="btn btn-info btn-sm" href="${updateUserURL}">
                              <i class="fas fa-pencil-alt">
                              </i>
                              Edit
                          </a>
                          <a class="btn btn-danger btn-sm" href="/admin/user/delete/${item.id}">
                              <i class="fas fa-trash">
                              </i>
                              Delete
                          </a>
                      </td>
                  </tr>
              </c:forEach>
                  
              </tbody>
          </table>
        </div>
        <!-- /.card-body -->
      </div>
      <!-- /.card -->
		<form action="/admin/user/list" id="formSubmit">
       			<div class="row" style="justify-content: center;">
						<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" id="page" name="page"/>
							<input type="hidden" value="" id="limit" name="limit"/>
				</div>
       	</form>
    </section>
    <!-- /.content -->
    <script type="text/javascript">
    var url = window.location.search;
    if( url == "?message=insert_success"){
    	const Toast = Swal.mixin({
    		  toast: true,
    		  position: 'top-end',
    		  showConfirmButton: false,
    		  timer: 3000,
    		  timerProgressBar: true,
    		  didOpen: (toast) => {
    		    toast.addEventListener('mouseenter', Swal.stopTimer)
    		    toast.addEventListener('mouseleave', Swal.resumeTimer)
    		  }
    		})

    		Toast.fire({
    		  icon: 'success',
    		  title: 'Thêm Mới Thành Công!'
    		})
    }else if( url == "?message=update_success"){
   	 const Toast = Swal.mixin({
		  toast: true,
		  position: 'top-end',
		  showConfirmButton: false,
		  timer: 3000,
		  timerProgressBar: true,
		  didOpen: (toast) => {
		    toast.addEventListener('mouseenter', Swal.stopTimer)
		    toast.addEventListener('mouseleave', Swal.resumeTimer)
		  }
		})

		Toast.fire({
		  icon: 'success',
		  title: 'Cập Nhật Thành Công!'
		})
}
    var totalPages = ${totalPage};
	var currentPage = ${currentPage};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 10,
				startPage: currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(5);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
    
  function warningBeforeDelete(id){
	  const swalWithBootstrapButtons = Swal.mixin({
		  customClass: {
		    confirmButton: 'btn btn-danger m-2',
		    cancelButton: 'btn btn-success m-1'
		  },
		  buttonsStyling: false 
		})
		swalWithBootstrapButtons.fire({
		  title: 'Are you sure?',
		  text: "",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonText: 'Yes, delete it!',
		  cancelButtonText: 'No, cancel!',
		  reverseButtons: true
		}).then((result) => {
		  if (result.isConfirmed) {
				deleteNew(id);
		    swalWithBootstrapButtons.fire(
		      'Deleted!',
		      'Your file has been deleted.',
		      'success'
		    )
		  } else if (
		    /* Read more about handling dismissals below */
		    result.dismiss === Swal.DismissReason.cancel
		  ) {
		    swalWithBootstrapButtons.fire(
		      'Cancelled',
		      'Your file is safe :)',
		      'error'
		    )
		  }
		})
	}
</script>