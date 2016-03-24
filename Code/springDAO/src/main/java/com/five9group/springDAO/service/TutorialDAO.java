package com.five9group.springDAO.service;



import java.util.List;

import com.five9group.springDAO.domain.Tutorial;

public interface TutorialDAO {
	public void addTutorial(Tutorial tutorial);
	public void deleteTutorial(Tutorial tutorial );
	public void updateTutorial(Tutorial tutorial);
	public List<Tutorial> getListOfTutorials();
	public Tutorial getTutorialById(Integer Id);
	

}
