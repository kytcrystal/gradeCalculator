package org.example;

import java.util.Dictionary;
import java.util.Hashtable;

public class GradeCalculator {

    public static final int FULL_LAB_POINTS = 50;
    public static final int FULL_EXAM_GRADE = 10;
    public static final int MAX_TOTAL_GRADE = 30;
    public static final int MIN_APPROVED_GRADE = 18;



    public static Grade computeGrade(int labPoints, float examGrade) throws Exception {
        if (!validateInputs(labPoints,examGrade)) {
            throw new Exception("Value out of range");
        }
        Grade grade = new Grade();
        Dictionary<String, Integer> labPointsDict = computeLabPoints(labPoints);
        float finalLabPoints = (float) (labPointsDict.get("ComputedLabPoints") * MAX_TOTAL_GRADE/2) / FULL_LAB_POINTS;
        float finalExamGrade = examGrade * (MAX_TOTAL_GRADE/2) / FULL_EXAM_GRADE;
        float finalGrade = finalLabPoints + finalExamGrade + labPointsDict.get("ExtraExamGrade");
        determineApprovedGrade(finalGrade, grade);
        determineNumericGrade(finalGrade, grade, labPointsDict.get("ComputedLabPoints"));
        determineCumLaude(finalGrade, grade,labPointsDict.get("UnusedLabPoints"));
        return grade;
    }

    public static boolean validateInputs(int labPoints, float examGrade) {
        return labPoints >= 0 && examGrade >= 0 && examGrade <= 10;
    }


    public static Dictionary<String, Integer> computeLabPoints(int labPoints) {
        Dictionary<String, Integer> labPointsDictionary = new Hashtable<>();
        labPointsDictionary.put("ExtraExamGrade", 0);
        labPointsDictionary.put("UnusedLabPoints", 0);
        labPointsDictionary.put("ComputedLabPoints", labPoints);
        if (labPoints > FULL_LAB_POINTS) {
            int extraLabPoints = labPoints - FULL_LAB_POINTS;
            int extraExamGrade = (int) Math.floor((double) extraLabPoints / 5);
            if (extraExamGrade>3) {
                extraExamGrade = 3;
            }
            labPointsDictionary.put("ExtraExamGrade", extraExamGrade);
            labPointsDictionary.put("ComputedLabPoints", FULL_LAB_POINTS);
            int unusedLabPoints = extraLabPoints - extraExamGrade * 5;
            labPointsDictionary.put("UnusedLabPoints", unusedLabPoints);
        }
        return labPointsDictionary;
    }


    private static void determineNumericGrade(float finalGrade, Grade grade, int labPoints) {
        if (finalGrade<MIN_APPROVED_GRADE) {
            grade.setNumericGrade(null);
        } else if (finalGrade>=MAX_TOTAL_GRADE) {
            grade.setNumericGrade(MAX_TOTAL_GRADE);
        } else {
            if (labPoints<25) {
                grade.setNumericGrade((int) finalGrade);
            } else if (labPoints>40) {
                grade.setNumericGrade(finalGrade%1>0 ? (int) finalGrade + 1 : (int) finalGrade);
            }
            else {
                grade.setNumericGrade(Math.round(finalGrade));
            }
        }
    }

    private static void determineApprovedGrade(float finalGrade, Grade grade) {
        grade.setApproved(finalGrade>=MIN_APPROVED_GRADE);
    }

    private static void determineCumLaude(float finalGrade, Grade grade, int unusedLabPoints) {
        grade.setCumLaude((finalGrade > MAX_TOTAL_GRADE) || (finalGrade == MAX_TOTAL_GRADE && unusedLabPoints > 0));
    }


}