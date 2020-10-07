package com.firstlab.map.create;

import com.firstlab.map.ExpenditureMap;
import com.firstlab.map.Mapper;

public class CreateExpenditureMapper extends CreateMapper {
    @Override
    public Mapper factoryMethod() {
        return new ExpenditureMap();
    }
}
