package com.dduongdev.entities;

import java.util.Objects;

public class FresherCandidate extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String graduatedFrom;
    public FresherCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }
    public FresherCandidate(String name, String birthdate, String address, String hometown, String phone,
                            String email, String graduationDate, String graduationRank,
                            String graduatedFrom) {
        super(name, birthdate, address, hometown, phone, email);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.graduatedFrom = graduatedFrom;
    }
    public String getGraduationDate() {
        return graduationDate;
    }
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }
    public String getGraduationRank() {
        return graduationRank;
    }
    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }
    public String getGraduatedFrom() {
        return graduatedFrom;
    }
    public void setGraduatedFrom(String graduatedFrom) {
        this.graduatedFrom = graduatedFrom;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((graduationDate == null) ? 0 : graduationDate.hashCode());
        result = prime * result + ((graduationRank == null) ? 0 : graduationRank.hashCode());
        result = prime * result + ((graduatedFrom == null) ? 0 : graduatedFrom.hashCode());
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
        FresherCandidate other = (FresherCandidate) obj;
        return Objects.equals(graduatedFrom, other.graduatedFrom)
                && Objects.equals(graduationDate, other.graduationDate)
                && Objects.equals(graduationRank, other.graduationRank);
    }
}
