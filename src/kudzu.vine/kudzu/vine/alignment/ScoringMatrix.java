package kudzu.vine.alignment;

import java.util.Arrays;

/**
 * The ScoringMatrix class represents a matrix of two sequences, scored against each other 
 * according to a specified scoring function.
 * 
 * @author Planters
 *
 */
public class ScoringMatrix<T> {

	private T[] columnSequence = null;
	private T[] rowSequence = null;
	private Scoring scoringFunction = null;
//	private Alignment alignment = null;
	private int score = 0;
	
	public ScoringMatrix(T[] sequenceOne, T[] sequenceTwo, Scoring scoringFunction) {
		if (sequenceOne != null && sequenceTwo != null && scoringFunction != null) {
			this.columnSequence = sequenceOne.clone();
			this.rowSequence = sequenceTwo.clone();
			this.scoringFunction = scoringFunction;
		} else {
			throw new NullPointerException(String.format("Neither the first %s, nor the second "
					+ "%s sequence, nor the scoring function %s may be null.", sequenceOne, 
					sequenceTwo, scoringFunction));
		}
	}
	
	private void createScoring() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(columnSequence);
		result = prime * result + Arrays.hashCode(rowSequence);
		result = prime * result + ((scoringFunction == null) ? 0 : scoringFunction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof ScoringMatrix) {
			@SuppressWarnings("rawtypes")
			ScoringMatrix other = (ScoringMatrix) obj;
			return Arrays.equals(, arg1)
		}
		return false;
		

	}
	
}
