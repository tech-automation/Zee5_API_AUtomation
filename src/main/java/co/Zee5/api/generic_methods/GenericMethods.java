package co.Zee5.api.generic_methods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Ooviya
 *
 */
public class GenericMethods {

	private static String sourceClass = GenericMethods.class.getName();
	private static String sourceMethod;

	static Logger LOGGER = Logger.getLogger(sourceClass);

	/**
	 * convertStringToIntegerList - converts string list to integer list
	 * 
	 * @author Ooviya
	 * @param testData
	 * @return
	 */
	public static List<Integer> convertStringToIntegerList(String string) {
		sourceMethod = "convertStringToIntegerList";
		LOGGER.entering(sourceClass, sourceMethod);

		List<String> stringList = null;
		if (string != null) {
			stringList = Arrays.asList(string.split(","));
			LOGGER.info("String list : " + stringList);
		}

		List<Integer> intList = null;
		if (stringList != null) {
			intList = stringList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		}
		LOGGER.info("Int list : " + intList);

		LOGGER.exiting(sourceClass, sourceMethod);
		return intList;
	}

	/**
	 * getRandomNumber - Generate random integers
	 * 
	 * @author Ooviya
	 * @param min
	 * @param max
	 * @return
	 */
	public static Integer getRandomNumber(int min, int max) {
		Random rand = new Random();
		int value = rand.nextInt((max - min) + 1) + min;
		return value;
	}

	// Function to generate a random string of length n
	public static String getAlphaNumericString(int stringLength) {

		// chose a Character random from this String
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(stringLength);

		for (int i = 0; i < stringLength; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (alphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(alphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	/**
	 * generateStringFromResource - returns content of file in the given path as
	 * string
	 *
	 * @param path
	 * @return String
	 * @throws IOException
	 */
	public String generateStringFromResource(String path) throws IOException {
		sourceMethod = "generateStringFromResource";
		LOGGER.entering(sourceClass, sourceMethod);
		LOGGER.exiting(sourceClass, sourceMethod);
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
