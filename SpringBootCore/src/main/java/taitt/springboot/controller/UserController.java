package taitt.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import taitt.springboot.dao.UserDAO;
import taitt.springboot.entity.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/getalluser")
	public ModelAndView getAll(){
		return new ModelAndView("getAll","listUser",userDAO.getAllUser());
		
	}
	
	@RequestMapping("/add")
	public ModelAndView addUser(){
		return new ModelAndView("add","user",new User());
	}
	
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute  User user){
		userDAO.addUser(user);
		return "redirect:/getalluser";
	}
	
	@RequestMapping("/{id}/edit/{email}")
	public ModelAndView updateForm(@PathVariable("id") int id, @PathVariable String email){
		System.out.println(email);
		return new ModelAndView("editform","user",userDAO.getUserById(id));
	}
	
	@RequestMapping("/save/edit")
	public String updateUser(@ModelAttribute  User user){
		userDAO.updateUser(user);
		return "redirect:/getalluser";
	}
	
	@RequestMapping("/{id}/delete")
	public String deleteUser(@PathVariable("id") int id){
		userDAO.removeUser(id);
		return "redirect:/getalluser";
	}
	
	//test requestparam
	@RequestMapping("/search")
	public ModelAndView searchUser(@RequestParam("q") String q){
		System.out.println("abc");
		return new ModelAndView("editform","user",userDAO.getUserById(Integer.valueOf(q)));
	}
}
