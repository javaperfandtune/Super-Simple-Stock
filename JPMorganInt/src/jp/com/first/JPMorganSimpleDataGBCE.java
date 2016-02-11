package jp.com.first;

import jp.com.first.util.StockType;
/**
 * 
 * @author George
 * 
 *	this will contain Sample data from the Global Beverage Corporation Exchange
 */
public class JPMorganSimpleDataGBCE {
	
	private String stockSimbol;
	private StockType type;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;
	
	public JPMorganSimpleDataGBCE(String stockSimbol, StockType type, 
			Double lastDividend, Double fixedDividend, Double parValue){
		this.stockSimbol = stockSimbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	
	public String getStockSimbol() {
		return stockSimbol;
	}
	public void setStockSimbol(String stockSimbol) {
		this.stockSimbol = stockSimbol;
	}
	public StockType getType() {
		return type;
	}
	public void setType(StockType type) {
		this.type = type;
	}
	public Double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public Double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public Double getParValue() {
		return parValue;
	}
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
	
}
