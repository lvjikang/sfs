package com.example.mongo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yangli01 implements Serializable {
    private static long yanglisid = 665487811021555l;
    private String[] Diagnosis_on_Admission;  //入院诊断
    private String[] Condition_on_hosipital;  //入院情况
    private String[] Discharge_af_Diagnosis;  //出院诊断
    private String[] Discharge_instructions;  //出院医嘱

    public Yangli01() {
    }

    public Yangli01(String[] diagnosis_on_Admission, String[] condition_on_hosipital, String[] discharge_af_Diagnosis, String[] discharge_instructions) {
        Diagnosis_on_Admission = diagnosis_on_Admission;
        Condition_on_hosipital = condition_on_hosipital;
        Discharge_af_Diagnosis = discharge_af_Diagnosis;
        Discharge_instructions = discharge_instructions;
    }

    public String[] getDiagnosis_on_Admission() {
        return Diagnosis_on_Admission;
    }

    public void setDiagnosis_on_Admission(String[] diagnosis_on_Admission) {
        Diagnosis_on_Admission = diagnosis_on_Admission;
    }

    public String[] getCondition_on_hosipital() {
        return Condition_on_hosipital;
    }

    public void setCondition_on_hosipital(String[] condition_on_hosipital) {
        Condition_on_hosipital = condition_on_hosipital;
    }

    public String[] getDischarge_af_Diagnosis() {
        return Discharge_af_Diagnosis;
    }

    public void setDischarge_af_Diagnosis(String[] discharge_af_Diagnosis) {
        Discharge_af_Diagnosis = discharge_af_Diagnosis;
    }

    public String[] getDischarge_instructions() {
        return Discharge_instructions;
    }

    public void setDischarge_instructions(String[] discharge_instructions) {
        Discharge_instructions = discharge_instructions;
    }

    @Override
    public String toString() {
        return "\n" +
                "入院诊断: " + Arrays.toString(Diagnosis_on_Admission) + "\n" +
                "入院情况: " + Arrays.toString(Condition_on_hosipital) + "\n" +
                "出院诊断: " + Arrays.toString(Discharge_af_Diagnosis) + "\n" +
                "出院医嘱: " + Arrays.toString(Discharge_instructions) + "\n";
    }
}
