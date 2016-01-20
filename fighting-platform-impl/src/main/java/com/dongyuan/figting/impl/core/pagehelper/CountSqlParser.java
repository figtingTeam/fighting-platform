package com.dongyuan.figting.impl.core.pagehelper;

import java.util.ArrayList;
import java.util.List;

import com.foundationdb.sql.StandardException;
import com.foundationdb.sql.parser.OrderByList;
import com.foundationdb.sql.parser.ParameterNode;
import com.foundationdb.sql.parser.ResultColumnList;
import com.foundationdb.sql.parser.SQLParser;
import com.foundationdb.sql.parser.StatementNode;
import com.foundationdb.sql.unparser.NodeToString;

public class CountSqlParser extends NodeToString {
	private final SQLParser PARSER = new SQLParser();

	private boolean isFirst = true;

	public String generate(String sql) throws StandardException {
		StatementNode stmt = PARSER.parseStatement(sql);
		return toString(stmt);
	}

	@Override
	protected String orderByList(OrderByList node) throws StandardException {
		return "";
	}

	@Override
	protected String resultColumnList(ResultColumnList node) throws StandardException {
		if (isFirst) {
			isFirst = false;
			return " count(*) ";
		} else {
			return super.resultColumnList(node);
		}
	}

	// @Override
	// protected String groupByList(GroupByList node) throws StandardException {
	// return "";
	// }

	@Override
	protected String parameterNode(ParameterNode node) throws StandardException {
		return " ? ";
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add(" select tom.order_id, tom.order_flag, tom.order_status, tom.outer_order_id, tom.total_amount, tom.payment_amount, tom.pay_order_no, tom.platform_id, tom.shop_id, tom.order_type, tom.remain_time,tom.outer_create_time, tom.seller_memo, tom.buyer_memo, toa.receiver_name, toa.receiver_addr_detail, toa.receiver_mobile from t_order_main tom left join t_order_addr toa on toa.order_id = tom.order_id WHERE ( tom.shop_id in ( ? , ? , ? , ? , ? , ? ) and tom.order_status = ? and tom.refund_status = ? and tom.order_id in (select distinct toi.order_id from t_order_item toi where toi.store_id = ?) and tom.pay_time >= ? ) order by tom.outer_create_time desc");
		ls.add("SELECT * frOm dual");
		ls.add("Select C1,c2 From tb");
		ls.add("select c1,c2 from tb");
		ls.add("select count(*) from t1");
		ls.add("select c1,c2,c3 from t1 where condi1=1 ");
		ls.add("Select c1,c2,c3 From t1 Where condi1=1 ");
		ls.add("select c1,c2,c3 from t1,t2 where condi3=3 or condi4=5 order by o1,o2");
		ls.add("Select c1,c2,c3 from t1,t2 Where condi3=3 or condi4=5 Order by o1,o2");
		ls.add("select c1,c2,c3 from t1,t2,t3 where condi1=5 and condi6=6 or condi7=7 group by g1,g2");
		ls.add("Select c1,c2,c3 From t1,t2,t3 Where condi1=5 and condi6=6 or condi7=7 Group by g1,g2");
		ls.add("Select c1,c2,c3 From t1,t2,t3 Where condi1=5 and condi6=6 or condi7=7 Group by g1,g2,g3 order by g2,g3");
		ls.add("select * from m_shop a left join m_shop_store b on a.shop_id=b.shop_id where a.shop_id in (?,?,?,?) and a.sss=? group by a.shop_id  order by a.shop_id");
		ls.add("select * from m_shop a left join m_shop_store b on a.shop_id=b.shop_id  group by a.shop_id  order by a.shop_id");
		for (String sql : ls) {
			System.out.println("原始：" + sql);
			long start = System.currentTimeMillis();
			CountSqlParser parser = new CountSqlParser();
			try {
				System.out.println("生产Count：" + parser.generate(sql));
			} catch (StandardException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
			// System.out.println(sql);
		}
	}

}
