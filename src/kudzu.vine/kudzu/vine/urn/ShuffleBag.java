package kudzu.vine.urn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public final class ShuffleBag<E> {
	
	private final List<E> allElements;
	private final NonReplacingUrn<E> urn;
	
	public ShuffleBag(List<? extends E> content) {
		if (content.isEmpty()) {
			throw new IllegalArgumentException("The content list must not be empty.");
		}
		this.allElements = new ArrayList<E>(content);
		this.urn = new NonReplacingUrn<E>(this.allElements);
	}

	public boolean contains(Object element) {
		return this.allElements.contains(element);
	}

	public boolean containsAll(Collection<?> elements) {
		Objects.requireNonNull(elements);
		return this.allElements.containsAll(elements);
	}
	
	public List<E> getContent() {
		return new ArrayList<E>(this.allElements);
	}

	public int size() {
		return this.allElements.size();
	}
	
	public void reset() {
		this.urn.clear();
		this.urn.addAll(this.allElements);
	}

	public E draw() {
		if (this.urn.isEmpty()) {
			this.urn.addAll(this.allElements);
		}
		return this.urn.draw();
	}
	
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
		return this.allElements.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj instanceof ShuffleBag) {
			List<?> compContent = new ArrayList<>(((ShuffleBag<?>) obj).allElements);
			for (Object contentObject : this.allElements) {
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
		return this.allElements.toString();
	}

}
