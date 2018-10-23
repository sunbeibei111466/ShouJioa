package com.pilot.common.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AndroidExecutors {

	private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
	/* package */ static final int  CORE_POOL_SIZE  = CPU_COUNT + 1;
	/* package */ static final int  MAX_POOL_SIZE   = CPU_COUNT * 2 + 1;
	/* package */ static final long KEEP_ALIVE_TIME = 1L;

	public static PausableExecutorService newSingleThreadExecutor() {
		return new FinalizableDelegatedExecutorService(
			new AndroidThreadPool(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()));
	}

	public static PausableExecutorService newSinglePriorityExecutor() {
		return new FinalizableDelegatedExecutorService(
			new AndroidThreadPool(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>()));
	}

	public static PausableExecutorService newFixedPriorityExecutor(int nThreads) {
		return new FinalizableDelegatedExecutorService(
			new AndroidThreadPool(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>()));
	}

	/**
	 * Creates a proper Cached Thread Pool. Tasks will reuse cached threads if available or create new threads until the core pool is full.
	 * tasks will then be queued. If an task cannot be queued, a new thread will be created unless this would exceed max pool size, then the
	 * task will be rejected. Threads will time out after 1 second.
	 *
	 * Core thread timeout is only available on android-9+.
	 *
	 * @return the newly created thread pool
	 */
	public static PausableExecutorService newProperThreadPool() {
		return new FinalizableDelegatedExecutorService(
			new AndroidThreadPool(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()));
	}

	/**
	 * Creates a proper Cached Thread Pool. Tasks will reuse cached threads if available or create new threads until the core pool is full.
	 * tasks will then be queued. If an task cannot be queued, a new thread will be created unless this would exceed max pool size, then the
	 * task will be rejected. Threads will time out after 1 second.
	 *
	 * Core thread timeout is only available on android-9+.
	 *
	 * @param threadFactory the factory to use when creating new threads
	 * @return the newly created thread pool
	 */
	public static PausableExecutorService newProperThreadPool(ThreadFactory threadFactory) {
		return new FinalizableDelegatedExecutorService(
			new AndroidThreadPool(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
								  threadFactory));
	}

	/**
	 * Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available.
	 * These pools will typically improve the performance of programs that execute many short-lived asynchronous tasks. Calls to {@code
	 * execute} will reuse previously constructed threads if available. If no existing thread is available, a new thread will be created and
	 * added to the pool. Threads that have not been used for sixty seconds are terminated and removed from the cache. Thus, a pool that
	 * remains idle for long enough will not consume any resources. Note that pools with similar properties but different details (for
	 * example, timeout parameters) may be created using {@link ThreadPoolExecutor} constructors.
	 *
	 * @return the newly created thread pool
	 */
	public static PausableExecutorService newCachedThreadPool() {
		return new FinalizableDelegatedExecutorService(
			new AndroidThreadPool(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>()));
	}

	public static PausableExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
		return new FinalizableDelegatedExecutorService(
			new AndroidThreadPool(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), threadFactory));
	}

	/**
	 * A wrapper class that exposes only the ExecutorService methods of an ExecutorService implementation.
	 */
	@SuppressWarnings("NullableProblems")
	static class DelegatedExecutorService extends AbstractExecutorService implements PausableExecutorService {

		private final PausableExecutorService e;

		DelegatedExecutorService(PausableExecutorService executor) {
			e = executor;
		}

		public void execute(Runnable command) {
			e.execute(command);
		}

		public void shutdown() {
			e.shutdown();
		}

		public List<Runnable> shutdownNow() {
			return e.shutdownNow();
		}

		public boolean isShutdown() {
			return e.isShutdown();
		}

		public boolean isTerminated() {
			return e.isTerminated();
		}

		public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
			return e.awaitTermination(timeout, unit);
		}

		public Future<?> submit(Runnable task) {
			return e.submit(task);
		}

		public <T> Future<T> submit(Callable<T> task) {
			return e.submit(task);
		}

		public <T> Future<T> submit(Runnable task, T result) {
			return e.submit(task, result);
		}

		public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
			return e.invokeAll(tasks);
		}

		public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
			return e.invokeAll(tasks, timeout, unit);
		}

		public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
			return e.invokeAny(tasks);
		}

		public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
			return e.invokeAny(tasks, timeout, unit);
		}

		@Override
		public void pause() {
			e.pause();
		}

		@Override
		public void resume() {
			e.resume();
		}

		@Override
		public boolean isPause() {
			return e.isPause();
		}
	}

	static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {

		FinalizableDelegatedExecutorService(PausableExecutorService executor) {
			super(executor);
		}

		@SuppressWarnings("FinalizeDoesntCallSuperFinalize")
		protected void finalize() {
			super.shutdown();
		}
	}
}
