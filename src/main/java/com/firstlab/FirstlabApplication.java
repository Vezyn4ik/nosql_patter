package com.firstlab;

import com.firstlab.aggregation.ExpAg;
import com.firstlab.aggregation.FirmAg;
import com.firstlab.aggregation.StaffAgg;
import com.firstlab.aggregation.StaffAggOcupation;
import com.firstlab.aggregation.methods.ExpenditureMethods;
import com.firstlab.aggregation.methods.StaffMethods;
import com.firstlab.jpa.Expenditure;
import com.firstlab.jpa.Firm;
import com.firstlab.jpa.Realm;
import com.firstlab.jpa.Staff;
import com.firstlab.jpa.sql.ExpenditureSql;
import com.firstlab.jpa.sql.FirmSql;
import com.firstlab.jpa.sql.RealmSql;
import com.firstlab.jpa.sql.StaffSql;
import com.firstlab.map.Mapper;
import com.firstlab.map.create.CreateExpenditureMapper;
import com.firstlab.map.create.CreateFirmMapper;
import com.firstlab.map.create.CreateMapper;
import com.firstlab.memento.Caretaker;
import com.firstlab.migration.MongoSql;
import com.firstlab.migration.SqlMongo;
import com.firstlab.observer.ObjectObservable;
import com.firstlab.repository.ExpenditureRepository;
import com.firstlab.repository.FirmRepository;
import com.firstlab.repository.RealmRepository;
import com.firstlab.repository.StaffRepository;
import com.firstlab.repositorySQL.ExpenditureRepositorySql;
import com.firstlab.repositorySQL.FirmRepositorySql;
import com.firstlab.repositorySQL.RealmRepositorySql;
import com.firstlab.repositorySQL.StaffRepositorySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@EnableMongoRepositories(basePackageClasses = FirmRepository.class) //,RealmRepository.class,ExpenditureRepository.class)
//@EnableJpaRepositories(basePackageClasses = FirmRepositorySql.class)
@SpringBootApplication
public class FirstlabApplication implements CommandLineRunner {
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private RealmRepository realmRepository;
    @Autowired
    private ExpenditureRepository expenditureRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private FirmRepositorySql firmRepositorySql;
    @Autowired
    private ExpenditureRepositorySql expenditureRepositorySql;
    @Autowired
    private RealmRepositorySql realmRepositorySql;
    @Autowired
    private StaffRepositorySql staffRepositorySql;

