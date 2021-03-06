/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 heimuheimu
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

package com.heimuheimu.naiveredis.monitor.falcon;

import com.heimuheimu.naivemonitor.falcon.support.AbstractExecutionDataCollector;
import com.heimuheimu.naivemonitor.monitor.ExecutionMonitor;
import com.heimuheimu.naiveredis.constant.FalconDataCollectorConstant;
import com.heimuheimu.naiveredis.monitor.RedisLockClientMonitorFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Redis 分布式锁客户端使用的执行信息 Falcon 监控数据采集器。该采集器采集周期为 30 秒，每次采集将会返回以下数据项：
 *
 * <ul>
 *     <li>naiveredis_lock_client_illegal_argument/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端获取锁时发生的参数不正确错误次数</li>
 *     <li>naiveredis_lock_client_illegal_state/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端获取锁时发生的管道或命令已关闭错误次数</li>
 *     <li>naiveredis_lock_client_timeout/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端获取锁时发生的超时错误次数</li>
 *     <li>naiveredis_lock_client_redis_error/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端获取锁时发生的 Redis 命令执行错误次数</li>
 *     <li>naiveredis_lock_client_lock_exist/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端获取锁时发生的锁已被占用错误次数</li>
 *     <li>naiveredis_lock_client_unexpected_error/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端获取锁时发生的预期外错误次数</li>
 *     <li>naiveredis_lock_client_tps/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端每秒平均获取锁的次数</li>
 *     <li>naiveredis_lock_client_peak_tps/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端每秒最大获取锁的次数</li>
 *     <li>naiveredis_lock_client_avg_exec_time/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端单次获取锁的平均执行时间</li>
 *     <li>naiveredis_lock_client_max_exec_time/module=naiveredis &nbsp;&nbsp;&nbsp;&nbsp; 30 秒内 Redis 分布式锁客户端单次获取锁的最大执行时间</li>
 * </ul>
 *
 * @author heimuheimu
 */
public class RedisLockClientDataCollector extends AbstractExecutionDataCollector {

    private static final Map<Integer, String> ERROR_METRIC_SUFFIX_MAP;

    static {
        ERROR_METRIC_SUFFIX_MAP = new HashMap<>();
        ERROR_METRIC_SUFFIX_MAP.put(RedisLockClientMonitorFactory.ERROR_CODE_ILLEGAL_ARGUMENT, "_illegal_argument");
        ERROR_METRIC_SUFFIX_MAP.put(RedisLockClientMonitorFactory.ERROR_CODE_ILLEGAL_STATE, "_illegal_state");
        ERROR_METRIC_SUFFIX_MAP.put(RedisLockClientMonitorFactory.ERROR_CODE_TIMEOUT, "_timeout");
        ERROR_METRIC_SUFFIX_MAP.put(RedisLockClientMonitorFactory.ERROR_CODE_REDIS_ERROR, "_redis_error");
        ERROR_METRIC_SUFFIX_MAP.put(RedisLockClientMonitorFactory.ERROR_CODE_LOCK_IS_EXIST, "_lock_exist");
        ERROR_METRIC_SUFFIX_MAP.put(RedisLockClientMonitorFactory.ERROR_CODE_UNEXPECTED_ERROR, "_unexpected_error");
    }

    @Override
    protected List<ExecutionMonitor> getExecutionMonitorList() {
        return RedisLockClientMonitorFactory.getAll();
    }

    @Override
    protected String getModuleName() {
        return FalconDataCollectorConstant.MODULE_NAME;
    }

    @Override
    protected String getCollectorName() {
        return "lock_client";
    }

    @Override
    public int getPeriod() {
        return FalconDataCollectorConstant.REPORT_PERIOD;
    }

    @Override
    protected Map<Integer, String> getErrorMetricSuffixMap() {
        return ERROR_METRIC_SUFFIX_MAP;
    }
}
