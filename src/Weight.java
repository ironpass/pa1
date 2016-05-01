
public enum Weight {
	GRAM("Gram", 1000.00),
	KILOGRAM("Kilogram", 1.0),
	MILLIGRAM("Milligram", 1000000.00),
	POUND("Pound", 2.20462),
	OUNCE("Ounce", 35.274);
	
	private final String name;
	private final double value;
	
	private Weight(String name, double value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return this.name;
	}
	public double getValue() {
		return value;
	}
}
