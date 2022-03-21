<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Start header -->
<jsp:include page="./include/header.jsp"></jsp:include>
<!-- End header -->

    <div class="container">
        <div class="title">Cập nhật mức lương cứng</div>
        <div class="row " >
          <div class="col-md-3"></div>
          <div class="col-md-6">
            <form action="salary-update" method="post" class="input-group">
                <input type="text" name="salaryupdate" value="${salary}" class="form-control" placeholder="Nhập mức lương" aria-label="Recipient's username" aria-describedby="button-addon2">
              
              <button class="btn btn-primary" type="submit" id="button-addon2">Cập nhật</button>
            </form>
              <p class="form-message" style="color: red">${warning}</span>
          </div>
        </div>
    </div>

<!-- Start footer -->
<jsp:include page="./include/footer.jsp"></jsp:include>
<!-- End footer -->