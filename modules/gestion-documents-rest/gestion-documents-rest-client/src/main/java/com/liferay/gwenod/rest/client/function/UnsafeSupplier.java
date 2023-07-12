package com.liferay.gwenod.rest.client.function;

import javax.annotation.Generated;

/**
 * @author elbou
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}