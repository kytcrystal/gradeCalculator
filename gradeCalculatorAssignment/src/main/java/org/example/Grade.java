package org.example;

public class Grade {
    private Integer numericGrade;
    private boolean gradeApproved;

    public boolean getApproved() {
        return gradeApproved;
    }

    public void setApproved(boolean isApproved) {
        this.gradeApproved = isApproved;
    }

    public Integer getNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(Integer finalGrade) {
        this.numericGrade = finalGrade;
    }

    public boolean getCumLaude() {
        return false;
    }

}