    public static void main(String[] args) {
        SpringApplication.run(FirstlabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//test mongodb
       /* realmRepository.save(new Realm("heelo","descr"));
        //add
      //  firmRepository.insert(new Firm.Builder("АВТОМАГИСТРАЛЬ-ЮГ", (long) 241745765, "Николай Тимофеев").address("Киев, ул. Воробина").build());

firmRepository.insert(new Firm.Builder("АВТОМАГИСТРАЛЬ", (long) 241575, "Николай Тищук").contactNumber("+380950751655").build());

        realmRepository.insert(new Realm.Builder("Инфраструктура")
                .description(" комплекс взаимосвязанных обслуживающих структур обеспечивающих основу функционирования системы").build());
        expenditureRepository.insert(new Expenditure.Builder("Расходы на постройку дороги на участке Н-32 Днепр — Решетиловка", 30101).
                firm(new Firm.Builder("АВТОМАГИСТРАЛЬ-ЮГ", (long) 241745765, "Николай Тимофеев").address("Киев, ул. Воробина").build())
                .realm(new Realm.Builder("Инфраструктура").build()).build());

        //find all
        System.out.println("Firms found with findAll():");
        System.out.println("-------------------------------");
        for (Firm firm : firmRepository.findAll()) {
            System.out.println(firm);
        }
        System.out.println();

        //update
        Firm f = firmRepository.findFirstByName("АВТОМАГИСТРАЛЬ");
        f.setName("АВТОМАГИСТРАЛЬ-СЕВЕР");
        firmRepository.save(f);

        //find by name
        System.out.println("Firm found with findByName():");
        System.out.println("-------------------------------");
        System.out.println(firmRepository.findFirstByName("АВТОМАГИСТРАЛЬ-СЕВЕР"));
        System.out.println();

        //delete by money
        firmRepository.deleteFirmByInLessThan((long) 24176);

        System.out.println("Firms found with findAll():");
        System.out.println("-------------------------------");
        for (Firm firm : firmRepository.findAll()) {
            System.out.println(firm);
        }
        System.out.println();
        System.out.println("Update");
        if (firmRepository.update("АВТОМАГИСТРАЛЬ-ЮГ", "Строим дороги.")) {
            System.out.println("Success");
        } else {
            System.out.println("Error");
        }

        System.out.println(SingletonLog.getInstance().getLastAction());

        f = firmRepository.findFirstByName("АВТОМАГИСТРАЛЬ-СЕВЕР");
        CreateMapper c = new CreateFirmMapper();
        Mapper fe = c.factoryMethod();
        System.out.println(fe.convertToDto(f));

        System.out.println(fe.convertToDocument(fe.convertToDto(f)));

        Expenditure f2 = expenditureRepository.findFirstByTittle("Расходы на постройку дороги на участке Н-32 Днепр — Решетиловка");
        CreateMapper c2 = new CreateExpenditureMapper();
        Mapper fe2 = c2.factoryMethod();
        System.out.println(fe2.convertToDto(f2));

        System.out.println(fe2.convertToDocument(fe2.convertToDto(f2)));

*/

        // time test
/*
        System.out.println("Insert");
        //add 100
       // Firm f = new Firm("АВТОМАГИСТРАЛЬ-ЮГ", (long) 241745765, "Николай Тимофеев");
        long startTime = System.nanoTime();

        for (int i =0 ;i<10000;i++){
           realmRepository.insert(new Realm("Инфраструктура"));
        }
        long endTime = System.nanoTime();
        System.out.println("Mongo db , 10000 insert");
        System.out.println((double)(endTime-startTime)/1000000000);

        startTime = System.nanoTime();
        for (int i =0 ;i<10000;i++){
            realmRepositorySql.save(new RealmSql("Инфраструктура"));
        }
        endTime = System.nanoTime();
        System.out.println("MySQL, 10000 insert");
        System.out.println((double)(endTime-startTime)/1000000000);


        System.out.println("Select");
        //select 100
         startTime = System.nanoTime();
        for (int i =0 ;i<10000;i++){
            firmRepository.findAllByManager("Николай Тимофеев");
        }
         endTime = System.nanoTime();
        System.out.println("Mongo db , 10000 select");
        System.out.println((double)(endTime-startTime)/1000000000);
        startTime = System.nanoTime();
        for (int i =0 ;i<10000;i++){
            firmRepositorySql.findAllByManager("Николай Тимофеев");
        }
        endTime = System.nanoTime();
        System.out.println("MySQL, 10000 select");
        System.out.println((double)(endTime-startTime)/1000000000);
*/
/*
        //test sql
        System.out.println("Sql , Firm insert");
        FirmSql f=new FirmSql.Builder("АВТОМАГИСТРАЛЬ-ЮГ", (long) 241745765, "Николай Тимофеев").address("Киев, ул. Воробина").contactNumber("+35321532").build();

        firmRepositorySql.save(f);
        System.out.println("Sql, Firm update manager");
        firmRepositorySql.updateFirmSetManagerForId("Иван Тимофеев",f.getId());
        System.out.println("Sql, Firm find all");
        for (FirmSql firm : firmRepositorySql.findAll()) {
            System.out.println(firm);
        }
        System.out.println("Sql , Realm insert");
        RealmSql r=new RealmSql.Builder("Инфраструктура").description("Описание").build();
        realmRepositorySql.save(r);

        System.out.println("Sql , Expenditure insert");
        ExpenditureSql e1=new ExpenditureSql.Builder("Расходы на постройку дороги на участке Н-32 Днепр — Решетиловка", 30101).firm(f).realm(r).build();
       expenditureRepositorySql.save(e1);
        ExpenditureSql e2=new ExpenditureSql.Builder("Расходы на постройку дороги на участке Н-33", 90101).firm(f).realm(r).build();
        expenditureRepositorySql.save(e2);
        ExpenditureSql e3=new ExpenditureSql.Builder("Расходы на постройку дороги на участке Н-13", 60101).firm(f).realm(r).build();
        expenditureRepositorySql.save(e3);
        System.out.println("Sql , Expenditure find all");
        for (ExpenditureSql firm : expenditureRepositorySql.findAll()) {
            System.out.println(firm);
        }
        System.out.println("Sql , Expenditure find all by tittle");
        for (ExpenditureSql firm : expenditureRepositorySql.findAllByTittle("Расходы на постройку дороги на участке Н-13")) {
            System.out.println(firm);
        }
        System.out.println("Sql , Expenditure find all by order");
        for (ExpenditureSql firm : expenditureRepositorySql.findAllByOrderByMoney()) {
            System.out.println(firm);
        }
        System.out.println("Sql , Expenditure delete by tittle");
        expenditureRepositorySql.deleteByTittle("Расходы на постройку дороги на участке Н-13");
        */
 /*       Firm f=new Firm.Builder("АВТОМАГИСТРАЛЬ-ЮГ", (long) 241745765, "Николай Тимофеев").address("Киев, ул. Воробина").build();

        firmRepository.save(f);
        firmRepository.save(new Firm.Builder("АВТОМАГИСТРАЛЬ", (long) 241575, "Николай Тищук").contactNumber("+380950751655").build());

        realmRepository.save(new Realm.Builder("Инфраструктура")
                .description(" комплекс взаимосвязанных обслуживающих структур обеспечивающих основу функционирования системы").build());
        expenditureRepository.save(new Expenditure.Builder("Расходы на постройку дороги на участке Н-32 Днепр — Решетиловка", 30101).
                firm(new Firm.Builder("АВТОМАГИСТРАЛЬ-ЮГ", (long) 241745765, "Николай Тимофеев").address("Киев, ул. Воробина").build())
                .realm(new Realm.Builder("Инфраструктура").build()).build());

        staffRepository.save(new Staff("Vlad", "manager", "vlad@nure.ua", (long)125323, 50000, "descr",f));

        MongoRepository mongoRepositories[]={firmRepository,realmRepository,expenditureRepository,staffRepository};
        JpaRepository jpaRepositories[]={firmRepositorySql,realmRepositorySql,expenditureRepositorySql,staffRepositorySql};
        MongoSql test = new MongoSql(firmRepository,realmRepository,expenditureRepository,staffRepository,
                firmRepositorySql,expenditureRepositorySql,realmRepositorySql,staffRepositorySql);
        test.convertMongoToSql(mongoRepositories);

        FirmSql f=new FirmSql.Builder("АВТОМАГИСТРАЛЬ-Север3", (long) 241745765, "Николай Тимофеев").address("Киев, ул. Воробина").build();

        firmRepositorySql.save(f);
        RealmSql r =new RealmSql.Builder("Инфраструктура,дороги")
                .description(" комплекс взаимосвязанных обслуживающих структур обеспечивающих основу функционирования системы").build();
        realmRepositorySql.save(r);
        expenditureRepositorySql.save(new ExpenditureSql.Builder("Расходы на постройку дороги на участке Н-35 Днепр — Харьков", 30101).
                firm(f).realm(r).build());

        staffRepositorySql.save(new StaffSql("Василий", "manager", "vlad@nure.ua", (long)125323, 50000, "descr",f));
       SqlMongo test = new SqlMongo(firmRepository,realmRepository,expenditureRepository,staffRepository,
                firmRepositorySql,expenditureRepositorySql,realmRepositorySql,staffRepositorySql);
        test.convertSqlToMongo(jpaRepositories);
        */

        // migration();
       //replication();
       // observer();
      //  memento();
        aggregation();

    }

    void migration() {
        MongoRepository mongoRepositories[] = {firmRepository, realmRepository, expenditureRepository, staffRepository};
        JpaRepository jpaRepositories[] = {firmRepositorySql, realmRepositorySql, expenditureRepositorySql, staffRepositorySql};
        MongoSql test = new MongoSql(firmRepository, realmRepository, expenditureRepository, staffRepository,
                firmRepositorySql, expenditureRepositorySql, realmRepositorySql, staffRepositorySql);
        test.convertMongoToSql(mongoRepositories);

        SqlMongo test2 = new SqlMongo(firmRepository, realmRepository, expenditureRepository, staffRepository,
                firmRepositorySql, expenditureRepositorySql, realmRepositorySql, staffRepositorySql);
        test2.convertSqlToMongo(jpaRepositories);
    }

    void replication() throws Exception {
        firmRepository.deleteAll();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            firmRepository.save(new Firm.Builder("АВТОМАГИСТРАЛЬ" + i, (long) 241575 + i, "Николай Тищук").contactNumber("+380950751655").build());
        }
        long endTime = System.nanoTime();
        System.out.println("Insert: " + (double) (endTime - startTime) / 1000000000);
        startTime = System.nanoTime();
        List<Firm> firms = firmRepository.findAll();
        endTime = System.nanoTime();
        System.out.println("Select: " + (double) (endTime - startTime) / 1000000000);
    }

