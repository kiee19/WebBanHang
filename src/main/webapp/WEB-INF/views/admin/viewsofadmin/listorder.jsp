<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/common/taglib.jsp"%>
<!-- Main content -->
<section class="content">

	<!-- Default box -->
	<div class="card">
		<div class="card-header">
			<div class="card-title">
			</div>
		</div>
		<div class="card-body p-0">
			<table class="table table-striped projects">
				<thead>
					<tr>
						<th>id</th>
						<th>Username</th>
						<th>Address</th>
						<th>Phone</th>
						<th class="text-center">Status</th>
						<th>Total price</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${items}">
						<tr>
							<td>${item.id}</td>
							<td>${item.userId.fullname}</td>
							<td>${item.address} </td>
							<td>${item.phone}</td>
							<td class="project-state">
								<c:if test="${item.status == 'Đã giao hàng'}">
									<span class="badge badge-success">${item.status}</span>
								</c:if> 
								<c:if test="${item.status != 'Đã giao hàng'}">
									<span class="badge badge-danger">${item.status}</span>
								</c:if> 
							</td>
							<td><fmt:formatNumber type="number" maxFractionDigits="3"
									value="${item.totalPrice}" /></td>
							<td class="project-actions text-right"><a
								class="btn btn-primary btn-sm" href="/admin/order-detail/${item.id}"> <i
									class="fas fa-folder"> </i> View
							</a> 
							<c:url var="updateOrderURL" value="/admin/order/edit">
									<c:param name="id" value="${item.id}" />
									<c:param name="status" value="${item.status}" />
								</c:url> <a class="btn btn-info btn-sm" href="${updateOrderURL}">
									<i class="fas fa-pencil-alt"> </i> Change Status
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
	<form action="/admin/product/list" id="formSubmit">
		<div class="row" style="justify-content: center;">
			<ul class="pagination" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page" /> <input
				type="hidden" value="" id="limit" name="limit" />
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
</script>