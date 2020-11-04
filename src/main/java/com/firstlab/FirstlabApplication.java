package com.firstlab;

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
import com.firstlab.migration.MongoSql;
import com.firstlab.migration.SqlMongo;
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
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

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
*/
        MongoRepository mongoRepositories[]={firmRepository,realmRepository,expenditureRepository,staffRepository};
        JpaRepository jpaRepositories[]={firmRepositorySql,realmRepositorySql,expenditureRepositorySql,staffRepositorySql};
       /* MongoSql test = new MongoSql(firmRepository,realmRepository,expenditureRepository,staffRepository,
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
      */ SqlMongo test = new SqlMongo(firmRepository,realmRepository,expenditureRepository,staffRepository,
                firmRepositorySql,expenditureRepositorySql,realmRepositorySql,staffRepositorySql);
        test.convertSqlToMongo(jpaRepositories);
}

}
