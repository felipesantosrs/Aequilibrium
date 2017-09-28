package task_2;

public class Autobot extends Transformer {
	private Description description = Description.AUTOBOT;

	public Autobot(String name, Integer strength, Integer intelligence, Integer speed, Integer endurece, Integer rank,
			Integer courage, Integer firepower, Integer skills) {
		super(name, strength, intelligence, speed, endurece, rank, courage, firepower, skills);
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}



}
