
public class Animation implements Runnable {
	
	BlockBreakerPanel bp;
	
	
	Animation (BlockBreakerPanel b){
		bp = b;
	}
	
	public void run(){
		//Make it continuous
		while(true){
			bp.update(g);
			Thread.sleep(10);
		}
		
	}

}
