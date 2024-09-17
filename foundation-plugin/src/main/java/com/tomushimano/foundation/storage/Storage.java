package com.tomushimano.foundation.storage;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface Storage<T> {

    CompletableFuture<?> init();

    CompletableFuture<?> shutdown();

    CompletableFuture<Optional<T>> findOne(UniqueSelector<T> selector);

    CompletableFuture<Set<T>> findMany(ListSelector<T> selector);

    CompletableFuture<?> saveOne(T item);

    CompletableFuture<?> saveMany(Set<T> items);

    CompletableFuture<?> deleteOne(UniqueSelector<T> selector);

    interface UniqueSelector<T> {}

    interface ListSelector<T> {}
}
