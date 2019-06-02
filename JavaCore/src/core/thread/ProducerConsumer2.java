package core.thread;

import java.util.LinkedList;
import java.util.Queue;


public class ProducerConsumer2 {

	public static void main(String[] args) throws InterruptedException {

		/* the buffer is responsible for storing and removing the elements in a thread-safe manner*/
		Buffer pc = new Buffer(5);

		Thread consumerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				Integer value = 0;
				while (value<500) {
					try {
						pc.producer(value);
						System.out.println("produce : "+value);
						Thread.sleep(1000);
						value++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		Thread producerThread = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					try {
						int value = pc.consumer();
						System.out.println("consume : "+value);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		producerThread.start();
		consumerThread.start();

		producerThread.join();
		consumerThread.join();
	}

	/**
	 *  the buffer shouldn’t be responsible for creating or removing the elements.
	 *  the buffer should be responsible just for storing and pooling elements in a thread-safe manner, not for producing the elements.
	 * @author vipingupta
	 *
	 */
	static class Buffer {
		private Queue<Integer> queue = new LinkedList<Integer>();
		private int capacity;

		Buffer(int size) {
			this.capacity = size;
		}

		public void producer(Integer value) throws InterruptedException {
			synchronized (this) {
				while (queue.size() == capacity) {
					wait();
				}
				queue.add(value);
				notify();
			}
		}

		public int consumer() throws InterruptedException {
			synchronized (this) {
				while (queue.size() == 0) {
					wait();
				}
				Integer var = queue.poll();
				notify();
				return var;
			}
		}

	}

}
