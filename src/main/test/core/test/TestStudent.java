package core.test;

import core.api.IAdmin;
import core.api.IInstructor;
import core.api.IStudent;
import core.api.impl.Admin;
import core.api.impl.Instructor;
import core.api.impl.Student;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStudent {
	
	private IStudent student; 
    protected IAdmin admin = new Admin();
    protected IInstructor instructor = new Instructor();
	
	@Before
	 public void setup() {
        this.student = new Student();
    }
	 
	@Test
	 public void testisRegisteredFor() {
			this.admin.createClass("Class", 2017, "Instructor", 2);
	        this.student.registerForClass("Student", "Class", 2017);
	        this.student.submitHomework("Student", "Homework", "Answer" ,"Class", 2017);
	        assertTrue(this.student.isRegisteredFor("Student", "Class", 2017));
	        assertFalse(this.student.isRegisteredFor("Student2", "Class", 2017));
	}  

	@Test
	 public void testSubmitedHomework() {
	        this.student.submitHomework("Student", "Homework", "Answer" ,"Class", 2017);
	        assertFalse(this.student.hasSubmitted("Student","Homework", "Class", 2017));
	        assertFalse(this.student.isRegisteredFor("Student2", "Class", 2017));
	}  
	
    @Test
    public void TestEnrollmentCapacity(){
        this.admin.createClass("Test", 2017, "Instructor", 2);
        this.student.registerForClass("Student1", "Test", 2017);
        this.student.registerForClass("Student2", "Test", 2017);
        this.student.registerForClass("Student3", "Test", 2017);
        this.student.registerForClass("Student4", "Test", 2017);
        assertTrue(this.student.isRegisteredFor("Student4", "Test", 2017));
    }
}