    void observer() {
        ObjectObservable objectObservable = new ObjectObservable();
        objectObservable.registerObserver(SingletonLog.getInstance());

        firmRepository.save(new Firm.Builder("АВТОМАГИСТРАЛЬ_Укр", (long) 241575, "Николай Тищук").contactNumber("+380950751655").build());
        objectObservable.notifyObservers("insert", "firm");

        realmRepository.insert(new Realm.Builder("Инфраструктура_Укр")
                .description(" комплекс взаимосвязанных обслуживающих структур обеспечивающих основу функционирования системы").build());
        objectObservable.notifyObservers("insert", "realm");

        expenditureRepository.insert(new Expenditure.Builder("Расходы на постройку дороги на участке Н-3 Днепр — Решетиловка", 30101).
                firm(new Firm.Builder("АВТОМАГИСТРАЛЬ-Центр", (long) 241745765, "Николай Тимофеев").address("Киев, ул. Воробина").build())
                .realm(new Realm.Builder("Инфраструктура_Запад").build()).build());
        objectObservable.notifyObservers("insert", "Expenditure");
        firmRepository.deleteFirmByInLessThan((long) 24176);
        objectObservable.notifyObservers("delete", "firm");
        firmRepository.update("АВТОМАГИСТРАЛЬ-ЮГ", "Строим дороги.");
        objectObservable.notifyObservers("update", "firm");
        System.out.println(SingletonLog.getInstance().getAllActions());
    }

