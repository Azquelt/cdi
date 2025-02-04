/*
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jakarta.enterprise.inject;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.enterprise.event.Event;
import jakarta.enterprise.util.AnnotationLiteral;

/**
 * <p>
 * If a parameter annotated with <code>&#064;TransientReference</code> resolves to a dependent scoped bean, then the bean will be
 * destroyed after the invocation completes.
 * </p>
 * 
 * <pre>
 * public class OrderManager {
 * 
 *     &#064;Inject 
 *     public OrderManager(@TransientReference Order order) {
 *        ...
 *    
 *     }
 * }
 * </pre>
 * 
 * @author Pete Muir
 * @since 1.1
 */

@Target(PARAMETER)
@Retention(RUNTIME)
@Documented
public @interface TransientReference {
    
    /**
     * Supports inline instantiation of the {@link TransientReference} annotation.
     *
     * @author Martin Kouba
     * @since 2.0
     * @see Instance
     * @see Event
     */
    public static final class Literal extends AnnotationLiteral<TransientReference> implements TransientReference {

        private static final long serialVersionUID = 1L;

        public static final Literal INSTANCE = new Literal();

    }

}
