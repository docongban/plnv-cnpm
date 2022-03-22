<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Start header -->
<jsp:include page="./include/header.jsp"></jsp:include>
<!-- End header -->

    <div class="container">
        <div class="title">Cập nhật sản phẩm bán được</div>
        <div class="row " >
          <div class="col-md-3"></div>
          <div class="col-md-6">
            <div class="input-group">
              <form action="search-product-by-name" method="post" style="display: flex">
                  <input type="text" name="title" style="width: 330px" class="form-control" placeholder="Nhập tên sản phẩm" aria-label="Recipient's username" aria-describedby="button-addon2">
                <button class="btn btn-primary" type="submit" id="button-addon2">Tìm</button>
              </form>
              <a href="listproductsupdate.jsp" class="btn btn-primary" style="margin-left: 30px;">Danh sách (1)</a>
            </div>
          </div>
        </div>

        
        <div class="row row-cols-1 row-cols-md-4 g-4 m-t-30">
        <c:forEach items="${list}" var="o">
          <div class="col">
            <div class="card">
              <img src="${o.thumbnail}" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">${o.title}</h5>
                <p class="card-text">${o.content}</p>
                <h5 class="card-title" style="float: left">${o.price}đ</h5>
                <a href="#" class="btn btn-primary" style="float: right">Thêm</a>
              </div>
            </div>
          </div>
        </c:forEach>
        </div>
      </div>

<!-- Start footer -->
<jsp:include page="./include/footer.jsp"></jsp:include>
<!-- End footer -->