package kudzu.vine.alignment.local;

import kudzu.vine.alignment.AlignmentScore;
import kudzu.vine.alignment.Scoring;

/**
 * The SmithWaterman class implements the Smith-Waterman algorithm for local sequence alignment.
 * 
 * @author Planters
 *
 */
public class SmithWaterman<T> implements Scoring {
	
	private AlignmentScore gap = new AlignmentScore() {
		
		@Override
		public int alignmentEventScore(int alignmentEventLength) {
			return alignmentEventLength * -1;
		}
	};
	private AlignmentScore match = new AlignmentScore() {
		
		@Override
		public int alignmentEventScore(int alignmentEventLength) {
			return alignmentEventLength * 1;
		}
	};
	private AlignmentScore missmatch = new AlignmentScore() {
		
		@Override
		public int alignmentEventScore(int alignmentEventLength) {
			return alignmentEventLength * -1;
		}
	};
	
	
	public SmithWaterman() {
		
	}
	
	public SmithWaterman(AlignmentScore matchFunction, AlignmentScore missmatchFunction, 
			AlignmentScore gapFunction) {
		
	}

	@Override
	public int score(Object elementOne, Object elementTwo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
