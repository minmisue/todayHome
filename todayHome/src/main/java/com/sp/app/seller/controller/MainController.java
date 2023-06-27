
package com.sp.app.seller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("seller.mainController")
public class MainController {
	 
	@RequestMapping(value="/seller", method=RequestMethod.GET)
	public String method() {
		return ".sellerLayout";
	}
}
