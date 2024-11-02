package com.dduongdev.services;

import com.dduongdev.entities.Candidate;
import com.dduongdev.entities.ExperienceCandidate;
import com.dduongdev.entities.exceptions.IncorrectDataFormatException;
import com.dduongdev.utils.IncorrectDataTypes;
import com.dduongdev.utils.Validator;

import java.util.Set;

public class ExperienceCandidateService extends CandidateService {
    public ExperienceCandidateService() {
        super();
    }

    @Override
    public Set<IncorrectDataTypes> isValidCandidateData(String data){
        String[] ss = data.split(",");
        for(int i=0; i< ss.length; i++) {
            ss[i] = ss[i].trim();
        }

        Set<IncorrectDataTypes> result = super.isValidCandidateData(data);

        if(!Validator.isYOE(Double.parseDouble(ss[7]))) {
            result.add(IncorrectDataTypes.YOE);
        }

        for(int i = 10; i <= 16; i++) {
            if(!ss[i].equalsIgnoreCase("None")) {
                result.add(IncorrectDataTypes.EXCESS_DATA);;
                break;
            }
        }

        return result;
    }

    @Override
    public Candidate createCandidate(String data) throws IncorrectDataFormatException {
        if(!isValidCandidateData(data).isEmpty())
            throw new IncorrectDataFormatException();

        String[] ss = data.split(",");
        for(int i=0; i< ss.length; i++) {
            ss[i] = ss[i].trim();
        }

        ExperienceCandidate candidate = new ExperienceCandidate();
        candidate.setName(ss[1]);
        candidate.setBirthdate(ss[2]);
        candidate.setAddress(ss[3]);
        candidate.setHometown(ss[4]);
        candidate.setPhone(ss[5]);
        candidate.setEmail(ss[6]);
        candidate.setYoe(Double.parseDouble(ss[7]));
        candidate.setSpecialistSkills(ss[8]);
        candidate.setMostRecentCompany(ss[9]);

        return candidate;
    }
}
