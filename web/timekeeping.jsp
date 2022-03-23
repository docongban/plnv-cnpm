<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Start header -->
<jsp:include page="./include/header.jsp"></jsp:include>
<!-- End header -->


<div class="container">
    <p class="title">Bảng chấm công Tháng ${monthnow}/${yearnow}</p>
<table class="table table-bordered border-primary" >
    <thead>
      <tr>
        <th colspan="10" class="text-align: center">Tổng số ngày làm hiện tại của Tháng ${monthnow}: <span style="color: #0d6efd">${listDateSize} ngày</span></th>
      </tr>
    </thead>
    <!-- Nam nhuan -->
    <c:if test="${yearnow % 4 == 0}">
        <!-- Thang co 30 ngay -->
        <c:if test="${monthnow == 4||monthnow == 6||monthnow == 9||monthnow == 11}">
            <tbody>
                <tr>
                    <c:forEach begin="1" end="10" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="11" end="20" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="21" end="30" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
            </tbody>
        </c:if>
        
        <!-- Thang co 31 ngay -->
        <c:if test="${monthnow == 1||monthnow == 3||monthnow == 5||monthnow == 7||monthnow == 8||monthnow == 10||monthnow == 12}">
            <tbody>
                <tr>
                    <c:forEach begin="1" end="10" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="11" end="20" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="21" end="30" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr style="border-bottom: none">
                    <c:forEach begin="31" end="31" step="1" var="i">
                        <td style="border-bottom: 1px solid #0d6efd">Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
            </tbody>
        </c:if>
            
        <!-- Thang 2 nam nhuan co 29 ngay -->
        <c:if test="${monthnow == 2}">
            <tbody>
                <tr>
                    <c:forEach begin="1" end="10" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="11" end="20" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="21" end="29" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
            </tbody>
        </c:if>
    </c:if>
    
    <!-- Nam ko nhuan -->
    <c:if test="${yearnow % 4 !=0}">
        <!-- Thang co 30 ngay -->
        <c:if test="${monthnow == 4||monthnow == 6||monthnow == 9||monthnow == 11}">
            <tbody>
                <tr>
                    <c:forEach begin="1" end="10" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="11" end="20" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="21" end="30" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
            </tbody>
        </c:if>
        
        <!-- Thang co 31 ngay -->
        <c:if test="${monthnow == 1||monthnow == 3||monthnow == 5||monthnow == 7||monthnow == 8||monthnow == 10||monthnow == 12}">
            <tbody>
                <tr>
                    <c:forEach begin="1" end="10" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="11" end="20" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="21" end="30" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr style="border-bottom: none">
                    <c:forEach begin="31" end="31" step="1" var="i">
                        <td style="border-bottom: 1px solid #0d6efd">Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
            </tbody>
        </c:if>
            
        <!-- Thang 2 nam ko nhuan co 28 ngay -->
        <c:if test="${monthnow == 2}">
            <tbody>
                <tr>
                    <c:forEach begin="1" end="10" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="11" end="20" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach begin="21" end="28" step="1" var="i">
                        <td>Ngày ${i} 
                            <c:if test="${listDate.contains(i)==true}"><p class="yes">Có</p></c:if>
                            <c:if test="${listDate.contains(i)==false}"><p class="absent">Vắng</p></c:if>
                        </td>
                    </c:forEach>
                </tr>
            </tbody>
        </c:if>
    </c:if>
  </table> 
</div>
<!-- Start footer -->
<jsp:include page="./include/footer.jsp"></jsp:include>
<!-- End footer -->