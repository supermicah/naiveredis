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

package com.heimuheimu.naiveredis.clients.delegate;

import com.heimuheimu.naiveredis.NaiveRedisStorageClient;
import com.heimuheimu.naiveredis.exception.RedisException;
import com.heimuheimu.naiveredis.exception.TimeoutException;

import java.util.Map;
import java.util.Set;

/**
 * Redis 存储客户端代理接口。
 *
 * @author heimuheimu
 */
public interface NaiveRedisStorageClientDelegate extends NaiveRedisStorageClient {

    NaiveRedisStorageClient getNaiveRedisStorageClient();

    @Override
    default <T> T get(String key) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        return getNaiveRedisStorageClient().get(key);
    }

    default <T> Map<String, T> multiGet(Set<String> keySet) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        return getNaiveRedisStorageClient().multiGet(keySet);
    }

    @Override
    default void set(String key, Object value) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        getNaiveRedisStorageClient().set(key, value);
    }

    @Override
    default void set(String key, Object value, int expiry) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        getNaiveRedisStorageClient().set(key, value, expiry);
    }

    @Override
    default boolean setIfAbsent(String key, Object value) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        return getNaiveRedisStorageClient().setIfAbsent(key, value);
    }

    @Override
    default boolean setIfAbsent(String key, Object value, int expiry) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        return getNaiveRedisStorageClient().setIfAbsent(key, value, expiry);
    }

    @Override
    default boolean setIfExist(String key, Object value) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        return getNaiveRedisStorageClient().setIfExist(key, value);
    }

    @Override
    default boolean setIfExist(String key, Object value, int expiry) throws IllegalArgumentException, IllegalStateException, TimeoutException, RedisException {
        return getNaiveRedisStorageClient().setIfExist(key, value, expiry);
    }
}
