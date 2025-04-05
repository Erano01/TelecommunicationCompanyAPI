package me.erano.com.domain.specification.shared;

// We use Policy pattern its known as strategy design pattern.
// Policies are intentionally kept separate from entities and value objects to avoid coupling.
// This decoupling provides the well-known benefit of evolving one part without direct impact or side-effects on the other.
public interface Specification<T> {

    boolean isSatisfiedBy(T t);

    Specification<T> and(Specification<T> specification);
}
