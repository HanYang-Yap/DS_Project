import java.io.IOException;
import java.util.*;

import org.w3c.dom.UserDataHandler;

public class Main {
	public static void main(String[] args) {
		try {
			
			Scanner userScanner = new Scanner(System.in);
			System.out.println("User input: ");
			String userInput = userScanner.nextLine();
			
			System.out.println(new GoogleQuery(userInput).query());
//			System.out.println(new GoogleQuery("�f�X").query());
			userScanner.close();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}