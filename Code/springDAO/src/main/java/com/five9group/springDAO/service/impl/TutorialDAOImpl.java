package com.five9group.springDAO.service.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.five9group.springDAO.domain.Tutorial;
import com.five9group.springDAO.service.TutorialDAO;

public class TutorialDAOImpl implements TutorialDAO{
	
	
	 private JdbcTemplate jdbcTemplate;
    
    public TutorialDAOImpl(DataSource dataSource){
    	super();
    	jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public void addTutorial(Tutorial tutorial) {
		String insertSql = "INSERT INTO tutorials_tbl" +
                     "(tutorial_title, tutorial_author, submission_date)"+
                     "VALUES(?,?,?)";
	jdbcTemplate.update(insertSql,new Object[]{tutorial.getTutorialTitle(),tutorial.getTutorialAuthor(),tutorial.getCreationDate()});
		
	}
	
	public Tutorial getTutorialById(Integer Id) {
		String query = "select tutorial_id, tutorial_title, tutorial_author,submission_date from tutorials_tbl where tutorial_id = ?";
        
		Tutorial tutorial = jdbcTemplate.queryForObject(query, new Object[]{Id}, new RowMapper<Tutorial>(){
		        
            public Tutorial mapRow(ResultSet rs, int rowNum)throws SQLException {
                Tutorial tutorial = new Tutorial();
                tutorial.setId(rs.getInt("tutorial_id"));
                tutorial.setCreationDate(rs.getString("submission_date"));
                tutorial.setTutorialAuthor(rs.getString("tutorial_author"));
                tutorial.setTutorialTitle(rs.getString("tutorial_title"));
                return tutorial;
            }});
		return tutorial;
	}
		
	public List<Tutorial> getListOfTutorials() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public void deleteTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		
	}

	public void updateTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		
	}

		
	

}
