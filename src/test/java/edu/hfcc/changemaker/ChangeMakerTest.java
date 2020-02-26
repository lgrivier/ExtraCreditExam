package edu.hfcc.changemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.hfcc.changemaker.BadDataException;

public class ChangeMakerTest {
	
	private ChangeMaker changeMaker;

    @BeforeEach
    public void setup(){
        changeMaker = new ChangeMaker();
    }
    
    @Test
    public void whenInvalidDataThrowBadDataException() {
    	Assertions.assertThrows(BadDataException.class,
				() -> {changeMaker.makeChange("0.00");});
		
    }

    @Test
    public void whenInputIsZeroReturnNothing() throws BadDataException {
        String actual = changeMaker.makeChange("$0.00");
        assertEquals("nothing", actual);
    }

    @Test
    public void whenInputIs251Return1Quarter() throws BadDataException {
        String actual = changeMaker.makeChange("$0.25");
        assertEquals("1 quarter", actual);
    }

    @Test
    public void whenInputIs10Return1Dime() throws BadDataException {
        String actual = changeMaker.makeChange("$0.10");
        assertEquals("1 dime", actual);
    }

    @Test
    public void whenInputIs5Return1Nickel() throws BadDataException {
        String actual = changeMaker.makeChange("$0.05");
        assertEquals("1 nickel", actual);
    }

    @Test
    public void whenInputIs01Return1Nickel() throws BadDataException {
        String actual = changeMaker.makeChange("$0.01");
        assertEquals("1 penny", actual);
    }


    @Test
    public void whenInputIs99Return2Quarters() throws BadDataException {
        String actual = changeMaker.makeChange("$0.99");
        assertEquals("3 quarters 2 dimes 4 pennies", actual);
    }

}
