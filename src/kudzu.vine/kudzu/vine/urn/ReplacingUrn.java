package kudzu.vine.urn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


/**
 * The {@code ReplacingUrn} class represents an {@link Urn}, which retains elements 
 * upon drawing. Thereby drawing elements does not alter the {@link Urn}s content.
 * 
 * @author Planters
 *
 * @param <E> - the type of elements contained in the {@link Urn}
 */
public final class ReplacingUrn<E> implements Urn<E> {

	private final List<E> content = new ArrayList<E>();
	
	/**
	 * Creates an empty {@link Urn}.
	 */
	public ReplacingUrn() {
		// empty constructor
	}
	
	/**
	 * Creates a {@link Urn} with the specified content.
	 * 
	 * @param initialContent - the content to be contained in the {@link Urn}
	 */
	public ReplacingUrn(Collection<? extends E> initialContent) {
		Objects.requireNonNull(initialContent);
		this.content.addAll(initialContent);
	}
	
	@Override
	public boolean add(E arg0) {
		return this.content.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		return this.content.addAll(arg0);
	}

	@Override
	public void clear() {
		this.content.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		return this.content.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return this.content.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return this.content.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return this.content.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return this.content.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return this.content.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return this.content.retainAll(arg0);
	}

	@Override
	public int size() {
		return this.content.size();
	}

	@Override
	public Object[] toArray() {
		return this.content.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return this.content.toArray(arg0);
	}

	@Override
	public E draw() {
		if (this.isEmpty()) {
			throw new IllegalStateException(String.format("%s must not be empty.", this));
		}
		return this.content.get(ThreadLocalRandom.current().nextInt(this.content.size()));
	}

	@Override
	public List<E> draw(int numberOfDraws) {
		if (numberOfDraws < 0) {
			throw new IllegalArgumentException(String.format(
					"%d must be zero or positve.", numberOfDraws));
		}
		List<E> draws = new ArrayList<E>(numberOfDraws);
		for (int i = 0; i < numberOfDraws; i++) {
			draws.add(this.draw());
		}
		return draws;
	}

	@Override
	public int hashCode() {
		return this.content.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof ReplacingUrn) {
			List<?> compContent = new ArrayList<>(((ReplacingUrn<?>) obj).content);
			for (Object contentObject : this.content) {
				if (!compContent.remove(contentObject)) {
					return false;
				}
			}
			return compContent.isEmpty();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.content.toString();
	}

	@Override
	public List<E> getContent() {
		return new ArrayList<E>(this.content);
	}
	
}
