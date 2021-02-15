package course.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "teacher_id", referencedColumnName = "id")
public class Teacher extends User {
	private String phone;
	private int experiences;
	
	public String getPhone() {
		return phone;
	}
	
	public int getExperiences() {
		return experiences;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setExperiences(int experiences) {
		this.experiences = experiences;
	}
}
