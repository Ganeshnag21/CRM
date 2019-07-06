package com.gani.project1.service.listService;

import java.util.List;

import org.springframework.ui.Model;

import com.gani.project1.dto.listDTO.UserDTO;

public interface ListUsersInterface {

	public List<UserDTO> listUserDetails();

	public void addUser(UserDTO dto);

	public UserDTO getUser(int userId);

	public void deleteUser(int id);
}
