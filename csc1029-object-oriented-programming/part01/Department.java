package part01;

public enum Department {
	ELECTRICAL(0),
	PHOTOGRAPHIC(1),
	COMPUTING(2),
	BOOKS(3),
	MUSIC(4),
	FASHION(5),
	OTHER(6);
	
	
	private String deptInfo[] = 
		
	{"Electrical", "Photographic", "Computing", "Books", "Music", "Fashion", "Other"};
	
	private int deptNum; 
	
	private Department (int num) {
		deptNum = num;
	}
	
	public String toString() {
		return deptInfo [deptNum];
	}
	
}
