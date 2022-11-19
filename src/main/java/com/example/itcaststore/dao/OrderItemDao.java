package com.example.itcaststore.dao;

import com.example.itcaststore.domain.Order;
import com.example.itcaststore.domain.OrderItem;
import com.example.itcaststore.domain.Product;
import com.example.itcaststore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class OrderItemDao {
    JdbcTemplate jdbcTemplate=  new JdbcTemplate(DataSourceUtils.getDataSource());
	// 添加订单项
	public void addOrderItem(Order order) throws SQLException {
		// 1.生成sql语句
		String sql = "insert into orderItem values(?,?,?)";

		QueryRunner runner = new QueryRunner();
		List<OrderItem> items = order.getOrderItems();

		Object[][] params = new Object[items.size()][3];

		for (int i = 0; i < params.length; i++) {
			params[i][0] = items.get(i).getOrder().getId();
			params[i][1] = items.get(i).getP().getId();
			params[i][2] = items.get(i).getBuynum();
		}

		runner.batch(DataSourceUtils.getConnection(), sql, params);
	}

	// 根据订单查找订单项.并将订单项中商品查找到。
	public List<OrderItem> findOrderItemByOrder(final Order order)
			throws SQLException {
		String sql = "select * from orderItem,Products where products.id=orderItem.product_id and order_id=?";


		List<OrderItem> list= jdbcTemplate.query(sql, new RowMapper<OrderItem>() {
			@Override
			public OrderItem mapRow(ResultSet rs, int i) throws SQLException {
				OrderItem item = new OrderItem();

				item.setOrder(order);
				item.setBuynum(rs.getInt("buynum"));
				Product p = new Product();
				p.setCategory(rs.getString("category"));
				p.setId(rs.getString("id"));
				p.setDescription(rs.getString("description"));
				p.setImgurl(rs.getString("imgurl"));
				p.setName(rs.getString("name"));
				p.setPnum(rs.getInt("pnum"));
				p.setPrice(rs.getDouble("price"));
				item.setP(p);

				item.setP(p);
				return item;
			}

		}, order.getId());
		return list;
	}
	//根据订单id删除订单项
	public void delOrderItems(String id) throws SQLException {
		String sql="delete from orderItem where order_id=?";

		jdbcTemplate.update(sql,id);
	}

}
