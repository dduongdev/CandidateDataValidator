package com.dduongdev.services;

import com.dduongdev.entities.Candidate;
import com.dduongdev.utils.IncorrectDataTypes;
import com.dduongdev.utils.Validator;
import com.dduongdev.entities.exceptions.IncorrectDataFormatException;

import java.util.HashSet;
import java.util.Set;

public abstract class CandidateService {
    /**
     * This method is used to check whether the common values of candidate's data
     * are valid or not.
     *
     * #method isValidCandidateData
     * @param data: String
     * @return Set<IncorrectDataTypes>
     */
    public Set<IncorrectDataTypes> isValidCandidateData(String data){
        String[] ss = data.split(",");
        for(int i=0; i< ss.length; i++) {
            ss[i] = ss[i].trim();
        }

        Set<IncorrectDataTypes> result = new HashSet<>();

        if(!Validator.isBirthdate(ss[2])) {
            result.add(IncorrectDataTypes.BRITHDATE_FORMAT);
        }

        if(!Validator.isPhone(ss[5])) {
            result.add(IncorrectDataTypes.PHONE_FORMAT);
        }

        if(!Validator.isEmail(ss[6])) {
            result.add(IncorrectDataTypes.EMAIL_FORMAT);
        }

        return result;
    }

    /**
     * Create a candidate by candidate data type.
     *
     * @method createCandidate
     * @param data: String
     * @return Candidate
     * @throws IncorrectDataFormatException
     */
    public abstract Candidate createCandidate(String data) throws IncorrectDataFormatException;
}
