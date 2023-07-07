<%--
  Created by IntelliJ IDEA.
  User: kun
  Date: 2023/07/05
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
  <style>
    .board-content, .board-content-container, .product-tag {
      border: 1px solid black; padding: 15px
    }

    .board-content input {
      width: 80px;
    }

    .product-tag {
      display: flex;
      flex-direction: row;
      gap: 10px;
      justify-content: center;
      align-items: center;
    }

    .product-tag input {
      width: 50px;
    }
  </style>
</head>
<body>

<form name="postsForm" method="post" enctype="multipart/form-data" style="width: 500px">
  <input type="hidden" name="boardType" value="1">
  보드 제목 : <input type="text" name="subject" value="제목">
<%--  콘텐츠들 --%>
  <div class="board-content-container" style="display: flex; gap: 15px; flex-direction: column; margin-top: 10px;">
    <div class="board-content">
      <h3 >보드 콘텐츠1</h3>
      콘텐츠 : <input type="text" name="boardContentList[0].content" value="콘1 콘">
      이미지 이름 : <input type="text" name="boardContentList[0].imgName" value="콘1 이름">
      이미지 : <input type="file" name="boardContentList[0].thumbnailFile">

      <h3 >프로덕트 태그</h3>
      <div class="product-tag-container">

        <div class="product-tag">
          상품 아이디 : <input type="text" name="boardContentList[0].productTagList[0].productId" value="1">
          x좌표 : <input type="text" name="boardContentList[0].productTagList[0].xCoordinate" value="1.1">
          y좌표 : <input type="text" name="boardContentList[0].productTagList[0].yCoordinate" value="1.2">
        </div>

        <div class="product-tag">
          상품 아이디 : <input type="text" name="boardContentList[0].productTagList[1].productId" value="2">
          y좌표 : <input type="text" name="boardContentList[0].productTagList[1].xCoordinate" value="2.1">
          y좌표 : <input type="text" name="boardContentList[0].productTagList[1].yCoordinate" value="2.2">
        </div>
      </div>
    </div>

    <div class="board-content">
      <h3 >보드 콘텐츠2</h3>
      콘텐츠 : <input type="text" name="boardContentList[1].content" value="콘2 콘">
      이미지 이름 : <input type="text" name="boardContentList[1].imgName" value="콘2 이름">
      이미지 : <input type="file" name="boardContentList[1].thumbnailFile">
    </div>

    <div class="board-content">
      <h3>보드 콘텐츠3</h3>
      콘텐츠 : <input type="text" name="boardContentList[2].content" value="콘3 콘">
      이미지 이름 : <input type="text" name="boardContentList[2].imgName" value="콘3 이름">
      이미지 : <input type="file" name="boardContentList[2].thumbnailFile">
    </div>
  </div>


</form>

<button type="button" class="abledButton" onclick="sendOk();">올리기</button>

<script>
  function sendOk() {
    const f = document.postsForm;

    f.action = "${pageContext.request.contextPath}/community/picture/test";

    f.submit();
  }
</script>
</body>
</html>
