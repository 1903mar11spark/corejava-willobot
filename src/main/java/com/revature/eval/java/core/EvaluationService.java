package com.revature.eval.java.core;

import java.text.SimpleDateFormat;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	public static void main(String[] args) {

	System.out.println(reverse("Robot"));
	System.out.println(reverse("Mississippi"));
	System.out.println(acronym("World Health Organization"));
	System.out.println(acronym("not-a-space-alien"));
	System.out.println(isArmstrongNumber(34));
	System.out.println(getScrabbleScore("WHALSJDFLSJ"));
	System.out.println(solveWordProblem("what is 1 plus 2"));
	System.out.println(wordCount("olly olly oxen free"));
	
	System.out.println(cleanPhoneNumber(" +1 (801)725-6641"));
	String[] arr = { "one fish two fish red fish blue fish" };
//	System.out.println(wordCount(Arrays.toString(arr)));
	System.out.println(solveWordProblem("what is 2 minus 7"));
	System.out.println(toPigLatin("Nasa is watchin"));
	
	System.out.println(calculatePrimeFactorsOf(39285));
	
	System.out.println(calculateNthPrime(33));

	System.out.println(isValidIsbn("978-3-16-148410-0"));

	System.out.println(isPangram("Five quacking zephyrs jolt my wax bed."));

	int[] z = {4, 5};
	
	System.out.println(getSumOfMultiples(5, z));

	System.out.println(isLuhnValid("8,9,19,9"));
	
	System.out.println(solveWordProblem("what is 1 plus 2"));


	}

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
//	public String reverse(String string) {
//		char[] reversed = new char[string.length()];
//		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
//			reversed[j] = string.charAt(i);
//		}
//		return new String(reversed);
//	}

