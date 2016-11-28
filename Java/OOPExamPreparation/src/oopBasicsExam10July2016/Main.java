package oopBasicsExam10July2016;

import oopBasicsExam10July2016.core.CommandExecutor;
import oopBasicsExam10July2016.core.Engine;
import oopBasicsExam10July2016.data.Dump;
import oopBasicsExam10July2016.data.SystemData;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		SystemData systemData = new SystemData();
		Dump dump = new Dump();
		CommandExecutor commandExecutor = new CommandExecutor(systemData, dump);
		Engine engine = new Engine(reader, commandExecutor);
		engine.run();
	}
}
