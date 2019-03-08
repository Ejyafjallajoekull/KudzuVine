package kudzu.vine.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import koro.sensei.tester.TestRunner;

/**
 * The TestRunnerWrapper class wraps the TestRunner classes main method from the Korosensei 
 * testing framework for easier execution. 
 * 
 * @author Planters
 *
 */
public class TestRunnerWrapper {

	/**
	 * Passes the command line arguments to the TestRunners main function.
	 * 
	 * @param args - the command line arguments for the test runner
	 */
	public static void main(String[] args) {
		TestRunner.main(args);
	}

	/**
	 * Create a random object.
	 * 
	 * @return a random object
	 */
	public static Object createRandomObject() {
		int random = ThreadLocalRandom.current().nextInt(6);
		switch (random) {
		case 0:
			return Integer.valueOf(ThreadLocalRandom.current().nextInt());

		case 1:
			return Double.valueOf(ThreadLocalRandom.current().nextDouble());
			
		case 2:
			return Float.valueOf(ThreadLocalRandom.current().nextFloat());
			
		case 3:
			return Long.valueOf(ThreadLocalRandom.current().nextLong());
			
		case 4:
			return Boolean.valueOf(ThreadLocalRandom.current().nextBoolean());
			
		case 5:
			return TestRunnerWrapper.createRandomString();
			
		default:
			return new Object();
		}
	}
	
	/**
	 * Create a random string.
	 * 
	 * @return a random string
	 */
	public static String createRandomString() {
		byte[] binaryString = new byte[ThreadLocalRandom.current().nextInt(30)];
		ThreadLocalRandom.current().nextBytes(binaryString);
		return new String(binaryString);
	}
	
	/**
	 * Create a random list of objects.
	 * 
	 * @return random objects
	 */
	public static List<Object> createRandomObjects() {
		ArrayList<Object> randomObjects = new ArrayList<>();
		int numberOfObjects = ThreadLocalRandom.current().nextInt(30);
		for (int i = 0; i < numberOfObjects; i++) {
			randomObjects.add(TestRunnerWrapper.createRandomObject());
		}
		return randomObjects;
	}

}
