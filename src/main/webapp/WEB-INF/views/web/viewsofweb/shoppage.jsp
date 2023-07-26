<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/web/common/taglib.jsp"%>
<!-- Main content -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shop</h2>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="promo-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo1">
					<i class="fa fa-refresh"></i>
					<p>30 Days return</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo2">
					<i class="fa fa-truck"></i>
					<p>Free shipping</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo3">
					<i class="fa fa-lock"></i>
					<p>Secure payments</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo4">
					<i class="fa fa-gift"></i>
					<p>New products</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End promo area -->

<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<form action="/shoppage/search" method="post">
					<div class="input-group">
						<input type="text" class="form-control" name="keyword" placeholder="Search">
						<div class="input-group-btn">
							<button class="btn btn-default btn-sm" style="padding: 8px 15px"
								type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-9">
				<form action="/shoppage" method="post">
					<div class="col-sm-4">
						<div class="form-group" class="form-inline">
							<span style="white-space: nowrap"> <label for="size">Sắp
									Xếp Theo:</label> 
							<select class="form-control" name="order-by"
								onchange="this.form.submit()" id="size"
								style="display: inline-block">
									<c:if test="${sort=='asc'}">
										<option value = "asc" selected>Giá tăng dần</option>
										<option value = "desc" >Giá giảm dần</option>
									</c:if>
									<c:if test="${sort!='asc'}">
										<option value = "asc" >Giá tăng dần</option>
										<option value = "desc" selected>Giá giảm dần</option>
									</c:if>
							</select>
							</span>
						</div>
					</div>
				</form>
			</div>
		</div>
		<hr>
		<div class="row">
			<c:forEach var="item" items="${items}">
				<div class="col-md-3 col-sm-6">
					<div class="single-shop-product">
						<div class="product-upper">
							<img src="${item.imgUrl}" style="height: 200px">
						</div>
						<h2>
		                      <h2><a href="/single-product/${item.id}">${item.name}</a></h2>
						</h2>
						<div class="product-carousel-price">
							<ins>
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${item.price}" />
							</ins>
						</div>

						<div class="product-option-shop">
							<a class="add_to_cart_button" data-quantity="1"
								data-product_sku="" data-product_id="70" rel="nofollow"
								onclick="addToCart(${item.id})">Add to cart</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="product-pagination text-center">
					<form action="/shoppage" id="formSubmit">
						<div class="row" style="justify-content: center;">
							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" id="page" name="page" /> <input
								type="hidden" value="" id="limit" name="limit" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
var totalPages = ${totalPage};
var currentPage = ${currentPage};
	$(function() {
		window.pagObj = $('#pagination').twbsPagination({
			totalPages: totalPages,
			visiblePages: 10,
			startPage: currentPage,
			onPageClick : function(event, page) {
				if (currentPage != page) {
					$('#limit').val(8);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
			}
		});
	});
	
	function addToCart(productId) {
		var apiUrl = '/api/cart/update?productId=' + productId + '&quantity=1&isReplate=false';
		$.ajax({
				type: "GET",
				contentType : "application/json",
				url: apiUrl,
				async: false,
				success: function(currentCart) {
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top',
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
						  title: 'Thêm Vào Giỏ Hàng Thành Công!'
						})
					$('#totalPrice').text(numberWithDot(currentCart.totalPrice));
				},
				error: function(e) {
					alert(e);
    	    	}
    	   });
	}
	
	function numberWithDot(x) {
	    return x.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ".");
	}
</script>
