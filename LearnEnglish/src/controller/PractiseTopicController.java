package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MainMenuController.PractiseTopicListener;
import model.PractiseTopicModel;
import view.MainMenuView;

public class PractiseTopicController {
	
	private MainMenuView theView;
	private PractiseTopicModel theModel;

	public PractiseTopicController(MainMenuView theView, PractiseTopicModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addGetAssociationListener(new GetAssociationListener());
		this.theView.addCheckAnswerListener(new CheckAnswerListener());
		this.theView.addShowSolutionListener(new ShowSolutionListener());
		this.theView.addNextListener(new NextListener());
		this.theView.addCancelListener(new CancelListener());
	}
	
/*	public void start() {
		theModel.shuffle();
		
	}
*/	
	
	class GetAssociationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(theView.isEnabledGetAssociationButton()) {
				String currentText = theView.getTextFromTextArea(); 
				theView.setTextToTheTextArea(currentText + " Association: " + theModel.getTopic().getAssociation());
			}
		}
		
	}
	
	class CheckAnswerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(theView.isEnabledCheckAnswerButton()) {
				if(theView.getTextFromTextField().equalsIgnoreCase(theModel.getTopic().getWord())) {
					theView.setTextToTheTextArea("CORRECT!\n" + theModel.getSolution());
				} else {
					theView.setTextToTheTextArea("WRONG!\n" + theModel.getSolution());
				}
			theView.getRootPane().setDefaultButton(theView.getNextButton());
			}
			
			
		}
	}
	
	class ShowSolutionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(theView.isEnabledShowSolutionButton()) {
//				theView.cleanTextArea();
				theView.setTextToTheTextArea(theModel.getSolution());
			}
			
		}
	}
	
	class NextListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(theView.isEnabledNextButton()) {
				theView.cleanTextArea();
				theView.cleanTextField();
				if(!theModel.isEmptyStack()) {
					theModel.getTopic().popEntryFromStackAndPutItToCurrentEntry();
					String translation = theModel.getTopic().getTranslation();
					theView.setTextToTheTextArea(translation);
					System.out.println("Zaehlerstand = " + ++view.MainMenuView.counter + " von " + theModel.getTopicSize());
//					theView.getTextArea().;
				}
				theView.getRootPane().setDefaultButton(theView.getCheckAnswerButton());
			}	
		}
	}
	
	class CancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			theView.cleanTextArea(); 
			
		}
	}
	


}
