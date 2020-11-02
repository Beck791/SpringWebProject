package tw.leonchen.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDAO {

	private DataSource datasource;

	public HouseDAO() {

	}
	@Autowired
	public HouseDAO(@Qualifier("dataSource")DataSource datasource) {
		this.datasource = datasource;
	}

	public House select(int houseid) throws SQLException {
		Connection conn = datasource.getConnection();
		String sql = "Select * from House Where houseid=?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setInt(1, houseid);
		ResultSet rs = preState.executeQuery();
		House hbean = null;
		if (rs.next()) {
			hbean = new House();
			hbean.setHouseid(rs.getInt(1));
			hbean.setHousename(rs.getString(2));
		}
		rs.close();
		preState.close();
		conn.close();
		return hbean;
	}

}
