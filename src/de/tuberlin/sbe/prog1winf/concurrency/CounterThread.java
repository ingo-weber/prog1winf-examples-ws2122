package de.tuberlin.sbe.prog1winf.concurrency;

public class CounterThread extends Thread {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
//	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			System.out.println("I am " + this.getName()
					+ " and my number is " + i);
			try {
				Thread.sleep((long) (100 + Math.random() * 1000));
			} catch (InterruptedException e) {
				this.interrupt();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new CounterThread().run();
//		new CounterThread().run();
		new CounterThread().start();
		new CounterThread().start();
	}



}
