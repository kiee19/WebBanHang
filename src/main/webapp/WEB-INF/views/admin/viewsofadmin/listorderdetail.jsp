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
						<th>Product Name</th>
						<th>Image</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Order Id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${items}">
						<tr>
							<td>${item.productName}</td>
							<td><img alt="Avatar" class="table-avatar"
								src="${item.imgUrl}"></td>
							<td><fmt:formatNumber type="number" maxFractionDigits="3"
									value="${item.price}" /></td>
							<td>${item.quantity}</td>
							<td>${item.orderId}</span>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<!-- /.card-body -->
	</div>
	 <div class="row">
		        <div class="col-md-12 m-2">
		          <a href="/admin/report/list" class="btn btn-secondary">Cancel</a>
		        </div>
		      </div>
	<!-- /.card -->
</section>
<!-- /.content -->
