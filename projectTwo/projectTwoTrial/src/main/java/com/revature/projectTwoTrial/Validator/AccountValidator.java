package com.revature.projectTwoTrial.Validator;

import com.revature.projectTwoTrial.Entity.UserEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class AccountValidator implements org.springframework.validation.Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserEntity.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        UserEntity userEntity = (UserEntity) target;

        if(userEntity.getName().contains("$")){
            errors.reject("name", "Can't contain $");
        } if(userEntity.getId() < 0){
            errors.reject("id", "id cannot be negative");
        }
    }
    public boolean testString(String s){
        for(int i = 0; i < s.length(); i++){
            int ascii = (int) s.charAt(i);
            if(ascii == 4)  return false;
        }   return true;
    }
}
