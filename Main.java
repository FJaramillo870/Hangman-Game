import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//creating the word the user has to guess
		String word = "Banana";
		//Creating variable for the number of incorrect guesses
		int incorrect = 0;
		//Creating arrayList and Adding the number of characters in the word to the list as _
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i< word.length(); i++) {
    		arrayList.add("_");
		}

		System.out.println("The length of the word you need to guess!"+ arrayList);
		System.out.println("Enter a letter to see if its a match");
		//Created A gameloop to stay running until the user gets the word or reaches 5 incorrect guesses
		while(true){
		boolean matchFound = false;
		String guess = scanner.nextLine();
		for(int i=0; i<word.length(); i++){
			//getting the index
			char letter = word.charAt(i);
			String ind = word.valueOf(letter);
			//if the value of the letter at this index is equal to the input add to list at that index
			if(ind.equalsIgnoreCase(guess)){
				arrayList.set(i, guess);
				System.out.println("Match found on index "+i);
				matchFound = true;}
		}
		//if no match is found in the whole word then add an incorrect guess
		if (!matchFound) {
    		System.out.println("No match found");
    		incorrect++;
    		System.out.println("The number of incorrect guesses: "+incorrect);
		}
		//if the user reaches 5 incorrect guesses then end the game
		if(incorrect == 5){
			System.out.println("Game over you lost");
			break;
		}

		StringBuilder resultBuilder = new StringBuilder();
		for (String element : arrayList) { 
		resultBuilder.append(element);
		}

		String result = resultBuilder.toString();
		System.out.println(result);

		//if the user gets the word right then break the game loop
		if(result.equalsIgnoreCase(word)){
			System.out.println("WOOOOO GOOD JOB!");
			break;
		}

		}
	}
}


