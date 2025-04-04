package com.qwipper.cqrs.query;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
