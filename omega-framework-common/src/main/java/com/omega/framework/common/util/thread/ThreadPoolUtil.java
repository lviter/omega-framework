package com.omega.framework.common.util.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author lviter
 * @Description 线程池工具类
 * @Date 17:27 2021/6/24
 * @Desc: Warning!Warning!!Warning!!!
 **/
public class ThreadPoolUtil {

    /**
     * 有界阻塞队列
     */
    private static final LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(1000);

    /**
     * 创建指定线程数量的线程池
     *
     * @param threadCount
     * @return
     */
    public static ThreadPoolExecutor createThreadPoolByCount(int threadCount) {
        return new ThreadPoolExecutor(threadCount, threadCount,
                60L, TimeUnit.SECONDS, blockingQueue, new ThreadPoolExecutor.CallerRunsPolicy());
    }

    /**
     * @param corePoolSize      核心线程数
     * @param maximumPoolSize   最大线程数
     * @param blockingQueueSize 工作队列：阻塞队列
     * @param threadPoolName    线程池名称
     * @return
     */
    public static ThreadPoolExecutor createThreadPoolByName(int corePoolSize, int maximumPoolSize, int blockingQueueSize, String threadPoolName) {
        //默认空闲线程最大存活时间60秒
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(blockingQueueSize), new NamedThreadFactory(threadPoolName), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
