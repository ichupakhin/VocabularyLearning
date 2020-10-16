 
import model.Storage;
import model.Topic;

import java.io.File;
import java.io.IOException;

import controller.MainMenuController;
import model.MainMenuModel;
import view.MainMenuView;
public class Main {

	public static void main(String[] args) throws IOException {
		Storage topicsStorage = new Storage("Topics");
//		topicsStorage.createFile("Test1");
//		Topic topic = new Topic(topicsStorage.getSelectedFile());
//		topic.writeEntry("Hallo");
//		topic.writeEntry("Wie laeuft es");
//		topic.overwriteEntry("Hallo", "hey");
//		topicsStorage.deleteFile("Test1");
		
		MainMenuView mainMenuView = new MainMenuView(topicsStorage.getFiles());
		MainMenuModel mainMenuModel = new MainMenuModel();
		MainMenuController mainMenuController = new MainMenuController(mainMenuView, mainMenuModel);
		mainMenuView.setVisible(true);
		
		//File file = new File("Hello.txt");
		//file.createNewFile();
	}
	

}
