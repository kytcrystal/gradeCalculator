package org.example;

public class Grade {
    private int numericGrade;

    public boolean getApproved() {
        return true;
    }

    public int getNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(int finalGrade) {
        this.numericGrade = finalGrade;
    }

    public boolean getCumLaude() {
        return false;
    }


}
