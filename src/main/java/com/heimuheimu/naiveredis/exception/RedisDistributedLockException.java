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


package com.heimuheimu.naiveredis.exception;

/**
 * 获取或释放 Redis 分布式锁出错时，将抛出此异常。
 *
 * @author heimuheimu
 */
public class RedisDistributedLockException extends RuntimeException {

    /**
     * 构造一个 RedisDistributedLockException 实例子。
     *
     * @param message 错误信息
     */
    public RedisDistributedLockException(String message) {
        super(message);
    }

    /**
     * 构造一个 RedisDistributedLockException 实例子。
     *
     * @param message 错误信息
     * @param cause 上层异常
     */
    public RedisDistributedLockException(String message, Throwable cause) {
        super(message, cause);
    }
}