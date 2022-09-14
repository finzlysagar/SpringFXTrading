package com.fxtrading.FxTradingApplication.controller;

import java.util.ArrayList;


import com.fxtrading.FxTradingApplication.dao.PrintDao;
import com.fxtrading.FxTradingApplication.entity.Book;
import com.fxtrading.FxTradingApplication.entity.Print;
import com.fxtrading.FxTradingApplication.service.FxTradingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FxTradingController {
	@Autowired
	FxTradingService fxTradingService;
	@Autowired
	PrintDao printDao;
	
	String message = "booktrade/book  \n /printtrade \n /exit/yes  ";
//
//	@RequestMapping("message")
//	public String message(){
//		return message;
		
	//}
	
	@PostMapping("booktrade/{bookingconfirmation}")
	public String bookTrade(@RequestBody Book bookingDetails, @PathVariable String bookingconfirmation) {
		return fxTradingService.bookTrade(bookingDetails, bookingconfirmation);
		
	}
	@GetMapping("printtrade")
	public ArrayList<Print> printTrading() {
		
		return printDao.printTrading();
	}
	
	@PutMapping("exit/{confirm}")
	public String Exit(@PathVariable String confirm) {
		
		if(confirm.equalsIgnoreCase("yes"))
			return "bye have a nice day";
		else if(confirm.equalsIgnoreCase("no"))
			return message;
		return null;
		
		
		
	}
	
}
