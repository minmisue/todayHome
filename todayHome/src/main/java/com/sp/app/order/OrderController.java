package com.sp.app.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sp.app.cart.CartService;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.member.Member;
import com.sp.app.domain.mypage.MemberPoint;
import com.sp.app.domain.mypage.Point;
import com.sp.app.domain.order.Delivery;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.domain.seller.SellerAdjustment;
import com.sp.app.member.management.MemberManagementService;
import com.sp.app.mypage.managerment.PointService;
import com.sp.app.product.management.ProductManagementService;
import com.sp.app.seller.adjustment.AdjustmentService;

@Controller("order.orderController")
@RequestMapping("/payment/*")
public class OrderController {
	@Autowired
	CartService cartservice;
	
	@Autowired
	ProductManagementService productservice;
	
	@Autowired
	MemberManagementService memberservie;
	
	@Autowired
	OrderManagementService orderManagementService;
	
	@Autowired
	PointService pointService;
	
	@Autowired
	AdjustmentService adjustmentService;
	
	@GetMapping("list")
	public String listCartOrder(HttpSession session,
			Model model) throws Exception {
		
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		if(info == null) {
			return "redirect:/login";
		}
		
		Long memberId = info.getMemberId();
		// 전체 장바구니 리스트 가져옴
		List<Cart> cartList = cartservice.getCartList(memberId);

		System.out.println(cartList);
		
		for(Cart cart : cartList) {
			Long cartId = cart.getCartId();
			
			List<CartOptionMap> stockIdList = cartservice.getStockId(cartId);
			
			List<ProductStock> productStockList = new ArrayList<ProductStock>();
			
			for(CartOptionMap vo : stockIdList) {
				Long stockId = vo.getStockId();
				
				Long quantity = vo.getQuantity();
				
				ProductStock productStock = productservice.getStockByStockId(stockId);
				productStock.setPrice(Long.valueOf(productStock.getOptionPrice()));
				
				productStock.setCartQuantity(quantity);
				productStockList.add(productStock);
			}
			
			cart.setProductStockList(productStockList);
			
		}
		
		String orderBundleId = orderManagementService.productOrderNumber();
		Member member = memberservie.readMemberById(memberId);
		
		
		Point point =  pointService.getPointById(memberId);
		
		Integer dataCount = cartservice.cartDateCountByMemberId(memberId);
		System.out.println(dataCount);
		if(dataCount == null) {
			return "redirect:/cart/cart-empty";
		}
		
		model.addAttribute("dataCount",dataCount);
		model.addAttribute("point", point);
		model.addAttribute("orderBundleId", orderBundleId);
		model.addAttribute("member", member);
		model.addAttribute("cartList", cartList);
		
		return "/payment/payment-page";
	}
	
	@PostMapping("paymentOk")
	@ResponseBody
	public String paymentSubmit(
			@ModelAttribute Order order,
			@RequestParam List<Long> productNums,
			@RequestParam List<Integer> finalPrices,
			@RequestParam List<Integer> originalPrices,
			@RequestParam List<Integer> disCountPercent,
			@RequestParam List<Integer> price,
			@RequestParam List<Long> stockNums,
			@RequestParam List<Integer> quantityList,
			@RequestParam List<Integer> gubun,
			@RequestParam List<Long> cartIdList,
			@RequestParam List<Integer> state,
			@RequestParam List<Integer> deliveryCostList,
			@RequestParam List<Long> sellerNums,
			@RequestParam(defaultValue = "-1") Integer remainPoint,
			@RequestParam(defaultValue = "-1") Integer usedPoint,
			@RequestParam Integer reward,
			Model model
			) {
		
		System.out.println(deliveryCostList);
		
		order.setPayMethod("카드");
		// 옵션 상세
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		List<Delivery> deliveryList = new ArrayList<Delivery>();
		
		for(int i=0;i<productNums.size();i++) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderBundleId(order.getOrderBundleId());
			orderDetail.setProductId(productNums.get(i));
			orderDetail.setDisCountPercent(disCountPercent.get(i));
			orderDetail.setFinalPrice(finalPrices.get(i));
			orderDetail.setOriginalPrice(originalPrices.get(i));
			orderDetail.setStatus(state.get(i)); // 상품 상태
			
			orderDetailList.add(orderDetail);
			
			Delivery delivery = new Delivery();
			delivery.setDeliveryCost(deliveryCostList.get(i));
			deliveryList.add(delivery);
			
			// 정산 테이블
			SellerAdjustment sellerAdjustment = new SellerAdjustment();
			sellerAdjustment.setSellerId(sellerNums.get(i));
			sellerAdjustment.setAmount(Long.valueOf(finalPrices.get(i)));
			try {
				adjustmentService.createAdjustment(sellerAdjustment);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		List<OrderItemStock> orderItemStockList = new ArrayList<OrderItemStock>();
		for(int i=0;i<stockNums.size();i++) {
			
			OrderItemStock orderItemStock = new OrderItemStock();
			orderItemStock.setGubun(gubun.get(i));
			orderItemStock.setPrice(price.get(i));
			orderItemStock.setQuantity(quantityList.get(i));
			orderItemStock.setStockId(stockNums.get(i));
			orderItemStockList.add(orderItemStock);
		}
		
		if(remainPoint != -1 ) {
			// 포인트
			Point point = new Point();
			point.setMemberId(order.getMemberId());
			point.setRemainPoint(remainPoint+reward);
			try {
				pointService.updateMemberPoint(point);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// 포인트 사용이력
			MemberPoint memberPoint = new MemberPoint();
			memberPoint.setAmount(usedPoint);
			memberPoint.setMemberId(order.getMemberId());
			memberPoint.setStatus(2);
			try {
				pointService.insertMemberPoint(memberPoint);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			// 적립금
			MemberPoint memberPoint2 = new MemberPoint();
			memberPoint2.setAmount(reward);
			memberPoint2.setMemberId(order.getMemberId());
			memberPoint2.setStatus(1);
			try {
				pointService.insertMemberPoint(memberPoint2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		try {
			orderManagementService.createOrder(order, orderDetailList, orderItemStockList,deliveryList);
		} catch (Exception e) {
			model.addAttribute("msg","결제실패");
			return "fail";

		}
		
		
		// 결제 완료 후 장바구니 삭제
		for(Long cartId : cartIdList) {
			cartservice.deleteCart(cartId);
		}
		
		return "ok";
	}
	
	// 결제 검증
	
}
