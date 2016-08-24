
public class Animation implements Runnable {
	
	BlockBreakerPanel bp;
	
	
	Animation (BlockBreakerPanel b){
		bp = b;
	}
	
	public void run(){
		//Make it continuous
		while(true){
			bp.update();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
