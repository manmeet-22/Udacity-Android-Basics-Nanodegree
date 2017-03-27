import java.util.Arrays;

/**
 * ReportCard class for Udacity ABND P-5
 * there are 5 main subjects,
 *
 * The Grade system is as follows:
 * Marks Range | Grade | Grade Point
 * >90         | A1    | 10
 * 80-90       | A2    | 9
 * 70-80       | B1    | 8
 * 60-70       | B2    | 7
 * 50-60       | C1    | 6
 * 40-50       | C2    | 5
 * 33-40       | D     | 4
 * <33         | E     | -
 *
 * The marks of 5 different subjects shall be stored in variables:
 * marksCn, marksNmst, marksCst, marksPstc, marksDbms
 * Sequence of gradePoints and grades in 2 Arrays:
 * {CN, NMST, CST, PSTC, DBMS}
 */
public class ReportCard
{
    private String studentName;
    final private int NUMBER_OF_SUBJECTS = 5;
    /*5 subjects to store marks for*/
    private float marksCst;
    private float marksCn;
    private float marksNmst;
    private float marksPstc;
    private float marksDbms;

    private int gradePointArray[] = new int[NUMBER_OF_SUBJECTS];
    private String gradeArray[] = new String[NUMBER_OF_SUBJECTS];

    /* The Final CGPA of the student*/
    private float CGPA;

    /**
     * Constructor for the ReportCard class
     * The constructor Initializes marks as 0 for all subjects until the marks are added by a teacher
     * @param studentName The name of the student for whom to create the report
     */
    public ReportCard(String studentName)
    {
        this.studentName = studentName;
        setCnMarks(0);
        setCstMarks(0);
        setPstcMarks(0);
        setSecondLanguageMarks(0);
        setDbmsMarks(0);
    }

    /**
     * Sets the marks for Cn
     * @param marks for Cn subject
     */
    public void setCnMarks(float marks){
        this.marksCn =marks;
        gradePointArray[0] = getGradePoint(marks);
        gradeArray[0] = getGrade(gradePointArray[0]);
    }

    /**
     * Sets the marks for the Nmst
     * @param marks for the Nmst Subject
     */
    public void setNmstMarks(float marks){
        this.marksNmst = marks;
        gradePointArray[1] = getGradePoint(marks);
        gradeArray[1] = getGrade(gradePointArray[1]);
    }

    /**
     * Sets the marks for Cst
     * @param marks for Cst
     */
    public void setCstMarks(float marks){
        this.marksCst = marks;
        gradePointArray[2] = getGradePoint(marks);
        gradeArray[2] = getGrade(gradePointArray[2]);
    }

    /**
     * Sets the marks for Pstc
     * @param marks for Pstc
     */
    public void setPstcMarks(float marks){
        this.marksPstc = marks;
        gradePointArray[3] = getGradePoint(marks);
        gradeArray[3] = getGrade(gradePointArray[3]);
    }

    /**
     * Sets the marks for Social Pstc
     * @param marks for Social Pstc
     */
    public void setDbmsMarks(float marks){
        this.marksDbms = marks;
        gradePointArray[4] = getGradePoint(marks);
        gradeArray[4] = getGrade(gradePointArray[4]);
    }

    /**
     * Gets the marks for Cst
     */
    public float getMarksCst() {
        return marksCst;
    }

    /**
     * Gets the marks for Cn Language
     */
    public float getMarksCn() {
        return marksCn;
    }

    /**
     * Gets the marks for Second Language
     */
    public float getMarksNmst() {
        return marksNmst;
    }

    /**
     * Gets the marks for Pstc
     */
    public float getMarksPstc() {
        return marksPstc;
    }

    /**
     * Gets the marks for Social Pstc
     */
    public float getMarksDbms() {
        return marksDbms;
    }

    /**
     * Return the gradePoint for given parameters
     * @param marks checks these marks
     * @return grade of the subject
     */
    private int getGradePoint(float marks){
        if(marks>90){
            return 10;
        } else if(marks > 80){
            return 9;
        } else if(marks > 70){
            return 8;
        } else if(marks > 60){
            return 7;
        } else if(marks > 50){
            return 6;
        } else if(marks > 40){
            return 5;
        } else if(marks > 33){
            return 4;
        } else {
            return 0;
        }
    }

    /**
     * Return the grade for given parameters
     * @param gradePoint checks these marks
     * @return grade of the subject
     */
    private String getGrade(int gradePoint){
        switch (gradePoint){
            case 10:
                return "A1";
            case 9:
                return "A2";
            case 8:
                return "B1";
            case 7:
                return "B2";
            case 6:
                return "C1";
            case 5:
                return "C2";
            case 4:
                return "D";
            default:
                return "E1";
        }
    }

    /**
     * Calculates the marks for the student
     */
    public void calculateCGPA(){
        float cgpa = 0;
        for (int gradePoint : gradePointArray) {
            cgpa += gradePoint;
        }
        cgpa /= 5;
        this.CGPA = cgpa;
    }

    /**
     * Returns the CGPA of the student
     */
    public float getCGPA(){
        return CGPA;
    }

    /**
     * Returns the complete details of the class as a String
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReportCard{");
        sb.append("Student\'s Name='").append(studentName).append('\'');
        sb.append("\n NUMBER OF SUBJECTS=").append(NUMBER_OF_SUBJECTS);
        sb.append("\n marks in CN=").append(marksCn).append(" Grade Point: ").append(gradePointArray[0]).append(" Grade: ").append(gradeArray[0]);
        sb.append("\n marks in NMST=").append(marksNmst).append(" Grade Point: ").append(gradePointArray[1]).append(" Grade: ").append(gradeArray[1]);
        sb.append("\n marks in CST=").append(marksCst).append(" Grade Point: ").append(gradePointArray[2]).append(" Grade: ").append(gradeArray[2]);
        sb.append("\n marks in PSTC=").append(marksPstc).append(" Grade Point: ").append(gradePointArray[3]).append(" Grade: ").append(gradeArray[3]);
        sb.append("\n marks in DBMS=").append(marksDbms).append(" Grade Point: ").append(gradePointArray[4]).append(" Grade: ").append(gradeArray[4]);
        sb.append("\n CGPA=").append(CGPA);
        sb.append('}');
        return sb.toString();
    }
}
