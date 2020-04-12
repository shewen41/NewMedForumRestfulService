package com.shewen.MedForumRestServices.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.shewen.MedForumRestServices.dao.CategoriesDao;
import com.shewen.MedForumRestServices.dto.Categories;
import com.shewen.MedForumRestServices.dto.Topics;



@Service
public class CategoriesDaoImpl implements CategoriesDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CategoriesDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public List<Categories> getAllCategories() {
		
		String sql = "SELECT * FROM she_categories";
		
		List<Categories> categories = jdbcTemplate.query(sql, new CategoriesMapper());
		if(categories.size() > 0) {
			return categories;
		}
		else {
			categories = new ArrayList<Categories>();
			return categories;
		}
		
	}
	
	
	public class CategoriesMapper implements RowMapper<Categories> {

		public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Categories categories = new Categories();
			
			categories.setCategory_id(rs.getInt("category_id"));
			categories.setCategory_name(rs.getString("category_name"));
			
			return categories;
		}
	}

}
