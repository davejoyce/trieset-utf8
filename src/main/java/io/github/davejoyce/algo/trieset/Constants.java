/*
 * Copyright (c) 2018 David Joyce.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */

package io.github.davejoyce.algo.trieset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Central collection of constant values used in the UTF-8 TrieSET library.
 *
 * @author <a href="mailto:dave@osframework.org">Dave Joyce</a>
 */
public class Constants {

    /**
     * Characters to be excluded from Latin-1 character arrays. This exclusion
     * array contains arithmetic operators.
     */
    private static final int[] EXCLUDES_LATIN_1 = { 0x0D7, 0x0F7 };

    /**
     * Characters to be excluded from Latin-A character arrays. This exclusion
     * array contains:
     * <ul>
     *     <li>Unicode 0138: Old Greenlandic 'kra' letter</li>
     *     <li>Unicode 0149: Deprecated small letter apostrophe n</li>
     *     <li>Unicode 017F: Old small letter long s</li>
     * </ul>
     */
    private static final int[] EXCLUDES_LATIN_A = { 0x138, 0x149, 0x17F };

    /**
     * Starting Unicode point of Latin Basic (ASCII) uppercase letters.
     */
    private static final int START_LATIN_BASIC_UPPER = 0x041;

    /**
     * Ending Unicode point of Latin Basic (ASCII) uppercase letters.
     */
    private static final int END_LATIN_BASIC_UPPER   = 0x05A;

    /**
     * Starting Unicode point of Latin-1 Supplement uppercase letters.
     */
    private static final int START_LATIN_1_UPPER     = 0x0C0;

    /**
     * Ending Unicode point of Latin-1 Supplement uppercase letters.
     */
    private static final int END_LATIN_1_UPPER       = 0x0DE;

    /**
     * Starting Unicode point of Latin-A Extension letters.
     */
    private static final int START_LATIN_A           = 0x100;

    /**
     * Ending Unicode point of Latin-A Extension letters.
     */
    private static final int END_LATIN_A             = 0x17F;

    /**
     * Starting Unicode point of Latin Basic (ASCII) lowercase letters.
     */
    private static final int START_LATIN_BASIC_LOWER = START_LATIN_BASIC_UPPER + 0x020;

    /**
     * Ending Unicode point of Latin Basic (ASCII) lowercase letters.
     */
    private static final int END_LATIN_BASIC_LOWER   = END_LATIN_BASIC_UPPER + 0x020;

    /**
     * Starting Unicode point of Latin-1 Supplement lowercase letters.
     */
    private static final int START_LATIN_1_LOWER     = 0x0DF;

    /**
     * Ending Unicode point of Latin-1 Supplement lowercase letters.
     */
    private static final int END_LATIN_1_LOWER       = START_LATIN_1_LOWER + 0x020;

    static final char[] CHARS_LATIN_BASIC_UPPER;
    static final char[] CHARS_LATIN_BASIC_LOWER;

    static final char[] CHARS_LATIN_1_UPPER;
    static final char[] CHARS_LATIN_1_LOWER;

    static final char[] CHARS_LATIN_A_UPPER;
    static final char[] CHARS_LATIN_A_LOWER;

    /**
     * Array of all uppercase Unicode letters from:
     * <ol>
     *     <li>Basic Latin (ASCII)</li>
     *     <li>Latin-1 Supplement</li>
     *     <li>Latin Extended-A</li>
     * </ol>
     */
    public static final char[] CHARS_LATIN_ALL_UPPER;

    /**
     * Array of all lowercase Unicode letters from:
     * <ol>
     *     <li>Basic Latin (ASCII)</li>
     *     <li>Latin-1 Supplement</li>
     *     <li>Latin Extended-A</li>
     * </ol>
     */
    public static final char[] CHARS_LATIN_ALL_LOWER;

    static {
        // 1. Load Latin Basic characters
        final List<Character> list = new ArrayList<>();
        IntStream.rangeClosed(START_LATIN_BASIC_UPPER, END_LATIN_BASIC_UPPER)
                 .mapToObj(codePoint -> (char) codePoint)
                 .forEach(list::add);
        CHARS_LATIN_BASIC_UPPER = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            CHARS_LATIN_BASIC_UPPER[i] = list.get(i);
        }

