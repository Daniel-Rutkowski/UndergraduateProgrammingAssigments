public class Program2 {
	
			/* This program generates random poems based on set Themes.
				
				Date Last Modified: 10/20/2016
				Daniel Rutkowski
				
				CS1121, Fall 2016    */
	
			// These are large strings that will be used to store random words to be called upon later.
	
	public String[] verbs = { "moving ", "racing", "slowing", "determining", "stopping", "starting", "ending",
			"command", "confirm", "crawl", "decide", "enjoy", "enter", "fix", "help", "hide", "haunt", "include",
			"play", "pause", "satisfy", "report", "surprise", "relax", "rescue", "test", "terrify", "transport",
			"hinder", "trade", "take", "use", "understand", "waste", "watch", "welcome" };

	public String[] adjectives = { "silent ", "loud", "big", "small", "evil", "good", "smart", "silly", "complex",
			"classic", "dishonest", "gloomy", "enlightening", "emotional", "every", "fast", "gross", "hopeful", "happy",
			"lively", "little", "large", "marvelous", "noxious", "outstanding", "optimistic", "powerful", "black",
			"white", "orange", "red", "blue", "grey", "green", "remorseful", "wasteful", "watchful", "rigid", };

	public String[] nouns = { "happiness ", "success", "failure", "contempt", "loyalty", "sadness", "anger", "jeaously",
			"people", "computers", "programs", "food", "information", "art", "law", "software",
			"clocks", "science", "love", "player", "friends", "friend", "exam", "policy", "direction", "strategy",
			"truth", "growth", "energy", "income", "entertainment", "death", "life", "attitude", "personality",
			"interaction", "preference", };

	public String[] prepositions = { "into ", "onto", "under", "over", "in", "for", "with", "of", "below", "by", "but",
			"from", "off", "than", " through", "within", "without", };

	public String[] haikuVerbs = {
			"go", "come" , "calm" ,"end", "stop" , "act" , "heat" , "drop" , "cause" , "break"
	};
	
	public String[] haikuNouns = {
			"seasons", "winters" , "summers", "weekdays" , "workdays", "spring days" , "autumns" , 
			};
	
	public String[] haikuAdjectives = {
		"happy", "angry", "peaceful", "chilly", "dreary", "dreamy" , "messy" , "crappy" , "hazy" ,
		"sloppy" , "sunny" , "foggy" , "cloudy", "cozy" , "breezy" , "lovely" , "pretty" , "busy"
	};
	
	/**
	 * Enumerations are finite ordered sets of symbols. Each symbol corresponds
	 * to its position in the enumeration.
	 * 
	 * Enter one symbol for each poetic theme.
	 * 
	 * You must include the themes Einstein and Memory.
	 */

	public enum Theme {
		// YOUR THEMES LISTED HERE
		Einstein, Memory, Time, College, Computers, Emotions, Work, Life,
	}
	
	// This enum contains my haiku themes.
	
	public enum haikuTheme {
		pleasant , bitter
	}


	/**
	 * @return a randomly selected theme from the above enumeration.
	 */
	private Theme getTheme() {
		Theme theme = (Theme.values())[(int) (Math.random() * Theme.values().length)];
		return theme;
	}
	
	// This generates random haiku themes.
	
	private haikuTheme gethaikuTheme() {
		haikuTheme haikutheme = (haikuTheme.values())[(int) (Math.random() * haikuTheme.values().length)];
		return haikutheme;
	}

	/**
	 * @param array
	 * @return a randomly selected element of the given array.
	 */
	private String getRandomElement(String[] array) {
		// YOUR CODE HERE
		String element = array[(int) (Math.random() * array.length)];
		return element;
	}

	// Allows the first letter of each line to be capitalized.
	
	private String capital(String element) {
		String character = element.substring(0,1);
		character = character.toUpperCase();
		return character + element.substring(1);
		
	}
	
	/**
   * Generated a poem based on a specified theme 
   * in the format specified above.
   * 
   * @return a poem based on a specified theme.
   */
   public String generateThematicPoem( Theme theme ) {
      // YOUR CODE HERE
	
	   String line1 = "";
	   String line2 = "";
	   String line3 = "";
	   String line4 = "";
	   String line5 = "";
	   
	   if ( theme == Theme.Einstein ) {
		   line1 = "MASTER OF KNOWLEDGE";
		   line2 = capital(getRandomElement(adjectives)) + " " + "Scientist" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "Einstein Knows All";
	   } else if ( theme == Theme.Time ) {
		   line1 = "MYSTERY OF TIME";
		   line2 = capital(getRandomElement(adjectives)) + " " + "Time" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "Clocks tick On";
	   } else if ( theme == Theme.Memory ) {
		   line1 = "FOOD FOR THOUGHT";
		   line2 = capital(getRandomElement(adjectives)) + " " + "Memory" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "Always Remember";
	   } else if ( theme == Theme.College ) {
		   line1 = "SCHOOL OF KNOWLEDGE";
		   line2 = capital(getRandomElement(adjectives)) + " " + "College" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "University Days";
	   } else if ( theme == Theme.Computers) {
		   line1 = "SCHOOL OF KNOWLEDGE";
		   line2 = capital(getRandomElement(adjectives)) + " " + "Technology" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "Computers of Wonder";   
	   } else if ( theme == Theme.Emotions) {
		   line1 = "THE INTERNAL MOTIVATORS";
		   line2 = capital(getRandomElement(adjectives)) + " " + "Emotions" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "Emotional Rollar Coaster";   
	   } else if ( theme == Theme.Work) {
		   line1 = "THE DAILY STRUGGLE";
		   line2 = capital(getRandomElement(adjectives)) + " " + "Career" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "Working Unceasingly";   
	   } else if ( theme == Theme.Life) {
		   line1 = "THE HUMAN EXPERIENCE";
		   line2 = capital(getRandomElement(adjectives)) + " " + "Life" ;
		   line3 = capital(getRandomElement(verbs)) + " " + getRandomElement(nouns);
		   line4 = capital(getRandomElement(nouns)) + " " + getRandomElement(prepositions) + " " + getRandomElement(nouns) + " " + getRandomElement(verbs) + " " + getRandomElement(nouns);
		   line5 = "Life Goes On"; 
	   }
	   
	  String finalResult = String.format( "%s \n %s \n %s \n %s \n\t %s \n" , line1, line2, line3, line4, line5 );
      return finalResult;
   }
  
	

	/**
	 * Generated a poem based on a specified theme in the format specified
	 * above.
	 * 
	 * If the theme does not exist, return the empty string.
	 * 
	 * @return a poem based on a specified theme.
	 */
	public String generateThematicPoem(String themeString) {
		// YOUR CODE HERE
		switch(themeString) {
		case "Einstein" :
			return generateThematicPoem( Theme.Einstein );
		case "Memory" :
			return generateThematicPoem( Theme.Memory);
		case "Time" :
			return generateThematicPoem( Theme.Time );
		case "College" :
			return generateThematicPoem( Theme.College);
		case "Computers" :
			return generateThematicPoem( Theme.Computers );
		case "Emotions" :
			return generateThematicPoem( Theme.Emotions);	
		case "Work" :
			return generateThematicPoem( Theme.Work );
		case "Life" :
			return generateThematicPoem( Theme.Life );
		}
		
		String emptyString = "";
		return emptyString;
	}

	/**
	 * Generated a poem based on a randomly selected theme in the format
	 * specified above.
	 * 
	 * @return a poem based on a randomly selected theme.
	 */
	public String generateRandomPoem() {
		// YOUR CODE HERE
		Theme theme = getTheme();
		String product = generateThematicPoem(theme); 
		return product;
	}

	/**
	 * 5 Bonus Tech Points Generate a haiku based on two randomly selected
	 * themes.
	 * 
	 * Haiku + is often represented by the juxtaposition of two thematic images.
	 * + Consist of three lines of 5, 7, and 5 syllables each. + A seasonal
	 * reference, usually drawn from an list of such words.
	 * 
	 * @return a haiku based on two randomly selected themes.
	 */
	
	// These blocks of codes generate a random haiku theme and then creates a random poem based off of that theme.
	
	public String generateRandomHaiku() {
		// YOUR CODE HERE
		haikuTheme haikuTheme = gethaikuTheme();
		String product = generateRandomHaiku(haikuTheme); 
		return product;
	}
			
	// My themes correlate with the words "pleasant" and "bitter", and my seasonal references correlate with "summers" and winters".
	
	
	public String generateRandomHaiku(haikuTheme haikuTheme) {
		// YOUR CODE HERE
		
		String line11 = "";
		String line12 = "";
		String line13 = "";
		
		if ( haikuTheme == Program2.haikuTheme.pleasant ) {
			   line11 = capital("pleasant") + " " + getRandomElement(haikuNouns) + " " + getRandomElement(haikuVerbs); 
			   line12 = capital(getRandomElement(haikuAdjectives)) + " " + getRandomElement(haikuAdjectives) + " " + getRandomElement(haikuNouns) + " " + getRandomElement(haikuVerbs) ;
			   line13 = capital(getRandomElement(haikuAdjectives)) + " " + "summers" + " " + getRandomElement(haikuVerbs);
		}
		if ( haikuTheme == Program2.haikuTheme.bitter ) {
			   line11 = capital("bitter") + " " + getRandomElement(haikuNouns) + " " + getRandomElement(haikuVerbs); 
			   line12 = capital(getRandomElement(haikuAdjectives)) + " " + getRandomElement(haikuAdjectives) + " " + getRandomElement(haikuNouns) + " " + getRandomElement(haikuVerbs) ;
			   line13 = capital(getRandomElement(haikuAdjectives)) + " " + "winters" + " " + getRandomElement(haikuVerbs);	   
		}	   
		String finalResult2 = String.format( "%s \n %s \n %s ", line11, line12, line13 );	   
		return finalResult2;
	}

	/**
	 * This main method can be used to test your code. As implemented, this will
	 * print out + A poem about Einstein. + A poem about Memory. + And 10 poems
	 * about random themes.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Program2 obj = new Program2();
		System.out.println(obj.generateThematicPoem("Einstein"));
		System.out.println(obj.generateThematicPoem(Theme.Memory));
		for (int i = 0; i < 10; i++) {
			System.out.println(obj.generateRandomPoem());
		}
		System.out.println(obj.generateRandomHaiku());
	}
}