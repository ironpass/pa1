
public enum Time implements Unit {
	SECOND("Second", 1.00),
	MINUTE("Minute", 60.0),
	HOUR("Hour", 3600.0),
	DAY("Day", 86400.0),
	MONTH("Month", 2628000.0),
	YARM("Yarm", 10800.0);
	
	private final String name;
	private final double value;
	
	private Time(String name, double value) {
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
