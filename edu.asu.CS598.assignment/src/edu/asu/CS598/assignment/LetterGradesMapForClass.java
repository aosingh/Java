package edu.asu.CS598.assignment;

import java.util.ArrayList;
import java.util.List;

public class LetterGradesMapForClass {


	private static LetterGradesMapForClass gradeMapperInstance = null;
	
	
	
	/**
	 * Returns object of grader instance class
	 * @return
	 */
	public static LetterGradesMapForClass getInstance()
	{
		if(gradeMapperInstance == null)
		{
			gradeMapperInstance = new LetterGradesMapForClass();
		}
		return gradeMapperInstance;
	}

	/**
	 * This static class represents the Grade Ranges for different letter grades.
	 * @author abhi
	 *
	 */
	static class GradeRangeEntry {
		private final double lower_limit;
		private final double upper_limit;
		private final Object value;
		public GradeRangeEntry(double lower, double upper, Object mappedValue) {
			this.lower_limit = lower;
			this.upper_limit = upper;
			this.value = mappedValue;
		}
		public boolean matches(double value) {
			return value >= lower_limit && value <= upper_limit;
		}
		public Object getValue() { return value; }
	}

	
	protected static final List<GradeRangeEntry> entries = new ArrayList<GradeRangeEntry>();
	
	
	/**
	 * Put grade API to enter grades and their lower and upper limits
	 * @param lower
	 * @param upper
	 * @param mappedValue
	 */
	public void putGrade(double lower, double upper, Object mappedValue) {
		entries.add(new GradeRangeEntry(lower, upper, mappedValue));
	}
	
	/**
	 * Given a numeric value, this will return the letter grade
	 * @param key
	 * @return
	 */
	public Object getValueFor(double key) {
		for (GradeRangeEntry entry : entries) {
			if (entry.matches(key))
				return entry.getValue();
		}
		return null;
	}

	/**
	 * This method will clear the GradeMAP.
	 */
	public void clearGradeMap()
	{
		entries.clear();
	}

	/**
	 * Get the range(lower and upper limit) of a given Letter grade.
	 * @param value
	 * @return
	 */
	private double[] getRange(Object value)
	{
		double range[] = new double[2];
		for (GradeRangeEntry entry : entries) {
			if (entry.value.equals(value))
			{
				range[0] = entry.lower_limit;
				range[1] = entry.upper_limit;
			}
		}
		return range;

	}
	
	
	/**
	 * Return the median of the spread for the given letter grade.
	 * @param value
	 * @return
	 */
	public double getMedianOfTheRange(Object value)
	{
		double [] range = getRange(value);
		int length = (int) ((int) range[1]-range[0]);
		double [] array = new double[length];
		array[0] = range[0];
		for(int i = 1; i < length; i++)
		{
			array[i] = array[i-1]+1;
		}
		if(length%2 == 0)
		{
			return array[length/2];
		}
		else
		{
			return array[length/2];
		}
		
	}

}
