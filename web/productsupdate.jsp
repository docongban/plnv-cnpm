<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.DAO"%>
<%@page import="java.util.*"%>
<%@page import="enity.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
DecimalFormat df = new DecimalFormat(",###");
    
ArrayList<ListProductsUpdate> cart_list = (ArrayList<ListProductsUpdate>) session.getAttribute("cart-list");
List<ListProductsUpdate> cartProduct = null;
if (cart_list != null) {
	DAO dao = new DAO();
	cartProduct = dao.getListProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}
%>

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
              <% if(cart_list == null || cart_list.size()<=0){ %>
                <a href="listproductsupdate.jsp" class="btn btn-primary" style="margin-left: 30px;">Danh sách (0)</a>
              <% }%>
              <% if(cart_list != null && cart_list.size()>0){ %>
                <a href="listproductsupdate.jsp" class="btn btn-primary" style="margin-left: 30px;">Danh sách (<%= cart_list.size()%>)</a>
              <% }%>
            </div>
          </div>
        </div>

        
        <c:if test="${list.size()==0}">
            <p class="no-product">Không có sản phẩm nào vui lòng nhập lại</p>
        </c:if>
            
        <c:if test="${list.size()!=0}">
            <div class="row row-cols-1 row-cols-md-4 g-4 m-t-30">
                <c:forEach items="${list}" var="o">
                  <div class="col">
                    <div class="card">
                      <img src="${o.thumbnail}" class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title" style="height: 48px">${o.title}</h5>
                        <p class="card-text">${o.content}</p>
                        <h5 class="card-title" style="float: left">${String.format("%.0f",o.price)}đ</h5>
                        <a href="add-to-list-products?id=${o.id}" class="btn btn-primary" style="float: right">Thêm</a>
                      </div>
                    </div>
                  </div>
                </c:forEach>
            </div>
        </c:if>
      </div>

<!-- Start footer -->
<jsp:include page="./include/footer.jsp"></jsp:include>
<!-- End footer -->