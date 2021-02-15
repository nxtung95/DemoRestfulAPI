package course.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "id")
public class Student extends User {
	private int year;
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
}
