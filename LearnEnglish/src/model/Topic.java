package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

//import java.util.HashMap;

public class Topic {
	
	
//	private HashMap<String,String[]> topic;
	private File topicFile;
	private String topicName;
	private String[] currentEntry;
	private Scanner topicScanner;
	private Stack<String[]> stackOfTopics = new Stack<>();
	private int topicSize;

	
	public Topic(File topicFile) /*throws FileNotFoundException*/ {
		this.topicFile = topicFile;
		topicName = topicFile.getName();
//		currentEntry = new String[5];
		try {
			topicScanner = new Scanner(topicFile);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		currentEntry = getNextEntry();
		
	}
	
	
	public void putWordsToStackAndSchuffle() {
		topicScanner.reset();
		LinkedList<String[]> tempListOfEntries = new LinkedList<>() ;
		tempListOfEntries.add(currentEntry);
		while(topicScanner.hasNext()) {
			tempListOfEntries.add(getNextEntry());
		}
		Collections.shuffle(tempListOfEntries);

		for(int i = 0; i < tempListOfEntries.size(); i++) {
			
			stackOfTopics.push(tempListOfEntries.get(i));
		}
		topicScanner.reset();
		topicSize = stackOfTopics.size();
//		Scanner scanner = new Scanner(topicFile);
	}
	
	public String[] popEntryFromStack() {
		if(!stackOfTopics.isEmpty()) {
			return stackOfTopics.pop();	
		}
		return null;
	}
	
	public void popEntryFromStackAndPutItToCurrentEntry() {
		currentEntry = popEntryFromStack();
	}
	
	public String[] getNextEntry() {
		if(topicScanner.hasNext()) {
			String entry = topicScanner.nextLine();
			currentEntry = entry.split(":");
			return currentEntry;
		}
		return null;
	}
	
	
	public void writeEntry(String entry) /*throws IOException*/ {
		try {
			FileWriter fw = new FileWriter(topicFile, true);	
			
			fw.write("\n" + entry);
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteEntry(String entry) {
		
	}
	
	
	public void overwriteEntry(String oldEntry, String newEntry) /*throws IOException*/ {
	    try {
	    	File tempFile = new File("C:\\EclipseWorkspace\\LearnEnglish\\Topics\\tempFile.txt");
	    	tempFile.createNewFile();
			FileReader     input  = new FileReader(topicFile);
	        FileWriter     output = new FileWriter(tempFile);
	        BufferedReader reader = new BufferedReader(input);
	        BufferedWriter writer = new BufferedWriter(output);
	        String         line   = reader.readLine();
	        while (line!=null) {
	            if (line.equalsIgnoreCase(oldEntry)) {
	                writer.write(newEntry);
	            } else {
	                writer.write(line);
	            }
	            writer.newLine();
//                writer.flush();
	            line = reader.readLine();
	        }
            reader.close();           
            writer.close();
//            Files.move(tempFile.toPath(), topicFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            topicFile = tempFile;
            tempFile.delete();
//            System.out.println(topicFile.delete());
//            delete(new File(Storage.))
            
	    }
	    catch(IOException e) {
	    	e.printStackTrace();
	    }

	}
	
	public String getWord() {
		return currentEntry[0];
	}
	
	public String getPronunciation() {
		return currentEntry[1];
	}
	
	public String getAssociation() {
		return currentEntry[2];
	}
	
	public String getTranslation() {
		return currentEntry[3];
	}
	
	public String getExamples() {
		return currentEntry[4];
	}
	
	public int getTopicSize() {
		return topicSize;
	}
	
	public boolean isEmptyStack() {
		return stackOfTopics.isEmpty();
	}
	
	
}
