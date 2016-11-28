package oopBasicsExam10July2016.models.software;

public class ExpressSoftware extends Software {

	public ExpressSoftware(String name, double price,
						   int capacityConsumption, int memoryConsumption) {
		super(name, price, capacityConsumption, memoryConsumption);
		this.setPrice(price);
		this.setMemoryConsumption(memoryConsumption);
	}

	@Override
	protected void setMemoryConsumption(int memoryConsumption) {
		memoryConsumption <<= 1;
		super.setMemoryConsumption(memoryConsumption);
	}

	@Override
	protected void setPrice(double price) {
		price *= 2d;
		super.setPrice(price);
	}
}