    void memento() {
        Caretaker caretaker = new Caretaker();
        Firm f = new Firm.Builder("Memento", (long) 241575, "Николай Тищук").contactNumber("+380950751655").build();
        firmRepository.insert(f);
        caretaker.addMemento(f.saveState());
        f.setYear(2016);
        firmRepository.update(f);
        caretaker.addMemento(f.saveState());
        f.setContactNumber("+380950661764");
        firmRepository.update(f);
        caretaker.addMemento(f.saveState());
        f.setManager("Виталий Бобриков");
        firmRepository.update(f);
        caretaker.addMemento(f.saveState());
        f.restoreState(caretaker.getMemento(1));
        System.out.println(f.toString());
    }

    void aggregation() {
        StaffMethods sm = new StaffMethods(staffRepository,firmRepository);
        ExpenditureMethods em=new ExpenditureMethods(expenditureRepository,firmRepository);

        long startTime = System.nanoTime();
                for (StaffAgg staff : staffRepository.maxSalaryFirm()) {
            System.out.println(staff);
        }
       long endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);


        startTime = System.nanoTime();
        for (StaffAgg staff : sm.maxSalaryFirmWithoutAggregation()) {
            System.out.println(staff);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        startTime = System.nanoTime();
        for (StaffAggOcupation staff : staffRepository.countOccupation()) {
            System.out.println(staff);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);


        startTime = System.nanoTime();
        for (StaffAggOcupation staff : sm.countOccupationWithoutAggregation()) {
            System.out.println(staff);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        startTime = System.nanoTime();
        System.out.println(staffRepository.avgSalary());
         endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

        startTime = System.nanoTime();
        System.out.println(sm.avgSalaryWithoutAggregation());
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

         startTime = System.nanoTime();
        for (ExpAg expAg : expenditureRepository.sumLostMoneyFirm()) {
            System.out.println(expAg);
        }
         endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);


        startTime = System.nanoTime();
        for (ExpAg expAg : em.sumLostMoneyFirmWithoutAggregation()) {
            System.out.println(expAg);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);


        startTime = System.nanoTime();
        for (ExpAg expAg : expenditureRepository.maxLostMoneyFirm()) {
            System.out.println(expAg);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);


        startTime = System.nanoTime();
        for (ExpAg expAg : em.maxLostMoneyFirmWithoutAggregation()) {
            System.out.println(expAg);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);


        startTime = System.nanoTime();
        for (Expenditure expenditure : expenditureRepository.matchFirmName()) {
            System.out.println(expenditure);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);


        startTime = System.nanoTime();
        for (Expenditure expenditure : expenditureRepository.findAllByFirm(firmRepository.findByName("АВТОМАГИСТРАЛЬ-Север3").get())) {
            System.out.println(expenditure);
        }
        endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000);

    }
    }