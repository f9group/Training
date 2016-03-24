package com.five9group.springDAO.service.impl;

import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.five9group.springDAO.domain.Tutorial;

@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TutorialDAOImplTest {

	@Autowired
	TutorialDAOImpl tutorialDAOImpl;


	@Test
	public void testInsertData() {
		Tutorial tutorial = new Tutorial();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// get current date time with Date()
		Date date = new Date();
	    tutorial.setCreationDate(dateFormat.format(date));
		tutorial.setTutorialTitle("The Lost Island");
		tutorial.setTutorialAuthor("Bibhuti");
		tutorialDAOImpl.addTutorial(tutorial);
		//verify the id before running the test and increment by 1 
		Tutorial insertedTutorial = tutorialDAOImpl.getTutorialById(5);
		assertNotNull(insertedTutorial.getTutorialAuthor());	
	}
}
