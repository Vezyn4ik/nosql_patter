package com.firstlab.map;


public interface Mapper<D, E> {
    D convertToDto(E var1);

    E convertToDocument(D var1);

}
