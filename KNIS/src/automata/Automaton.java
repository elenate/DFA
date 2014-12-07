package automata;

import java.util.LinkedHashSet;
import java.util.Set;

public class Automaton {

	private String name;
	private String startState;
	private Set<Character> alphabet = new LinkedHashSet<Character>();
	private Set<Transition> transitions = new LinkedHashSet<Transition>();
	private Set<String> acceptStates = new LinkedHashSet<String>();
	private Character epsilon = 'e';
	//TODO set epsilon
	
	
	public void addAcceptState(String state) {
		//TODO check if valid state
		this.acceptStates.add(state);		
	}
	
	public void addTransition(Transition transition) {
		//TODO check states and alphabet
		this.transitions.add(transition);
	}
	
	public void addLetterToAlphabet(char c) {
		this.alphabet.add(c);
	}
	
	public String getStartState() {
		//TODO check if valid state
		return startState;
	}
	
	public void setStartState(String startState) {
		this.startState = startState;
	}
	
	public Set<Transition> getTransitions() {
		return this.transitions;
	}

	
	public Set<Character> getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(Set<Character> alphabet) {
		this.alphabet = alphabet;
	}

	@Override
	public String toString() {
		return "Automata" + " : " + name +
				"\n startState = " + startState +
				",\n alphabet = " + alphabet +
				",\n transitions = "+ transitions +
				",\n acceptStates = " + acceptStates;
	}

	public Set<String> moveWithEpsilon(String state) {
		Set<String> states = new LinkedHashSet<String>();
/*		states = transitions.stream()
				.filter(t -> t.getInput().equals(this.epsilon) && t.getFromState().equals(state))
				.map(Transition::getToState).collect(Collectors.toList());*/
		
		for (Transition transition : this.transitions) {
			if (transition.getFromState().equals(state)
					&& transition.getInput().equals(this.epsilon)) {
				states.add(transition.getToState());
			}
		}
		
		return states;
	}
	
	public Set<String> move(String state, Character character) {
		Set<String> states = new LinkedHashSet<String>();
/*		states = transitions.stream()
				.filter(t -> t.getInput().equals(this.epsilon) && t.getFromState().equals(state))
				.map(Transition::getToState).collect(Collectors.toList());*/
		
		for (Transition transition : this.transitions) {
			if (transition.getFromState().equals(state)
					&& transition.getInput().equals(character)) {
				states.add(transition.getToState());
			}
		}
		
		return states;
	}
	
	public Set<String> moves(Set<String> states, Character character) {
		Set<String> result = new LinkedHashSet<String>();
		for (String state : states) {
			result.addAll(move(state, character));
		}
		
		return result;
	}
 
	public void addTransition(String fromState, char input, String toState) {
		//TODO check states and alphabet
		Transition transition = new Transition(fromState, input, toState);
		this.transitions.add(transition);
	}

	public boolean containsAcceptState(Set<String> states) {
		for (String state : states) {
			if (this.acceptStates.contains(state)) {
				return true;
			}
		}

		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
