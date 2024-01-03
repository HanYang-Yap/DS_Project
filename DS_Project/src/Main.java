//import java.io.IOException;
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		KeywordList keywords=new KeywordList();
//		keywords.setKword();
//		try {
//			Scanner userScanner = new Scanner(System.in);
//			System.out.println("User input: ");
//			String userInput = userScanner.nextLine();
//			
//			GoogleQuery result = new GoogleQuery(userInput);
//			System.out.println(result.query()); 
////			System.out.println(new GoogleQuery("�f�X").query());
//			userScanner.close();
//			WebTree webTree = new WebTree(result.queue);
//			webTree.output();
//		} 
//		catch (IOException e) {
//			
//			e.printStackTrace(); 
//		}
//	}
//}
//
//
