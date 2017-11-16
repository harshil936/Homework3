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

public class TestInstructor {

	private IInstructor instructor; 
    protected IAdmin admin = new Admin();
    protected IStudent student = new Student();
		
	@Before
	 public void setup() {
        this.instructor = new Instructor();
    }
	 
	@Test
	 public void testHomeworkExist1() {
	        this.instructor.addHomework("Instructor", "Test", 2017, "homework1");
	        assertTrue(this.instructor.homeworkExists("Test", 2017, "homework1"));
	}        
	
	@Test
	 public void testHomeworkExist2() {
	        this.instructor.addHomework("Instructor", "Test", 2017, "homework1");
	        this.instructor.addHomework("Instructor", "T2", 2016, "homework");
	        assertTrue(this.instructor.homeworkExists("Test", 2017, "homework1"));
	        assertFalse(this.instructor.homeworkExists("Test3", 2016, "homework"));
	} 
	
	@Test
	 public void testHomeworkDoesnotExist() {
	        this.instructor.addHomework("Instructor", "Test", 2017, "homework1");
	        assertFalse(this.instructor.homeworkExists("Test2", 2016, "homework5"));
	} 
	
	@Test
	 public void testGetGrade() {
	        this.instructor.addHomework("Instructor", "Test", 2017, "homework1");
	        this.instructor.assignGrade("Instructor", "Test", 2017, "homework1", "student", 95);
	        assertTrue(this.instructor.homeworkExists("Test", 2017, "homework1"));
	        long exp = 95;
	        long act = Long.valueOf(this.instructor.getGrade("Test", 2017, "homework1","student"));
	        assertEquals(exp, act);
	} 
	
	@Test
	 public void testGetGrade2() {
	        this.instructor.addHomework("Instructor", "Test", 2017, "homework1");
	        this.instructor.assignGrade("Instructor", "Test", 2017, "homework1", "student", 90);
	        assertTrue(this.instructor.homeworkExists("Test", 2017, "homework1"));
	        long exp = 95;
	        long act = Long.valueOf(this.instructor.getGrade("Test", 2017, "homework1","student"));
	        assertNotEquals(exp, act);
	} 

	
}