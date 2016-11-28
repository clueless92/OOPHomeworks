package oopBasicsExam10July2016.core;

import oopBasicsExam10July2016.data.Dump;
import oopBasicsExam10July2016.data.SystemData;
import oopBasicsExam10July2016.models.hardware.Hardware;
import oopBasicsExam10July2016.models.hardware.HeavyHardware;
import oopBasicsExam10July2016.models.hardware.PowerHardware;
import oopBasicsExam10July2016.models.software.ExpressSoftware;
import oopBasicsExam10July2016.models.software.LightSoftware;
import oopBasicsExam10July2016.models.software.Software;

public class CommandExecutor {

	SystemData systemData;
	Dump dump;

	public CommandExecutor(SystemData systemData, Dump dump) {
		this.systemData = systemData;
		this.dump = dump;
	}

	public void executeCommand(String[] inputData) {
		String commandName = inputData[0];
		this.parseCommand(commandName, inputData);
	}

	private void parseCommand(String commandName, String[] inputData) {
		switch (commandName) {
			case "RegisterPowerHardware":
				this.registerPowerHardware(inputData);
				break;
			case "RegisterHeavyHardware":
				this.registerHeavyHardware(inputData);
				break;
			case "RegisterExpressSoftware":
				this.registerExpressSoftware(inputData);
				break;
			case "RegisterLightSoftware":
				this.registerLightSoftware(inputData);
				break;
			case "Analyze":
				this.analyzeCommand();
				break;
			case "Dump":
				this.dumpCommand(inputData);
				break;
			case "Restore":
				this.restoreCommand(inputData);
				break;
			case "Destroy":
				this.destroyCommand(inputData);
				break;
			case "System Split":
				this.systemSplitCommand();
				break;
			case "DumpAnalyze":
				this.dumpAnalyzeCommand();
				break;
			default:
				System.out.println("Invalid command!");
				break;
		}
	}

	private void dumpAnalyzeCommand() {

	}

	private void systemSplitCommand() {
		for (Hardware hardware : systemData) {
			System.out.println(hardware);
		}
	}

	private void destroyCommand(String[] inputData) {
		String[] data = inputData[1].split(", ");
		String type = data[0];
		String name = data[1];
		if (!this.dump.containsHardware(name, type)) {
			return;
		}
		this.dump.removeHardware(name, type);
	}

	private void restoreCommand(String[] inputData) {
		String[] data = inputData[1].split(", ");
		String type = data[0];
		String name = data[1];
		if (!this.dump.containsHardware(name, type)) {
			return;
		}
		Hardware hardware = this.dump.getHardware(name);
		this.systemData.addHardware(hardware);
	}

	private void dumpCommand(String[] inputData) {
		String[] data = inputData[1].split(", ");
		String type = data[0];
		String name = data[1];
		if (!this.systemData.containsHardware(name, type)) {
			return;
		}
		Hardware hardware = this.systemData.getHardware(name);

		this.systemData.removeHardware(name, type);
		this.dump.addHardware(hardware);
	}

	private void analyzeCommand() {
		System.out.print(this.systemData.toString());
	}

	private void registerLightSoftware(String[] inputData) {
		String[] data = inputData[1].split(", ");
		String hardwareName = data[0];
		String name = data[1];
		double price = Double.parseDouble(data[2]);
		int capacity = Integer.parseInt(data[3]);
		int memory = Integer.parseInt(data[4]);
		Software software = new LightSoftware(name, price, capacity, memory);
		this.systemData.addSoftware(hardwareName, software);
	}

	private void registerExpressSoftware(String[] inputData) {
		String[] data = inputData[1].split(", ");
		String hardwareName = data[0];
		String name = data[1];
		double price = Double.parseDouble(data[2]);
		int capacity = Integer.parseInt(data[3]);
		int memory = Integer.parseInt(data[4]);
		Software software = new ExpressSoftware(name, price, capacity, memory);
		this.systemData.addSoftware(hardwareName, software);
	}

	private void registerHeavyHardware(String[] inputData) {
		String[] data = inputData[1].split(", ");
		String name = data[0];
		double price = Double.parseDouble(data[1]);
		int capacity = Integer.parseInt(data[2]);
		int memory = Integer.parseInt(data[3]);
		int energy = Integer.parseInt(data[4]);
		Hardware powerHardware =
				new HeavyHardware(name, price, memory, capacity, energy);
		this.systemData.addHardware(powerHardware);

	}

	private void registerPowerHardware(String[] inputData) {
		String[] data = inputData[1].split(", ");
		String name = data[0];
		double price = Double.parseDouble(data[1]);
		int capacity = Integer.parseInt(data[2]);
		int memory = Integer.parseInt(data[3]);
		int energy = Integer.parseInt(data[4]);
		Hardware powerHardware =
				new PowerHardware(name, price, memory, capacity, energy);
		this.systemData.addHardware(powerHardware);
	}
}
