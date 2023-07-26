<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/admin/common/taglib.jsp" %>
 <c:url var="categoryAPI" value="/api/category" />
 <c:url var="categoryURL" value="/admin/category/list" />
<!-- Main content -->
    <section class="content">

      <!-- Default box -->
     
      <div class="card">
        <div class="card-header">
         <div class="card-title">
                <form action="/admin/category/search" method="post">
         				<div class="input-group input-group-sm">
		                  <input type="text" name="keyword" class="form-control" placeholder="Search">
		                  <div class="input-group-append">
		                    	<button type="submit" class="btn btn-primary"><i class="fas fa-search"></i></button>
		                  </div>
		                </div>
         		</form>
              </div>
			
          <div class="card-tools">
          	<c:url var="addCategoryUrl" value="/admin/category/edit"/>
            <a class="btn btn-warning btn-sm" href="${addCategoryUrl}">
                  <i class="fas fa-plus"></i>
                              Add
             </a>
          </div>
        </div>
        <div class="card-body p-0">
          <table class="table table-striped projects">
              <thead>
                  <tr>
                      <th style="width: 1%">
                          #
                      </th>
                      <th >
                          Category Name
                      </th>
                      <th >
                          Category code
                      </th>
                      <th >
                      	
                      </th>
                  </tr>
              </thead>
              <tbody>
              <c:forEach var="item" items="${list}">
              		<tr>
                      <td>
                          ${item.id}
                      </td>
                      <td>
							${item.name}
                      </td>
                      <td>
							${item.code}
                      </td>
                      <td class="project-actions text-right">
                          <c:url var="updateCategoryURL" value="/admin/category/edit">
								<c:param name="id" value="${item.id}"/>
							</c:url>
                          <a class="btn btn-info btn-sm" href="${updateCategoryURL}">
                              <i class="fas fa-pencil-alt">
                              </i>
                              Edit
                          </a>
                          <a class="btn btn-danger btn-sm" value="hello" href="/admin/category/delete/${item.id}">
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
       <form action="/admin/category/list" id="formSubmit">
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