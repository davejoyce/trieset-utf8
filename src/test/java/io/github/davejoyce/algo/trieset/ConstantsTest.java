/*
 * Copyright (c) 2018 David Joyce.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */

package io.github.davejoyce.algo.trieset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.*;

/**
 * Unit tests of Unicode character array constants.
 *
 * @author <a href="mailto:dave@osframework.org">Dave Joyce</a>
 */
public class ConstantsTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Validate the content and byte size of Basic Latin (ASCII) character
     * array constants.
     */
    @Test(priority = 0)
    public void testLatinBasicChars() {
        for (char c : Constants.CHARS_LATIN_BASIC_UPPER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Uppercase Latin Basic letters: {}", Constants.CHARS_LATIN_BASIC_UPPER.length);

        String letters = String.valueOf(Constants.CHARS_LATIN_BASIC_UPPER);
        int bytes = letters.getBytes(StandardCharsets.UTF_8).length;

        // Assert that basic Latin letters are 1 byte in UTF-8
        assertEquals(bytes, letters.length());
        logger.debug("Uppercase Latin Basic letters: {} bytes", bytes);

        for (char c : Constants.CHARS_LATIN_BASIC_LOWER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Lowercase Latin Basic letters: {}", Constants.CHARS_LATIN_BASIC_LOWER.length);

        letters = String.valueOf(Constants.CHARS_LATIN_BASIC_LOWER);
        bytes = letters.getBytes(StandardCharsets.UTF_8).length;

        // Assert that basic Latin letters are 1 byte in UTF-8
        assertEquals(bytes, letters.length());
        logger.debug("Lowercase Latin Basic letters: {} bytes", bytes);
    }

    /**
     * Validate the content and byte size of Latin-1 Supplement character
     * array constants.
     */
    @Test(priority = 1)
    public void testLatin1SupplementChars() {
        for (char c : Constants.CHARS_LATIN_1_UPPER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Uppercase Latin-1 Supplement letters: {}", Constants.CHARS_LATIN_1_UPPER.length);

        String letters = String.valueOf(Constants.CHARS_LATIN_1_UPPER);
        int bytes = letters.getBytes(StandardCharsets.UTF_8).length;

        // Assert that Latin-1 letters are 2 bytes in UTF-8
        assertEquals(bytes, (2 * letters.length()));
        logger.debug("Uppercase Latin-1 Supplement letters: {} bytes", bytes);

        for (char c : Constants.CHARS_LATIN_1_LOWER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Lowercase Latin-1 Supplement letters: {}", Constants.CHARS_LATIN_1_LOWER.length);

        letters = String.valueOf(Constants.CHARS_LATIN_1_LOWER);
        bytes = letters.getBytes(StandardCharsets.UTF_8).length;

        // Assert that Latin-1 letters are 2 bytes in UTF-8
        assertEquals(bytes, (2 * letters.length()));
        logger.debug("Lowercase Latin-1 Supplement letters: {} bytes", bytes);
    }

    /**
     * Validate the content and byte size of Latin Extension-A character
     * array constants.
     */
    @Test(priority = 2)
    public void testLatinAExtensionChars() {
        for (char c : Constants.CHARS_LATIN_A_UPPER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Uppercase Latin-A Extension letters: {}", Constants.CHARS_LATIN_A_UPPER.length);

        String letters = String.valueOf(Constants.CHARS_LATIN_A_UPPER);
        int bytes = letters.getBytes(StandardCharsets.UTF_8).length;

        // Assert that Latin-A letters are 2 bytes in UTF-8
        assertEquals(bytes, (2 * letters.length()));
        logger.debug("Uppercase Latin-A Extension letters: {} bytes", bytes);

        for (char c : Constants.CHARS_LATIN_A_LOWER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Lowercase Latin-A Extension letters: {}", Constants.CHARS_LATIN_A_LOWER.length);

        letters = String.valueOf(Constants.CHARS_LATIN_A_LOWER);
        bytes = letters.getBytes(StandardCharsets.UTF_8).length;

        // Assert that Latin-A letters are 2 bytes in UTF-8
        assertEquals(bytes, (2 * letters.length()));
        logger.debug("Lowercase Latin-A Extension letters: {} bytes", bytes);
    }

    /**
     * Validate the content of combined Latin character array constants.
     */
    @Test(priority = 4)
    public void testLatinCombinedChars() {
        for (char c : Constants.CHARS_LATIN_ALL_UPPER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Uppercase Latin letters (combined): {}", Constants.CHARS_LATIN_ALL_UPPER.length);

        Set<Character> lowers = IntStream.range(0, Constants.CHARS_LATIN_ALL_UPPER.length)
                                         .mapToObj(i -> Constants.CHARS_LATIN_ALL_UPPER[i])
                                         .filter(Character::isLowerCase)
                                         .collect(Collectors.toSet());
        assertTrue(lowers.isEmpty(), "Found unexpected lowercase character: " + lowers);

        for (char c : Constants.CHARS_LATIN_ALL_LOWER) {
            logger.debug("letter: '{}'", c);
        }
        logger.debug("Lowercase Latin letters (combined): {}", Constants.CHARS_LATIN_ALL_LOWER.length);

        Set<Character> uppers = IntStream.range(0, Constants.CHARS_LATIN_ALL_LOWER.length)
                                         .mapToObj(i -> Constants.CHARS_LATIN_ALL_LOWER[i])
                                         .filter(Character::isUpperCase)
                                         .collect(Collectors.toSet());
        assertTrue(uppers.isEmpty(), "Found unexpected uppercase character: " + uppers);
    }

}
