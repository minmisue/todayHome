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
.css-a4hf5k {
    margin-top: 40px;
    color: rgb(47, 52, 56);
	}
	
	.css-1066lcq {
    display: flex;
    -webkit-box-pack: justify;
    justify-content: space-between;
    -webkit-box-align: center;
    align-items: center;
	}
	
	.css-o538wr {
    font-size: 24px;
    line-height: 32px;
    font-weight: 700;
	}
	
	.css-1eaft1l {
    font-size: 14px;
    line-height: 18px;
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    background-color: inherit;
    border: 0px;
    padding: 7px;
	}
	
	.css-18ewygj {
    margin-top: 20px;
	}
	
	.css-oc7sge {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    border-top: 1px solid rgb(234, 237, 239);
    padding: 20px 10px;
	}
	
	.css-oc7sge > div {
    box-sizing: border-box;
	}
	
	.css-1kwo4sf {
    width: 100%;
    display: flex;
	}	
	
	.css-3eylin {
    font-size: 14px;
    line-height: 18px;
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    color: rgb(53, 197, 240);
	}
	
	.css-15jzb03 {
    width: 100%;
    margin-top: 0px;
    margin-left: 20px;
	}
	
	.css-s5xdrg {
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-align-items: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
	}
	
	.content{
	padding: 0 290px;
	}
	
	.css-lgp5e9blue {
    text-align: right;
    margin-left: 16px;
    font-size: 20px;
    line-height: 28px;
    font-weight: 700;
    flex-shrink: 0;
    color: rgb(53, 197, 240);
	}
	
	.css-lgp5e9red {
    text-align: right;
    margin-left: 16px;
    font-size: 20px;
    line-height: 28px;
    font-weight: 700;
    flex-shrink: 0;
    color: rgb(255, 119, 119);
	}
	
	.css-y3863iblue {
    background-color: rgb(239, 251, 255);
    color: rgb(53, 197, 240);
	}
	
	.css-y3863ired {
    background-color: rgb(239, 251, 255);
    color: rgb(255, 119, 119);
	}
	
	.css-1kzfo6n {
    font-size: 16px;
    line-height: 20px;
    margin-left: 8px;
    font-weight: 700;
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
	selectMyPage(2,1);
});

</script>
</head>
<body>

	<jsp:include page="/WEB-INF/views/fragment/menubar.jsp"/>

	<div class="main-container">
		<div class="content">

         <div class="css-a4hf5k">
				<div class="css-1066lcq">
					<h2 class="css-o538wr">결제 내역</h2>
				</div>
				<div class="css-18ewygj">
				<c:forEach var="orderdetailList" items="${orderdetailList }" varStatus="status">
					<div class="css-oc7sge">
						<div class="css-1kwo4sf">
							<div class="css-3eylin">${orderdetailList.status == 5 ? "결제" : ""}</div>
							<div class="css-15jzb03 e1rx7pum5">
								<div class="css-s5xdrg e1rx7pum4">
									<div class="css-y3863i"></div>
									<h2 class="css-1kzfo6n">상품번호 : ${orderdetailList.productName }</h2>
								</div>
							</div>
						</div>
						
						<div class="css-lgp5e9red">가격 : ${orderdetailList.finalPrice}</div>
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	

	<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>
</body>
</html>


	<script type="text/javascript">
	</script>
