<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Start header -->
<jsp:include page="./include/header.jsp"></jsp:include>
<!-- End header -->

    <div class="main">
        <form action="login" method="post" class="form" id="register-form">
            <h3 class="heading">Đăng nhập</h3>

            <div class="spacer">
                <p style="color: red">${warning}</p>
            </div>

            <div class="form-group">
                <label for="phone" class="form-label">Số điện thoại</label>
                <input id="phone" name="phone" value="${phoneuser}" rules="required" type="text" placeholder="" class="form-control">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="password" class="form-label">Mật khẩu</label>
                <input id="password" name="password" rules="required|min:6" type="password" placeholder="" class="form-control">
                <span class="form-message"></span>
            </div>

            <button class="form-submit ">Đăng nhập
                <span><i class="fa-solid fa-arrow-right"></i></span>
            </button>
            <a href="#" class="forget">Quên mật khẩu</a>
        </form> 
     </div> 

<!-- Start footer -->
<jsp:include page="./include/footer.jsp"></jsp:include>
<!-- End footer -->