<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
// 메뉴 활성화
  $(document).ready(function() {
    $('#sellerLogout').click(function(e) {
      e.preventDefault(); 

      $('#logoutForm').submit();
    });
  });

  function sellerLogout(){
      let f = document.createElement('form');
      f.setAttribute('method', 'post');
      f.setAttribute('action', '${pageContext.request.contextPath}' + '/seller/logout')

      document.body.appendChild(f);	
      f.submit();
  }

$(function(){
    var url = window.location.pathname;
    var urlRegExp = new RegExp(url.replace(/\/$/, '') + "$");
    
    try {
    	$('nav ul>li>a').each(function() {
    		if ( urlRegExp.test(this.href.replace(/\/$/, '')) ) {
    			$(this).addClass('active_menu');
    			return false;
    		}
    	});
    	if($('nav ul>li>a').hasClass("active_menu")) return false;

     	var parent = url.replace(/\/$/, '').substr(0, url.replace(/\/$/, '').lastIndexOf("/"));
     	if(! parent) parent = "/";
        var urlParentRegExp = new RegExp(parent);
    	$('nav ul>li>a').each(function() {
    		if($(this).attr("href")=="#") return true;
    		
    		var phref = this.href.replace(/\/$/, '').substr(0, this.href.replace(/\/$/, '').lastIndexOf("/"));
    		
    		if ( urlParentRegExp.test(phref) ) {
    			$(this).addClass('active_menu');
    			return false;
    		}
    	});
    	if($('nav ul>li>a').hasClass("active_menu")) return false;
    	
    	$('nav ul>.menu--item__has_sub_menu').each(function() {
    		if (urlRegExp.test(this.href.replace(/\/$/, '')) ) {
    			$(this).addClass('active_menu');
    			return false;
    		}
    	});
    	
    }catch(e) {
    }
});

$(function(){
	$('nav ul>.menu--item__has_sub_menu ul>li>a').each(function() {
		if($(this).hasClass('active_menu')) {
			$(this).closest(".menu--item__has_sub_menu").addClass('menu--subitens__opened');
			return false;
		}
	});
});
</script>

<header class="header clearfix">
	<button type="button" id="toggleMenu" class="toggle_menu">
		<i class="fa-solid fa-bars"></i>
	</button>
	
	<div class="header-container">
		<div class="header-left">
			<h1>판매자 페이지</h1>
		</div>
		<div class="header-right">
 	
			<span class="img" style="background-image: url('${pageContext.request.contextPath}/resources/images/person.png');"></span>
			<span class="roll-user">
				<label class="roll">판매자</label>
				<label class="user">					
					<span class="name">${sessionScope.sellerSessionInfo.sellerName}님</span>
					<a href="javascript:void(0)" onclick="sellerLogout()"><i class="fa-solid fa-arrow-right-from-bracket"></i></a>
				</label>
			</span>

		</div>
	</div>

</header>

<nav class="vertical_nav">
	<ul id="js-menu" class="menu">
	
		<li class="menu--item">
			<a href="${pageContext.request.contextPath}/seller" class="menu--link" title="Home">
				<i class="menu--icon  fa-fw fa-solid fa-house"></i>
				<span class="menu--label">Home</span>
			</a>
		</li>

		<li class="menu--item menu--item__has_sub_menu">
	        <label class="menu--link" title="상품 관리">
				<i class="menu--icon  fa-fw fa-solid fa-basket-shopping"></i>
				<span class="menu--label">상품 관리</span>
			</label>
			<ul class="sub_menu">
				<li class="sub_menu--item">
					<a href="<c:url value='/seller/product'/>" class="sub_menu--link">상품 등록</a>
				</li>
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/inquiryManage/list'/>" class="sub_menu--link">상품 조회</a>
				</li>
			</ul>
		</li>
	
		<li class="menu--item menu--item__has_sub_menu">
			<label class="menu--link" title="주문/배송 관리">
				<i class="menu--icon  fa-fw fa-solid fa-truck-fast"></i>
				<span class="menu--label">주문/배송 관리</span>
			</label>

			<ul class="sub_menu">
				<li class="sub_menu--item">
					<a href="<c:url value='/seller/deliveryManage'/>" class="sub_menu--link">배송조회/수정</a>
				</li>
				<li class="sub_menu--item">
					<a href="<c:url value='/seller/delivery/ordermanage'/>" class="sub_menu--link">주문 조회</a>
				</li>
			</ul>
		</li>

		<li class="menu--item">
	        <a href="<c:url value='/seller/adjustment/list'/>" class="menu--link" title="정산 현황">
				<i class="menu--icon  fa-fw fa-solid fa-calculator"></i>
				<span class="menu--label">정산 현황</span>
			</a>
		</li>
		
		<li class="menu--item">
	        <a href="<c:url value='/seller/adjustment/money'/>" class="menu--link" title="정산 받기">
				<i class="menu--icon  fa-fw fa-solid fa-won-sign"></i>
				<span class="menu--label">정산 받기</span>
			</a>
		</li>		

		<li class="menu--item menu--item__has_sub_menu">
			<label class="menu--link" title="고객 관리">
				<i class="menu--icon  fa-fw fa-solid fa-user-group"></i>
				<span class="menu--label">고객 관리</span>
			</label>
			<ul class="sub_menu">
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/faqManage/main'/>" class="sub_menu--link">상품 문의 답변</a>
				</li>
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/noticeManage/list'/>" class="sub_menu--link">상품 리뷰</a>
				</li>
			</ul>
		</li>
		
		<li class="menu--item">
	        <a href="<c:url value='/seller/chart/chart'/>" class="menu--link" title="판매 통계">
				<i class="menu--icon  fa-fw fa-solid fa-chart-pie"></i>
				<span class="menu--label">판매 통계</span>
			</a>
		</li>
		
		<li class="menu--item menu--item__has_sub_menu">
			<label class="menu--link" title="판매자 정보">
				<i class="menu--icon  fa-fw fa-solid fa-gear"></i>
				<span class="menu--label">판매자 설정</span>
			</label>
			<ul class="sub_menu">
				<li class="sub_menu--item">
					<a href="<c:url value='/seller/status'/>" class="sub_menu--link">상태 확인</a>
				</li>
				<li class="sub_menu--item">
					<a href="<c:url value='/seller/update'/>" class="sub_menu--link">판매자 정보 수정</a>
				</li>
			</ul>
		</li>	
	</ul>

	<button id="collapse_menu" class="collapse_menu">
		<i class="collapse_menu--icon fa fa-fw"></i>
		<span class="menu--label">사이드바 숨기기</span>
	</button>

</nav>
