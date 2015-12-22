package edu.asu.passwordvalidator.filter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FilterChain {

	private static Log logger = LogFactory.getLog(FilterChain.class);
	private List<Filter> filters = new ArrayList<Filter>();
	private Target target;

	public Target getTarget() 
	{
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(Target target) {
		this.target = target;
	}

	public void addPasswordFilter(Filter filter)
	{
		filters.add(filter);
	}

	public String executeFilters(String message)
	{
		logger.info("Method to execute filter");
		logger.info("Filter Size is"+filters.size());
		String filteredMessage = message;
		for(int i =0; i <filters.size(); i++)
		{
			logger.info("The filter is"+filters.get(i));
			if(i==0)
			{
				filteredMessage = filters.get(i).doFilter(message);
			}
			else if(i > 0)
			{
				filteredMessage = filters.get(i).doFilter(filteredMessage);
			}
		}
		target.executeRequest(filteredMessage);
		logger.info("Exiting Filter");
		return filteredMessage;
	}
	
	public String postProcess(String message)
	{
		logger.info("Method to post process Filter");
		logger.info("The post process Filters Size is:"+filters.size());
		String postProcessesedMessage = message;
		for(int i = filters.size()-1; i >= 0; i--)
		{
			logger.info("Going to post Process Filter"+filters.get(i));
			if (i == filters.size() - 1)
			{
				postProcessesedMessage = filters.get(i).postProcessing(message);
			}
			else
			{
				postProcessesedMessage = filters.get(i).postProcessing(postProcessesedMessage);
			}
		}
		logger.info("The post Processed message after the filter is"+postProcessesedMessage);
		return postProcessesedMessage;
	}









}
