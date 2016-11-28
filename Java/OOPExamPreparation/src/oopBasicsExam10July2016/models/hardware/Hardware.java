package oopBasicsExam10July2016.models.hardware;

import oopBasicsExam10July2016.models.software.Software;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public abstract class Hardware {
	private String name;
	private double price;
	private int memory;
	private int usedMemory;
	private int capacity;
	private int usedCapacity;
	private int energy;
	private Collection<Software> softwareCollection;

	protected Hardware(String name, double price,
					   int memory, int capacity, int energy) {
		this.setName(name);
		this.setPrice(price);
		this.setMemory(memory);
		this.setCapacity(capacity);
		this.setEnergy(energy);
		this.softwareCollection = new HashSet<>();
	}

	public Collection<Software> getSoftwareCollection() {
		return Collections.unmodifiableCollection(softwareCollection);
	}

	public int getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(int usedMemory) {
		this.usedMemory = usedMemory;
	}

	public int getUsedCapacity() {
		return usedCapacity;
	}

	public void setUsedCapacity(int usedCapacity) {
		this.usedCapacity = usedCapacity;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		if (price < 0d) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		this.price = price;
	}

	public int getMemory() {
		return memory;
	}

	protected void setMemory(int memory) {
		if (memory < 0) {
			throw new IllegalArgumentException("Memory cannot be negative.");
		}
		this.memory = memory;
	}

	public int getCapacity() {
		return capacity;
	}

	protected void setCapacity(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Capacity cannot be negative.");
		}
		this.capacity = capacity;
	}

	public int getEnergy() {
		return energy;
	}

	protected void setEnergy(int energy) {
		if (energy < 0) {
			throw new IllegalArgumentException("Energy cannot be negative.");
		}
		this.energy = energy;
	}

	public void addSoftware(Software software) {
		this.softwareCollection.add(software);
		this.setUsedCapacity(this.getUsedCapacity() + software.getCapacityConsumption());
		this.setUsedMemory(this.getUsedMemory() + software.getMemoryConsumption());
	}

	public String getType() {
		return this.getClass().getSimpleName().substring(0, 5);
	}

	@Override
	public String toString() {
		StringBuilder outputBuilder = new StringBuilder(String.format(
				"Hardware Component – %s%n" +
				"Price: %.2f%n" +
				"Memory Usage: %d / %d%n" +
				"Capacity Usage: %d / %d%n" +
				"Energy Usage: %d%n" +
				"Type: %s%n" +
				"Software Components: ",
				this.getName(),
				this.getPrice(),
				this.usedMemory, this.memory,
				this.usedCapacity, this.capacity,
				this.getEnergy(),
				this.getType()));

		for (Software software : softwareCollection) {
			outputBuilder.append(software.getName());
			outputBuilder.append(", ");
		}
		outputBuilder.setLength(outputBuilder.length() - 2);

		return outputBuilder.toString();
	}
}
