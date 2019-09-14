package edu.chl.hajo;

import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
    
     This is a test class (for some other class, in this case the List class)

 */
public class TestList {

    private List l = null;

    @Before
    public void objectCreatedBefore() {
        System.out.println("Before");
        l = new List();
    }

    @BeforeClass
    public static void beforeClass(){  //First of all
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass(){  // Last of all
        System.out.println("After class");
    }

    @After
    public void after(){  //After each test method
        System.out.println("After");
    }

    @Test
    public void testAdd() {
        l.add(1);                        // Call method to test
        assertTrue(l.getLength() == 1);  // The logical check
    }

    @Test
    public void testRemove() {
        l.add(1);
        assertTrue(l.getLength() == 1);
        int i = l.remove();
        assertTrue(l.getLength() == 0);
        assertTrue(i == 1);
    }

    @Test
    public void testGet() {
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        assertTrue(l.get(2) == 3);
    }

    @Test(expected=IllegalStateException.class)
    public void testGetBadIndex() {
        // Get a list then ...
        l.add(1);
        l.remove();
        l.remove();
    }

    @Test
    public void testCopyEmpty() {
        List testEmpty = new List();
        List test = l.copy();
        assertTrue(test.getLength() == 0);
    }

    @Test
    public void testCopyNonEmpty() {
        l.add(1);
        l.add(2);
        List test = l.copy();
        assertTrue(test.getLength() == 2);
        int removed = l.remove();
        assertTrue(removed == 2);
    }

}
