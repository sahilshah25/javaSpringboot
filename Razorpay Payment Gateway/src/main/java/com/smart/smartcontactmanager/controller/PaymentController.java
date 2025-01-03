package com.smart.smartcontactmanager.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	
	
	//creating order for payment
	
	@PostMapping("/create_order")
	@ResponseBody
	public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
		System.out.println(data);
		int amt= Integer.parseInt(data.get("amount").toString()); 
		
		
		var client = new RazorpayClient("rzp_test_hzbWmiHVbcxepb","a5gKWO1IZhvxjupD67k1I1OK" );
		
		JSONObject  ob=new JSONObject();
		ob.put("amount", amt*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txt_235425");
		
		
		//creating new order
		
		
	Order order=	client.orders.create(ob);
	
	// if we want we can save this to our dat base for our good practices
	
	
	System.out.println(order);
		
		
		
		
		
		
		
		
		return order.toString();
	}

}
