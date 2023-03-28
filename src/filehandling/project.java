package filehandling;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class project {
	final static String Developer_Name ="Syamsundara Reddy";
	final static String Application_Name ="File handling";
	final static String Welcome_Screen = "Welcome to " + Application_Name + " developed by " + Developer_Name +"!!";
	

	public static void main(String[] args) {
		
		System.out.println(Welcome_Screen);

		while(true) {
			displayMenu();
			int option = UserOption();
			
			switch(option) {
			
			case 1:
				displayFiles();
				break;
			
			case 2:
				fileApplications();
				break;
			
			case 3:
				closeApplication();
				break;
				
			default:
				System.out.println("Invalid option");
				break;
		}
			
		}
		
		}

     private static void displayMenu() {
    	 
		System.out.println("\nPlease select an option:");
		System.out.println("1.Display Files");
		System.out.println("2.FileApplications");
		System.out.println("3.Close Application");
	}


	private static int UserOption() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("\nEnter your choice");
		int choice = sc.nextInt();
		return choice;
	}
	
	private static void displayFiles() {
		
		File directory = new File("."); // gives current directory files
		System.out.println("Current directory: " + directory.getAbsolutePath()); // Display the absolute path of the current directory
		
		System.out.println("\nDisplaying files in ascending order");
		File[] file = directory.listFiles();
		Arrays.sort(file);
		
		for(File f: file) {
			 if (f.isFile()) {
		            System.out.println(f.getName());
		         }
		      }
		}
		
	
	private static void fileApplications() {
		while(true) {
			displayDirectoryMenu();
			int option = UserOption();
			
			switch(option) {
			
			case 1:
				addFile();
				break;
			
			case 2:
				deleteFile();
				break;
			
			case 3:
				searchFile();
				break;
				
			case 4:
				return;
				
			default:
				System.out.println("Invalid option");
				break;
		}
			
		}
		
		}

	private static void displayDirectoryMenu() {
		
		System.out.println("\nPlease select an option:");
		System.out.println("1.Add File");
		System.out.println("2.Delete File");
		System.out.println("3.Search File");
		System.out.println("4.Menu");
	}
	
	private static void addFile() {
		
		System.out.println("Enter filename you want to add: ");
		Scanner sc = new Scanner(System.in);
		String filename= sc.next();
		
		File file = new File(filename.toLowerCase()); // ignoring casesensitivity
		try {
			if(file.exists()) {
				System.out.println("file exists!!!");
				}
			else {
				file.createNewFile();
				System.out.println("file successfully created!!");
				}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void deleteFile() {
		
		System.out.println("Enter filename you want to delete: ");
		Scanner sc = new Scanner(System.in);
		String filename= sc.next();
		
		File file = new File(filename);
		
		if(!file.exists()) {
			System.out.println("file not found");
		}
		
		if(file.exists()) {
			
			if(file.delete()) {
			System.out.println("File deleted successfully");
			 }
			
			else {
		  System.out.println("error occured while deleting");
			}
			
			}
		
		}
		
		
	private static void searchFile() {
		
		System.out.println("Enter file name you want to search: ");
		Scanner sc = new Scanner(System.in);
		String filename= sc.next();
		
		File directory = new File(".");
		File[] file = directory.listFiles();
		
		boolean found = false;
		
		for(File f: file) {
			 if (f.getName().equals(filename)) {
		            System.out.println("file found");
		            found= true;
		            break;
		            }
			 }
		
		if(!found) {
			System.out.println("File not found");
		}
		  
		}
	
	private static void closeApplication() {
		System.out.println("Application Closed");
		System.exit(0);
		
	}
}
