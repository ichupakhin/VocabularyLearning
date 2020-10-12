package model;

import java.io.File;

public class MainMenuModel {

	private Storage theStorage;
	private Topic currentTopic;
	private String currentTopicName;
	
	public MainMenuModel() {
		
	}
	
	public void setCurrentTopicName(String currentTopicName) {
		this.currentTopicName = currentTopicName;
		currentTopic = new Topic(new File("Topics//" + currentTopicName));
	}
	
	public String getCurrentTopicName() {
		return currentTopicName;
	}
	
	public void setCurrentTopic(Topic topic) {
		currentTopic = topic;
	}
	
	public Topic getCurrentTopic() {
		return currentTopic;
	}
	
	
	
}
