package com.dduongdev.entities;

import com.dduongdev.utils.Validator;

import java.util.Objects;

public class ExperienceCandidate extends Candidate {
    private double yoe;
    private String specialistSkills;
    private String mostRecentCompany;

    public ExperienceCandidate() {
        super();
    }

    public ExperienceCandidate(String name, String birthdate, String address, String hometown, String phone,
                               String email, double yoe, String specialistSkills, String mostRecentCompany) {
        super(name, birthdate, address, hometown, phone, email);
        this.yoe = yoe;
        this.specialistSkills = specialistSkills;
        this.mostRecentCompany = mostRecentCompany;
    }

    public double getYoe() {
        return this.yoe;
    }

    public void setYoe(double yoe) {
        if(!Validator.isYOE(yoe))
            throw new IllegalArgumentException();
        yoe = (int)(yoe * 10);
        this.yoe = yoe / 10;
    }

    public String getSpecialistSkills() {
        return specialistSkills;
    }

    public void setSpecialistSkills(String specialistSkills) {
        this.specialistSkills = specialistSkills;
    }

    public String getMostRecentCompany() {
        return mostRecentCompany;
    }

    public void setMostRecentCompany(String mostRecentCompany) {
        this.mostRecentCompany = mostRecentCompany;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (int)yoe;
        result = prime * result + ((specialistSkills == null) ? 0 : specialistSkills.hashCode());
        result = prime * result + ((mostRecentCompany == null) ? 0 : mostRecentCompany.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ExperienceCandidate other = (ExperienceCandidate) obj;
        return Objects.equals(mostRecentCompany, other.mostRecentCompany)
                && Objects.equals(specialistSkills, other.specialistSkills)
                && Double.doubleToLongBits(yoe) == Double.doubleToLongBits(other.yoe);
    }
}
