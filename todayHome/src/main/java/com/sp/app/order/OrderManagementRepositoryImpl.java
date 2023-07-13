package com.sp.app.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.app.common.CommonDAO;
import com.sp.app.domain.order.Delivery;
import com.sp.app.domain.order.Order;
import com.sp.app.domain.order.OrderDetail;
import com.sp.app.domain.order.OrderItemStock;

@Repository
public class OrderManagementRepositoryImpl implements OrderManagementRepository{

	@Autowired
	CommonDAO commondao;
	
	@Override
	public void insertOrderBundle(Order order) throws Exception {
		commondao.insertData("order.insertOrderBundle", order);
		
	}

	@Override
	public void insertOrderItem(OrderDetail orderDetail) throws Exception {
		commondao.insertData("order.insertOrderItem", orderDetail);
		
	}

	@Override
	public void insertOrderItemStock(OrderItemStock orderItemStock) throws Exception {
		commondao.insertData("order.insertOrderItemStock", orderItemStock);
		
	}

	@Override
	public void insertOrderStatus(OrderDetail orderDetail) throws Exception {
		commondao.insertData("order.insertOrderStatus", orderDetail);
		
	}

	@Override
	public void insertDelivery(Delivery delivery) throws Exception {
		commondao.insertData("order.insertDelivery", delivery);
		
	}

	@Override
	public List<Order> getOrderList(Long sellerId,int offset,int size,String startDate, String endDate,String keyword,String condition) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("sellerId", sellerId);
		map.put("offset", offset);			
		map.put("size", size);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("keyword", keyword);
		map.put("condition", condition);
		
		return commondao.selectList("order.getOrderList", map);
		
	}

	@Override
	public List<Order> getOrderDetailList( String orderBundleId,int offset, int size) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("orderBundleId", orderBundleId);
		map.put("offset", offset);
		map.put("size", size);
		List<Order> OrderDetailList = commondao.selectList("order.getOrderDetailList", map);
		return OrderDetailList;
	}

	@Override
	public Order getOrderCount(Long sellerId, String date) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sellerId", sellerId);
		map.put("date", date);
		Order orderCount = commondao.selectOne("order.getOrderCount",map);
		return orderCount;
	}

	@Override
	public int orderListCount(Long sellerId, String startDate, String endDate, String keyword, String condition)throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("sellerId", sellerId);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("keyword", keyword);
		map.put("condition", condition);
		return commondao.selectOne("order.orderListCount",map);
	}

	@Override
	public int orderDetailCount(String orderBundleId) throws Exception {
		
		return commondao.selectOne("order.orderDetailCount", orderBundleId);
	}

	@Override
	public Integer dateCountByStatus(Long memberId, Integer status) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("status", status);
		
		return commondao.selectOne("order.dateCountByStatus", map);
	}

	@Override
	public List<Order> getOrderDetailMypage(String orderBundleId, Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderBundleId", orderBundleId);
		map.put("memberId", memberId);
		return commondao.selectList("order.getOrderDetailMypage", map);
	}

	@Override
	public List<Order> getOrderListMyPage(Long memberId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		return commondao.selectList("order.getOrderListMyPage", map);
	}

	@Override
	public List<Long> selectStatusCount(Long memberId) throws Exception {
		List<Long> list = commondao.selectList("order.selectStatusCount",memberId);
		return list;
	}


}
