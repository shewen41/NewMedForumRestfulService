package com.shewen.MedForumRestServices.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.shewen.MedForumRestServices.dao.SubCategoriesDao;
import com.shewen.MedForumRestServices.dto.SubCategories;


@Service
public class SubCategoriesDaoImpl implements SubCategoriesDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SubCategoriesDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	
	
	public List<SubCategories> getAllSubCategories() {
		
		String sql = "SELECT * FROM she_subcategories";
		
		return jdbcTemplate.query(sql, new SubCategoriesMapper());
		
	}

	public class SubCategoriesMapper implements RowMapper<SubCategories> {

		public SubCategories mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			SubCategories subCategories = new SubCategories();
			
			subCategories.setCategory_id(rs.getInt("category_id"));
			subCategories.setSubcategory_id(rs.getInt("subcategory_id"));
			subCategories.setSubcategory_name(rs.getString("subcategory_name"));
			
			return subCategories;
		}	
	}
	
}
