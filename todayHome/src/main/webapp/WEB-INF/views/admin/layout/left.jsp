<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<script type="text/javascript">
// 메뉴 활성화
function adminLogout(){
      let f = document.createElement('form');
      f.setAttribute('method', 'post');
      f.setAttribute('action', '${pageContext.request.contextPath}' + '/admin/logout')

      document.body.appendChild(f);	
      f.submit();
  }
  $(document).ready(function() {
    $('#adminLogout').click(function(e) {
      e.preventDefault(); 

      $('#logoutForm').submit();
    });
  });
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
			<h1>관리자 페이지</h1>
		</div>
		<div class="header-right">
			<span class="img" style="background-image: url('${pageContext.request.contextPath}/resources/images/person.png');"></span>
			<span class="roll-user">
				<label class="roll">관리자</label>
				<label class="user">
					<span class="name">관리자</span>
					<a href="${pageContext.request.contextPath}/"><i class="fa-solid fa-arrow-right-from-bracket"></i></a>
				</label>
			</span>
		</div>
	</div>

</header>

<nav class="vertical_nav">
	<ul id="js-menu" class="menu">
	
		<li class="menu--item">
			<a href="${pageContext.request.contextPath}/admin" class="menu--link" title="Home">
				<i class="menu--icon  fa-fw fa-solid fa-house"></i>
				<span class="menu--label">Home</span>
			</a>
		</li>

		<li class="menu--item menu--item__has_sub_menu">
	        <label class="menu--link" title="회원 관리">
				<i class="menu--icon  fa-fw fa-solid fa-user-group"></i>
				<span class="menu--label">회원 관리</span>
			</label>
			
			<ul class="sub_menu">
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/faqManage/main'/>" class="sub_menu--link">일반 회원</a>
				</li>
			</ul>
			<ul class="sub_menu">
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/faqManage/main'/>" class="sub_menu--link">판매자</a>
				</li>
			</ul>					
		</li>
	
		<li class="menu--item menu--item__has_sub_menu">
			<label class="menu--link" title="글관리">
				<i class="menu--icon  fa-fw fa-solid fa-newspaper"></i>
				<span class="menu--label">글관리</span>
			</label>

			<ul class="sub_menu">
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/event/list'/>" class="sub_menu--link">이벤트 글 생성</a>
				</li>
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/noticeManage/list'/>" class="sub_menu--link">회원 글 리스트</a>
				</li>
				<li class="sub_menu--item">
					<a href="<c:url value='/admin/inquiryManage/list'/>" class="sub_menu--link">회원 글 수정</a>
				</li>
			</ul>
		</li>

		<li class="menu--item">
	        <a href="#" class="menu--link" title="상품 관리">
				<i class="menu--icon fa-fw fa-solid fa-basket-shopping"></i>
				<span class="menu--label">상품 관리</span>
			</a>
		</li>

		<li class="menu--item">
			<a href="#" class="menu--link" title="주문통계">
				<i class="menu--icon  fa-fw fa-solid fa-chart-pie"></i>
				<span class="menu--label">주문 통계</span>
			</a>
		</li>

		<li class="menu--item">
			<a href="<c:url value='/admin/adjustment/list'/>" class="menu--link" title="정산 리스트">
				<i class="menu--icon  fa-fw fa-solid fa-calculator"></i>
				<span class="menu--label">정산 리스트</span>
			</a>
		</li>

		<li class="menu--item">
			<a class="menu--link" href="javascript:void(0)" onclick="adminLogout()" >
				<i class="menu--icon fa-fw fa-solid fa-lock-open"></i>
				<span class="menu--label">Logout</span>
			</a>
		</li>
	</ul>

	<button id="collapse_menu" class="collapse_menu">
		<i class="collapse_menu--icon fa fa-fw"></i>
		<span class="menu--label">Recolher menu</span>
	</button>

</nav>
