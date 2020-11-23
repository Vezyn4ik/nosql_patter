package com.firstlab.aggregation.methods;

import com.firstlab.aggregation.StaffAgg;
import com.firstlab.aggregation.StaffAggOcupation;
import com.firstlab.jpa.Expenditure;
import com.firstlab.jpa.Staff;
import com.firstlab.repository.FirmRepository;
import com.firstlab.repository.StaffRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Aggregation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffMethods {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private FirmRepository firmRepository;

    public StaffMethods(StaffRepository staffRepository, FirmRepository firmRepository) {
        this.staffRepository = staffRepository;
        this.firmRepository = firmRepository;
    }

    public  Long avgSalaryWithoutAggregation(){
        Long result = (long)0;
        List<Staff> temp = staffRepository.findAll();
        for( Staff st : temp){
            result+=st.getSalary();
        }
        return result/temp.size();
    }

    public  List<StaffAggOcupation> countOccupationWithoutAggregation(){
        List<Staff> temp = staffRepository.findAll();
        HashMap<String, Integer> countOccupation = new HashMap<>();
        for( Staff st : temp) {
            Integer frequency = countOccupation.get(st.getOccupation());
            countOccupation.put(st.getOccupation(), frequency == null ? 1 : frequency + 1);
        }
        List<StaffAggOcupation> result = new ArrayList<StaffAggOcupation>();
        for (Map.Entry<String, Integer> entry : countOccupation.entrySet()) {
            result.add(new StaffAggOcupation(entry.getKey(),entry.getValue()));
        }
        return result;
    }

    public  List<StaffAgg> maxSalaryFirmWithoutAggregation(){
        List<Staff> temp = staffRepository.findAll();
        HashMap<String, Integer> maxSalary = new HashMap<>();
        for( Staff st : temp) {
            Integer max = maxSalary.get(st.getFirm().getName());
            maxSalary.put(st.getFirm().getName(), max == null ? st.getSalary() : (st.getSalary()>max ? st.getSalary() : max ));
        }
        List<StaffAgg> result = new ArrayList<StaffAgg>();
        for (Map.Entry<String, Integer> entry : maxSalary.entrySet()) {
            result.add(new StaffAgg(firmRepository.findByName(entry.getKey()).get(),entry.getValue()));
        }
        return result;
    }

}
