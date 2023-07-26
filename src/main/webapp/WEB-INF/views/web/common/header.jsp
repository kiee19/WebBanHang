<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/views/web/common/taglib.jsp"%>
<div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                        	<c:if test="${not empty currentUser}">
                        		<li><a href="#"><i class="fa fa-user"></i>Xin Chào, ${currentUser.fullname}</a></li>
                            	<li><a href="/logout"><i class="fa fa-user"></i>Log Out</a></li>
                        	</c:if>
                        	<c:if test="${empty currentUser}">
                        		<li><a href="/login"><i class="fa fa-user"></i> Sign In</a></li>
                            <li><a href="/signup"><i class="fa fa-user"></i> Sign Up</a></li>
                        	</c:if>
                            
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">English</a></li>
                                    <li><a href="#">Tiếng việt</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->