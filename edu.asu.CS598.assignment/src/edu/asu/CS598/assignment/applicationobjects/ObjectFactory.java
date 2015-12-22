
package edu.asu.CS598.assignment.applicationobjects;

import javax.xml.bind.annotation.XmlRegistry;



@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GradeBook }
     * 
     */
    public GradeBook createGradeBook() {
        return new GradeBook();
    }

    /**
     * Create an instance of {@link GradeBook.Grades }
     * 
     */
    public GradeBook.Grades createGradeBookGrades() {
        return new GradeBook.Grades();
    }

    /**
     * Create an instance of {@link GradeBook.Grades.Student }
     * 
     */
    public GradeBook.Grades.Student createGradeBookGradesStudent() {
        return new GradeBook.Grades.Student();
    }

    /**
     * Create an instance of {@link GradeBook.Grades.Student.AssignedWork }
     * 
     */
    public GradeBook.Grades.Student.AssignedWork createGradeBookGradesStudentAssignedWork() {
        return new GradeBook.Grades.Student.AssignedWork();
    }

    /**
     * Create an instance of {@link GradeBook.GradingSchema }
     * 
     */
    public GradeBook.GradingSchema createGradeBookGradingSchema() {
        return new GradeBook.GradingSchema();
    }

    /**
     * Create an instance of {@link GradeBook.Grades.Student.AssignedWork.GradedWork }
     * 
     */
    public GradeBook.Grades.Student.AssignedWork.GradedWork createGradeBookGradesStudentAssignedWorkGradedWork() {
        return new GradeBook.Grades.Student.AssignedWork.GradedWork();
    }

    /**
     * Create an instance of {@link GradeBook.GradingSchema.GradeItem }
     * 
     */
    public GradeBook.GradingSchema.GradeItem createGradeBookGradingSchemaGradeItem() {
        return new GradeBook.GradingSchema.GradeItem();
    }

}
