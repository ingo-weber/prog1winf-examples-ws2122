package de.tuberlin.sbe.prog1winf.concurrency;

import java.util.ArrayList;

public class CounterThreadForTestingSynchr extends Thread {

	public ArrayList<Integer> I = new ArrayList<>();
	CounterThreadForTestingSynchr obj = null;

	CounterThreadForTestingSynchr(CounterThreadForTestingSynchr obj) {
		if (obj == null) {
			this.obj = this;
		} else {
			this.obj = obj;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
//			System.out.println("I am " + Thread.currentThread().getName()
//					+ " and my number is " + i);
			int rnd = (int) (Math.random() * 10);
			if (rnd%2 == 0) {
				try {
					this.sleep(10);
				} catch (InterruptedException e) {
					this.interrupt();
				}
				obj.I.add(i, i/2);
			} else {
				synchronized (obj.I) {
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						this.interrupt();
					}
					obj.I.add(i,i/2);
				}
			}

//			try {
//				Thread.sleep((long) (Math.random() * 100));
//			} catch (InterruptedException e) {
//				this.interrupt();
//			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		int max = 5;
		ArrayList<CounterThreadForTestingSynchr> myThreads = new ArrayList<>();

		CounterThreadForTestingSynchr c0 = new CounterThreadForTestingSynchr(null);
		c0.setName("MyThread-0");
		myThreads.add(c0);
		for (int i=1; i<max; i++) {
			CounterThreadForTestingSynchr c = new CounterThreadForTestingSynchr(c0);
			myThreads.add(c);
			String strName = "MyThread-" + i;
			System.out.println(strName);
			c.setName(strName);
		}

		// do something

		for (CounterThreadForTestingSynchr c : myThreads) {
			c.start();
		}

		// do something in between

		for (CounterThreadForTestingSynchr c : myThreads) {
			c.join();
		}
//
//		CounterThreadForTestingSynchr c2 = new CounterThreadForTestingSynchr(c1);
//		CounterThreadForTestingSynchr c3 = new CounterThreadForTestingSynchr(c1);
//		CounterThreadForTestingSynchr c4 = new CounterThreadForTestingSynchr(c1);
//		CounterThreadForTestingSynchr c5 = new CounterThreadForTestingSynchr(c1);
//		c1.start();
//		c2.start();
//		c3.start();
//		c4.start();
//		c5.start();
//		c1.join();
//		c2.join();
//		c3.join();
//		c4.join();
//		c5.join();
		System.out.println("I is " + c0.I);
		System.out.println(c0.I.size());
	}



}
