package jp.com.first;

import java.util.List;
import java.util.logging.Logger;

import jp.com.first.util.StockType;
/**
 * 
 * @author George
 *
 */
public class JPMorganCalculator {
	
	private static final Logger LOG = Logger.getLogger(JPMorganCalculator.class.getName()); 
	/**
	 * 
	 * @param price
	 * @param dividend
	 * @param parValue
	 * @return Devidend
	 * @throws Exception 
	 */
	Double calculateDevidend(Double price, JPMorganSimpleDataGBCE jpm) throws Exception{
		if(price == 0){
			throw new Exception("wrong price");
		}
		String stringLogMessage = "calculate devidend using price=%s , last dividend=%s , parValue=%s, stockType=%s for %s";
		LOG.info(String.format(stringLogMessage, price, jpm.getLastDividend(), jpm.getParValue(), jpm.getType(), jpm.getStockSimbol()));
		return jpm.getType().equals(StockType.Preferred) ? 
				jpm.getFixedDividend() * jpm.getParValue() / price : jpm.getLastDividend() / price;
	}
	/**
	 * 
	 * @param price
	 * @param dividend
	 * @return P/E ratio
	 * @throws Exception 
	 */
	Double calculatePERatio(Double price, JPMorganSimpleDataGBCE jpm) throws Exception{
		String stringLogMessage = "calculate P/E ratio using price=%s ";
		LOG.info(String.format(stringLogMessage, price));
		return price / this.calculateDevidend(price, jpm);
	}
	/**
	 * 
	 * @param prices
	 * 				 a list of prices
	 * @return Geometric Mean
	 */
	Double calulateGeometricMean(List<Double> prices){
		Double sum = 1d;
		for(Double price : prices){
			sum *= price;
		}
		return Math.pow(sum, 1/prices.size());
	}
	
	/**
	 * 
	 * @param trade
	 * 	  			a list of transaction  
	 * @return Volume Weighted Stock Price
	 * @throws Exception 
	 */
	Double calculateVWSP(List<JPMorganTrade> trade) throws Exception{
		Double sumTPQ = 0d;
		Double sumQuantity = 0d;
		for( JPMorganTrade jpt : trade){
			double d = jpt.getPrice() * jpt.getQuantity();
			sumTPQ += d;
			sumQuantity += jpt.getQuantity();
		}
		if(sumQuantity == 0){
			throw new Exception("have no trade quntity");
		}
		return sumTPQ / sumQuantity;
	}
	
}
