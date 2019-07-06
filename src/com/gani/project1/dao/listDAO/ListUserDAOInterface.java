package com.gani.project1.dao.listDAO;

import java.util.List;

import com.gani.project1.dto.listDTO.UserDTO;

public interface ListUserDAOInterface {

	public List<UserDTO> listUsersfromDB();

	public int addUser(UserDTO dto);

	public int deleteUser(int id);

	public UserDTO getUser(int userId);
}
