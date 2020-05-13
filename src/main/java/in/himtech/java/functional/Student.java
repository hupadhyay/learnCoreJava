package in.himtech.java.functional;

public class Student {

	private Integer id;
	private String name;
	private String location;
	private String dateOfJoining;
	private Double fees;

	public Student() {

	}

	public Student(Integer id, String name, String location, String dateOfJoining, Double fees) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.dateOfJoining = dateOfJoining;
		this.fees = fees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", location=" + location + ", dateOfJoining=" + dateOfJoining
				+ ", fees=" + fees + "]";
	}

}
