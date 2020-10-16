package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MainMenuView extends JFrame {
	
	private JList topics;
	private JScrollPane scrollPane;
	
	public static int counter = 0;



//	 scrollPane.setViewportView(list);


	
	private JButton selectTopicButton = new JButton("Select");
	private JButton practiseTopicReverseButton = new JButton("Practise the topic reverse");
	private JButton addWordButton = new JButton("Add a new word to the topic");
	private JButton practiseTopicButton  = new JButton("Practise the topic");

	private JButton getAssociationButton = new JButton("Get association");
	private JButton checkAnswerButton = new JButton("Check Answer");
	private JButton showSolutionButton = new JButton("Show solution");
	private JButton nextButton = new JButton("Next");
	private JButton cancelButton = new JButton("Cancel"); 
	private JTextPane textPane = new JTextPane();
	private JTextField textField = new JTextField();
	
	

	public MainMenuView(String[] topicsList) {

		setLayout(null);

		this.getRootPane().setDefaultButton(nextButton);
//		this.getRootPane().setDefaultButton(checkAnswerButton);
		
		
		topics = new JList<>(topicsList);
		scrollPane = new JScrollPane(topics);
		
		JPanel mainMenuPanel = new JPanel();
		JPanel practiseTopicPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300,730);
		this.setLocationRelativeTo(null);
		mainMenuPanel.setBounds(250,0,900,100);
		
		scrollPane.setBounds(0, 0, 195, 600);
		
		textPane.setBounds(200, 50, 1000, 180);
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		//textPane.setLogicalStyle();
		textField.setBounds(200, 250, 1000, 50);
		textField.setHorizontalAlignment(JTextField.CENTER);
		practiseTopicPanel.setBounds(200, 300, 1000, 50);

//Text style		
	    Font font = new Font("Arial", Font.CENTER_BASELINE, 18);
	    textPane.setFont(font);
		textField.setFont(font);
		
//		nextButton.setMnemonic(KeyEvent.VK_N);
//		nextButton.setDisplayedMnemonicIndex(nextButton.getName().indexOf(KeyEvent.VK_N));
		
//		JRootPane rootPane = SwingUtilities.getRootPane(checkAnswerButton); 
//		rootPane.setDefaultButton(enterButton);

//		panel.
		mainMenuPanel.add(selectTopicButton);
		mainMenuPanel.add(practiseTopicButton);
		mainMenuPanel.add(practiseTopicReverseButton);
//		mainMenuPanel.add(addWordButton);

		deactivateFirstJPanel();
		

		practiseTopicPanel.add(getAssociationButton);
		practiseTopicPanel.add(checkAnswerButton);
		practiseTopicPanel.add(showSolutionButton);
		practiseTopicPanel.add(nextButton);
		practiseTopicPanel.add(cancelButton);
		deactivateSecondJPanel();
		
		add(mainMenuPanel);
		add(textField);
		add(textPane);
		add(scrollPane);
		add(practiseTopicPanel);
	}


	public void activateFirstJPanel() {
		practiseTopicReverseButton.setEnabled(true);
		addWordButton.setEnabled(true);
		practiseTopicButton.setEnabled(true);
	}
	
	public void deactivateFirstJPanel() {
		practiseTopicReverseButton.setEnabled(false);
		addWordButton.setEnabled(false);
		practiseTopicButton.setEnabled(false);
	}
	
	public void activateSecondJPanel() {
		getAssociationButton.setEnabled(true);
		checkAnswerButton.setEnabled(true);
		showSolutionButton.setEnabled(true);
		nextButton.setEnabled(true);
		cancelButton.setEnabled(true);
		textPane.setEditable(true);
		textField.setEditable(true);
	}
	
	public void deactivateSecondJPanel() {
		getAssociationButton.setEnabled(false);
		checkAnswerButton.setEnabled(false);
		showSolutionButton.setEnabled(false);
		nextButton.setEnabled(false);
		cancelButton.setEnabled(false);
		textPane.setEditable(false);
		textField.setEditable(false);
	}
	
	public boolean isEnabledSelectTopicButton() {
//		System.out.println("Is Selected" + selectTopicButton.isEnabled());
		return selectTopicButton.isEnabled();
	}
	
/*	public boolean isFocusableTopic() {
		return topics.isCursorSet();
	}
*/	
	public String getTopicFileName() {
		return topics.getSelectedValue().toString();
	}
	
	public boolean isEnabledPractiseTopicButton() {
//		System.out.println("Is Selected" + selectTopicButton.isEnabled());
		return practiseTopicButton.isEnabled();
	}
	
	public boolean isEnabledPractiseTopicReverseButton() {
//		System.out.println("Is Selected" + selectTopicButton.isEnabled());
		return practiseTopicReverseButton.isEnabled();
	}
	
	public boolean isEnabledGetAssociationButton() {
		return getAssociationButton.isEnabled();
	}
	
	public boolean isEnabledCheckAnswerButton() {
		return checkAnswerButton.isEnabled();
	}
	
	public boolean isEnabledShowSolutionButton() {
		return showSolutionButton.isEnabled();
	}
	
	public boolean isEnabledNextButton() {
		return nextButton.isEnabled();
	}
	
	public boolean isEnabledCancelButton() {
		return cancelButton.isEnabled();
	}
	
	public void setTextToTheTextArea(String text) {
		textPane.setText(text);
	}
	
	public String getTextFromTextField() {
		return textField.getText();
	}
	
	public String getTextFromTextArea() {
		return textPane.getText();
	}
	
	public void cleanTextArea() {
		textPane.setText("");
	}
	
	public void cleanTextField() {
		textField.setText("");
	}
	
	public JButton getCheckAnswerButton() {
		return checkAnswerButton;
	}
	
	public JButton getNextButton() {
		return nextButton;
	}

//Listeners	
	public void addSelectTopicListener(ActionListener listenerSelectTopic) {
		selectTopicButton.addActionListener(listenerSelectTopic);
	}
	
	public void addPractiseTopicListener(ActionListener listenerPractiseTopic) {
		practiseTopicButton.addActionListener(listenerPractiseTopic);
	}
	
	public void addPractiseTopicReverseListener(ActionListener listenerPractiseTopicReverse) {
		practiseTopicReverseButton.addActionListener(listenerPractiseTopicReverse);
	}
	
	public void addGetAssociationListener(ActionListener listenerGetAssociation) {
		getAssociationButton.addActionListener(listenerGetAssociation);
	}
	
	public void addCheckAnswerListener(ActionListener listenerCheckAnswer) {
		
		checkAnswerButton.addActionListener(listenerCheckAnswer);
//		this.getRootPane().setDefaultButton(checkAnswerButton);
	}
	
	public void addShowSolutionListener(ActionListener listenerShowSolution) {
		showSolutionButton.addActionListener(listenerShowSolution);
	}
	
	public void addNextListener(ActionListener listenerNext) {
		nextButton.addActionListener(listenerNext);
//		this.getRootPane().setDefaultButton(nextButton);
	}
	
	public void addCancelListener(ActionListener listenerCancel) {
		cancelButton.addActionListener(listenerCancel);
	}
	
	public JTextPane getTextArea() {
		return textPane;
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
}
