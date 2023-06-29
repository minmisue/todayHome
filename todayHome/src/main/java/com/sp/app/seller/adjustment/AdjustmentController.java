package com.sp.app.seller.adjustment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdjustmentController {

	@Autowired
	AdjustmentService adjustmentService;
	
	@GetMapping("seller/adjustment/adjustment")
	public String adjustmentList() {
		return ".seller.adjustment.adjustment";
		
	}
	
}
