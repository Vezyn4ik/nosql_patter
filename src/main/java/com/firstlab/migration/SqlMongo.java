package com.firstlab.migration;

import com.firstlab.jpa.Expenditure;
import com.firstlab.jpa.Firm;
import com.firstlab.jpa.Realm;
import com.firstlab.jpa.Staff;
import com.firstlab.jpa.sql.ExpenditureSql;
import com.firstlab.jpa.sql.FirmSql;
import com.firstlab.jpa.sql.RealmSql;
import com.firstlab.jpa.sql.StaffSql;
import com.firstlab.repository.ExpenditureRepository;
import com.firstlab.repository.FirmRepository;
import com.firstlab.repository.RealmRepository;
import com.firstlab.repository.StaffRepository;
import com.firstlab.repositorySQL.ExpenditureRepositorySql;
import com.firstlab.repositorySQL.FirmRepositorySql;
import com.firstlab.repositorySQL.RealmRepositorySql;
import com.firstlab.repositorySQL.StaffRepositorySql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public class SqlMongo {
    private FirmRepository firmRepository;
    private RealmRepository realmRepository;
    private ExpenditureRepository expenditureRepository;
    private StaffRepository staffRepository;
    private FirmRepositorySql firmRepositorySql;
    private ExpenditureRepositorySql expenditureRepositorySql;
    private RealmRepositorySql realmRepositorySql;
    private StaffRepositorySql staffRepositorySql;

    public SqlMongo(FirmRepository firmRepository, RealmRepository realmRepository, ExpenditureRepository expenditureRepository, StaffRepository staffRepository, FirmRepositorySql firmRepositorySql, ExpenditureRepositorySql expenditureRepositorySql, RealmRepositorySql realmRepositorySql, StaffRepositorySql staffRepositorySql) {
        this.firmRepository = firmRepository;
        this.realmRepository = realmRepository;
        this.expenditureRepository = expenditureRepository;
        this.staffRepository = staffRepository;
        this.firmRepositorySql = firmRepositorySql;
        this.expenditureRepositorySql = expenditureRepositorySql;
        this.realmRepositorySql = realmRepositorySql;
        this.staffRepositorySql = staffRepositorySql;
    }

    public void convertSqlToMongo(JpaRepository jpaRepositories[])
    {
        for(int i =0;i<jpaRepositories.length;i++){
            List<Object> data=jpaRepositories[i].findAll();
            for(int j=0;j<data.size();j++){
                convertEntitySqlToMongo(data.get(j));
            }
        }
    }

    public void convertEntitySqlToMongo(Object jpa){
        if(jpa instanceof ExpenditureSql){
            Optional<Expenditure> exp=expenditureRepository.findByTittle(((ExpenditureSql) jpa).getTittle());
            if(exp.isEmpty()){
                expenditureRepository.save(convertExpenditure((ExpenditureSql) jpa));
            }
        }
        else if(jpa instanceof FirmSql){
            Optional<Firm> f=firmRepository.findByName(((FirmSql) jpa).getName());
            if(f.isEmpty()){
                firmRepository.save( convertFirm((FirmSql) jpa));
            }
        }
        else if(jpa instanceof RealmSql){
            Optional<Realm> r=realmRepository.findByTittle(((RealmSql) jpa).getTittle());
            if(r.isEmpty()){
                realmRepository.save( convertRealm((RealmSql) jpa));
            }
        }
        else if(jpa instanceof StaffSql){
            Optional<Staff> s=staffRepository.findByName(((StaffSql) jpa).getName());
            if(s.isEmpty()){
                staffRepository.save( convertStaff((StaffSql) jpa));
            }
        }
    }

    public Expenditure convertExpenditure(ExpenditureSql jpa){
        Optional<Firm> f=firmRepository.findByName((jpa.getFirmSql()).getName());
        Optional<Realm> r=realmRepository.findByTittle((jpa.getRealmSql()).getTittle());
        return new Expenditure(jpa.getTittle(),jpa.getMoney(),jpa.getDescription(),f.get(),r.get());

    }
    public Firm convertFirm(FirmSql jpa){
        return new Firm(jpa.getName(),jpa.getAddress(),jpa.getIndetification_number(),
                jpa.getContactNumber(), jpa.getManager(),jpa.getYear());
    }
    public Realm convertRealm(RealmSql jpa){
        return new Realm(jpa.getTittle(),jpa.getDescription());
    }
    public Staff convertStaff(StaffSql jpa){
        Optional<Firm> f=firmRepository.findByName((jpa.getFirmSql()).getName());
        return new Staff(jpa.getName(),jpa.getOccupation(),jpa.getEmail(),
                jpa.getPhone(),jpa.getSalary(),jpa.getDescription(),f.get());

    }
}