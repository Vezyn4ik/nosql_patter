package com.firstlab.repository;

import com.firstlab.aggregation.FirmAg;
import com.firstlab.jpa.Firm;

import java.util.List;

public interface FirmRepositoryCustom {
    Boolean update(String tittle, String description);
    Boolean update(Firm firm);
    Firm checkSave(Firm firm) throws Exception;

    List<FirmAg> countFirmsYear();
    List<FirmAg> maxFirmsYear();
}
