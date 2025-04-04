package com.qwipper.cqrs.query;

public interface Query<T> {
    default String queryName() {
        return this.getClass().getSimpleName();
    }
}
