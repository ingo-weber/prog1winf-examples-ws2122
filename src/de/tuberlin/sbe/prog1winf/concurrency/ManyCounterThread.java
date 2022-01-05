package de.tuberlin.sbe.prog1winf.concurrency;

public class ManyCounterThread extends Thread {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
//	@Override
	public void run() {
		try {
			Thread.sleep((long) (100));
		} catch (InterruptedException e) {
			this.interrupt();
		}

		for (int i = 1; i < 11; i++) {
			System.out.println("I am " + this.getName()
					+ " and my number is " + i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new CounterThread().run();
//		new CounterThread().run();
		for (int i=0; i<20; i++) {
			new ManyCounterThread().start();
		}
	}
}
