<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/web/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="/template/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/template/css/font-awesome.min.css">
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@9.17.2/dist/sweetalert2.min.css">
     <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.7/dist/sweetalert2.all.min.js"></script>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="/template/css/owl.carousel.css">
    <link rel="stylesheet" href="/template/css/style.css">
    <link rel="stylesheet" href="/template/css/responsive.css">
</head>
<body>
	
	<tiles:insertAttribute name="header" />
    
    <tiles:insertAttribute name="menu" />
    
    <tiles:insertAttribute name="body" />
    
    <tiles:insertAttribute name="footer" />
   

    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="/template/js/owl.carousel.min.js"></script>
    <script src="/template/js/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="/template/js/jquery.easing.1.3.min.js"></script>
    <!-- jQuery -->
 <!--   <script src="/assetsAd/plugins/jquery/jquery.min.js"></script> -->
	<!--   pagination -->
	<script src="/assetsAd/dist/paging/jquery.twbsPagination.js"></script>
    
    <!-- Main Script -->
    <script src="/template/js/main.js"></script>
    
    <!-- Slider -->
    <script type="text/javascript" src="/template/js/bxslider.min.js"></script>
	<script type="text/javascript" src="/template/js/script.slider.js"></script>
</body>
</html>