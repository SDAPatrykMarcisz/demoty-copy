package com.copy.demotywatorycopy.validation;

import com.copy.demotywatorycopy.model.votes.VoteType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValueInValidator implements ConstraintValidator<VoteValidType, String> {


    @Override
    public boolean isValid(String source, ConstraintValidatorContext constraintValidatorContext) {
        for(VoteType type : VoteType.values()){
            if(type.name().equals(source) || type.getType().equalsIgnoreCase(source)){
                return true;
            }
        }
        return false;
    }
}
