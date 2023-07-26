<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/web/common/taglib.jsp"%>
<!-- Main content -->
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shopping Cart</h2>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Search Products</h2>
					<form action="">
						<input type="text" placeholder="Search products..."> <input
							type="submit" value="Search">
					</form>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Products</h2>
					<div class="thubmnail-recent">
						<img src="/template/img/product-thumb-1.jpg" class="recent-thumb" alt="">
						<h2>
							<a href="single-product.html">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img src="/template/img/product-thumb-1.jpg" class="recent-thumb" alt="">
						<h2>
							<a href="single-product.html">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img src="/template/img/product-thumb-1.jpg" class="recent-thumb" alt="">
						<h2>
							<a href="single-product.html">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img src="/template/img/product-thumb-1.jpg" class="recent-thumb" alt="">
						<h2>
							<a href="single-product.html">Sony Smart TV - 2015</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$700.00</ins>
							<del>$100.00</del>
						</div>
					</div>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Recent Posts</h2>
					<ul>
						<li><a href="single-product.html">Sony Smart TV - 2015</a></li>
						<li><a href="single-product.html">Sony Smart TV - 2015</a></li>
						<li><a href="single-product.html">Sony Smart TV - 2015</a></li>
						<li><a href="single-product.html">Sony Smart TV - 2015</a></li>
						<li><a href="single-product.html">Sony Smart TV - 2015</a></li>
					</ul>
				</div>
			</div>

			<div class="col-md-8">
				<div class="product-content-right">
					<div class="woocommerce">
						<div class="woocommerce-info">
							Returning customer? <a class="showlogin" data-toggle="collapse"
								href="#login-form-wrap" aria-expanded="false"
								aria-controls="login-form-wrap">Click here to login</a>
						</div>

						<form id="login-form-wrap" class="login collapse" method="post">


							<p>If you have shopped with us before, please enter your
								details in the boxes below. If you are a new customer please
								proceed to the Billing &amp; Shipping section.</p>

							<p class="form-row form-row-first">
								<label for="username">Username or email <span
									class="required">*</span>
								</label> <input type="text" id="username" name="username"
									class="input-text">
							</p>
							<p class="form-row form-row-last">
								<label for="password">Password <span class="required">*</span>
								</label> <input type="password" id="password" name="password"
									class="input-text">
							</p>
							<div class="clear"></div>


							<p class="form-row">
								<input type="submit" value="Login" name="login" class="button">
								<label class="inline" for="rememberme"><input
									type="checkbox" value="forever" id="rememberme"
									name="rememberme"> Remember me </label>
							</p>
							<p class="lost_password">
								<a href="#">Lost your password?</a>
							</p>

							<div class="clear"></div>
						</form>
							<div id="customer_details" class="col2-set">
								<div class="col-1">
									<div class="woocommerce-billing-fields">
										<h3>Billing Details</h3>

										<p id="billing_company_field" class="form-row form-row-wide">
											<label class="" for="billing_company">Your Name</label> <input
												type="text" value="${currentUser.fullname}" placeholder="" id="billing_company"
												name="billing_company" class="input-text ">
										</p>
										<div class="clear"></div>

										<p id="billing_email_field"
											class="form-row form-row-first validate-required validate-email">
											<label class="" for="billing_email">Your Address <abbr
												title="required" class="required">*</abbr>
											</label> <input type="text" value="" placeholder=""
												id="address" name="billing_email" class="input-text ">
										</p>

										<p id="billing_phone_field"
											class="form-row form-row-last validate-required validate-phone">
											<label class="" for="billing_phone">Phone <abbr
												title="required" class="required">*</abbr>
											</label> <input type="text" value="" placeholder=""
												id="phone" name="billing_phone" class="input-text ">
										</p>
										<div class="clear"></div>
									</div>
								</div>
							</div>
							<h3 id="order_review_heading">Your order</h3>

							<div id="order_review" style="position: relative;">
								<table class="shop_table">
									<thead>
										<tr>
											<th class="product-name">Product</th>
											<th class="product-total">Total</th>
										</tr>
									</thead>
									<tbody>
										<tr class="cart_item">
											<td class="product-name">Cart Subtotal
											</td>
											<td class="product-total"><span class="amount"><fmt:formatNumber type="number" maxFractionDigits="3" value="${currentCart.totalPrice}"/></span>
											</td>
										</tr>
										<tr class="cart_item">
											<td class="product-name">Shipping and Handling
											</td>
											<td class="product-total"><span class="amount">Free Shipping</span>
											</td>
										</tr>
									</tbody>
									<tfoot>
										<tr class="order-total">
											<th>Order Total</th>
											<td><strong><span class="amount"><fmt:formatNumber type="number" maxFractionDigits="3" value="${currentCart.totalPrice}"/></span></strong>
											</td>
										</tr>

									</tfoot>
								</table>


								<div id="payment">
									<ul class="payment_methods methods">
										<li class="payment_method_bacs"><input type="radio"
											data-order_button_text="" checked="checked" value="bacs"
											name="payment_method" class="input-radio"
											id="payment_method_bacs"> <label
											for="payment_method_bacs">Direct Bank Transfer </label>
											<div class="payment_box payment_method_bacs">
												<p>Make your payment directly into our bank account.
													Please use your Order ID as the payment reference. Your
													order won’t be shipped until the funds have cleared in our
													account.</p>
											</div></li>
										<li class="payment_method_cheque"><input type="radio"
											data-order_button_text="" value="cheque"
											name="payment_method" class="input-radio"
											id="payment_method_cheque"> <label
											for="payment_method_cheque">Cheque Payment </label>
											<div style="display: none;"
												class="payment_box payment_method_cheque">
												<p>Please send your cheque to Store Name, Store Street,
													Store Town, Store State / County, Store Postcode.</p>
											</div></li>
										<li class="payment_method_paypal"><input type="radio"
											data-order_button_text="Proceed to PayPal" value="paypal"
											name="payment_method" class="input-radio"
											id="payment_method_paypal"> <label
											for="payment_method_paypal">PayPal <img
												alt="PayPal Acceptance Mark"
												src="https://www.paypalobjects.com/webstatic/mktg/Logo/AM_mc_vs_ms_ae_UK.png"><a
												title="What is PayPal?"
												onclick="javascript:window.open('https://www.paypal.com/gb/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=1060, height=700'); return false;"
												class="about_paypal"
												href="https://www.paypal.com/gb/webapps/mpp/paypal-popup">What
													is PayPal?</a>
										</label>
											<div style="display: none;"
												class="payment_box payment_method_paypal">
												<p>Pay via PayPal; you can pay with your credit card if
													you don’t have a PayPal account.</p>
											</div></li>
									</ul>

									<div class="form-row place-order">

										<input type="button" data-value="Place order"
											value="Place order" id="place_order"
											name="woocommerce_checkout_place_order" onclick="placeOrder()" class="button alt">

									</div>

									<div class="clear"></div>

								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function placeOrder() {
	var address = $('#address').val();
	var phone = $('#phone').val();
	if( address=='' || phone==''){
 		Swal.fire({
 			  icon: 'error',
 			  title: 'FAILED',
 			  text: 'Vui lòng kiểm tra lại địa chỉ và số điện thoại!',
 			})
 	}else{
 		var urlApi = "/api/cart/checkout?address="+address+"&phone="+phone;
 		$.ajax({
 			type: "GET",
 			contentType : "application/json",
 			url: urlApi,
 			async: false,
 			success: function(currentCart) {
 				window.location.href = "/cart?checkout=success";
 			},
 			error: function(e) {
 				alert(e);
 	    	}
 	   });
 	}
	
}
	
</script>