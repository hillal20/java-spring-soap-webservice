package javaspringsoapwebservice.services;

import org.springframework.stereotype.Service;
import javaspringsoapwebservice.userGeneratedFromXML.User;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    //  we need to hard code data in this map
    private static final Map<String, User> usersMap = new HashMap<>();


    @PostConstruct
    public void initialize(){
        // we create the first user
        User peter = new User();
        peter.setName("peter");
        peter.setSalary(30000.88);
        peter.setEmpId(1);

        usersMap.put(peter.getName(), peter);


        User john = new User();
        john.setName("john");
        john.setSalary(30000.88);
        john.setEmpId(1);

        usersMap.put(john.getName(), john);

        User steve = new User();
        steve.setName("steve");
        steve.setSalary(30000.88);
        steve.setEmpId(1);

        usersMap.put(steve.getName(),steve);
    }



    public User getUserByName(String name){
        System.out.println("name ==> "+ name );
        return usersMap.get(name);
    }


}


