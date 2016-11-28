package oopBasicsExam10July2016.data;

import oopBasicsExam10July2016.models.hardware.Hardware;

import java.util.HashMap;
import java.util.Map;

public class Dump {
	private Map<String, Hardware> hardwareCollection;

	public Dump() {
		this.hardwareCollection = new HashMap<>();
	}

	public Hardware getHardware(String name) {
		return this.hardwareCollection.get(name);
	}

	public void addHardware(Hardware hardware) {
		hardwareCollection.put(hardware.getName(), hardware);
	}

	public void removeHardware(String name, String type) {
		if (!this.containsHardware(name, type)) {
			return;
		}

		hardwareCollection.remove(name);
	}

	public boolean containsHardware(String name, String type) {
		return this.isHardwareAvailable(name) &&
				this.hardwareCollection.get(name).getType().equals(type);
	}

	private boolean isHardwareAvailable(String hardwareName) {
		return hardwareCollection.containsKey(hardwareName);
	}
}
