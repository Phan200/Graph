package TestGraph;

public class Friend implements Display{
    private String name;
    private String address;
    private int age;
    private String job;
    private String hobby;
    private String Relationship;
    private double x,y;
    
    Friend(){
    	
    }
    
	public Friend(String name, String address, int age, String job, String hobby, String relationship, double x,
			double y) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
		Relationship = relationship;
		this.x = x;
		this.y = y;
	}

	public Friend(String name, String address, int age, String job, 
			String hobby, String Relationship) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
		this.Relationship = Relationship;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getRelationship() {
		return Relationship;
	}
	public void setRelationship(String Relationship) {
		this.Relationship = Relationship;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public String getFriend() {
		// TODO Auto-generated method stub
		return name;
	}

    
}

