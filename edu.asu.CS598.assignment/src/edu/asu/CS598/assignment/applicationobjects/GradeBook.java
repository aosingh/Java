package edu.asu.CS598.assignment.applicationobjects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.map.annotate.JsonRootName;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gradingSchema",
    "grades"
})
@XmlRootElement(name = "GradeBook")
@JsonRootName(value = "GradeBook")
public class GradeBook {

    @XmlElement(name = "GradingSchema", required = false)
    protected GradeBook.GradingSchema gradingSchema;
    @XmlElement(name = "Grades", required = false)
    protected GradeBook.Grades grades;
    @XmlAttribute(name = "class")
    protected String clazz;

    /**
     * Gets the value of the gradingSchema property.
     * 
     * @return
     *     possible object is
     *     {@link GradeBook.GradingSchema }
     *     
     */
    @JsonProperty("GradingSchema")
    public GradeBook.GradingSchema getGradingSchema() {
        return gradingSchema;
    }

    /**
     * Sets the value of the gradingSchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link GradeBook.GradingSchema }
     *     
     */
    @JsonProperty("GradingSchema")
    public void setGradingSchema(GradeBook.GradingSchema value) {
        this.gradingSchema = value;
    }

    /**
     * Gets the value of the grades property.
     * 
     * @return
     *     possible object is
     *     {@link GradeBook.Grades }
     *     
     */
    @JsonProperty("Grades")
    public GradeBook.Grades getGrades() {
        return grades;
    }

    /**
     * Sets the value of the grades property.
     * 
     * @param value
     *     allowed object is
     *     {@link GradeBook.Grades }
     *     
     */
    @JsonProperty("Grades")
    public void setGrades(GradeBook.Grades value) {
        this.grades = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @JsonProperty("-class")
    public String getClazz() {
        return clazz;
    }
    
    @JsonSetter("_class")
    private void setGradeBookClass(String value) {
        if (this.clazz == null) {
            setClazz(value);
        }
    }


    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @JsonProperty("-class")
    public void setClazz(String value) {
        this.clazz = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "student"
    })
    public static class Grades {

        @XmlElement(name = "Student")
        protected List<GradeBook.Grades.Student> student;

