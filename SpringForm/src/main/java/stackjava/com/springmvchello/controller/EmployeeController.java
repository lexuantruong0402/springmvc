package stackjava.com.springmvchello.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import stackjava.com.springmvchello.entities.Employee;
import stackjava.com.springmvchello.entities.Question;

@Controller
public class EmployeeController {

	private List<Employee> listEmployee = new ArrayList<Employee>();
	private List<Question> listQuestion = new ArrayList<Question>();
	private Date date1, date2;

	//home
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String addEmployee(Model model) {

		Question ques = new Question();
		ques.setId(0);
		ques.setQuestion("this is something");
		listQuestion.add(ques);

		model.addAttribute("employee", new Employee());
		return "add-employee";
	}
	
	//update and view ranking score
	@RequestMapping(value = "/addScore", method = RequestMethod.POST)
	public String doAddEmployee(@RequestParam("answer") String answer, Model modelMap) {
		for (int i = 0; i < listQuestion.size(); i++) {
			if (listQuestion.get(i).getQuestion().equals(answer)) {
				date2 = java.util.Calendar.getInstance().getTime();
				long score = (date2.getTime() - date1.getTime()) / 1000;
				Employee employee = listEmployee.get(listEmployee.size() - 1);
				employee.setScore(score);
				for (int j = 0; j < listEmployee.size(); j++)
					if (listEmployee.get(i).getScore() > score) {
						listEmployee.add(j, employee);
						listEmployee.remove(listEmployee.size()-1);
						break;
					}
				modelMap.addAttribute("list", listEmployee);
				return "view-employee";
			}
		}
		return "wrong";
	}
	
	
	//start a game
	@RequestMapping(value = "/startGame")
	public String startGame() {
		date1 = java.util.Calendar.getInstance().getTime();
		return "game";
	}
	
	//create a name to ranking after game
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String doGame(@ModelAttribute("employee") Employee employee, ModelMap modelMap) {

		Random rd = new Random();
		int number = rd.nextInt(listQuestion.size());

		String ques = listQuestion.get(number).getQuestion();

		listEmployee.add(employee);
		modelMap.addAttribute("ques", ques);
		return "game";
	}
	
	//adming login
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String adminLogin(@RequestParam("pwd") String pwd, ModelMap modelMap) {
		if (pwd.equals("topica")) {
			modelMap.addAttribute("list", listQuestion);
			return "view-question";
		}
		return "wrong-pwd";
	}
	
	//add new question
	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String addNew(@RequestParam("question") String question, ModelMap modelMap) {
		Question ques = new Question();
		ques.setId(listQuestion.get(listQuestion.size() - 1).getId() + 1);
		ques.setQuestion(question);
		listQuestion.add(ques);
		modelMap.addAttribute("list", listQuestion);
		return "view-question";
	}
	
	//delete question
	@RequestMapping(value = "/delete/{question}")
	public String delete(@PathVariable("question") String question, ModelMap modelMap) {
		for (int i = 0; i < listQuestion.size(); i++) {
			if (listQuestion.get(i).getQuestion().equals(question)) {
				listQuestion.remove(i);
			}
		}
		modelMap.addAttribute("list", listQuestion);
		return "view-question";
	}
}
