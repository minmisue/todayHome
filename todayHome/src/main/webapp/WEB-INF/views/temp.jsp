<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>카테고리 선택</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(document).ready(function() {
      $("#parentCategory").change(function() {
        var selectedCategoryId = $(this).val();
        var url = "${pageContext.request.contextPath}/categories/" + selectedCategoryId;
        $.ajax({
          url: url,
          type: "GET",
          dataType: "json",
          success: function(data) {
            var options = "";
            for (var i = 0; i < data.length; i++) {
              options += "<option value='" + data[i].productCategoryId + "'>" + data[i].categoryName + "</option>";
            }
            $("#childCategory").html(options);
            $("#childCategory").removeAttr("disabled");
          },
          error: function() {
            alert("카테고리 조회 중 오류가 발생했습니다.");
          }
        });
      });
    });
  </script>
  <style>
    .indent {
      margin-left: 10px;
    }
  </style>
</head>
<body>
<h1>카테고리 선택</h1>

<form>
  <label for="parentCategory">상위 카테고리:</label>
  <select name="parentCategory" id="parentCategory">
    <option value="">전체</option>
    <c:forEach items="${categories}" var="category">
      <option value="${category.productCategoryId}">
        <c:forEach begin="1" step="1" end="${category.categoryLevel}">
          &nbsp;
        </c:forEach>

          ${category.categoryName}
      </option>
    </c:forEach>
  </select>

  <br><br>

<%--  <label for="childCategory">하위 카테고리:</label>--%>
<%--  <select name="childCategory" id="childCategory" disabled>--%>
<%--    <option value="">선택하세요</option>--%>
<%--    <c:forEach items="${childCategories}" var="childCategory">--%>
<%--      <option value="${childCategory.productCategoryId}">--%>
<%--          ${childCategory.categoryName}--%>
<%--      </option>--%>
<%--    </c:forEach>--%>
<%--  </select>--%>
<%--</form>--%>

<%--<br>--%>

<%--<h2>선택된 카테고리 정보</h2>--%>
<%--<div>--%>
<%--  <c:forEach items="${selectedCategoryPath}" var="category">--%>
<%--    <span class="indent">${category.categoryName}</span>--%>
<%--    <br>--%>
<%--  </c:forEach>--%>
<%--</div>--%>
</body>
</html>
