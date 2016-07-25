package com.mtol.checker.service.validator;

import com.mtol.checker.entity.UserCreateForm;
import com.mtol.checker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Custom validate implementation
 */
@Component
public class UserCreateFormValidator implements Validator{
    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserCreateForm form = (UserCreateForm) o;
        validateEmail(errors, form);
        validatePasswords(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form){
        if(form.getPassword().length()<4){
            errors.reject("password", "Password is to short. Password must be more than 4 char");
        }
    }
    private void validateEmail(Errors errors, UserCreateForm form){
        if(userService.getUserByEmail(form.getEmail()).isPresent()){
            errors.reject("email", "This email already exist!");
        }
    }


}
