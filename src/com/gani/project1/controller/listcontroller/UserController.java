package com.gani.project1.controller.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gani.project1.dto.listDTO.UserDTO;
import com.gani.project1.service.listService.ListUsersInterface;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	ListUsersInterface listUserinterface;

	@RequestMapping("list.do")
	public String listUsersControl(Model model) {
		List<UserDTO> list = listUserinterface.listUserDetails();
		model.addAttribute("listofusers", list);
		return "listpage";
	}

	@RequestMapping("/showFormForAdd.do")
	public String showFormForAdd() {
		System.out.println("Showing form for adding user");
		return "adduserform";
	}

	@RequestMapping("/showFormForUpdate.do")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		System.out.println("Form for update");
		UserDTO dto = listUserinterface.getUser(theId);
		model.addAttribute("user", dto);
		return "formforupdateuser";
	}

	@RequestMapping(value = "/showFormForDelete.do", method = RequestMethod.GET)
	public String showFormForDelete(@RequestParam("customerId") int theId) {
		listUserinterface.deleteUser(theId);
		return "redirect:list.do";
	}

	@RequestMapping("/addUser.do")
	public String addUser(@ModelAttribute UserDTO dto) {
		listUserinterface.addUser(dto);
		return "redirect:list.do";
	}

	@RequestMapping(value = "/saveCustomer.do")
	public String modifyExistingUser(@ModelAttribute("user") UserDTO user) {
		System.out.println("Modifying user " + user.getFirstName());
		System.out.println("Modifying user " + user.getId());
		listUserinterface.addUser(user);
		return "redirect:list.do";
	}

}
