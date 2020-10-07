package com.firstlab.map;

import com.firstlab.dto.FirmDTO;
import com.firstlab.jpa.Firm;

import java.util.GregorianCalendar;

public class FirmMap implements Mapper<FirmDTO, Firm> {

    @Override
    public FirmDTO convertToDto(Firm var1) {
        FirmDTO firmDTO = new FirmDTO();
        if (var1.getName() != null) {
            firmDTO.setName(var1.getName());
        }
        if (var1.getAddress() != null) {
            firmDTO.setAddress(var1.getAddress());
        }
        if (var1.getContactNumber() != null) {
            firmDTO.setContactNumber(var1.getContactNumber());
        }
        if (var1.getManager() != null) {
            firmDTO.setManager(var1.getManager());
        }
        if (var1.getYear() != null) {
            firmDTO.setAge(new GregorianCalendar().get(java.util.Calendar.YEAR) - var1.getYear());
        }
        return firmDTO;
    }

    @Override
    public Firm convertToDocument(FirmDTO var1) {
        try {
            Firm firm = new Firm();
            if (var1.getName() != null) {
                if (var1.getName().isEmpty()) {
                    throw new Exception("Error!Name is empty");
                }
                firm.setName(var1.getName());
            }
            if (var1.getAddress() != null) {
                firm.setAddress(var1.getAddress());
            }
            if (var1.getContactNumber() != null) {
                firm.setContactNumber(var1.getContactNumber());
            }
            if (var1.getManager() != null) {
                if (var1.getManager().isEmpty()) {
                    throw new Exception("Error!Manager name is empty");
                }
                firm.setManager(var1.getManager());
            }
            if (var1.getAge() != null) {
                if (var1.getAge() < 0) {
                    throw new Exception("Error!Age is negative");
                }
                firm.setYear(new GregorianCalendar().get(java.util.Calendar.YEAR) - var1.getAge());
            }
            return firm;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
