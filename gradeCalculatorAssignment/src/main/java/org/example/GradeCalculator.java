package org.example;

public class GradeCalculator {

    public static Grade computeGrade(int labPoints, float examGrade) {
        Grade grade = new Grade();
        int extraExamGrade = 0;
        float finalLabPoints = computeLabPoints(labPoints, extraExamGrade);
        float finalExamGrade = examGrade * 15 / 10;
        float finalGrade = finalLabPoints + finalExamGrade + extraExamGrade;
        determineApprovedGrade(finalGrade, grade);
        determineNumericGrade(finalGrade, grade);
        determineCumLaude(finalGrade, grade);
        return grade;
    }

    public static float computeLabPoints(int labPoints, int extraExamGrade) {
        if (labPoints > 50) {
            int extraLabPoints = labPoints - 50;
            extraExamGrade = (int) Math.floor((double) extraLabPoints / 5);
            labPoints = 50;
        }
        return (float) (labPoints * 15) / 50;
    }


    private static void determineNumericGrade(float finalGrade, Grade grade) {
        if (finalGrade<18) {
            grade.setNumericGrade(null);
        } else if (finalGrade>30) {
            grade.setNumericGrade(30);
        } else {
            grade.setNumericGrade((int) finalGrade);
        }
    }

    private static void determineApprovedGrade(float finalGrade, Grade grade) {
        grade.setApproved(finalGrade>=18);
    }

    private static void determineCumLaude(float finalGrade, Grade grade) {
        grade.setCumLaude(finalGrade > 30);
    }


}