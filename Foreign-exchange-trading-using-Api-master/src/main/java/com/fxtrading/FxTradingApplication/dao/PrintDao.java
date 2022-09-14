package com.fxtrading.FxTradingApplication.dao;
import java.util.ArrayList;

import com.fxtrading.FxTradingApplication.entity.Print;

import org.springframework.stereotype.Repository;
@Repository
public class PrintDao {

	static int  tradeNo=0;
	static ArrayList<Print> bookHistory = new ArrayList<>();
	
	public  void addTrading(int tradeNo, String currencyPair, String customerName, double inrAmount, double rate) {
		bookHistory.add(new Print(tradeNo, currencyPair, customerName, inrAmount, rate));
	}
	public ArrayList<Print>  printTrading() {
		
		return bookHistory;
		
	}
}



