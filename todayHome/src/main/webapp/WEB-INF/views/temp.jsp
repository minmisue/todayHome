<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>카테고리 선택</title>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<style>
        .indent {
            margin-left: 10px;
        }
	</style>
</head>
<body>
<h1>카테고리 선택</h1>

<form>

	<div id="selectContainer">
		<label for="parentCategory">상위 카테고리:</label>
		<select class="category-select" name="parentCategory" id="parentCategory">
			<option value="">전체</option>
			<c:forEach items="${categories}" var="category">
				<option value="${category.productCategoryId}">
						<%--        <c:forEach begin="1" step="1" end="${category.categoryLevel}">--%>
						<%--          &nbsp;--%>
						<%--        </c:forEach>--%>

						${category.categoryName}
				</option>
			</c:forEach>
		</select>

		<br><br>

<%--		<label for="childCategory">하위 카테고리:</label>--%>
<%--		<select name="childCategory" id="childCategory" disabled>--%>
<%--			<option value="">선택하세요</option>--%>
<%--			<c:forEach items="${childCategories}" var="childCategory">--%>
<%--				<option value="${childCategory.productCategoryId}">--%>
<%--						${childCategory.categoryName}--%>
<%--				</option>--%>
<%--			</c:forEach>--%>
<%--		</select>--%>
	</div>
</form>

<div>
	<label for="parentCategory">상위 카테고리:</label>
	<select class="category-select" name="parentCategory">
		<option value="">전체</option>
		<c:forEach items="${productCategories}" var="category">
			<c:choose>
				<c:when test="${not empty category.subCategoryList}">
					<c:forEach items="${category.subCategoryList}" var="subcategory">
						<c:set var="indent" value="" />
						<c:forEach begin="1" end="${subcategory.categoryLevel}" varStatus="loop">
							<c:set var="indent" value="${indent}  " />
						</c:forEach>
						<option value="${subcategory.productCategoryId}">
								${indent}${subcategory.categoryName}
						</option>
						<c:forEach items="${subcategory.subCategoryList}" var="subsubcategory">
							<c:set var="indent" value="${indent}  " />
							<option value="${subsubcategory.productCategoryId}">
									${indent}${subsubcategory.categoryName}
							</option>
							<!-- 계층 구조에 따라 더 하위 계층이 있다면 위와 같이 반복하여 출력 -->
						</c:forEach>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<option value="${category.productCategoryId}">
							${category.categoryName}
					</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>

</div>

<%--<br>--%>

<%--<h2>선택된 카테고리 정보</h2>--%>
<%--<div>--%>
<%--  <c:forEach items="${selectedCategoryPath}" var="category">--%>
<%--    <span class="indent">${category.categoryName}</span>--%>
<%--    <br>--%>
<%--  </c:forEach>--%>
<%--</div>--%>

<script>
    <%--$(document).ready(function () {--%>
    <%--    $("#parentCategory").change(function () {--%>
    <%--        let selectContainer = $('#selectContainer');--%>

    <%--        var selectedCategoryId = $(this).val();--%>
    <%--        var url = "${pageContext.request.contextPath}/categories/" + selectedCategoryId;--%>
    <%--        $.ajax({--%>
    <%--            url: url,--%>
    <%--            type: "GET",--%>
    <%--            dataType: "json",--%>
    <%--            success: function (data) {--%>
    <%--                var options = "";--%>

    <%--                console.log(data.length)--%>

    <%--                if (data.length === 0) {--%>
    <%--                    return;--%>
    <%--                } else {--%>
    <%--                    console.log('hello')--%>
    <%--                    for (var i = 0; i < data.length; i++) {--%>
    <%--                        options += "<option value='" + data[i].productCategoryId + "'>" + data[i].categoryName + "</option>";--%>
    <%--                    }--%>

    <%--                    let selectTag =--%>
    <%--                        `--%>
	<%--								<label for="childCategory">하위 카테고리:</label>--%>
	<%--								<select name="childCategory" id="childCategory">--%>
	<%--									<option value="">선택하세요</option>--%>
	<%--									` + options + `--%>
	<%--								</select>--%>
	<%--							`--%>

    <%--                    // $("#childCategory").removeAttr("disabled");--%>
    <%--                    selectContainer.append(selectTag);--%>
    <%--                }--%>
    <%--            },--%>
    <%--            error: function () {--%>
    <%--                alert("카테고리 조회 중 오류가 발생했습니다.");--%>
    <%--            }--%>
    <%--        });--%>
    <%--    });--%>
    <%--});--%>
</script>
</body>
</html>
