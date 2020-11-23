package com.firstlab.memento;

import com.firstlab.jpa.Firm;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final Firm firm;

    public Memento(Firm f) {
        this.firm=new Firm( f.getName(),f.getAddress(),f.getIn(),f.getContactNumber(),
                f.getManager(),f.getYear());
    }

    public Firm getFirm() {
        return firm;
    }
}
