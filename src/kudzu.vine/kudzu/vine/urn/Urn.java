package kudzu.vine.urn;

import java.util.Collection;
import java.util.List;

/**
 * The {@code Urn} interface represents a collection of elements, which cannot be 
 * retrieved individually. Instead each element has the same probability of being 
 * retrieved by drawing from the {@code Urn}.
 * 
 * @author Planters
 *
 * @param <E> - the type of elements contained in the urn
 */
public interface Urn<E> extends Collection<E> {

	/**
	 * Draw a random element from the urn.
	 * 
	 * @return a random element contained in the urn
	 * @throws IllegalStateException if the urn is empty
	 */
	public E draw();
	
	/**
	 * Subsequently draw the specified number of elements from the urn.
	 * 
	 * <p>The elements are returned as {@link List} in the order they have 
	 * been drawn from the urn.</p>
	 * 
	 * @param numberOfDraws - the number of times to draw from the urn
	 * @return a {@link List} of all draw results
	 * @throws IllegalArgumentException if the number of draws is smaller 0 or the urn 
	 * would be empty before drawing is finished
	 */
	public List<E> draw(int numberOfDraws);
	
}
