package com.dduongdev.entities;

import java.util.Objects;

public class InternCandidate extends Candidate {
    private String majorStudying;
    private int currentSemester;
    private String schoolName;
    private String expectedGraduationDate;

    public InternCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

    public InternCandidate(String name, String birthdate, String address, String hometown, String phone, String email,
                           String majorStudying, int currentSemester, String schoolName, String expectedGraduationDate) {
        super(name, birthdate, address, hometown, phone, email);
        this.majorStudying = majorStudying;
        this.currentSemester = currentSemester;
        this.schoolName = schoolName;
        this.expectedGraduationDate = expectedGraduationDate;
    }

    public String getMajorStudying() {
        return majorStudying;
    }

    public void setMajorStudying(String majorStudying) {
        this.majorStudying = majorStudying;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getExpectedGraduationDate() {
        return expectedGraduationDate;
    }

    public void setExpectedGraduationDate(String expectedGraduationDate) {
        this.expectedGraduationDate = expectedGraduationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((majorStudying == null) ? 0 : majorStudying.hashCode());
        result = prime * result + currentSemester;
        result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
        result = prime * result + ((expectedGraduationDate == null) ? 0 : expectedGraduationDate.hashCode());
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
        InternCandidate other = (InternCandidate) obj;
        return currentSemester == other.currentSemester
                && Objects.equals(expectedGraduationDate, other.expectedGraduationDate)
                && Objects.equals(majorStudying, other.majorStudying) && Objects.equals(schoolName, other.schoolName);
    }
}
