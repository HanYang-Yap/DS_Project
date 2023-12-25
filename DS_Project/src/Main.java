import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		KeywordList keywords=new KeywordList();
		
		Keyword hikingTrail = new Keyword("HIKING TRAIL", 5);
		Keyword scenery = new Keyword("SCENARY", 3);
		Keyword nationalPark = new Keyword("NATIONAL PARK", 3);
		Keyword forest = new Keyword("FOREST", 3);
		Keyword climb = new Keyword("CLIMB", 3);
		Keyword guide = new Keyword("GUIDE", 3);
		Keyword hiking = new Keyword("HIKING", 3);
		Keyword nature = new Keyword("NATURE", 4);
		Keyword hundredMountian = new Keyword("100 MOUNTAIN", 2);
		Keyword exercise = new Keyword("EXERCISE", 1);
		Keyword attraction = new Keyword("ATTRACTION", 4);
		Keyword publicTransportation = new Keyword("PUBLIC TRANSPORTATION", 2);
		Keyword equipment = new Keyword("EQUIPMENT", -3);
		Keyword dictionary = new Keyword("DICTIONARY", -10);
		Keyword translate = new Keyword("TRANSLATE", -10);
		Keyword weather = new Keyword("WEATHER", -3);
		Keyword hotSpring = new Keyword("HOT SPRING", -2);
		Keyword dictionary_chinese = new Keyword("字典", -10);
		Keyword translate_chinese = new Keyword("翻譯", -10);
		Keyword meaning = new Keyword("意思", -10);
		
		keywords.add(hikingTrail);
		keywords.add(scenery);
		keywords.add(nationalPark);
		keywords.add(forest);
		keywords.add(climb);
		keywords.add(guide);
		keywords.add(hiking);
		keywords.add(nature);
		keywords.add(hundredMountian);
		keywords.add(exercise);
		keywords.add(attraction);
		keywords.add(publicTransportation);
		keywords.add(equipment);
		keywords.add(dictionary);
		keywords.add(translate);
		keywords.add(dictionary_chinese);
		keywords.add(translate_chinese);
		keywords.add(meaning);
		keywords.add(weather);
		keywords.add(hotSpring);

		keywords.printKeywordList(keywords.keywords);

		try {
			Scanner userScanner = new Scanner(System.in);
			System.out.println("User input: ");
			String userInput = userScanner.nextLine();
			
			GoogleQuery result = new GoogleQuery(userInput);
			System.out.println(result.query()); 
//			System.out.println(new GoogleQuery("�f�X").query());
			userScanner.close();
			
			WebTree webTree = new WebTree(result.queue);
			webTree.output();
		} 
		catch (IOException e) {
			
			e.printStackTrace(); 
		}
	}
}


