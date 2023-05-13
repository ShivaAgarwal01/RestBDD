package restassuredTest;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	
	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("peter@klaven"+generatedString);
		
		
	}
	
	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("morpheus"+generatedString);
		
		
	}

}
