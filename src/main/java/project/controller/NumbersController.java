package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.domain.Numbers;
import project.service.NumbersService;

@Controller
public class NumbersController {

	@Autowired
	NumbersService numbersService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getNumbersPage(Model model) {
		List<Numbers> nums = numbersService.getAll();
		model.addAttribute("numberList", nums);
		return "index";
	}

	@RequestMapping(value = "/add-new-numbers", method = RequestMethod.GET)
	public String addNewNumbersPage() {
		return "index";
	}

	@RequestMapping(value="/add-new-numbers", method=RequestMethod.POST)
	public ModelAndView addNumbers(
			@RequestParam(value = "a") double a,
			@RequestParam(value = "b") double b,
			@RequestParam(value = "c") double c
			) {
		Numbers numbers = new Numbers();
		
		String msg;
		double d = b * b - 4 * a * c;
		if(d > 0) {
			double x1, x2;
			x1 = (-b - Math.sqrt(d)) / (2 * a);
		    x2 = (-b + Math.sqrt(d)) / (2 * a);
		    msg = "Корни уравнения: x1 = " + x1 + ", x2 = " + x2;
		}else if(d == 0) {
			double x;
			x = -b / (2 * a);
			msg = "Уравнение имеет единственный корень: x = " + x;
		}else {
			msg = "Уравнение не имеет действительных корней!";
		}
		
		numbers.setA(a);
		numbers.setB(b);
		numbers.setC(c);
		numbers.setMsg(msg);
		numbersService.save(numbers);
		return new ModelAndView ("redirect:/");
	}

}
