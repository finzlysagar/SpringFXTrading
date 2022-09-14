package com.fxtrading.FxTradingApplication.dao;
import com.fxtrading.FxTradingApplication.entity.Book;

import org.springframework.stereotype.Repository;

@Repository
public class BookingDao {
	//Booking the trade
	
	public String bookTrade(Book Details, String Confirmation) {

		
		
		if(Details.getCustomerName().matches("[a-zA-Z\\s\\.].*$")) {
			
		if (Details.getCurrencyPair().equalsIgnoreCase("USDINR")) {
			final double rateOfUsd = 66.00;
			
			double inrAmount = rateOfUsd * Details.getTranferAmount();
			if(Details.getRate().equalsIgnoreCase("yes")) {
				
				if(Confirmation.equalsIgnoreCase("book")) {
					
					PrintDao.tradeNo++;
					PrintDao printdao = new PrintDao();
					printdao.addTrading(PrintDao.tradeNo ,Details.getCurrencyPair(),Details.getCustomerName() , inrAmount, rateOfUsd);
					
					return "you are transferring INR " + inrAmount + " to " + Details.getCustomerName()+".(Assuming that rate was 66.00)"+"\n"+
				"Trade for " + Details.getCurrencyPair() + " has been booked with rate " + rateOfUsd + " , The amount of Rs."+ inrAmount +
				" will be transferred in 2 days to " + Details.getCustomerName() + "\n";

			}
			else if (Confirmation.equalsIgnoreCase("cancel")) {
				return "The trade is cancelled";
			} else {
				return "invalid option";
			}
			}
			else if(Details.getRate().equalsIgnoreCase("no")) {
				if(Confirmation.equalsIgnoreCase("book")) {
					PrintDao.tradeNo++;
					
					PrintDao printdao = new PrintDao();
					printdao.addTrading(PrintDao.tradeNo ,Details.getCurrencyPair(),Details.getCustomerName() , inrAmount, rateOfUsd);
					
	
				return  "Trade for " + Details.getCurrencyPair() + " has been booked with rate " + rateOfUsd + " , The amount of Rs."+ inrAmount +
						" will be transferred in 2 days to " + Details.getCustomerName() + "\n";

			}
			else if (Confirmation.equalsIgnoreCase("cancel")) {
				
				return "The trade is cancelled";
				
				
			} else {
				
				return "Invalid option ....";
			}
			}

			else {
				return "invalid input";
			}

		} else {
			return "Invalid data!!!...Try again...";
			
		}

	}
		else {
			return "Invalid Customer name ...Try again";
			
			
		}
}
	
}