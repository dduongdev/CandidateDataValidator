package com.dduongdev.services;

import com.dduongdev.entities.Candidate;
import com.dduongdev.entities.FresherCandidate;
import com.dduongdev.entities.exceptions.IncorrectDataFormatException;
import com.dduongdev.utils.IncorrectDataTypes;

import java.util.Set;

public class FresherCandidateService extends CandidateService {
    public FresherCandidateService() {
        super();
    }

    @Override
    public Set<IncorrectDataTypes> isValidCandidateData(String data) {
        String[] ss = data.split(",");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = ss[i].trim();
        }

        Set<IncorrectDataTypes> result = super.isValidCandidateData(data);

        for (int i = 7; i <= 16; i++) {
            if (i == 10) {
                i = 13;
            }

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

        FresherCandidate candidate = new FresherCandidate();

        candidate.setName(ss[1]);
        candidate.setBirthdate(ss[2]);
        candidate.setAddress(ss[3]);
        candidate.setHometown(ss[4]);
        candidate.setPhone(ss[5]);
        candidate.setEmail(ss[6]);
        candidate.setGraduationDate(ss[10]);
        candidate.setGraduationRank(ss[11]);
        candidate.setGraduatedFrom(ss[12]);

        return candidate;
    }
}
