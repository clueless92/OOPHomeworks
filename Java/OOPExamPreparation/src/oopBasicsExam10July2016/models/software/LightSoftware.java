package oopBasicsExam10July2016.models.software;

public class LightSoftware extends Software{

	public LightSoftware(String name, double price,
						 int capacityConsumption, int memoryConsumption) {
		super(name, price, capacityConsumption, memoryConsumption);
		this.setMemoryConsumption(memoryConsumption);
		this.setCapacityConsumption(capacityConsumption);
	}

	@Override
	protected void setCapacityConsumption(int capacityConsumption) {
		capacityConsumption += (capacityConsumption >> 1);
		super.setCapacityConsumption(capacityConsumption);
	}

	@Override
	protected void setMemoryConsumption(int memoryConsumption) {
		memoryConsumption -= (memoryConsumption >> 1);
		super.setMemoryConsumption(memoryConsumption);
	}
}
