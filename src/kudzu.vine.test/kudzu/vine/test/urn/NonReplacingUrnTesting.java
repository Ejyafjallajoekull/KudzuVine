package kudzu.vine.test.urn;

import java.util.List;

import koro.sensei.tester.TestFailureException;
import koro.sensei.tester.TestSubject;
import kudzu.vine.test.TestRunnerWrapper;
import kudzu.vine.urn.NonReplacingUrn;
import kudzu.vine.urn.Urn;

/**
 * The {@code NonReplacingUrnTesting} class test the {@link kudzu.vine.urn.NonReplacingUrn 
 * NonReplacingUrn} class for correct functionality.
 * 
 * @author Planters
 *
 */
public class NonReplacingUrnTesting implements TestSubject {

	@Override
	public void runAllTests() throws TestFailureException {
		NonReplacingUrnTesting.testConstructors();
	}

	/**
	 * Test the constructors and some basic equality.
	 * 
	 * @throws TestFailureException the test did fail
	 */
	private static void testConstructors() throws TestFailureException {
		for (int i = 0; i < 1000; i++) {
			Urn<Object> testUrnA = new NonReplacingUrn<>();
			Urn<Object> testUrnB = null; // test null
			TestSubject.assertFailCondition(testUrnA.equals(testUrnB), "%s should not be equal %s.", testUrnA, testUrnB);
			testUrnB = new NonReplacingUrn<>(); // test basic equality
			TestSubject.assertTestCondition(testUrnA.equals(testUrnB), "%s should equal %s.", testUrnA, testUrnB);
			// test breaking equality
			List<Object> randomObjects = TestRunnerWrapper.createRandomObjects();
			testUrnA.addAll(randomObjects);
			if (randomObjects.isEmpty()) {
				TestSubject.assertTestCondition(testUrnA.equals(testUrnB), "%s should equal %s.", testUrnA, testUrnB);
			} else {
				TestSubject.assertFailCondition(testUrnA.equals(testUrnB), "%s should not be equal %s.", testUrnA, testUrnB);
			}
			if (randomObjects.size() > 1) {
				Object temp = randomObjects.get(0);
				randomObjects.set(0, randomObjects.get(1));
				randomObjects.set(1, temp);

			}
			testUrnB.addAll(randomObjects); // test rescuing equality
			TestSubject.assertTestCondition(testUrnA.equals(testUrnB), "%s should equal %s.", testUrnA, testUrnB);
		}
	}
	
	
	
	/**
	 * Create a random non replacing urn.
	 * 
	 * @return a random urn
	 */
	private static NonReplacingUrn<Object> createRandomUrn() {
		return new NonReplacingUrn<Object>(TestRunnerWrapper.createRandomObjects());
	}
	
}
