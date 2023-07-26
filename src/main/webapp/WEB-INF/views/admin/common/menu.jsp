<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="../../index3.html" class="brand-link">
      <img src="/assetsAd/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Admin</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="${currentUser.imgUrl}" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${currentUser.fullname}</a>
        </div>
      </div>
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="/admin/user/list" class="nav-link">
              <i class="fa fa-users" aria-hidden="true"></i>&nbsp;
              <p>
                Account Management
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/admin/product/list" class="nav-link">
              <i class="fa fa-tablet" aria-hidden="true"></i>&nbsp;
              <p>
                Product Management
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/admin/category/list" class="nav-link">
              <i class="fa fa-list-alt" aria-hidden="true"></i>&nbsp;
              <p>
                Category Management
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/admin/report/list" class="nav-link">
              <i class="fa fa-book" aria-hidden="true"></i>&nbsp;
              <p>
                Report Management
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/admin/bin/list" class="nav-link">
              <i class="fa fa-trash" aria-hidden="true"></i>&nbsp;
              <p>
                Recycle Bin
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/admin/product-bin/list" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Product Bin</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="/admin/category-bin/list" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Category Bin</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="/admin/user-bin/list" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>User Bin</p>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
 </div>
    <!-- /.sidebar -->
  </aside>