package oopBasicsExam10July2016.data;

import oopBasicsExam10July2016.models.hardware.Hardware;
import oopBasicsExam10July2016.models.software.Software;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SystemData implements Iterable<Hardware> {
	private int hardwareCount;
	private int softwareCount;
	private double moneySpent;
	private long memoryInUse;
	private long memoryMax;
	private long capacityInUse;
	private long capacityMax;
	private long totalEnergy;
	private Map<String, Hardware> hardwareCollection;

	public SystemData() {
		this.hardwareCollection = new LinkedHashMap<>();
	}

	public Hardware getHardware(String name) {
		return this.hardwareCollection.get(name);
	}

	public void removeHardware(String name, String type) {
		if (!this.containsHardware(name, type)) {
			return;
		}
		Hardware hardware = this.getHardware(name);

		hardwareCollection.remove(name);
		this.memoryMax -= hardware.getMemory();
		this.capacityMax -= hardware.getCapacity();
		this.totalEnergy -= hardware.getEnergy();
		this.moneySpent -= hardware.getPrice();
		this.hardwareCount--;

		for (Software software : hardware.getSoftwareCollection()) {
			this.softwareCount--;
			this.capacityInUse -= software.getCapacityConsumption();
			this.memoryInUse -= software.getMemoryConsumption();
			this.moneySpent -= software.getPrice();
		}
	}

	public void addHardware(Hardware hardware) {
		hardwareCollection.put(hardware.getName(), hardware);
		this.hardwareCount++;
		this.memoryMax += hardware.getMemory();
		this.capacityMax += hardware.getCapacity();
		this.totalEnergy += hardware.getEnergy();
		this.moneySpent += hardware.getPrice();
	}

	public void addSoftware(String hardwareName, Software software) {
		if (!isHardwareAvailable(hardwareName)) {
			return;
		}

		Hardware hardware = this.hardwareCollection.get(hardwareName);
		if (!this.areResourcesSufficient(software, hardware)) {
			return;
		}

		if (!this.areCompatible(software, hardware)) {
			return;
		}

		hardware.addSoftware(software);
		this.moneySpent += software.getPrice();
		this.capacityInUse += software.getCapacityConsumption();
		this.memoryInUse += software.getMemoryConsumption();
		this.softwareCount++;
	}

	public boolean containsHardware(String name, String type) {
		return this.isHardwareAvailable(name) &&
				this.hardwareCollection.get(name).getType().equals(type);
	}

	private boolean isHardwareAvailable(String hardwareName) {
		return hardwareCollection.containsKey(hardwareName);
	}

	private boolean areResourcesSufficient(Software software, Hardware hardware) {
		if (hardware.getCapacity() - hardware.getUsedCapacity() < software.getCapacityConsumption() ||
				hardware.getMemory() - hardware.getUsedMemory() < software.getMemoryConsumption()) {
			return false;
		}
		return true;
	}

	private boolean areCompatible(Software software, Hardware hardware) {
		if (software.getType().equals("ExpressSoftware") &&
				!hardware.getType().equals("PowerHardware")) {
			return false;
		}
		if (software.getType().equals("LightSoftware") &&
				!hardware.getType().equals("HeavyHardware")) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		String output = String.format("System Analysis%n" +
				"Hardware Components: %d%n" +
				"Software Components: %d%n" +
				"Total Money Spent: %.2f%n" +
				"Total Operational Memory: %d / %d%n" +
				"Total Capacity Taken: %d / %d%n" +
				"Total Energy/Hour Consumption: %d%n",
				this.hardwareCount,
				this.softwareCount,
				this.moneySpent,
				this.memoryInUse, this.memoryMax,
				this.capacityInUse, this.capacityMax,
				this.totalEnergy);

		return output;
	}

	@Override
	public Iterator<Hardware> iterator() {
		return this.hardwareCollection.values().iterator();
	}
}
