package com.example.itcaststore.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.itcaststore.domain.Order;
import com.example.itcaststore.domain.OrderItem;
import com.example.itcaststore.domain.Product;
import com.example.itcaststore.domain.WeekHotProduct;
import com.example.itcaststore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;


public class ProductDao {

	DataSource ds=DataSourceUtils.getDataSource();
	JdbcTemplate jdbcTemplate=new JdbcTemplate(ds);

	// 添加商品
	public void addProduct(Product p) throws SQLException {

		String sql = "insert into products values(?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql,p.getId(), p.getName(), p.getPrice(),
				p.getCategory(), p.getPnum(), p.getImgurl(), p.getDescription());

	}
	// 查找所有商品
	public List<Product> listAll() throws SQLException {
		String sql = "select * from products";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Product>(Product.class));

	}

	// 获取数据总条数
	public int findAllCount(String category) throws SQLException {
		String sql = "select count(*) from products";
		StringBuilder sb = new StringBuilder();


		if (!"全部商品".equals(category)) {
			sql += " where category=?";
				sb.append(category+"%");

			return jdbcTemplate.queryForObject(sql,Integer.class,sb.toString());
		} else {


			return jdbcTemplate.queryForObject(sql,Integer.class);
		}
	}

	public int queryTotalCount() throws SQLException{
		String sql = "select count(*) from products";

		Integer total =jdbcTemplate.queryForObject(sql,Integer.class);
		return total;
	}

	@Test
	public void mytest(){

		try {
			System.out.println(queryTotalCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Product>  queryByPage(int currentPage,int currentCount) throws SQLException{
		String sql ="select * from products  limit ?,?";
		ArrayList<Object> para = new ArrayList<>();
		para.add((currentPage - 1) * currentCount);
		para.add(currentCount);
		List<Product> ps1 = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), para.toArray());
		return ps1;
	}

	// 获取当前页数据
	public List<Product> findByPage(int currentPage, int currentCount, String category) throws SQLException {
		// 要执行的sql语句
		String sql = null;
		//参数
		ArrayList<Object> para = new ArrayList<>();
		// 如果category不为null,代表是按分类查找
		if (!"全部商品".equals(category)) {
			sql = "select * from products  where category  like  ? limit ?,?";
			category = category + "%";
			para.add(category);
		} else {
			sql = "select * from products  limit ?,?";
		}
		para.add((currentPage - 1) * currentCount);
		para.add(currentCount);

		List<Product> ps1 = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), para.toArray());
		return ps1;
	}

	// 根据id查找商品
	public Product findProductById(String id) throws SQLException {
		String sql = "select * from products where id=?";
		Product product=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Product.class),id).get(0);
		return product;
	}

