package core.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * We’ve instantiated two threads, one that puts some elements in the blocking
 * queue, the producer, and another that retrieves elements from the queue, the
 * consumer.
 * 
 * But, good software techniques suggest that creating and destroying threads
 * manually is bad practice. Thread creation is an expensive task. Each thread
 * creation implies the following steps:
 * 
 * It allocates memory for a thread stack The OS creates a native thread
 * corresponding to the Java thread Descriptors relating to the thread are added
 * to the JVM internal data structures
 * 
 * 
 * we need a way to strategically manage threads. And here comes the thread
 * pools.
 * 
 * Thread pools handle the threads' life cycle based on a selected strategy. It
 * holds a limited number of idle threads and reuses them when it needs to solve
 * tasks. This way, we don’t have to create a new thread every time for a new
 * request, and therefore, we can avoid reaching a thread starvation,
 * 
 * The Java thread pool implementation consists of:
 * 
 * A task queue A collection of worker threads A thread factory Metadata for
 * managing thread pool state.
 * 
 * @author vipingupta
 *
 */
public class ProducerConsumer4 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<Integer>(5);

		/**
		 * The difference here is that, instead of manually creating and running the
		 * consumer and producer threads, we build a thread pool, and it will receive
		 * two tasks, a producer and a consumer task.
		 */
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Thread producerThread = new Thread(() -> {
			int value = 0;
			try {
				while (true) {
					blockingQueue.put(value);
					System.out.println("Produced " + value);
					value++;
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		});

		Thread consumerThread = new Thread(() -> {
			try {
				while (true) {
					// System.out.println("Consume ");
					int value = blockingQueue.take();
					System.out.println("Consumed " + value);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		});

		executor.execute(producerThread);
		executor.execute(consumerThread);

		executor.shutdown();

	}

}