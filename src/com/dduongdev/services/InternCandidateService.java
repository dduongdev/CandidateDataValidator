package com.dduongdev.services;

import com.dduongdev.entities.Candidate;
import com.dduongdev.entities.InternCandidate;
import com.dduongdev.entities.exceptions.IncorrectDataFormatException;
import com.dduongdev.utils.IncorrectDataTypes;

import java.util.Set;

public class InternCandidateService extends CandidateService {
    public InternCandidateService() {
        super();
    }

    @Override
    public Set<IncorrectDataTypes> isValidCandidateData(String data) {
        String[] ss = data.split(",");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = ss[i].trim();
        }

        Set<IncorrectDataTypes> result = super.isValidCandidateData(data);

        for (int i = 7; i <= 12; i++) {
            if (!ss[i].equalsIgnoreCase("None")) {
                result.add(IncorrectDataTypes.EXCESS_DATA);
                break;
            }
        }

        return result;
    }

    @Override
    public Candidate createCandidate(String data) throws IncorrectDataFormatException {
        if(!isValidCandidateData(data).isEmpty()) {
            throw new IncorrectDataFormatException();
        }

        String[] ss = data.split(",");
        for(int i=0; i< ss.length; i++) {
            ss[i] = ss[i].trim();
        }

        InternCandidate candidate = new InternCandidate();

        candidate.setName(ss[1]);
        candidate.setBirthdate(ss[2]);
        candidate.setAddress(ss[3]);
        candidate.setHometown(ss[4]);
        candidate.setPhone(ss[5]);
        candidate.setEmail(ss[6]);
        candidate.setMajorStudying(ss[13]);
        candidate.setCurrentSemester(Integer.parseInt(ss[14]));
        candidate.setSchoolName(ss[15]);
        candidate.setExpectedGraduationDate(ss[16]);

        return candidate;
    }
}
