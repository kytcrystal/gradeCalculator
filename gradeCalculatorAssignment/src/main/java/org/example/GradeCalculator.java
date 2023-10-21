package org.example;

public class GradeCalculator {

    public static final int FULL_LAB_POINTS = 50;
    public static final int FULL_EXAM_GRADE = 10;
    public static final int MAX_TOTAL_GRADE = 30;
    public static final int MIN_APPROVED_GRADE = 18;



    public static Grade computeGrade(int labPoints, float examGrade) {
        Grade grade = new Grade();
        int extraExamGrade = 0;
        if (labPoints > FULL_LAB_POINTS) {
            int extraLabPoints = labPoints - FULL_LAB_POINTS;
            extraExamGrade = (int) Math.floor((double) extraLabPoints / 5);
            labPoints = FULL_LAB_POINTS;
        }
        float finalLabPoints = (float) (labPoints * MAX_TOTAL_GRADE/2) / FULL_LAB_POINTS;
        float finalExamGrade = examGrade * (MAX_TOTAL_GRADE/2) / FULL_EXAM_GRADE;
        float finalGrade = (float) finalLabPoints + finalExamGrade + (int) extraExamGrade;
        determineApprovedGrade(finalGrade, grade);
        determineNumericGrade(finalGrade, grade);
        determineCumLaude(finalGrade, grade);
        return grade;
    }


    private static void determineNumericGrade(float finalGrade, Grade grade) {
        if (finalGrade<MIN_APPROVED_GRADE) {
            grade.setNumericGrade(null);
        } else if (finalGrade>MAX_TOTAL_GRADE) {
            grade.setNumericGrade(MAX_TOTAL_GRADE);
        } else {
            grade.setNumericGrade((int) finalGrade);
        }
    }

    private static void determineApprovedGrade(float finalGrade, Grade grade) {
        grade.setApproved(finalGrade>=MIN_APPROVED_GRADE);
    }

    private static void determineCumLaude(float finalGrade, Grade grade) {
        grade.setCumLaude(finalGrade > MAX_TOTAL_GRADE);
    }


}