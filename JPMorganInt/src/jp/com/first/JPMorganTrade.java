package jp.com.first;

import java.util.Date;

import jp.com.first.util.Indicator;
/**
 * 
 * @author George
 *
 */
public class JPMorganTrade {
	
	private Date timestamp;
	private Integer quantity;
	private Indicator buyOrSellStatus;
	private Double price;

	public JPMorganTrade(Date date, Integer quantity, Indicator bs, Double price){
		this.timestamp  = date;
		this.quantity = quantity;
		this.buyOrSellStatus = bs;
		this.price = price;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Indicator getBuyOrSellStatus() {
		return buyOrSellStatus;
	}


	public void setBuyOrSellStatus(Indicator buyOrSellStatus) {
		this.buyOrSellStatus = buyOrSellStatus;
	}
	
	
	
}
