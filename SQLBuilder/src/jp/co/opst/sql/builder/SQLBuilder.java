package jp.co.opst.sql.builder;

import java.util.HashMap;
import java.util.Map;

public class SQLBuilder {

	static String SELECT_ALL = "SELECT * FROM ONLINE_ORDER";

	public static String createSqlState(FormParam param) {

		if (param.isEmpty()) {
			return SELECT_ALL;
		}

		Map<String, Object> conditionMap = new HashMap<>();
		StringBuilder sb = new StringBuilder(SELECT_ALL);
		sb.append(" where 1 = 1");

		if (param.getMemberNo() != 0) {
			conditionMap.put("memberNo", param.getMemberNo());
			sb.append(" and MEMBER_NO = :memberNo");
		}

		if (param.getName() != null && !param.getName().isEmpty()) {
			conditionMap.put("name", param.getName());
			sb.append(" and NAME = :name");
		}

		if (param.getMinTotalPrice() != 0) {
			conditionMap.put("minTotalPrice", param.getMinTotalPrice());
			sb.append(" and TOTAL_PRICE >= :minTotalPrice");
		}
		
		if (param.getMaxTotalPrice() != 0) {
			sb.append(" and TOTAL_PRICE <= :maxTotalPrice");
			conditionMap.put("maxTotalPrice", param.getMaxTotalPrice());
		}
		
		if (param.getBeginOrderDate() != null) {
			sb.append(" and ORDER_DATE >= :beginOrderDate");
			conditionMap.put("beginOrderDate", param.getBeginOrderDate());
		}
		
		if (param.getEndOrderDate() != null) {
			sb.append(" and ORDER_DATE <= :endOrderDate");
			conditionMap.put("endOrderDate", param.getEndOrderDate());
		}

		return sb.toString();
	}

}
