package org.parmesh.rental;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.parmesh.rental.controller.RentalToolController;
import org.parmesh.rental.model.GetRentalToolResponse;
import org.parmesh.rental.model.ToolRentalRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    private RentalToolController rentalToolController;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    @Before
    public void initializedController(){
        rentalToolController = new RentalToolController();
    }

    @Test
    public void testOne() throws ParseException {


        Date checoutDate = dateFormat.parse("9/3/15");
        ToolRentalRequest rentalRequest = new ToolRentalRequest("JAKR", 5, 101, checoutDate);
        GetRentalToolResponse rentalToolResponse = rentalToolController.checkoutTool(rentalRequest);
        Assert.fail();

    }
    @Test
    public void testTwo() throws ParseException {


        Date checoutDate = dateFormat.parse("7/2/20");
        ToolRentalRequest rentalRequest = new ToolRentalRequest("LADW", 3, 10, checoutDate);
        GetRentalToolResponse rentalToolResponse = rentalToolController.checkoutTool(rentalRequest);
        assertEquals(5.37,rentalToolResponse.getFinalCharge(),0.00);


    }
    @Test
    public void testThree() throws ParseException {


        Date checoutDate = dateFormat.parse("7/2/15");
        ToolRentalRequest rentalRequest = new ToolRentalRequest("CHNS", 5, 25, checoutDate);
        GetRentalToolResponse rentalToolResponse = rentalToolController.checkoutTool(rentalRequest);
        assertEquals(7.46,rentalToolResponse.getFinalCharge(),0.00);


    }

    @Test
    public void testFour() throws ParseException {


        Date checoutDate = dateFormat.parse("9/3/15");
        ToolRentalRequest rentalRequest = new ToolRentalRequest("JAKD", 6, 0, checoutDate);
        GetRentalToolResponse rentalToolResponse = rentalToolController.checkoutTool(rentalRequest);
        assertEquals(11.96,rentalToolResponse.getFinalCharge(),0.00);


    }
    @Test
    public void testFive() throws ParseException {


        Date checoutDate = dateFormat.parse("7/2/15");
        ToolRentalRequest rentalRequest = new ToolRentalRequest("JAKR", 9, 0, checoutDate);
        GetRentalToolResponse rentalToolResponse = rentalToolController.checkoutTool(rentalRequest);
        assertEquals(17.94,rentalToolResponse.getFinalCharge(),0.00);


    }
    @Test
    public void testSix() throws ParseException {


        Date checoutDate = dateFormat.parse("7/2/20");
        ToolRentalRequest rentalRequest = new ToolRentalRequest("JAKR", 4, 50, checoutDate);
        GetRentalToolResponse rentalToolResponse = rentalToolController.checkoutTool(rentalRequest);
        assertEquals(2.99,rentalToolResponse.getFinalCharge(),0.00);


    }
}
