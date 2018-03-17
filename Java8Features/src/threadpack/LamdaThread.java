package threadpack;
/**
 * 
 * @author Sanjay Rawat
 *Example to show lambda with Thread
 *
 */
public class LamdaThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable run1 = () -> {
			for(int i=0;i<5;i++){
				System.out.println("Thread "+Thread.currentThread().getName()+"  Counter "+i);
				try {
					if(Thread.currentThread().getName().equals("Name 1"))
					Thread.sleep(2000);
					else 
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(run1,"Name 1");
		Thread t2 = new Thread(run1,"Name 2");
		Thread t3 = new Thread(run1,"Name 3");
		
		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}
}
