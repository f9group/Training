package com.five9group.springDAO.domain;

public class Tutorial {

	private Integer id;
	private String tutorialTitle;
	private String tutorialAuthor;
	private String creationDate;
	
	public final String getTutorialTitle() {
		return this.tutorialTitle;
	}
	public final void setTutorialTitle(final String tutorialTitle) {
		this.tutorialTitle = tutorialTitle;
	}
	public final String getTutorialAuthor() {
		return this.tutorialAuthor;
	}
	public final void setTutorialAuthor(final String tutorialAuthor) {
		this.tutorialAuthor = tutorialAuthor;
	}
	public final String getCreationDate() {
		return this.creationDate;
	}
	public final void setCreationDate(final String creationDate) {
		this.creationDate = creationDate;
	}
	public final Integer getId() {
		return this.id;
	}
	public final void setId(final Integer id) {
		this.id = id;
	}
	
}
