/**
 * Defines a testing module.
 * 
 * @author Planters
 *
 */
module kudzu.vine.test {
	
	exports kudzu.vine.test;
	exports kudzu.vine.test.alignment.local;
	exports kudzu.vine.test.urn;
	
	requires kudzu.vine;
	requires koro.sensei.tester;
	requires central.logging;
	requires java.base;
	requires transitive java.logging;
	
}