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

import com.sp.app.cart.CartService;
import com.sp.app.domain.cart.Cart;
import com.sp.app.domain.cart.CartOptionMap;
import com.sp.app.domain.common.SessionInfo;
import com.sp.app.domain.member.Member;
import com.sp.app.domain.mypage.MemberCoupon;
import com.sp.app.domain.mypage.MemberPoint;
import com.sp.app.domain.mypage.Point;
import com.sp.app.domain.order.Delivery;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;
import com.sp.app.domain.product.Product;
import com.sp.app.domain.product.ProductStock;
import com.sp.app.domain.seller.Seller;
import com.sp.app.member.management.MemberManagementService;
import com.sp.app.mypage.managerment.CouponService;
import com.sp.app.mypage.managerment.PointService;
import com.sp.app.product.management.ProductManagementService;
import com.sp.app.seller.SellerService;

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
	SellerService sellerService;
	
	@Autowired
	CouponService couponService;
	
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
		
		List<MemberCoupon> memberCoupon = couponService.getMemberCouponById(memberId);
		if(memberCoupon != null) {
			model.addAttribute("memberCoupon",memberCoupon);
		}
		
		model.addAttribute("dataCount",dataCount);
		model.addAttribute("point", point);
		model.addAttribute("orderBundleId", orderBundleId);
		model.addAttribute("member", member);
		model.addAttribute("mode","buy");
		model.addAttribute("cartList", cartList);
		
		return "/payment/payment-page";
	}
	
	@PostMapping("buy-now")
	public String BuyNowListCart(
			HttpSession session,
			@RequestParam Long productId,
			@RequestParam List<Long> stockId,
			@RequestParam List<Long> quantity,
			Model model) {
		SessionInfo info = (SessionInfo)session.getAttribute("sessionInfo");
		if(info == null) {
			return "redirect:/login";
		}
		
		Long memberId = info.getMemberId();
		Member member = null;
		try {
			member = memberservie.readMemberById(memberId);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		String orderBundleId = orderManagementService.productOrderNumber();
		List<Product> productList = new ArrayList<Product>();
		Product product =  productservice.getProductById(productId);
		
		List<ProductStock> productStockList = new ArrayList<ProductStock>();
		for(int i= 0; i<stockId.size(); i++) {
			Long stock = stockId.get(i);
			Long stockQuantity = quantity.get(i);
			
			ProductStock productStock = productservice.getStockByStockId(stock);
			productStock.setPrice(Long.valueOf(productStock.getOptionPrice()));
			
			productStock.setCartQuantity(stockQuantity);
			productStockList.add(productStock);
		}
		
		product.setProductStockList(productStockList);
		productList.add(product);
		model.addAttribute("cartList", productList);
		model.addAttribute("mode","buyNow");
		model.addAttribute("member",member);
		model.addAttribute("orderBundleId",orderBundleId);
		return "/payment/payment-page";
	}

	@PostMapping("paymentOk")
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
			@RequestParam(required = false) List<Long> cartIdList, // 바로구매일때 안씀
			@RequestParam List<Integer> state,
			@RequestParam List<Integer> deliveryCostList,
			@RequestParam List<Long> sellerNums,
			@RequestParam(required = false ,defaultValue = "-1") Integer remainPoint,
			@RequestParam(required = false, defaultValue = "-1") Integer usedPoint,
			@RequestParam Integer reward,
			@RequestParam(defaultValue = "isNottrue") String defaultAddress,
			Model model
			) {
		
		System.out.println(deliveryCostList);
		
		
		// 옵션 상세
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		List<Delivery> deliveryList = new ArrayList<Delivery>();
		
		for(int i=0;i<productNums.size();i++) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderBundleId(order.getOrderBundleId());
			orderDetail.setProductId(productNums.get(i));
			orderDetail.setDisCountPercent(disCountPercent.get(i));
			orderDetail.setFinalPrice(finalPrices.get(i));// 상품당 금액
			orderDetail.setOriginalPrice(originalPrices.get(i));
			orderDetail.setStatus(state.get(i)); // 상품 상태
			
			orderDetailList.add(orderDetail);
			
			Delivery delivery = new Delivery();
			delivery.setDeliveryCost(deliveryCostList.get(i));
			deliveryList.add(delivery);
			
			// 정산 테이블
			try {
				Seller seller = sellerService.getSellerBySellerId(sellerNums.get(i));
				Long accumulatedAmount = seller.getAccumulatedAmount(); // 업데이트 전 금액
				
				seller.setAccumulatedAmount(accumulatedAmount + Long.valueOf(finalPrices.get(i)));
				sellerService.updateAccumulatedAmount(seller); // 업데이트
				
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
		
		try {
			orderManagementService.createOrder(order, orderDetailList, orderItemStockList,deliveryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(defaultAddress.equals("istrue")) {
			Member member = new Member();
			member.setMemberId(order.getMemberId());
			member.setAddress1(order.getAddress1());
			member.setAddress2(order.getAddress2());
			member.setPostNum(order.getPostNum());
			
			try {
				memberservie.insertAddress(member);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(remainPoint != 0 || remainPoint.equals("")) {
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
			
		}
		
		if(order.getCouponId() != null) {
			try {
				couponService.deleteCoupon(order.getCouponId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 적립금
		MemberPoint memberPoint2 = new MemberPoint();
		memberPoint2.setAmount(reward);
		memberPoint2.setMemberId(order.getMemberId());
		memberPoint2.setStatus(1);
		try {
			pointService.insertMemberPoint(memberPoint2);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		

		// 결제 완료 후 장바구니 삭제
		if(cartIdList != null) {
			for(Long cartId : cartIdList) {
				cartservice.deleteCart(cartId);
			}
		}
		
		return "redirect:/payment/complete";
	}
	
	@GetMapping("complete")
	public String complete() {
		return "/payment/complete-page";
	}
}
