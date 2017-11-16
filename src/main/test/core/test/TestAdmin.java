package core.test;

import core.api.IAdmin;
import core.api.IInstructor;
import core.api.impl.Admin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAdmin {

	private IAdmin admin;
	protected IInstructor instructor;
		
	@Before
	 public void setup() {
        this.admin = new Admin();
    }
	 
	@Test
	 public void testMakeClass() {
	        this.admin.createClass("Test", 2017, "Instructor", 15);
	        assertTrue(this.admin.classExists("Test", 2017));
	}
	@Test
	 public void classShouldNotExist() {
	        this.admin.createClass("Test", 2017, "Instructor", 15);
	        assertFalse(this.admin.classExists("Test2", 2018));
	}	
	 
	@Test
	 public void testNoOverite() {
	        this.admin.createClass("Test", 2017, "Instructor", 15);
	        this.admin.createClass("Test2", 2018, "Instructorr", 30);
	        assertTrue(this.admin.classExists("Test", 2017));
	        assertTrue(this.admin.classExists("Test2", 2018));
	}

	@Test
    public void twoSameClasses(){
        admin.createClass("Class", 2017, "Instructor", 22);
        admin.createClass("Class", 2016, "Instructor", 22);
        assertFalse(this.admin.classExists("Test1", 2016));
    }
 
	@Test
	public void capacity(){
	    this.admin.createClass("Class", 2017, "Instructor", 0);
	    assertTrue(this.admin.classExists("Class", 2017));
	}
	 
	@Test
    public void TestInstructorName(){
        this.admin.createClass("Class", 2017, "Instructor", 15);
        String ret = this.admin.getClassInstructor("Class", 2017);
        assertEquals(ret, "Instructor");
        assertNotNull(ret);
    }
}