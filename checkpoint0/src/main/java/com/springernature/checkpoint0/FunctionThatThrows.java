package com.springernature.checkpoint0;

@FunctionalInterface
interface FunctionThatThrows<T, K extends Throwable> {
    T apply() throws K;
}
