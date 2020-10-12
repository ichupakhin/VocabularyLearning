package model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.List;

public class Storage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pathToFiles;
	private String[] files;
	private File selectedFile;
	private Topic selectedTopic;
	
	public Storage(String pathToFiles) {
		this.pathToFiles = pathToFiles;
		refreshListOfTopics();
//		selectedTopic = new Topic(selectedFile);
//		System.out.println(this.pathToFiles);
	}
	
	public void selectFile() {
		
	}
	
	
	public boolean createFile(String fileName)/* throws IOException */{
		File newFile = new File(pathToFiles + "/" + fileName + ".txt");
		try {
			newFile.createNewFile();
			selectedFile = newFile;
			refreshListOfTopics();
//			System.out.println("File created ");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean deleteFile(String fileName) {
		File file = new File(pathToFiles + "/" + fileName + ".txt");
		if(file.exists()) {
//Funktioniert nicht!
			System.out.println(file.delete());
//
			refreshListOfTopics();
			return true;
		}
		return false;
	}

	
	private void refreshListOfTopics() {
		File folder = new File(pathToFiles);
		files = folder.list();
	}
	
	public File getSelectedFile() {
		return selectedFile;
	}
	
	public String getPathToFiles() {
		return pathToFiles;
	}
	
	public String[] getFiles() {
		return files;
	}
	
}
