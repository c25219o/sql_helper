package jp.co.opst.sql.builder;

public class FormParam {

	private int memberNo;
	private String name;
	private int minTotalPrice;
	private int maxTotalPrice;

	private String beginOrderYear;
	private String beginOrderMonth;
	private String beginOrderDay;

	private String endOrderYear;
	private String endOrderMonth;
	private String endOrderDay;

	public String getBeginOrderDate() {
		if (beginOrderYear != null && beginOrderMonth != null && beginOrderDay != null) {
			return String.format("%s/%s/%s", beginOrderYear, beginOrderMonth, beginOrderDay);
		} else {
			return null;
		}
	}

	public String getEndOrderDate() {
		if (endOrderYear != null && endOrderMonth != null && endOrderDay != null) {
			return String.format("%s/%s/%s", endOrderYear, endOrderMonth, endOrderDay);
		} else {
			return null;
		}
	}

	// private Date beginOrderDate;
	// private Date endOrderDate;

	public boolean isEmpty() {
		return memberNo == 0 && (name == null || name.isEmpty()) && minTotalPrice == 0 && maxTotalPrice == 0
		        && getBeginOrderDate() == null && getEndOrderDate() == null;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinTotalPrice() {
		return minTotalPrice;
	}

	public void setMinTotalPrice(int minTotalPrice) {
		this.minTotalPrice = minTotalPrice;
	}

	public int getMaxTotalPrice() {
		return maxTotalPrice;
	}

	public void setMaxTotalPrice(int maxTotalPrice) {
		this.maxTotalPrice = maxTotalPrice;
	}

//	public String getBeginOrderYear() {
//		return beginOrderYear;
//	}

	public void setBeginOrderYear(String beginOrderYear) {
		this.beginOrderYear = beginOrderYear;
	}

//	public String getBeginOrderMonth() {
//		return beginOrderMonth;
//	}

	public void setBeginOrderMonth(String beginOrderMonth) {
		this.beginOrderMonth = beginOrderMonth;
	}

//	public String getBeginOrderDay() {
//		return beginOrderDay;
//	}

	public void setBeginOrderDay(String beginOrderDay) {
		this.beginOrderDay = beginOrderDay;
	}

//	public String getEndOrderYear() {
//		return endOrderYear;
//	}

	public void setEndOrderYear(String endOrderYear) {
		this.endOrderYear = endOrderYear;
	}

//	public String getEndOrderMonth() {
//		return endOrderMonth;
//	}

	public void setEndOrderMonth(String endOrderMonth) {
		this.endOrderMonth = endOrderMonth;
	}

//	public String getEndOrderDay() {
//		return endOrderDay;
//	}

	public void setEndOrderDay(String endOrderDay) {
		this.endOrderDay = endOrderDay;
	}
}
