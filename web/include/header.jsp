<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="./assets/style.css">
    <title>Admin</title>
</head>
<body>
    
    <!-- Start navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="./">Home</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              
            <c:if test="${sessionScope.acc.isAdmin == 1 || sessionScope.acc.isAdmin == 2}">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Quản lý tài khoản
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <c:if test="${sessionScope.acc.isAdmin == 2 }">
                    <li><a class="dropdown-item" href="#">Quản lý thông tin quản lý</a></li>
                </c:if>
                <li><a class="dropdown-item" href="#">Quản lý thông tin nhân viên</a></li>
                <li><a class="dropdown-item" href="#">Cấp tài khoản nhân viên</a></li>
                <li><a class="dropdown-item" href="#">Xem thông tin cá nhân</a></li>
                <li><a class="dropdown-item" href="#">Tìm kiếm thông tin nhân viên</a></li>
              </ul>
            </li>
            </c:if>
            
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Quản lý lương
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <c:if test="${sessionScope.acc.isAdmin == 1 || sessionScope.acc.isAdmin == 2}">
                    <li><a class="dropdown-item" href="#">Quản lý bảng chấm công</a></li>
                    <li><a class="dropdown-item" href="#">Xem bảng lương nhân viên</a></li>
                    <li><a class="dropdown-item" href="salaryupdate.jsp">Cập nhật mức lương cứng theo tháng</a></li>
                    <li><a class="dropdown-item" href="maxproductsupdate.jsp">Cập nhật số lượng sản phẩm tối thiểu</a></li>
                    <c:if test="${sessionScope.acc.isAdmin == 2}">
                        <li><a class="dropdown-item" href="#">Duyệt bảng lương</a></li>
                    </c:if>
                </c:if>
                <c:if test="${sessionScope.acc.isAdmin == 0}">
                    <li><a class="dropdown-item" href="#">Xem bảng chấm công</a></li>
                    <li><a class="dropdown-item" href="#">Cập nhật sản phẩm bán được</a></li>
                    <li><a class="dropdown-item" href="#">Xem lương thưởng cá nhân</a></li>
                </c:if>
              </ul>
            </li>
            
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Quản lý ca làm
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <c:if test="${sessionScope.acc.isAdmin == 0}">
                    <li><a class="dropdown-item" href="#">Xem ca làm việc cá nhân</a></li>
                </c:if>
                <c:if test="${sessionScope.acc.isAdmin == 1 || sessionScope.acc.isAdmin == 2}">
                    <li><a class="dropdown-item" href="#">Xem ca làm việc nhân viên</a></li>
                </c:if>
                
              </ul>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Chức năng khác
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#">Xem thông báo</a></li>
                <c:if test="${sessionScope.acc.isAdmin == 1 || sessionScope.acc.isAdmin == 0}">
                <li><a class="dropdown-item" href="#">Kiến nghị đề xuất</a></li>
                </c:if>
                <c:if test="${sessionScope.acc.isAdmin == 2}">
                    <li><a class="dropdown-item" href="#">Ra thông báo</a></li>
                    <li><a class="dropdown-item" href="#">Phản hồi kiến nghị</a></li>
                </c:if>
              </ul>
            </li>
          </ul>
        </div>
        
            
        <c:if test="${sessionScope.acc == null}">
            <a class="nav-link" href="login.jsp">Đăng nhập</a>
        </c:if>
        
        <c:if test="${sessionScope.acc != null}">
            <a class="nav-link" href="#">${sessionScope.acc.fullname}</a>
            <a class="nav-link" href="logout">Đăng xuất</a>
        </c:if>
      </div>
    </nav>
    <!-- End navbar -->