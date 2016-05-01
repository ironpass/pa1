
public enum Weight implements Unit {
	GRAM("Gram", 0.001),
	KILOGRAM("Kilogram", 1.0),
	MILLIGRAM("Milligram", 0.000001),
	POUND("Pound", 2.20462),
	OUNCE("Ounce", 35.274),
	CHANG("Chang", 1.2);
	
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
