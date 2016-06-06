package jp.co.opst.sql.builder;

public class BuilderTest {

	public static void main(String[] args) {
		FormParam param = new FormParam();
		
		param.setMemberNo(1);
		param.setName("ishino");
		param.setMinTotalPrice(1000);
		param.setMaxTotalPrice(10000);
		param.setBeginOrderYear("2015");
		param.setBeginOrderMonth("1");
		param.setBeginOrderDay("1");
		param.setEndOrderYear("2016");
		param.setEndOrderMonth("3");
		param.setEndOrderDay("15");
		
		System.out.println(SQLBuilder.createSqlState(param));
	}
}
