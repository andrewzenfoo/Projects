
public interface StateMachineInterface {

	//public int get();
	public StateMachine.Status stepNext();
	public void printStatus();	
	public void addCount();
	
}
