package oopBasicsExam10July2016.models.software;

public abstract class Software {
	private String name;
	private double price;
	private int capacityConsumption;
	private int memoryConsumption;

	protected Software(String name, double price,
					 int capacityConsumption, int memoryConsumption) {
		this.setName(name);
		this.setPrice(price);
		this.setCapacityConsumption(capacityConsumption);
		this.setMemoryConsumption(memoryConsumption);
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

	protected void setPrice(double price) {
		if (price < 0d) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		this.price = price;
	}

	public int getCapacityConsumption() {
		return capacityConsumption;
	}

	protected void setCapacityConsumption(int capacityConsumption) {
		if (capacityConsumption < 0) {
			throw new IllegalArgumentException("Capacity consumption cannot be negative.");
		}
		this.capacityConsumption = capacityConsumption;
	}

	public int getMemoryConsumption() {
		return memoryConsumption;
	}

	protected void setMemoryConsumption(int memoryConsumption) {
		if (capacityConsumption < 0) {
			throw new IllegalArgumentException("Memory consumption cannot be negative.");
		}
		this.memoryConsumption = memoryConsumption;
	}

	public String getType() {
		return this.getClass().getSimpleName();
	}
}
