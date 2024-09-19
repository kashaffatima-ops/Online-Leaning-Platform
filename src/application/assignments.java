package application;

public class assignments {

	private int assign_id;
	private int stuid;
	
	assignments(int ass, int stu){
		assign_id = ass;
		stuid = stu;
	}
	
	
	public int getAssign_id() {
		return assign_id;
	}
	public void setAssign_id(int assign_id) {
		this.assign_id = assign_id;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	
	
}