//	 生成订单时，将商品数量减少
	public void changeProductNum(Order order) throws SQLException {
		String sql = "update products set pnum=pnum-? where id=?";
		QueryRunner runner = new QueryRunner();

		List<OrderItem> items = order.getOrderItems();
		Object[][] params = new Object[items.size()][2];

		for (int i = 0; i < params.length; i++) {
			params[i][0] = items.get(i).getBuynum();
			params[i][1] = items.get(i).getP().getId();
		}

		runner.batch(DataSourceUtils.getConnection(), sql, params);
	}

	// 销售榜单
	public List<Object[]> salesList(String year, String month)
			throws SQLException {
		String sql = "SELECT products.name,SUM(orderitem.buynum) totalsalnum FROM orders,products,orderItem WHERE orders.id=orderItem.order_id AND products.id=orderItem.product_id AND orders.paystate=1 and year(ordertime)=? and month(ordertime)=? GROUP BY products.name ORDER BY totalsalnum DESC";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(), year, month);
	}

	// 多条件查询
	public List<Product> findProductByManyCondition(String id, String name,
			String category, String minprice, String maxprice)
			throws SQLException {
		List<Object> list = new ArrayList<Object>();
		String sql = "select * from products where 1=1 ";

		if (id != null && id.trim().length() > 0) {
			sql += " and id=?";
			list.add(id);
		}

		if (name != null && name.trim().length() > 0) {
			sql += " and name=?";
			list.add(name);
		}
		if (category != null && category.trim().length() > 0) {
			sql += " and category=?";
			list.add(category);
		}
		if (minprice != null && maxprice != null
				&& minprice.trim().length() > 0 && maxprice.trim().length() > 0) {
			sql += " and price between ? and ?";
			list.add(minprice);
			list.add(maxprice);
		}

		Object[] params = list.toArray();

		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Product>(Product.class),params);
	}
	// 修改商品信息
	public void editProduct(Product p) throws SQLException {
		//1.创建集合并将商品信息添加到集合中
		List<Object> obj = new ArrayList<Object>();
		obj.add(p.getName());
		obj.add(p.getPrice());
		obj.add(p.getCategory());
		obj.add(p.getPnum());
		obj.add(p.getDescription());
		//2.创建sql语句，并拼接sql
		String sql  = "update products " +
				      "set  name=?,price=?,category=?,pnum=?,description=? ";
		//判断是否有图片
		if (p.getImgurl() != null && p.getImgurl().trim().length() > 0) {
			sql += " ,imgurl=?";
			obj.add(p.getImgurl());
		}
		sql += " where id=?";
		obj.add(p.getId());
		System.out.println(sql);
		System.out.println(obj);


		jdbcTemplate.update(sql, obj.toArray());
	}
	//删除订单时，修改商品数量
	public void updateProductNum(List<OrderItem> items) throws SQLException {

		String sql = "update products set pnum=pnum+? where id=?";

		QueryRunner runner = new QueryRunner();

		Object[][] params = new Object[items.size()][2];

		for (int i = 0; i < items.size(); i++) {
			params[i][0] = items.get(i).getBuynum();
			params[i][1] = items.get(i).getP().getId();
		}
		runner.batch(DataSourceUtils.getConnection(), sql, params);

	}

	//前台，获取本周热销商品
	public List<WeekHotProduct> getWeekHotProduct() throws SQLException {
		String sql = "SELECT products.id,products.name, "+
                             " products.imgurl,SUM(orderitem.buynum) totalsalnum "+
                     " FROM orderitem,orders,products "+
                     " WHERE orderitem.order_id = orders.id "+
                             " AND products.id = orderitem.product_id "+
                             " AND orders.paystate=1 "+
                             " AND orders.ordertime > DATE_SUB(NOW(), INTERVAL 7 DAY) "+
                     " GROUP BY products.id,products.name,products.imgurl "+
                     " ORDER BY totalsalnum DESC "+
                     " LIMIT 0,2 ";
		List<WeekHotProduct> list=jdbcTemplate.query(sql, new RowMapper<WeekHotProduct>() {
			@Override
			public WeekHotProduct mapRow(ResultSet resultSet, int i) throws SQLException {
				WeekHotProduct weekHotProduct = new WeekHotProduct();
				Product product = new Product();
				product.setId(resultSet.getString("id"));
				product.setName(resultSet.getString("name"));
				product.setImgurl(resultSet.getString("imgurl"));

				weekHotProduct.setProduct(product);
				weekHotProduct.setNum(resultSet.getInt("totalsalnum"));
				return weekHotProduct;
			}
		});
		return list;
	}

	//前台，用于搜索框根据书名来模糊查询相应的图书
	public List<Product> findBookByName(int currentPage, int currentCount,
			String searchfield) throws SQLException {
		//根据名字模糊查询图书
		String sql = "SELECT * FROM products WHERE name LIKE '%"+searchfield+"%' LIMIT ?,?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		//用于分页查询的数据
//		Object obj = new Object[] { (currentPage - 1) * currentCount, currentCount };
		return runner.query(sql,
				new BeanListHandler<Product>(Product.class),currentPage-1,currentCount);
	}

	//前台搜索框，根据书名模糊查询出的图书总数量
	public int findBookByNameAllCount(String searchfield) throws SQLException {
		String sql = "SELECT COUNT(*) FROM products WHERE name LIKE '%"+searchfield+"%'";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		//查询出满足条件的总数量，为long类型
		Long count = (Long)runner.query(sql, new ScalarHandler());
		return count.intValue();
	}

	//后台系统，根据id删除商品信息
	public void deleteProduct(String id) throws SQLException {
		String sql = "DELETE FROM products WHERE id = ?";

		jdbcTemplate.update(sql, id);
	}
}
