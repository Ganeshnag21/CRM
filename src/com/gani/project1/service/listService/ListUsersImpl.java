package com.gani.project1.service.listService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.gani.project1.dao.listDAO.ListUserDAOImpl;
import com.gani.project1.dao.listDAO.ListUserDAOInterface;
import com.gani.project1.dto.listDTO.UserDTO;

@Service
public class ListUsersImpl implements ListUsersInterface {

	@Autowired
	ListUserDAOInterface dao;

	@Override
	@Transactional
	public List<UserDTO> listUserDetails() {
		List<UserDTO> list = new ArrayList<>();
		list = dao.listUsersfromDB();
		return list;
	}

	@Override
	@Transactional
	public void addUser(UserDTO dto) {
		dao.addUser(dto);
		System.out.println("Added new user to DB");
	}

	@Override
	@Transactional
	public UserDTO getUser(int userId) {
		return dao.getUser(userId);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		dao.deleteUser(id);
	}

}
