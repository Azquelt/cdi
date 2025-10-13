/*
 * Copyright (c) 2025 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * Apache Software License 2.0 which is available at:
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
*/
package jakarta.enterprise.invoke;

import java.util.concurrent.CompletionStage;

public interface InvokerAsyncHandler<T, R> {

    /**
     * Calls an Invoker, which starts an asynchronous operation, and ensures that {@code cleanup} is called when the
     * asynchronous operation completes.
     * <p>
     * It's expected that implementations will register a callback with the asynchronous framework to call {@code cleanup} once
     * the operation completes.
     * <p>
     * The implementation must ensure that {@code cleanup} is called even if the invoked method throws an exception or the
     * asynchronous operation fails.
     * <p>
     * For example, an async handler for a {@link CompletionStage} might look like this:
     *
     * <pre>{@code
     * try {
     *     CompletionStage<?> result = invoker.invoke(instance, parameters);
     *     result.handle((r, t) -> {
     *         cleanup.run();
     *         return null;
     *     });
     *     return result;
     * } catch (Throwable t) {
     *     cleanup.run();
     *     throw t;
     * }
     * }</pre>
     *
     * @param invoker an invoker, to invoke the method
     * @param instance the instance being invoked, may be {@code null} if the instance is looked up from CDI
     * @param parameters the array of parameters to the invoker
     * @param cleanup a runnable to release any beans looked up as part of the invocation call
     * @return the return value from calling {@code invoker}
     */
    public R handleAsyncInvocation(Invoker<T, R> invoker, T instance, Object[] parameters, Runnable cleanup) throws Exception;
}
