package com.company;

public class SalarySchedule {
    private String paySchedule;

    Teacher teacher;
    public SalarySchedule(){
        teacher = new Teacher();
        paySchedule = generateSchedule();
    }
    public SalarySchedule(Teacher teacherPass){
        teacher = teacherPass;
        paySchedule = generateSchedule();
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    @Override
    public String toString() {
        return "SalarySchedule{" +
                "employee=" + teacher +
                '}';
    }
    public String generateSchedule(){
        String generateScheduleString;
        generateScheduleString = "Degree ";
        for (int i = 0; i < 20; i++){
            generateScheduleString += "Year " + (i+1) +" ";
        }
        generateScheduleString += System.lineSeparator();
        generateScheduleString += "Bachelor's ";
        for (int i = 0; i<20; i++){
            generateScheduleString += (int)(teacher.getBaseSalary()*(Math.pow(1.02, i)));
            generateScheduleString += " ";
        }
        generateScheduleString += System.lineSeparator();
        generateScheduleString += "Master's ";
        for (int i = 0; i<20; i++) {
            generateScheduleString += (int) (teacher.getBaseSalary() * (Math.pow(1.02, i)) * 1.2);
            generateScheduleString += " ";
        }
        generateScheduleString += System.lineSeparator();
        generateScheduleString += "PhD ";
        for (int i = 0; i<20; i++) {
            generateScheduleString += (int) (teacher.getBaseSalary() * (Math.pow(1.02, i)) * 1.4);
            generateScheduleString += " ";
        }
        return generateScheduleString;
    }
}
