package org.parmesh.rental.repository;

import org.parmesh.rental.entity.RentalCharge;
import org.parmesh.rental.entity.Tool;

import java.util.ArrayList;
import java.util.List;

public class ToolRepositoryImpl implements ToolInterface {

    List<Tool> toolList = new ArrayList<>();
    public ToolRepositoryImpl() {

        toolList.add(new Tool("CHNS","Chainsaw","Stihl"));
        toolList.add(new Tool("LADW","Ladder","Werner"));
        toolList.add(new Tool("JAKD","Jackhammer","DeWalt"));
        toolList.add(new Tool("JAKR","Jackhammer","Ridgid"));

    }



    @Override
    public Tool getToolByCode(String toolCode) {
        for (Tool t: toolList) {
            if(t.getToolCode().equals(toolCode)){
                return t;
            }
        }
        return null;
    }
}
