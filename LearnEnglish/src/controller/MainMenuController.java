package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainMenuModel;
import model.PractiseTopicModel;
import model.Storage;
import model.Topic;
import view.MainMenuView;

public class MainMenuController {
	
	private MainMenuView theView;
	private MainMenuModel theModel;
	
	private PractiseTopicController practiseTopicController;

	
	public MainMenuController(MainMenuView theView, MainMenuModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addSelectTopicListener(new SelectTopicListener());
		this.theView.addPractiseTopicListener(new PractiseTopicListener());
	}
	
	class SelectTopicListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(theView.isEnabledSelectTopicButton()) {
				System.out.println(theView.getTopicFileName());
				theModel.setCurrentTopicName(theView.getTopicFileName());
				theView.activateFirstJPanel();
//				System.out.println(theModel.getCurrentTopicName());
//				System.out.println(theView.isFocusableTopic());
			}
			
		}
		
	}
	
	class PractiseTopicListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(theView.isEnabledPractiseTopicButton()) {
				theView.activateSecondJPanel();
				theView.setTextToTheTextArea("Please click 'Next'");
				practiseTopicController = new PractiseTopicController(theView, new PractiseTopicModel(theModel.getCurrentTopic()));
//TODO				practiseTopicController.start();
			}
			
		}
		
	}
	
	
	
	
	

}


