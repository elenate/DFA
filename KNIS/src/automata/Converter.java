package automata;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.collections4.BidiMap;

public class Converter {

	public static Set<String> epsilonClosure(Set<String> states,
			Automaton automaton) {
		// Push all states in T onto stack
		Stack<String> stack = new Stack<String>();
		stack.addAll(states);

		// initialize epsilon-Closure (T) to T
		Set<String> closure = new LinkedHashSet<String>(states);

		// while stack is not empty
		while (!stack.isEmpty()) {
			// pop top element t
			String stateToCheck = stack.pop();

			// for each state u with epsilon-edge t to u
			Set<String> statesWithEpsilonEdge = automaton
					.moveWithEpsilon(stateToCheck);

			for (String state : statesWithEpsilonEdge) {
				// If u is not in epsilon-Closure(T)
				if (!closure.contains(state)) {
					// add u to epsilon-Closure (T) and push u onto stack
					closure.add(state);
					stack.push(state);
				}
			}
		}

		return closure;
	}

	public static void transform(Automaton oldAutomaton,
			Automaton newAutomaton, BidiMap<String, Set<String>> states) {
		Set<Character> alphabet = oldAutomaton.getAlphabet();
		newAutomaton.setAlphabet(alphabet);

		// epsilon-Closure (S0) in DTrans.
		String startState = oldAutomaton.getStartState();
		Set<String> startStateSet = new LinkedHashSet<String>();
		startStateSet.add(startState);
		Set<String> epsilonStart = epsilonClosure(startStateSet, oldAutomaton);
		String newStart = "Q0";
		newAutomaton.setStartState(newStart);
		states.put(newStart, epsilonStart);

		// While unmarked state T in DTrans
		Stack<Set<String>> unmarked = new Stack<Set<String>>();
		unmarked.push(epsilonStart);
		int i = 1;
		String prevState = newStart;
		while (!unmarked.isEmpty()) {
			// mark T
			Set<String> stateToCheck = unmarked.pop();
			prevState = states.getKey(stateToCheck);
			// for each input symbol 'a'
			for (Character character : alphabet) {
				// u = epsilon-Closure (T, a)
				Set<String> moves = oldAutomaton.moves(stateToCheck, character);
				Set<String> newState = epsilonClosure(moves, oldAutomaton);
				// new automaton contains transition
				if (!newState.isEmpty()) {
					String state = states.getKey(newState);
					if (state == null) {
						state = "Q" + i;
						i++;
					}
					Transition transition = new Transition(prevState,
							character, state);
					if (!newAutomaton.getTransitions().contains(transition)) {
						newAutomaton.addTransition(prevState, character, state);
						states.put(state, newState);
						unmarked.push(newState);
					}
				}
			}

		}

		for (Entry<String, Set<String>> entry : states.entrySet()) {
			if (oldAutomaton.containsAcceptState(entry.getValue())) {
				newAutomaton.addAcceptState(entry.getKey());
			}
		}

	}
}
