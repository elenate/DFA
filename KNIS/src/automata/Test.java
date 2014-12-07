package automata;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class Test {

	public static void main(String[] args) throws IOException {
		Transition t = new Transition("A", 'e', "B");
		System.out.println(t);

		Automaton nfa = initAutomata();
		System.out.println(nfa);

		Automaton dfa = new Automaton();
		BidiMap<String, Set<String>> states = new DualHashBidiMap<String, Set<String>>();
		Converter.transform(nfa, dfa, states);
		System.out.println(dfa);
		System.out.println(states);

		System.out.println(AutomatonCreator.createAutomatonFromFile("input.txt"));

	}

	private static Automaton initAutomata5() {
		Automaton automata = new Automaton();
		// alphabet
		automata.addLetterToAlphabet('l');
		automata.addLetterToAlphabet('d');

		// start state
		automata.setStartState("q1");

		// accept states
		automata.addAcceptState("q10");
		
		// transitions
		automata.addTransition("q1", 'l', "q2");
		automata.addTransition("q2", 'e', "q3");
		automata.addTransition("q3", 'e', "q4");
		automata.addTransition("q3", 'e', "q10");
		automata.addTransition("q4", 'e', "q5");
		automata.addTransition("q4", 'e', "q8");
		automata.addTransition("q5", 'l', "q6");
		automata.addTransition("q6", 'e', "q7");
		automata.addTransition("q7", 'e', "q10");
		automata.addTransition("q7", 'e', "q4");
		automata.addTransition("q8", 'd', "q9");
		automata.addTransition("q9", 'e', "q7");

		return automata;
		
	}

	private static Automaton initAutomata4() {
		Automaton automata = new Automaton();
		// alphabet
		automata.addLetterToAlphabet('a');
		automata.addLetterToAlphabet('b');

		// start state
		automata.setStartState("q0");

		// accept states
		automata.addAcceptState("q1");

		// transitions
		automata.addTransition("q0", 'a', "q1");
		automata.addTransition("q1", 'a', "q1");
		automata.addTransition("q1", 'e', "q2");
		automata.addTransition("q2", 'b', "q0");
		
		return automata;
	}

	private static Automaton initAutomata3() {
		Automaton automata = new Automaton();
		// alphabet
		automata.addLetterToAlphabet('a');
		automata.addLetterToAlphabet('b');

		// start state
		automata.setStartState("q1");

		// accept states
		automata.addAcceptState("q5");

		// transitions
		automata.addTransition("q1", 'a', "q3");
		automata.addTransition("q1", 'e', "q2");
		automata.addTransition("q2", 'a', "q4");
		automata.addTransition("q2", 'a', "q5");
		automata.addTransition("q3", 'b', "q4");
		automata.addTransition("q4", 'a', "q5");
		automata.addTransition("q4", 'b', "q5");
		
		return automata;
	}

	private static Automaton initAutomata2() {
		Automaton automata = new Automaton();
		// alphabet
		automata.addLetterToAlphabet('a');
		automata.addLetterToAlphabet('b');

		// start state
		automata.setStartState("q0");

		// accept states
		automata.addAcceptState("q3");

		// transitions
		automata.addTransition("q0", 'a', "q1");
		automata.addTransition("q0", 'a', "q2");
		automata.addTransition("q0", 'e', "q3");
		automata.addTransition("q1", 'b', "q3");
		automata.addTransition("q2", 'e', "q3");
		automata.addTransition("q3", 'e', "q1");

		return automata;
	}

	private static Automaton initAutomata() {
		Automaton automata = new Automaton();
		// alphabet
		automata.addLetterToAlphabet('a');
		automata.addLetterToAlphabet('b');

		// start state
		automata.setStartState("q0");

		// accept states
		automata.addAcceptState("q10");

		// transitions
		automata.addTransition("q0", 'e', "q1");
		automata.addTransition("q0", 'e', "q7");
		automata.addTransition("q1", 'e', "q2");
		automata.addTransition("q1", 'e', "q4");
		automata.addTransition("q2", 'a', "q3");
		automata.addTransition("q3", 'e', "q6");
		automata.addTransition("q4", 'b', "q5");
		automata.addTransition("q5", 'e', "q6");
		automata.addTransition("q6", 'e', "q1");
		automata.addTransition("q6", 'e', "q7");
		automata.addTransition("q7", 'a', "q8");
		automata.addTransition("q8", 'b', "q9");
		automata.addTransition("q9", 'b', "q10");

		return automata;

	}

}
