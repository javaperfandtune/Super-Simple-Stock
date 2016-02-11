package jp.com.first;

import java.util.logging.Logger;

import jp.com.first.util.Indicator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author George
 *
 */
public class JPMorganData {
	
	private static final Logger LOG = Logger.getLogger(JPMorganData.class.getName());
	private static Integer UNITS = 34;
	
	public static void main(String arg[]){
		//a.	For a given stock,
		List<JPMorganSimpleDataGBCE> givenStock = new JPMorganBasicDataGBCE().getJpmsList();
		Double price = Double.valueOf(127.3);
		JPMorganCalculator calculator = new JPMorganCalculator();
		
		//i.	Given any price as input, calculate the dividend yield
		JPMorganSimpleDataGBCE gbce = dividendYield(givenStock, price, calculator);
		
		//ii.	Given any price as input,  calculate the P/E Ratio
		pOrERatio(price, calculator, gbce);
		
		//iii.	Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price
		JPMorganTrade trade = new JPMorganTrade(new Date(), UNITS, Indicator.buy, price);
		
		//iv.	Calculate Volume Weighted Stock Price based on trades in past 15 minutes
		volumeWeighedStock(price, calculator, trade);
		

		
	}

	private static void volumeWeighedStock(Double price, JPMorganCalculator calculator, JPMorganTrade trade) {
		LOG.info("iv. Calculate Volume Weighted Stock Price based on trades in past 15 minutes");
		List<JPMorganTrade> jpmt = new ArrayList<JPMorganTrade>();
		jpmt.add(trade);
		for(int i=1 ; i<15; i++){
			jpmt.add(new JPMorganTrade(new Date(jpmt.get(i-1).getTimestamp().getTime() - 60000), Integer.valueOf((int) (Math.random() * UNITS)), Indicator.buy, Math.random() * price));
		}
		try {
			LOG.info("Volume Weighted Stock Price based on trades in past 15 minutes is " + calculator.calculateVWSP(jpmt));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void pOrERatio(Double price, JPMorganCalculator calculator, JPMorganSimpleDataGBCE gbce) {
		LOG.info("ii. Given any price as input,  calculate the P/E Ratio");
		Double peRatio = null;
		try {
			peRatio = calculator.calculatePERatio(price, gbce);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("P/E ratio for stock " + gbce.getStockSimbol() + " with price " + price + " is " + peRatio);
	}

	private static JPMorganSimpleDataGBCE dividendYield(List<JPMorganSimpleDataGBCE> givenStock, Double price,
			JPMorganCalculator calculator) {
		LOG.info("i. Given any price as input, calculate the dividend yield");
		JPMorganSimpleDataGBCE gbce = givenStock.get(1);
		Double dividend = null;
		try {
			dividend = calculator.calculateDevidend(price, gbce);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("dividend for stock " + gbce.getStockSimbol() + " with price " + price + " is " + dividend);
		return gbce;
	}
}
