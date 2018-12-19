/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 heimuheimu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.heimuheimu.naiveredis.util;

import com.heimuheimu.naiveredis.exception.RedisException;
import org.junit.Assert;

/**
 * 提供单元测试工具方法。
 *
 * @author heimuheimu
 */
public class AssertUtil {

    public static void assertThrowIllegalArgumentException(Runnable runnable) {
        try {
            runnable.run();
            Assert.fail("Expected throw `IllegalArgumentException`.");
        } catch (IllegalArgumentException ignored) {
            ignored.printStackTrace();
        }
    }

    public static void assertThrowRedisException(Runnable runnable) {
        try {
            runnable.run();
            Assert.fail("Expected throw `RedisException`.");
        } catch (RedisException ignored) {}
    }

    public static void assertThrowException(Runnable runnable) {
        try {
            runnable.run();
            Assert.fail("Expected throw `Exception`.");
        } catch (Exception ignored) {}
    }
}