//	psudo
//	declare empty string
//	find last letter, and iterate down til you reach 0
//	put iterations into new string
	public static String reverse(String string) {
		String newStr = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			newStr += string.charAt(i);
		}
		return newStr;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	// psudo
	public static String acronym(String phrase) {
		String newStr = "";
		String[] str = phrase.split("[-\\s]");
		char x;
		for (int i = 0; i < str.length; i++) {
			x = str[i].charAt(0);
			newStr = (newStr + x).toUpperCase();
		}
		return newStr;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {

		private double sideOne;
		private double sideTwo;
		private double sideThree;
		public static void main(String[] args) {

//				System.out.println(isEqualateral);
		}

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			
			Triangle t = new Triangle();
			t.setSideOne(10);
			t.setSideTwo(12);
			t.setSideThree(12);

			if (sideOne != sideTwo && sideOne != sideThree) {
				return false;
			} else
				return true;
		}

		public boolean isIsosceles() {

			Triangle t1 = new Triangle();
			t1.setSideOne(12);
			t1.setSideTwo(12);
			t1.setSideThree(3);

			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return false;
			} else {
				return true;
			}
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public static int getScrabbleScore(String string) {

		string = string.toLowerCase();
		int sum = 0;

		for (int i = 0; i < string.length(); i++) {
			char x = string.charAt(i);
			switch (x) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'l':
			case 'n':
			case 'r':
			case 's':
			case 't':
				sum = sum + 1;
				break;
			case 'd':
			case 'g':
				sum = sum + 2;
				break;
			case 'b':
			case 'c':
			case 'm':
			case 'p':
				sum = sum + 3;
				break;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
				sum = sum + 4;
				break;
			case 'k':
				sum = sum + 5;
				break;
			case 'x':
			case 'j':
				sum = sum + 8;
				break;
			case 'q':
			case 'z':
				sum = sum + 10;
				break;
			default:
				sum = 0;
			}
		}
		return sum;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public static String cleanPhoneNumber(String string) {

//		String str = String.join("[-\\s]");
//		String[] nums = {};
//		String phone = "";

//		for(int i=0; i<str.length(); i++) {
////			nums = nums+str.valueOf(i); 
//			phone = Arrays.toString(nums);
//		}

//		return phone;	

		String nums = "";
		string = string.replaceAll("[a-zA-Z@!:()\\s-+.]+", nums);
		nums = nums.replaceAll("^\\d{3}-\\d{3}-\\d{4}$", "");

//		if(string.indexOf("1") == 0) {

//			char p = (char) string.indexOf("+");

//			char n = (char) (p+1);

//			string.replace(n, "");

//			
////		}
		return string;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public static Map<String, Integer> wordCount(String string) {
	
	      String[] splitted = string.split("");
		
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for (int i=0; i<splitted.length ; i++) {
	         if (hm.containsKey(splitted[i])) {
//	        	 System.out.println();
	            int cont = hm.get(splitted[i]);
	            hm.put(splitted[i], cont + 1);
	         } else {
	            hm.put(splitted[i], 1);
	         }
	      }
	      System.out.println(hm);
		return hm;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {

		private List<T> sortedList;

		public int indexOf(T t) {
			return Arrays.binarySearch(sortedList.toArray(), t);
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}
	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public static String toPigLatin(String string) {

		String[] str = string.split("[-\\s]");

		for (int i = 0; i < str.length; i++) {
			String y = String.valueOf(str[i].charAt(0));
			if (y == "A") {
				str[i] = str[i] + "'ay";
			} else if (y == "E") {
				str[i] = str[i] + "'ay";
			} else if (y == "I") {
				str[i] = str[i] + "'ay";
			} else if (y == "O") {
				str[i] = str[i] + "'ay";
			} else if (y == "U") {
				str[i] = str[i] + "'ay";
			} else {
				str[i] = str[i] + "ay";
			}
		}
		return String.join(" ", str);
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isArmstrongNumber(int input) {

		int numDigits = 0;
		int number = input;

		while (number > 0) {
			numDigits++;
			number = number / 10;
		}

		int sum = 0;

		number = input;

		while (number > 0) {
			int digit = number % 10;
			sum += Math.pow(digit, numDigits);
			number = number / 10;
		}
		return sum == input;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public static List<Long> calculatePrimeFactorsOf(long l) {

		List<Long> factors = new ArrayList<>();
		long originalValue = l;

		for (long number = 2; number <= originalValue; number++) {
			if (originalValue % number == 0) {
				factors.add(number);
				originalValue /= number;
				number--;
			}
		}
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public static int calculateNthPrime(int i) {

		int nthPrime = 1;
		int count = 0;

		while (count < i) {
			int divisor;
			nthPrime = nthPrime + 1;
			for (divisor = 2; divisor <= nthPrime; divisor++) {
				if (nthPrime % divisor == 0) {
					break;
				}
			}

			if (divisor == nthPrime) {
				count = count + 1;
			}
		}
		return nthPrime;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		public static String encode(String string) {
			string = string.toLowerCase();

			String aToZ = "abcdefghijklmnopqrstuvwxyz";
			String zToA = "zyxwvutsrqponmlkjihgfedcba";
			String result = "";

			for (int i = 0; i < string.length(); i++) {
				char letter = string.charAt(i);

				if (Character.isAlphabetic(letter)) {
					int index = aToZ.indexOf(letter);
					result += zToA.charAt(index);
				} else if (Character.isDigit(letter)) {
					result += letter;
				}
			}

			String spacedResult = "";

			for (int i = 0; i < result.length(); i++) {
				if (i != 0 && i % 5 == 0) {
					spacedResult += " ";
				}

				spacedResult += result.charAt(i);
			}

			return spacedResult;
		}

		/**
		 * Question 14
		 *
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string = string.toLowerCase();

			String aToZ = "abcdefghijklmnopqrstuvwxyz";
			String zToA = "zyxwvutsrqponmlkjihgfedcba";
			String result = "";

			for (int i = 0; i < string.length(); i++) {
				char letter = string.charAt(i);

				if (letter == ' ') {
					continue;
				}

				if (Character.isAlphabetic(letter)) {
					int index = zToA.indexOf(letter);
					result += aToZ.charAt(index);
				} else {
					result += letter;
				}
			}

			return result;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isValidIsbn(String string) {

		String cleaned = "";

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '-') {
				continue;
			}

			char letter = string.charAt(i);

			if ((letter >= '0' && letter <= '9') || (letter == 'X' && i == string.length() - 1)) {
				cleaned += string.charAt(i);
			} else {
				return false;
			}
		}

		if (cleaned.length() != 10) {
			return false;
		}

		int multiplier = 10;
		int sum = 0;

		for (int i = 0; i < cleaned.length(); i++) {
			char letter = cleaned.charAt(i);
			if (letter >= '0' && letter <= '9') {
				sum += ((letter - '0') * multiplier);
			} else if (letter == 'X') {
				sum += (10 * multiplier);
			}
			multiplier--;
		}
		return sum % 11 == 0;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isPangram(String string) {

		String alpha = string.toLowerCase();
		char[] bets = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".toCharArray();
		List<Character> letters = new ArrayList<Character>();

		if (string.length() > 0) {
			for (Character i : letters) {
				if (string.indexOf(i) > -1) {
					letters.add(i);
				}
			}
			return (letters.size() == 26);
		}
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public static Temporal getGigasecondDate(Temporal given) {

		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");

		System.out.println(form);

		return null;

	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public static int getSumOfMultiples(int x, int[] set) {

		HashSet<Integer> mult = new HashSet<>();
		int sum = 0;

		for (int i = 1; i < x; i++) {
			for (int num : set) {
				if (i % num == 0) {
					mult.add(i);
				}
			}
		}

		for (int number : mult) {
			sum += number;
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isLuhnValid(String string) {

		String cleaned = "";

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ') {
				continue;
			}
			
			if (!Character.isDigit(string.charAt(i))) {
				return false;
			}
			cleaned += string.charAt(i);
		}

		string = cleaned;
		int sum = 0;
		boolean isEven = false;

		for (int i = string.length(); i > 0; i--) {
			int k = Integer.parseInt(string.substring(i - 1, i));
			if (isEven) {
				k = k * 2;
				if (k / 10 != 0) {
					k = k / 10 + k % 10;
				}
			}
			isEven = !isEven;
			sum += k;
		}
		return sum % 10 == 0;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public static int solveWordProblem(String string) {
		int sum = 0;
		for (int i = 0; i < string.length(); i++) {
			if (Character.isDigit(string.charAt(i)) && string.indexOf("plus") != -1) {
				sum = sum + Character.getNumericValue(string.charAt(i));
			} else if (Character.isDigit(string.charAt(i)) && string.indexOf("minus") != -1) {
				sum = Character.getNumericValue(string.charAt(i));
				sum = sum - Character.getNumericValue(string.charAt(i));

			} else if (Character.isDigit(string.charAt(i)) && string.indexOf("multiplied") != -1) {
				sum = Character.getNumericValue(string.charAt(i));
			} else if (Character.isDigit(string.charAt(i)) && string.indexOf("divided") != -1) {
				sum = sum / Character.getNumericValue(string.charAt(i));
			}
		}
		return sum;
	}

}
