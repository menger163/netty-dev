package com.jd.ebs.netty.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExecutePool {

	private ExecutorService executorService;

	public TimeServerHandlerExecutePool() {

	}

	public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
		if (executorService == null) {
			executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L,
					TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
		}

	}

	public void execute(Runnable task) {
		executorService.execute(task);
	}
}
