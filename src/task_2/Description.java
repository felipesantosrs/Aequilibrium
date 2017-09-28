package task_2;

enum Description {

	DECEPTION("Deception"), AUTOBOT("Autobot");
	
	private String label;

	private Description(String label) {
		this.label = label;
	}

	public String label() {
		return label;
	}
	


}
