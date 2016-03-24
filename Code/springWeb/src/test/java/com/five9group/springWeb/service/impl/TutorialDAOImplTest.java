package com.five9group.springWeb.service.impl;


import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.five9group.springWeb.domain.Tutorial;
import com.five9group.springWeb.service.impl.TutorialDAOImpl;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@ContextConfiguration(locations = {"classpath:DataSourceConfiguration.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TutorialDAOImplTest {

	@Autowired
	TutorialDAOImpl tutorialDAOImpl;


	@Ignore
	public void testInsertData() throws Exception{
		Tutorial tutorial = new Tutorial();
		tutorial.setTutorialDescription("Stories about the lost pacific ");
		tutorial.setTutorialTitle("The Lost Island");
		tutorial.setTutorialAuthor("Bibhuti");
		tutorialDAOImpl.addTutorial(tutorial);
		//get the latest inserted id
		Tutorial insertedTutorial = tutorialDAOImpl.getTutorialById(tutorialDAOImpl.getLatestInsertedRow());
		assertNotNull(insertedTutorial.getTutorialAuthor());	
	}
	
	@Test
	public void testSelectAllFromTable() throws Exception{
		List<Tutorial> listOfTutorialsInDB =  tutorialDAOImpl.getListOfTutorials();
		assertThat(listOfTutorialsInDB.isEmpty(), is(false));
	}
}
