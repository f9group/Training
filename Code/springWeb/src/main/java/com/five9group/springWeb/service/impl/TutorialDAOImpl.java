package com.five9group.springWeb.service.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.five9group.springWeb.domain.Tutorial;
import com.five9group.springWeb.service.TutorialDAO;

public class TutorialDAOImpl implements TutorialDAO{
	
	
	 private JdbcTemplate jdbcTemplate;
    
    public TutorialDAOImpl(DataSource dataSource){
    	super();
    	jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
	public void addTutorial(Tutorial tutorial)throws Exception {
		String insertSql = "INSERT INTO tutorials_tbl" +
                     "(tutorial_title, tutorial_author, tutorial_description)"+
                     "VALUES(?,?,?)";
	jdbcTemplate.update(insertSql,new Object[]{tutorial.getTutorialTitle(),tutorial.getTutorialAuthor(),tutorial.getTutorialDescription()});
		
	}
	@Override
	public Tutorial getTutorialById(Integer Id) throws Exception{
		String query = "select tutorial_id, tutorial_title, tutorial_author,tutorial_description from tutorials_tbl where tutorial_id = ?";
        
		Tutorial tutorial = jdbcTemplate.queryForObject(query, new Object[]{Id}, new RowMapper<Tutorial>(){
		        
            public Tutorial mapRow(ResultSet rs, int rowNum)throws SQLException {
                Tutorial tutorial = new Tutorial();
                tutorial.setId(rs.getInt("tutorial_id"));
                tutorial.setTutorialDescription(rs.getString("tutorial_description"));
                tutorial.setTutorialAuthor(rs.getString("tutorial_author"));
                tutorial.setTutorialTitle(rs.getString("tutorial_title"));
                return tutorial;
            }});
		return tutorial;
	}
	@Override
	public List<Tutorial> getListOfTutorials() throws Exception {
		String sql = "select * from tutorials_tbl";
         List<Tutorial> listOfTutorials = jdbcTemplate.query(sql,
     			new BeanPropertyRowMapper<Tutorial>(Tutorial.class));
		return listOfTutorials;
	}
	
	@Override
	public void deleteTutorial(Tutorial tutorial) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLatestInsertedRow() throws Exception {
		String sql ="select max(tutorial_id) from tutorials_tbl";
		int latestInsertedId = jdbcTemplate.queryForObject(sql, Integer.class);
		return latestInsertedId;

	}

		
	

}
