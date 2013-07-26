public class UniqueChar {

	/*
	 * CCI: P1.1 on page 48 Start from 1:54am
	 */
	public static void main(String[] args) {
		String newString = "abcdeefg";
		System.out.println(hasUniqueChars(newString));
	}

	public static boolean hasUniqueChars(String newString) {
		int bitArray = 0;
		for (int i = 0; i < newString.length(); i++) {
			char aChar = newString.charAt(i);
			int diff = aChar - 'a';
		}
		return true;
	}

}
