/*
 * Copyright 2008, Red Hat, Inc., and individual contributors
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
package jakarta.enterprise.inject.literal;

import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;

/**
 * Supports inline instantiation of the {@link Qualifier} annotation.
 *
 * @author Martin Kouba
 * @since 2.0
 */
public final class QualifierLiteral extends AnnotationLiteral<Qualifier> implements Qualifier {

    public static final QualifierLiteral INSTANCE = new QualifierLiteral();

    private static final long serialVersionUID = 1L;

}
