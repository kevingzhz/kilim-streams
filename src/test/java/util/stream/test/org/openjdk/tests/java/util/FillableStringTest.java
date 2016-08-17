/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.openjdk.tests.java.util;

import java.util.Arrays;
import stream2.Collectors;
import stream2.Stream;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static stream2.Arrays2.proxy;

@Test(groups = "lib")
public class FillableStringTest {
    public Stream<String> generate() {
        return proxy(Arrays.asList("one", "two", "three", "four", "five", "six")).stream()
                .filter(s->s.length() > 3)
                .map(String::toUpperCase);
    }

    public void testStringBuilder() {
        String s = generate().collect(Collectors.joining());
        assertEquals(s, "THREEFOURFIVE");
    }

    public void testStringBuffer() {
        String s = generate().collect(Collectors.joining());
        assertEquals(s, "THREEFOURFIVE");
    }

    public void testStringJoiner() {
        String s = generate().collect(Collectors.joining("-"));
        assertEquals(s, "THREE-FOUR-FIVE");
    }
}