package automata;

public class Transition {

	private String fromState;
	private String toState;
	private Character input;
	
	
	
	public Transition(String fromState, char input, String toState) {
		this.fromState = fromState;
		this.toState = toState;
		this.input = input;
	}

	public String getFromState() {
		return fromState;
	}
	
	public String getToState() {
		return toState;
	}
	
	public Character getInput() {
		return input;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fromState == null) ? 0 : fromState.hashCode());
		result = prime * result + input;
		result = prime * result + ((toState == null) ? 0 : toState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transition other = (Transition) obj;
		if (fromState == null) {
			if (other.fromState != null)
				return false;
		} else if (!fromState.equals(other.fromState))
			return false;
		if (input != other.input)
			return false;
		if (toState == null) {
			if (other.toState != null)
				return false;
		} else if (!toState.equals(other.toState))
			return false;
		return true;
	}

	public String toString() {
		return fromState + " x " + input + " -> " + toState;
	} 
}
