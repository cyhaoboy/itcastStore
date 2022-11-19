package com.example.itcaststore.dao;

import com.example.itcaststore.domain.Order;
import com.example.itcaststore.domain.User;
import com.example.itcaststore.utils.DataSourceUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 订单
 * @author admin
 *
 */
public class OrderDao {
	DataSource ds=DataSourceUtils.getDataSource();
	JdbcTemplate jdbcTemplate=new JdbcTemplate(ds);
	/**
	 *  生成订单
	 * @param order
	 * @throws SQLException
	 */
	public void addProduct(Order order) throws SQLException {
		// 1.生成Sql语句
		String sql = "insert into orders(id,money,receiverAddress,receiverName,paystate,receiverPhone,user_id)  values(?,?,?,?,0,?,?)";

        // 3.执行update()方法插入数据
		jdbcTemplate.update( sql, order.getId(),
				order.getMoney(), order.getReceiverAddress(), order
						.getReceiverName(), order.getReceiverPhone(),order
						.getUser().getId());
	}
@Test
public void test(){
		User user = new User();
		user.setId(9);
	try {
		List<Order> order = findOrderByUser(user);
		if (order.size()!=0){

		System.out.println(order.get(0).getOrdertime());
		}else System.out.println("gg");

	} catch (SQLException e) {
		e.printStackTrace();
	}

}
	/**
	 * 查找用户所属订单
	 */
	public List<Order> findOrderByUser(final User user) throws SQLException {
		String sql = "select * from orders where user_id=?";

		List<Order> orders= jdbcTemplate.query(sql, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int i) throws SQLException {
				Order order = new Order();
					order.setId(rs.getString("id"));
					order.setMoney(rs.getDouble("money"));
					order.setOrdertime(rs.getDate("ordertime"));
					order.setPaystate(rs.getInt("paystate"));
					order.setReceiverAddress(rs.getString("receiverAddress"));
					order.setReceiverName(rs.getString("receiverName"));
					order.setReceiverPhone(rs.getString("receiverPhone"));
					order.setUser(user);

				return order;
			}

		}, user.getId());
		return  orders;
	}
	/**
	 * 根据id查找订单信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Order findOrderById(String id) throws SQLException {
		String sql = "select * from orders,user where orders.user_id=user.id and orders.id=?";

		Order orders=jdbcTemplate.queryForObject(sql, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int i) throws SQLException {
				Order order = new Order();
				order.setId(rs.getString("orders.id"));
				order.setMoney(rs.getDouble("orders.money"));
				order.setOrdertime(rs.getDate("orders.ordertime"));
				order.setPaystate(rs.getInt("orders.paystate"));
				order.setReceiverAddress(rs.getString("orders.receiverAddress"));
				order.setReceiverName(rs.getString("orders.receiverName"));
				order.setReceiverPhone(rs.getString("orders.receiverPhone"));

				User user = new User();
				user.setId(rs.getInt("user.id"));
				user.setEmail(rs.getString("user.email"));
				user.setGender(rs.getString("user.gender"));
				user.setActiveCode(rs.getString("user.activecode"));
				user.setIntroduce(rs.getString("user.introduce"));
				user.setPassword(rs.getString("user.password"));
				user.setRegistTime(rs.getDate("user.registtime"));
				user.setRole(rs.getString("user.role"));
				user.setState(rs.getInt("user.state"));
				user.setTelephone(rs.getString("user.telephone"));
				user.setUsername(rs.getString("user.username"));
				order.setUser(user);

				return order;
			}

		}, id);
		return orders;
	}

	/**
	 *  查找所有订单
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findAllOrder() throws SQLException {
		//1.创建sql
		String sql = "select orders.*,user.* from orders,user where user.id=orders.user_id order by orders.user_id";

		List<Order> orders= jdbcTemplate.query(sql, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int i) throws SQLException {
				Order order = new Order();
				order.setId(rs.getString("orders.id"));
				order.setMoney(rs.getDouble("orders.money"));
				order.setOrdertime(rs.getDate("orders.ordertime"));
				order.setPaystate(rs.getInt("orders.paystate"));
				order.setReceiverAddress(rs.getString("orders.receiverAddress"));
				order.setReceiverName(rs.getString("orders.receiverName"));
				order.setReceiverPhone(rs.getString("orders.receiverPhone"));

				User user = new User();
				user.setId(rs.getInt("user.id"));
				user.setEmail(rs.getString("user.email"));
				user.setGender(rs.getString("user.gender"));
				user.setActiveCode(rs.getString("user.activecode"));
				user.setIntroduce(rs.getString("user.introduce"));
				user.setPassword(rs.getString("user.password"));
				user.setRegistTime(rs.getDate("user.registtime"));
				user.setRole(rs.getString("user.role"));
				user.setState(rs.getInt("user.state"));
				user.setTelephone(rs.getString("user.telephone"));
				user.setUsername(rs.getString("user.username"));
				order.setUser(user);

				return order;
			}
		});
		return orders;
	}
	/**
	 *  根据订单号修改订单状态
	 * @param id
	 * @throws SQLException
	 */
	public void updateOrderState(String id) throws SQLException {
		String sql = "update orders set paystate=1 where id=?";

		jdbcTemplate.update(sql, id);
		System.out.println(jdbcTemplate.update(sql, id));
	}
	/**
	 *  多条件查询
	 * @param id
	 * @param receiverName
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findOrderByManyCondition(String id, String receiverName)
			throws SQLException {
		//1.创建集合对象
		List<Object> objs = new ArrayList<Object>();
		//2.定义查询sql
		String sql = "select orders.*,user.* from orders,user where user.id=orders.user_id ";
		//3.根据参数拼接sql语句
		if (id != null && id.trim().length() > 0) {
			sql += " and orders.id=?";
			objs.add(id);
		}
		if (receiverName != null && receiverName.trim().length() > 0) {
			sql += " and receiverName=?";
			objs.add(receiverName);
		}
		sql += " order by orders.user_id";


		//5.返回QueryRunner对象query方法的执行结果
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new ResultSetHandler<List<Order>>() {
			public List<Order> handle(ResultSet rs) throws SQLException {
				List<Order> orders = new ArrayList<Order>();
               //循环遍历出订单和用户信息
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getString("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPaystate(rs.getInt("orders.paystate"));
					order.setReceiverAddress(rs
							.getString("orders.receiverAddress"));
					order.setReceiverName(rs.getString("orders.receiverName"));
					order.setReceiverPhone(rs.getString("orders.receiverPhone"));
					orders.add(order);
					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setGender(rs.getString("user.gender"));
					user.setActiveCode(rs.getString("user.activecode"));
					user.setIntroduce(rs.getString("user.introduce"));
					user.setPassword(rs.getString("user.password"));
					user.setRegistTime(rs.getDate("user.registtime"));
					user.setRole(rs.getString("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setTelephone(rs.getString("user.telephone"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);

				}

				return orders;
			}
		}, objs.toArray());
	}
	/**
	 * 根据id删除订单
	 * @param id
	 * @throws SQLException
	 */
	public void delOrderById(String id) throws SQLException {
		String sql="delete from orders where id=?";
		jdbcTemplate.update(sql,id);
	}
}
