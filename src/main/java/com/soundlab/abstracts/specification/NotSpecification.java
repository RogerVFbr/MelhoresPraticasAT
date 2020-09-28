package com.soundlab.abstracts.specification;

public class NotSpecification<T> extends AbstractSpecification<T> {

	private final Specification<T> spec;
	
	public NotSpecification(Specification<T> s) {
		this.spec=s;
	}
	
	@Override
	public boolean isSatisfiedBy(T t) {
		return !spec.isSatisfiedBy(t);
	}

}
