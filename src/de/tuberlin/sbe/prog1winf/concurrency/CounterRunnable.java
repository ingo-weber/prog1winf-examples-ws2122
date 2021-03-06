package de.tuberlin.sbe.prog1winf.concurrency;

public class CounterRunnable implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("I am " + Thread.currentThread().getName()
					+ " and my number is " + i);
			try {
				Thread.sleep((long) (Math.random() * 100));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CounterRunnable r = new CounterRunnable();
		Thread t0 = new Thread(r);
		t0.start();
//		new Thread(new CounterRunnable()).start();
		Thread t1 = new Thread(new CounterRunnable());
		t1.start();
	}

}
