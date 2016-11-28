package oopBasicsExam10July2016.core;

import java.io.BufferedReader;
import java.io.IOException;

public class Engine {

	private BufferedReader reader;
	private CommandExecutor commandExecutor;

	public Engine(BufferedReader reader, CommandExecutor commandExecutor) {
		this.reader = reader;
		this.commandExecutor = commandExecutor;
	}

	public void run() {
		while (true) {
			String input = null;
			try {
				input = this.reader.readLine();
			} catch (IOException e) {
				System.err.println(e.getMessage());
				return;
			}
			String[] inputData = input.split("[()]");
			this.commandExecutor.executeCommand(inputData);
			if (input.equals("System Split")) {
				break;
			}
		}
	}
}
