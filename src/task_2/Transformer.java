package task_2;

public class Transformer {

	private String name;

	private Integer strength;

	private Integer intelligence;

	private Integer speed;

	private Integer endurece;

	private Integer rank;

	private Integer courage;

	private Integer firepower;

	private Integer skills;
	
	private Description description;

	public Transformer(String name, Integer strength, Integer intelligence, Integer speed, Integer endurece,
			Integer rank, Integer courage, Integer firepower, Integer skills) {
		super();
		this.name = name;
		this.strength = strength;
		this.intelligence = intelligence;
		this.speed = speed;
		this.endurece = endurece;
		this.rank = rank;
		this.courage = courage;
		this.firepower = firepower;
		this.skills = skills;
	}

	
	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getEndurece() {
		return endurece;
	}

	public void setEndurece(Integer endurece) {
		this.endurece = endurece;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getCourage() {
		return courage;
	}

	public void setCourage(Integer courage) {
		this.courage = courage;
	}

	public Integer getFirepower() {
		return firepower;
	}

	public void setFirepower(Integer firepower) {
		this.firepower = firepower;
	}

	public Integer getSkills() {
		return skills;
	}

	public void setSkills(Integer skills) {
		this.skills = skills;
	}

	int total() {
		return getStrength() + getIntelligence() + getSpeed() + getEndurece() + getRank() + getCourage()
				+ getFirepower() + getSkills();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Description getDescription() {
		return description;
	}


	public void setDescription(Description description) {
		this.description = description;
	}
}
