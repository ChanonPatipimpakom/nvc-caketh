package model;

public class Cake {
	private int id;
	private String name;
	private float pricePerPound;
	private float discountRate;
	
	public Cake() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPricePerPound() {
		return pricePerPound;
	}

	public void setPricePerPound(float pricePerPound) {
		this.pricePerPound = pricePerPound;
	}

	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}
	
	
}
