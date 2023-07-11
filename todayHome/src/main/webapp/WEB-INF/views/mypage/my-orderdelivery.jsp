<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<jsp:include page="/WEB-INF/views/fragment/static-header.jsp"/>
	<title>Home</title>

	<style>
a:not(:last-of-type):after {
   position: absolute;
   display: block;
   content: "";
   width: 12px;
   height: 12px;
   transform: rotate(45deg);
   border: solid #bdbdbd;
   border-width: 2px 2px 0 0;
   right: 0;
}

.menu-item {
   display: flex;
   box-shadow: 0 1px 3px 0 #dbdbdb;
   padding: 10px;
   border-radius: 4px;
   min-height: 60px;
   margin: 0;
}

.menu-item a {
   text-decoration: none;
   margin: 0;
   padding: 0;
   background: none;
   font: inherit;
   display: flex;
   flex: 1 0 0px;
   align-items: center;
   justify-content: center;
   border: none;
   border-right: 1px solid #dbdbdb;
   cursor: pointer;
   font-size: 15px;
   min-height: 60px;
}

.menu-item-content {
   align-items: center;
   text-align: center;
   word-break: break-all;
   color: #292929;
   line-height: 18px;
   display: flex;
   flex-direction: row;
   margin: 0;
   padding: 0;
}

.menu-item-content span {
   cursor: pointer;
   font-size: 15px;
   font: inherit;
}

.menu-item-content span:nth-child(2) {
   color: #35c5f0;
   font-weight: 700;
   margin-left: 5px;
   display: inline-block;
   min-width: 30px;
   font: inherit;
   cursor: pointer;
   font-size: 15px;
}

.status-item {
   display: flex;
   box-shadow: 0 1px 3px 0 #dbdbdb;
   padding: 20px;
   border-radius: 4px;
   min-height: 60px;
   margin-top: 20px;
}

.status-item a {
   align-items: center;
   position: relative;
   cursor: pointer;
   justify-content: center;
   display: flex;
   flex: 1 0 0px;
}

.status-item-content {
   text-align: center;
   border: none;
   margin: 0;
   cursor: pointer;
   padding: 0;
}

.status-item-content div:first-child {
   font-size: 20px;
   margin-bottom: 15px;
}

.status-item-content div:last-child {
   font-size: 20px;
   color: #35c5f0;
}

.purchase-container {
   margin-top: 50px;
   box-shadow: rgba(0, 0, 0, 0.15) 0px 1px 4px;
   padding: 30px;
}

.purchase-container .item {
   min-height: 62px;
   margin-bottom: 10px;
}

.custom-container {
   margin-top: 50px;
   box-shadow: rgba(0, 0, 0, 0.15) 0px 1px 4px;
   padding: 30px;
}

.custom-inner-container {
   min-height: 62px;
   margin-bottom: 10px;
}

.custom-button-group {
   margin: 0;
   padding: 0;
   display: block;
}

.custom-button-wrapper {
   justify-content: space-between;
   min-width: 0;
   margin: 0 -2px;
   padding: 5px 0;
   overflow: auto;
   display: flex;
}

.custom-button-list {
   flex: 0 0 auto;
   min-width: 0;
   margin: 0;
   padding: 0;
   list-style: none;
   white-space: nowrap;
}

.custom-button-item {
   list-style: none;
   white-space: nowrap;
   display: inline-block;
   margin: 0 2px;
   vertical-align: bottom;
   font-size: 0;
   line-height: 0;
}

.custom-button {
   font-size: 15px;
   line-height: 19px;
   padding: 7px 8px 6px;
   font-weight: 700;
   border: 1px solid transparent;
   border-radius: 6px;
   background-color: #f5f5f5;
   border-color: #f5f5f5;
   color: #757575;
}

	</style>
	
<script type="text/javascript">
$(function () {
	// 여기에서 메뉴 선택
    // 첫번째 파라미터 (커뮤니티, 쇼핑 중 선택)	
    // 두번째 파라미터 (서브 메뉴 중 몇번째인지 선택)
	// 두번째 파라미터에 null 입력시 메뉴바 숨김
    selectCurrentMenu(0, null);

    // 마이페이지일때 메뉴
	// 메인메뉴, 서브메뉴 숫자 입력
	// 첫번째 파라미터에 0 입력시 숨김
	selectMyPage(2,4);
});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">
 <div>
            <div class="menu-item">
               <a class="coupon">
                  <div class="menu-item-content">
                     <span>쿠폰</span> <span>0</span>
                  </div>
               </a> <a class="point">
                  <div class="menu-item-content">
                     <span>포인트</span> <span>0P</span>
                  </div>
               </a> <a class="grade">
                  <div class="menu-item-content">
                     <span>등급</span> <span>WELCOME</span>
                  </div>
               </a>
            </div>

            <div class="status-item">
               <a>
                  <div class="status-item-content">
                     <div>입금대기</div>
                     <div>0</div>
                  </div>
               </a> <a>
                  <div class="status-item-content">
                     <div>결제완료</div>
                     <div>0</div>
                  </div>
               </a> <a>
                  <div class="status-item-content">
                     <div>배송준비</div>
                     <div>0</div>
                  </div>
               </a> <a>
                  <div class="status-item-content">
                     <div>배송중</div>
                     <div>0</div>
                  </div>
               </a> <a>
                  <div class="status-item-content">
                     <div>배송완료</div>
                     <div>0</div>
                  </div>
               </a> <a>
                  <div class="status-item-content">
                     <div>구매확정</div>
                     <div>0</div>
                  </div>
               </a>
            </div>
         </div>

         <div class="custom-container">
            <div class="custom-inner-container">
               <div class="custom-button-group">
                  <div class="custom-button-wrapper">
                     <ul class="custom-button-list">
                        <li class="custom-button-item">
                           <div class="custom-button-wrapper">
                              <button class="custom-button">기간</button>
                           </div>
                        </li>
                        <li class="custom-button-item">
                           <div class="custom-button-wrapper">
                              <button class="custom-button">주문상태</button>
                           </div>
                        </li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
		</div>
	</div>
	
	

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>
