package com.sp.app.order;

public class OrderState {
	// 주문상태 정보
	/*
		0:입금대기, 1:결제완료, 2:발송처리, 3:배송시작, 4:배송중, 5:배송완료, 6:전체주문판매취소(관리자)/주문자전체주문취소
	*/
	public static final String[] ORDERSTATEINFO = 
		{"입금대기", "결제완료", "발송처리", "배송시작", "배송중", "배송완료", "판매취소"};

}
