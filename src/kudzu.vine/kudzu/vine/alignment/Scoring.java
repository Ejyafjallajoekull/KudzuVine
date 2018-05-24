package kudzu.vine.alignment;

/**
 * The Scoring interface provides functionality of comparing two elements based on similarity.
 * 
 * @author Planters
 *
 */
public interface Scoring {

	/**
	 * Get the similarity score of two elements.
	 * 
	 * @param elementOne - the first element to compare with the second
	 * @param elementTwo - the second element to compare with the first
	 * @return the similarity score
	 */
	public int score(Object elementOne, Object elementTwo);
	
}
