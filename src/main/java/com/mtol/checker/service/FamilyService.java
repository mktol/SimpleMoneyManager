package com.mtol.checker.service;

import com.mtol.checker.entity.Family;
import com.mtol.checker.entity.User;
import com.mtol.checker.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

/**
 * This class
 */
@Service
public class FamilyService { //TODO this class should be redisigned
    @Autowired
    private UserService userService;
    @Autowired
    private FamilyRepository familyRepository;

    @ResponseBody
    public String createFamily(String name){
        Family family = new Family();
        family.setName(name);
        User user = userService.getCurrentUser();
        family.addUser(user);
        familyRepository.save(family);
        return name;
    }

    /**
     * Connect to existing family by member of this family email;
     * @param memberEmail
     * @return
     */
    public String connectToExistingFamily(String memberEmail){
        Optional<User> memb = userService.getUserByEmail(memberEmail);
        User user = userService.getCurrentUser();
        User member  = memb.orElseThrow(()->new NotImplementedException());
        Family family = member.getFamily();
        if(family==null){
            //TODO create new family, or / end return error, and ask to create new family
        }
        user.addFamily(family);
        return null;
    }
}