        list.clear();
        IntStream.rangeClosed(START_LATIN_BASIC_LOWER, END_LATIN_BASIC_LOWER)
                 .mapToObj(codePoint -> (char) codePoint)
                 .forEach(list::add);
        CHARS_LATIN_BASIC_LOWER = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            CHARS_LATIN_BASIC_LOWER[i] = list.get(i);
        }

        // 2. Load Latin-1 characters
        list.clear();
        IntStream.rangeClosed(START_LATIN_1_UPPER, END_LATIN_1_UPPER)
                 .filter(codePoint -> (0 > Arrays.binarySearch(EXCLUDES_LATIN_1, codePoint))) // filter out excluded chars
                 .mapToObj(codePoint -> (char) codePoint)
                 .forEach(list::add);
        CHARS_LATIN_1_UPPER = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            CHARS_LATIN_1_UPPER[i] = list.get(i);
        }

        list.clear();
        IntStream.rangeClosed(START_LATIN_1_LOWER, END_LATIN_1_LOWER)
                 .filter(codePoint -> (0 > Arrays.binarySearch(EXCLUDES_LATIN_1, codePoint))) // filter out excluded chars
                 .mapToObj(codePoint -> (char) codePoint)
                 .forEach(list::add);
        CHARS_LATIN_1_LOWER = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            CHARS_LATIN_1_LOWER[i] = list.get(i);
        }

        // 3. Load Latin-A characters
        list.clear();
        IntStream.rangeClosed(START_LATIN_A, END_LATIN_A)
                 .filter(codePoint -> (0 > Arrays.binarySearch(EXCLUDES_LATIN_A, codePoint)))
                 .filter(codePoint -> Character.isUpperCase((char) codePoint))
                 .mapToObj(codePoint -> (char) codePoint)
                 .forEach(list::add);
        CHARS_LATIN_A_UPPER = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            CHARS_LATIN_A_UPPER[i] = list.get(i);
        }

        list.clear();
        IntStream.rangeClosed(START_LATIN_A, END_LATIN_A)
                 .filter(codePoint -> (0 > Arrays.binarySearch(EXCLUDES_LATIN_A, codePoint)))
                 .filter(codePoint -> Character.isLowerCase((char) codePoint))
                 .mapToObj(codePoint -> (char) codePoint)
                 .forEach(list::add);
        CHARS_LATIN_A_LOWER = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            CHARS_LATIN_A_LOWER[i] = list.get(i);
        }

        // 4. Load combined Latin character arrays
        CHARS_LATIN_ALL_UPPER = new char[CHARS_LATIN_BASIC_UPPER.length + CHARS_LATIN_1_UPPER.length + CHARS_LATIN_A_UPPER.length];
        int i = 0;
        for (char latinBasicUpperChar : CHARS_LATIN_BASIC_UPPER) {
            CHARS_LATIN_ALL_UPPER[i++] = latinBasicUpperChar;
        }
        for (char latin1UpperChar : CHARS_LATIN_1_UPPER) {
            CHARS_LATIN_ALL_UPPER[i++] = latin1UpperChar;
        }
        for (char latinAUpperChar : CHARS_LATIN_A_UPPER) {
            CHARS_LATIN_ALL_UPPER[i++] = latinAUpperChar;
        }

        CHARS_LATIN_ALL_LOWER = new char[CHARS_LATIN_BASIC_LOWER.length + CHARS_LATIN_1_LOWER.length + CHARS_LATIN_A_LOWER.length];
        i = 0;
        for (char latinBasicLowerChar : CHARS_LATIN_BASIC_LOWER) {
            CHARS_LATIN_ALL_LOWER[i++] = latinBasicLowerChar;
        }
        for (char latin1LowerChar : CHARS_LATIN_1_LOWER) {
            CHARS_LATIN_ALL_LOWER[i++] = latin1LowerChar;
        }
        for (char latinALowerChar : CHARS_LATIN_A_LOWER) {
            CHARS_LATIN_ALL_LOWER[i++] = latinALowerChar;
        }
    }

}
