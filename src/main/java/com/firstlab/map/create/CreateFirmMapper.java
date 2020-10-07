package com.firstlab.map.create;

import com.firstlab.map.FirmMap;
import com.firstlab.map.Mapper;

public class CreateFirmMapper extends CreateMapper {

    @Override
    public Mapper factoryMethod() {
        return new FirmMap();
    }
}
