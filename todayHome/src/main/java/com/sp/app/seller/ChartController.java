package com.sp.app.seller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.app.order.OrderManagementService;

@Controller("seller.ChartController")
@RequestMapping("/seller/chart/*")
public class ChartController {
	@Autowired
	private OrderManagementService orderManagementService;
	 
	@RequestMapping(value="chart", method=RequestMethod.GET)
	public String main(Model model) {
		

		return ".seller.chart.chart";
	}
}
