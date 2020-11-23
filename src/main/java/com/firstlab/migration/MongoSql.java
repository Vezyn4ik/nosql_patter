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
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;


public class MongoSql {
    private FirmRepository firmRepository;
    private RealmRepository realmRepository;
    private ExpenditureRepository expenditureRepository;
    private StaffRepository staffRepository;
    private FirmRepositorySql firmRepositorySql;
    private ExpenditureRepositorySql expenditureRepositorySql;
    private RealmRepositorySql realmRepositorySql;
    private StaffRepositorySql staffRepositorySql;

    public MongoSql(FirmRepository firmRepository, RealmRepository realmRepository, ExpenditureRepository expenditureRepository, StaffRepository staffRepository, FirmRepositorySql firmRepositorySql, ExpenditureRepositorySql expenditureRepositorySql, RealmRepositorySql realmRepositorySql, StaffRepositorySql staffRepositorySql) {
        this.firmRepository = firmRepository;
        this.realmRepository = realmRepository;
        this.expenditureRepository = expenditureRepository;
        this.staffRepository = staffRepository;
        this.firmRepositorySql = firmRepositorySql;
        this.expenditureRepositorySql = expenditureRepositorySql;
        this.realmRepositorySql = realmRepositorySql;
        this.staffRepositorySql = staffRepositorySql;
    }

    public void convertMongoToSql(MongoRepository mongoRepositories[])
    {
        for(int i =0;i<mongoRepositories.length;i++){
            List<Object> data=mongoRepositories[i].findAll();
            for(int j=0;j<data.size();j++){
                convertEntityMongoToSql(data.get(j));
            }
        }
    }

    public void convertEntityMongoToSql(Object mongo){
        if(mongo instanceof Expenditure){
            Optional<ExpenditureSql> exp=expenditureRepositorySql.findByTittle(((Expenditure) mongo).getTittle());
            if(exp.isEmpty()){
                expenditureRepositorySql.save(convertExpenditure((Expenditure) mongo));
            }
        }
        else if(mongo instanceof Firm){
            Optional<FirmSql> f=firmRepositorySql.findByName(((Firm) mongo).getName());
            if(f.isEmpty()){
                firmRepositorySql.save( convertFirm((Firm) mongo));
            }
        }
        else if(mongo instanceof Realm){
            Optional<RealmSql> r=realmRepositorySql.findByTittle(((Realm) mongo).getTittle());
            if(r.isEmpty()){
                realmRepositorySql.save( convertRealm((Realm) mongo));
            }
        }
        else if(mongo instanceof Staff){
            Optional<StaffSql> s=staffRepositorySql.findByName(((Staff) mongo).getName());
            if(s.isEmpty()){
                staffRepositorySql.save( convertStaff((Staff) mongo));
            }
        }
    }

    public ExpenditureSql convertExpenditure(Expenditure mongo){
        Optional<FirmSql> f=firmRepositorySql.findByName((mongo.getFirm()).getName());
        if(f.isEmpty()){
            f= Optional.ofNullable(convertFirm(mongo.getFirm()));
        }
        Optional<RealmSql> r=realmRepositorySql.findByTittle((mongo.getRealm()).getTittle());
        if(r.isEmpty()){
            r= Optional.ofNullable(convertRealm(mongo.getRealm()));
        }
        return new ExpenditureSql(mongo.getTittle(),
                mongo.getMoney(),mongo.getDescription(),f.get(),r.get());

    }
    public FirmSql convertFirm(Firm mongo){
        FirmSql f = new FirmSql(mongo.getName(),mongo.getAddress(),mongo.getContactNumber(),
                mongo.getManager(),mongo.getYear(),mongo.getIn());
        firmRepositorySql.save(f);
        return f;
    }
    public RealmSql convertRealm(Realm mongo){
        RealmSql r= new RealmSql(mongo.getTittle(),mongo.getDescription());
        realmRepositorySql.save(r);
        return r;
    }
    public StaffSql convertStaff(Staff mongo){
        Optional<FirmSql> f=firmRepositorySql.findByName((mongo.getFirm()).getName());
        if(f.isEmpty()){
            f= Optional.ofNullable(convertFirm(mongo.getFirm()));
        }
        return new StaffSql(mongo.getName(),mongo.getOccupation(),mongo.getEmail(),
                mongo.getPhone(),mongo.getSalary(),mongo.getDescription(),f.get());

    }
}
