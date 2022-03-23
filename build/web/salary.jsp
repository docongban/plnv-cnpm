<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Start header -->
<jsp:include page="./include/header.jsp"></jsp:include>
<!-- End header -->

<div class="" style="margin-left: 15px; margin-right: 15px;">
        <table class="table table-bordered border-primary">
          <thead>
            <div class="header-table" style="color: #0d6efd">Bảng lương cá nhân Năm ${yearnow}</div>
            <tr>
              <th scope="col"></th>
              <c:forEach items="${listMonthYear}" var="i">
                <th scope="col">${i}</th>
            </c:forEach>
            </tr>
          </thead>
          <tbody>
            <th scope="row">Số ngày làm</th>
            <c:forEach items="${listWorkDays}" var="i">
                <th scope="col" style="font-weight: 500">${i}</th>
            </c:forEach>
          </tbody>
          <tbody>
            <th scope="row">Số SP đã bán</th>
            <c:forEach items="${listProdutWorked}" var="i">
                <th scope="col" style="font-weight: 500">${i}</th>
            </c:forEach>
          </tbody>
          <tbody>
            <th scope="row">Lương cứng</th>
            <c:forEach items="${listWorkDays}" var="i">
                <th scope="col" style="font-weight: 500">${salary}đ</th>
            </c:forEach>
          </tbody>
          <tbody style="color: #198754">
            <th scope="row">Số SP vượt chỉ tiêu (${quantityMin} SP)</th>
            <c:forEach items="${listOverTargetProducts}" var="i">
                <th scope="col">${i}</th>
            </c:forEach>
          </tbody>
          <tbody style="color: #dc3545">
            <th scope="row">Thưởng</th>
            <c:forEach items="${listBonus}" var="i">
                <th scope="col">${i}đ</th>
            </c:forEach>
          </tbody>
          <tbody style="font-weight: 700">
            <th scope="row">Tổng lương</th>
            <c:forEach items="${listTotalSalary}" var="i">
                <th scope="col">${i}đ</th>
            </c:forEach>
          </tbody>
        </table>
      </div>

<!-- Start footer -->
<jsp:include page="./include/footer.jsp"></jsp:include>
<!-- End footer -->