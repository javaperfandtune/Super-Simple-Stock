package jp.com.first;

import java.util.ArrayList;
import java.util.List;

import jp.com.first.util.StockType;

public class JPMorganBasicDataGBCE {
	private List<JPMorganSimpleDataGBCE> jpmsList = new ArrayList<JPMorganSimpleDataGBCE>();;
	public JPMorganBasicDataGBCE(){
		jpmsList.add(new JPMorganSimpleDataGBCE("TEA", StockType.Common, 
				Double.valueOf(0), Double.valueOf(1), Double.valueOf(100)));
		jpmsList.add(new JPMorganSimpleDataGBCE("POP", StockType.Common, 
				Double.valueOf(8), Double.valueOf(1), Double.valueOf(100)));
		jpmsList.add(new JPMorganSimpleDataGBCE("ALE", StockType.Common, 
				Double.valueOf(23), Double.valueOf(1), Double.valueOf(60)));
		jpmsList.add(new JPMorganSimpleDataGBCE("GIN", StockType.Preferred, 
				Double.valueOf(8), Double.valueOf(0.02), Double.valueOf(100)));
		jpmsList.add(new JPMorganSimpleDataGBCE("JOE", StockType.Common, 
				Double.valueOf(13), Double.valueOf(1), Double.valueOf(250)));
	}
	public List<JPMorganSimpleDataGBCE> getJpmsList() {
		return jpmsList;
	}
	public void setJpmsList(List<JPMorganSimpleDataGBCE> jpmsList) {
		this.jpmsList = jpmsList;
	}
}
