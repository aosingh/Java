package edu.asu.passwordvalidator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.passwordvalidator.model.PasswordValidatorModel;
import edu.asu.passwordvalidator.model.PasswordValidatorModel.PasswordValidatorRule;
import edu.asu.passwordvalidator.filter.*;


@Controller
public class PasswordValidatorController {

	@ModelAttribute("passwordValidatorRuleType")
	public PasswordValidatorRule[] passwordValidatorRules()
	{
		return PasswordValidatorRule.values();
	}

	@ModelAttribute("passwordValidator")
	public PasswordValidatorModel getPassWordValidator()
	{
		return new PasswordValidatorModel();
	}


	@RequestMapping(value="passwordValidator", method=RequestMethod.GET)
	public ModelAndView loadForm()
	{
		ModelAndView mv = new ModelAndView("passwordValidator");
		mv.addObject("passwordValidator", new PasswordValidatorModel());
		return mv;
	}



	@RequestMapping(value="passwordValidator", method=RequestMethod.POST)		
	public ModelAndView validatePsssword(@ModelAttribute("passwordValidator") PasswordValidatorModel passwordValidator, BindingResult result)
	{
		ModelAndView mv = new ModelAndView("passwordValidator");
		Target target = new Target();
		FilterManager filterManager = new FilterManager(target);
		if (passwordValidator.getFirstPasswordFilter() != null)
		{
			if(passwordValidator.getFirstPasswordFilter().equals(PasswordValidatorRule.OFFENSIVE_WORDS))
			{
				filterManager.filterChain.addPasswordFilter(new OffensiveWordFilter());
			}
			else if(passwordValidator.getFirstPasswordFilter().equals(PasswordValidatorRule.PROPRIETORY_WORDS))
			{
				filterManager.filterChain.addPasswordFilter(new ProprietoryWordFilter());
			}
			else if(passwordValidator.getFirstPasswordFilter().equals(PasswordValidatorRule.SALTING))
			{
				filterManager.filterChain.addPasswordFilter(new SaltPasswordFilter());
				target.setSalt(true);
			}
		}
		if (passwordValidator.getSecondPasswordFilter() != null)
		{
			if(passwordValidator.getSecondPasswordFilter().equals(PasswordValidatorRule.OFFENSIVE_WORDS))
			{
				filterManager.filterChain.addPasswordFilter(new OffensiveWordFilter());
			}
			else if(passwordValidator.getSecondPasswordFilter().equals(PasswordValidatorRule.PROPRIETORY_WORDS))
			{
				filterManager.filterChain.addPasswordFilter(new ProprietoryWordFilter());
			}
			else if(passwordValidator.getSecondPasswordFilter().equals(PasswordValidatorRule.SALTING))
			{
				filterManager.filterChain.addPasswordFilter(new SaltPasswordFilter());
				target.setSalt(true);
			}
		}

		if (passwordValidator.getThirdPasswordFilter() != null)
		{
			if(passwordValidator.getThirdPasswordFilter().equals(PasswordValidatorRule.OFFENSIVE_WORDS))
			{
				filterManager.filterChain.addPasswordFilter(new OffensiveWordFilter());
			}
			else if(passwordValidator.getThirdPasswordFilter().equals(PasswordValidatorRule.PROPRIETORY_WORDS))
			{
				filterManager.filterChain.addPasswordFilter(new ProprietoryWordFilter());
			}
			else if(passwordValidator.getThirdPasswordFilter().equals(PasswordValidatorRule.SALTING))
			{
				filterManager.filterChain.addPasswordFilter(new SaltPasswordFilter());
				target.setSalt(true);
			}
		}
		String filteredPassword = filterManager.filterPassword(passwordValidator.getPassword());
		boolean isGood = filterManager.filterChain.getTarget().isValid();
		String postProcessedPassword = filterManager.postProcess(filteredPassword);
		String message = "";
		if(isGood)
		{
			message = "Your Password "+postProcessedPassword+" is a valid Password";
		}
		else
		{
			message = "Sorry, the password you entered is Invalid";
		}
		mv.addObject("message", message);
		return mv;
	}


}
