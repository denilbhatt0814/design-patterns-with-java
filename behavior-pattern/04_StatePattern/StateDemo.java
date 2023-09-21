interface State{
	public void handleState();
}

class State1 implements State{
	public void handleState(){
		System.out.println("Handling state1 - you may go to state2");
	}
}

class State2 implements State{
	public void handleState(){
		System.out.println("Handling state2 - you may go to state3");
	}
}


class State3 implements State{
	public void handleState(){
		System.out.println("Handling state3 - you may go to state1");
	}
}

class Context {
	State st;

	public Context(State s){
		st = s;
	}
	
	public void setState(State s){
		st = s;
	}

	public State getState(){
		return st;
	}

	public void performAction(){
		st.handleState();
	}
}

class StateDemo {
	public static void main(String[] args){
		State s1 = new State1();
		State s2 = new State2();
		State s3 = new State3();
		
		Context c1 = new Context(s2);
		c1.performAction();

		c1.setState(s1);
		c1.performAction();

	}

}
