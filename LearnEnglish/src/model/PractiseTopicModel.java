package model;

public class PractiseTopicModel {
	private Topic topic;
	
	public PractiseTopicModel(Topic topic) {
		this.topic = topic;
		shuffle();
	}
	
	public void shuffle() {
		topic.putWordsToStackAndSchuffle();
	}
	
	public Topic getTopic() {
		return topic;
	}
	
	public boolean isEmptyStack() {
		return topic.isEmptyStack();
	}
	
	public String getSolution() {
		String word = topic.getWord();
		String pronunciation = topic.getPronunciation();
		String association = topic.getAssociation();
		String translation = topic.getTranslation();
		String examples = topic.getExamples();
		return word + " [" + pronunciation + "] [" + association + "] - " + translation + "\nExamples: " + examples;
		
	}
//	public String[] getNextEntry()
}
