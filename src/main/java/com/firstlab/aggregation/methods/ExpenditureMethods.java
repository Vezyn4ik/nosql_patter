package com.firstlab.aggregation.methods;

import com.firstlab.aggregation.ExpAg;
import com.firstlab.aggregation.StaffAgg;
import com.firstlab.jpa.Expenditure;
import com.firstlab.jpa.Staff;
import com.firstlab.repository.ExpenditureRepository;
import com.firstlab.repository.FirmRepository;
import com.firstlab.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Aggregation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenditureMethods {
    @Autowired
    private ExpenditureRepository expenditureRepository;
    @Autowired
    private FirmRepository firmRepository;

    public ExpenditureMethods(ExpenditureRepository expenditureRepository, FirmRepository firmRepository) {
        this.expenditureRepository = expenditureRepository;
        this.firmRepository = firmRepository;
    }

    public List<ExpAg> maxLostMoneyFirmWithoutAggregation(){
        List<Expenditure> temp = expenditureRepository.findAll();
        HashMap<String, Long> maxLostMoney = new HashMap<>();
        for( Expenditure exp : temp) {
            Long max = maxLostMoney.get(exp.getFirm().getName());
            maxLostMoney.put(exp.getFirm().getName(), max == null ? exp.getMoney() : (exp.getMoney()>max ? exp.getMoney() : max ));
        }
        List<ExpAg> result = new ArrayList<ExpAg>();
        for (Map.Entry<String, Long> entry : maxLostMoney.entrySet()) {
            result.add(new ExpAg(entry.getKey(),entry.getValue()));
        }
        return result;
    }
    public List<ExpAg> sumLostMoneyFirmWithoutAggregation(){
        List<Expenditure> temp = expenditureRepository.findAll();
        HashMap<String, Long> sumLostMoney = new HashMap<>();
        for( Expenditure exp : temp) {
            Long sum = sumLostMoney.get(exp.getFirm().getName());
            sumLostMoney.put(exp.getFirm().getName(), sum == null ? exp.getMoney() : sum+exp.getMoney());
        }
        List<ExpAg> result = new ArrayList<>();
        for (Map.Entry<String, Long> entry : sumLostMoney.entrySet()) {
            result.add(new ExpAg(entry.getKey(),entry.getValue()));
        }
        return result;
    }


}
