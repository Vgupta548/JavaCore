/**
 * 
 */
package core.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author vipingupta 
 * 			previously buffer that, when storing an element, waits for
 *         a slot to become available in case there is no more space, and on
 *         pooling, in case that the buffer is empty, it waits for an element to
 *         become available, making the storing and removing operations
 *         thread-safe.
 * 
 *         Java already has a collection for this. It’s called a BlockingQueue
 *         this is a queue that is thread-safe to put into and take instances
 *         from.
 */
public class ProducerConsumer3 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<Integer>(5);

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

		producerThread.start();
		consumerThread.start();

		producerThread.join();
		consumerThread.join();

	}

}
