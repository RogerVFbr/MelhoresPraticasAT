package com.soundlab.abstracts.specification;

public interface Specification<T> {
	boolean isSatisfiedBy(T t);
}
