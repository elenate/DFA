package automata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class AutomatonCreator {

	public static Automaton createAutomatonFromFile(String filename)
			throws IOException {
		
		Automaton automaton = new Automaton();
		automaton.setName(filename);
		
		BufferedReader inputStream = new BufferedReader(new InputStreamReader(
				ClassLoader.getSystemClassLoader().getResourceAsStream(filename)));

		String line;
		while ((line = inputStream.readLine()) != null) {
			switch (line) {
			case "start state":
				line = inputStream.readLine();
				automaton.setStartState(line);
				break;
				
			case "alphabet":
				line = inputStream.readLine();
				createAlphabet(automaton, line);
				break;

			default:
				break;
			}
		}

		inputStream.close();
		
		return automaton;

	}

	private static void createAlphabet(Automaton automaton, String line) {
		String[] alphabet = line.split(" ");
		for (String string : alphabet) {
			automaton.addLetterToAlphabet(string.charAt(0));
		}
		
		
	}
}
