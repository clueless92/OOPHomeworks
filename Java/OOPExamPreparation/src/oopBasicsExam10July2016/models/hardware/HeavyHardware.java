package oopBasicsExam10July2016.models.hardware;

public class HeavyHardware extends Hardware {

	public HeavyHardware(String name, double price,
						 int memory, int capacity, int energy) {
		super(name, price, memory, capacity, energy);
		this.setCapacity(capacity);
		this.setMemory(memory);
	}

	@Override
	protected void setCapacity(int capacity) {
		capacity <<= 1; // same as *= 2;
		super.setCapacity(capacity);
	}

	@Override
	protected void setMemory(int memory) {
		memory -= (memory >> 2);
		super.setMemory(memory);
	}
}
