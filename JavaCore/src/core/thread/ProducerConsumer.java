package core.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://dzone.com/articles/the-evolution-of-producer-consumer-problem-in-java
 * synchronize(this) vs synchronize(MyClass.class) 
 * 
 * synchronize(this){
    // code
   }
  * synchronize(MyClass.class){
    //code
   }

* this - is the reference to particular his instance of class, and
* MyClass.class - is the reference to My Class description object

* first will synchronize all the threads that deal concretly with this instance of MyClass,
* second one will synchronize all threads independently of which object on which thismethod was called.
  
 * @author vipingupta
 *
 */
public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		PC pc =new PC(10);
		
		Thread t1 =new Thread(() -> {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		});
		
		
//		Thread t1 =new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					pc.produce();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		});
		
		Thread t2 =new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
	}
	
	/**
	 *  buffer is responsible for creating or removing the elements
	 *  buffer is responsible for storing and pooling elements in a thread-safe manner.
	 *
	 */
	public static class PC{
		private volatile Queue<Integer> list = new LinkedList<Integer>();
		int capacity = 1;
		PC(int cap){
			this.capacity = cap;
		}
		
		
		public void produce() throws InterruptedException {
			int value = 0;
			while(value<500) {
				synchronized (this) {
					while(list.size() == capacity) {
						System.out.println("producer waiting: "+ list.size());
						wait();
					}
					
					System.out.println("producing : "+ value);
					list.add( value++);
					notify();
					Thread.sleep(100);
				}
			}
		}

		public void consume() throws InterruptedException {
			while(true) {
				synchronized (this) {
					while(list.size() == 0) {
						System.out.println("consumer waiting: "+ list.size());
						wait();
					}
					
					int val = list.poll();
					System.out.println("consuming : "+ val);
					notify();
					Thread.sleep(100);
				}
			}
		}
		
	}
}
