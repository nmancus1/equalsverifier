/*
 * Copyright 2017 Jan Ouwens
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.jqno.equalsverifier.coverage;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import javax.annotation.Nonnull;

public class CoverageNonnullTest {
    @Test
    public void lombokCoverage() {
        EqualsVerifier.forClass(LombokNonnullStringContainer.class)
                .verify();

        // Also cover the constructor
        new LombokNonnullStringContainer("");
    }

    /**
     * equals and hashCode generated by Project Lombok 1.16.10, using delombok.
     */
    /*
     * Original class:
     *
     * @EqualsAndHashCode
     * public static final class LombokNonnullStringContainer {
     *     @Nonnull
     *     private final String s;
     *
     *     public LombokNonnullStringContainer(String s) {
     *         this.s = s;
     *     }
     * }
     */
    public static final class LombokNonnullStringContainer {
        @Nonnull
        private final String s;

        public LombokNonnullStringContainer(String s) {
            this.s = s;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public boolean equals(final java.lang.Object o) {
            if (o == this) return true;
            if (!(o instanceof CoverageNonnullTest.LombokNonnullStringContainer)) return false;
            final LombokNonnullStringContainer other = (LombokNonnullStringContainer) o;
            final java.lang.Object this$s = this.s;
            final java.lang.Object other$s = other.s;
            if (this$s == null ? other$s != null : !this$s.equals(other$s)) return false;
            return true;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        @javax.annotation.Generated("lombok")
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final java.lang.Object $s = this.s;
            result = result * PRIME + ($s == null ? 43 : $s.hashCode());
            return result;
        }
    }
}