        /**
         * Gets the value of the student property.
         * 
         * <p>
         * This accessor method returns a reference to the liveGradeBook       * not a snapshot. Therefore any modification you make to the
         * returned list willGradeBookt inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the student property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         * GradeBookent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the followGradeBook) are allowed in the list
         * {@link GradeBook.Grades.Student }
         * 
         * 
         */
        @JsonProperty("Student")
        public List<GradeBook.Grades.Student> getStudent() {
            if (student == null) {
                student = new ArrayList<GradeBook.Grades.Student>();
            }
            return this.student;
        }

  
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name",
            "id",
            "assignedWork",
            "letterGrade"
        })
        public static class Student {

			@XmlElement(name = "Name", required = true)
            protected String name;
            @XmlElement(name = "ID", required = true)
            protected String id;
            @XmlElement(name = "AssignedWork")
            protected List<GradeBook.Grades.Student.AssignedWork> assignedWork;
            @XmlElement(name = "LetterGrade", required = false)
            protected String letterGrade;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @JsonProperty("Name")
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @JsonProperty("Name")
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @JsonProperty("ID")
            public String getID() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @JsonProperty("ID")
            public void setID(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the assignedWork property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the assignedWork property.
             * 
             * <p>
        GradeBook example, to add a new item, do as follows:
             * <pre>
             *    getAssignedWork().add(newItem);
             * </pre>
         GradeBook           * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link GradeBook1.GradGradeBook.AssignedWork }
             * 
             * 
             */
            @JsonProperty("AssignedWork")
            public List<GradeBook.Grades.Student.AssignedWork> getAssignedWork() {
                if (assignedWork == null) {
                    assignedWork = new ArrayList<GradeBook.Grades.Student.AssignedWork>();
                }
                return this.assignedWork;
            }
            
            /**
             * Gets the value of the finalGrade property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
			public String getLetterGrade() {
				return letterGrade;
			}

			/**
             * Sets the value of the finalGrade property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */			
			public void setLetterGrade(String letterGrade) {
				this.letterGrade = letterGrade;
			}


         
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "gradedWork"
            })
            public static class AssignedWork {

                @XmlElement(name = "GradedWork")
                protected List<GradeBook.Grades.Student.AssignedWork.GradedWork> gradedWork;
                @XmlAttribute(name = "category")
                protected String category;

                /**
                 * Gets the value of the gradedWork property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the gradedWork property.
                 * 
                 * <p>
                 * For example, to add a nGradeBooko as follows:
                 * <pre>
                 *    getGradedWork().add(newItem);
                 * </pre>
                 * 
                 * 
                GradeBook               * Objects of the following type(s) are allowed in the list
                 * {@link GradeBook.Grades.Student.AssignedWork.GradedWork }
    GradeBook   * 
                 * 
                 */
                @JsonProperty("GradedWork")
                public List<GradeBook.Grades.Student.AssignedWork.GradedWork> getGradedWork() {
                    if (gradedWork == null) {
                        gradedWork = new ArrayList<GradeBook.Grades.Student.AssignedWork.GradedWork>();
                    }
                    return this.gradedWork;
                }

                /**
                 * Gets the value of the category property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @JsonProperty("-category")
                public String getCategory() {
                    return category;
                }

                /**
                 * Sets the value of the category property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @JsonProperty("-category")
                public void setCategory(String value) {
                    this.category = value;
                }

                @JsonSetter("_category")
                private void setAssignmentCategory(String value) {
                    if (this.category == null) {
                    	setCategory(value);
                    }
                }


                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "name",
                    "grade"
                })
                public static class GradedWork {

                    @XmlElement(name = "Name", required = true)
                    protected String name;
                    @XmlElement(name = "Grade", required = true)
                    protected String grade;

                    /**
                     * Gets the value of the name property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    @JsonProperty("Name")
                    public String getName() {
                        return name;
                    }

                    /**
                     * Sets the value of the name property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    @JsonProperty("Name")
                    public void setName(String value) {
                        this.name = value;
                    }

                    /**
                     * Gets the value of the grade property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    @JsonProperty("Grade")
                    public String getGrade() {
                        return grade;
                    }

                    /**
                     * Sets the value of the grade property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    @JsonProperty("Grade")
                    public void setGrade(String value) {
                        this.grade = value;
                    }

                }

            }

        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "gradeItem"
    })
    public static class GradingSchema {

        @XmlElement(name = "GradeItem")
        protected List<GradeBook.GradingSchema.GradeItem> gradeItem;

        /**
         * Gets the value of the gradeItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gradeItem property.GradeBook * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGradeIteGradeBookwItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are alloweGradeBookist
         * {@link GradeBook1.GradingSchema.GradeItem }
         * 
         * 
         */
        @JsonProperty("GradeItem")
        public List<GradeBook.GradingSchema.GradeItem> getGradeItem() {
            if (gradeItem == null) {
                gradeItem = new ArrayList<GradeBook.GradingSchema.GradeItem>();
            }
            return this.gradeItem;
        }


      
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "category",
            "percentage"
        })
        public static class GradeItem {

            @XmlElement(name = "Category", required = true)
            protected String category;
            @XmlElement(name = "Percentage")
            protected double percentage;

            /**
             * Gets the value of the category property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @JsonProperty("Category")
            public String getCategory() {
                return category;
            }

            /**
             * Sets the value of the category property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @JsonProperty("Category")
            public void setCategory(String value) {
                this.category = value;
            }

            /**
             * Gets the value of the percentage property.
             * 
             */
            @JsonProperty("Percentage")
            public double getPercentage() {
                return percentage;
            }

            /**
             * Sets the value of the percentage property.
             * 
             */
            @JsonProperty("Percentage")
            public void setPercentage(double value) {
                this.percentage = value;
            }

        }

    }

}
