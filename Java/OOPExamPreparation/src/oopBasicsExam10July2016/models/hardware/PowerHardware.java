package oopBasicsExam10July2016.models.hardware;

public class PowerHardware extends Hardware {

	public PowerHardware(String name, double price,
						 int memory, int capacity, int energy) {
		super(name, price, memory, capacity, energy);
		this.setCapacity(capacity);
		this.setMemory(memory);
		this.setEnergy(energy);
	}

	@Override
	protected void setMemory(int memory) {
		memory += memory - (memory >> 2);
		super.setMemory(memory);
	}

	@Override
	protected void setCapacity(int capacity) {
		capacity -= 3 * (capacity >> 2);
		super.setCapacity(capacity);
	}

	@Override
	protected void setEnergy(int energy) {
		energy <<= 1; // same as *= 2;
		super.setEnergy(energy);
	}
}
