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
        <div class="row">
            <%
                if (cart_list != null && cart_list.size()>0) { 
                    for (ListProductsUpdate c : cartProduct) {
            %>
            <div class="col-md-12">
                <div class="product-cart">
                  <div class="product-cart__img" style="background-image: url('<%=c.getThumbnail()%>');"></div>
                  <div class="product-cart__content">
                      <div class="product-cart__content-title"><%=c.getTitle()%></div>
                      <div class="product-cart__content-decrip" ><%=c.getContent()%></div>
                  </div>
                  <div class="product-cart__price-old"><%=c.getPrice()%></div>

                  <a href="quantity-dec-inc?action=dec&id=<%= c.getId()%>" class="product-cart__btn_left"><i class="fas fa-angle-left"></i></a> 
                  <input type="text" name="quantity" value="<%=c.getQuantity()%>" class="product-cart__quantity" readonly>
                  <a href="quantity-dec-inc?action=inc&id=<%= c.getId()%>" class="product-cart__btn_right"><i class="fas fa-angle-right"></i></a> 

                  <div class="product-cart__price"><%=c.getPrices()%></div>
                  <a href="remove-product?id=<%= c.getId()%>" class="product-cart__delete">
                      <i class="fas fa-trash-alt"></i>
                  </a>
              </div>
            </div>
            <%
            }}%>
        </div>
        <a href="productsupdate.jsp" class="btn btn-primary m-t-30" style="float: left;">Thêm tiếp sản phẩm</a>
        <a href="insert-products-update" class="btn btn-primary m-t-30" style="float: right;">Thêm</a>
      </div>

<!-- Start footer -->
<jsp:include page="./include/footer.jsp"></jsp:include>
<!-- End footer -->