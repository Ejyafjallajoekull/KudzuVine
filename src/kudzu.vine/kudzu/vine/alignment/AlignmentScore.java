package kudzu.vine.alignment;

/**
 * The AlignmentScore interface provides a function for determining the score of a specific 
 * alignment event in relation to the event length. <br>
 * For example a gap extension penalty.
 * 
 * @author Planters
 *
 */
public interface AlignmentScore {
	
	/**
	 * Get the score for a alignment event of the specified length.
	 * 
	 * @return the score of the alignment event
	 */
	public int alignmentEventScore(int alignmentEventLength);
	
}
