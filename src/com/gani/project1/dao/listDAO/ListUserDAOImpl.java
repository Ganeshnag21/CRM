package com.gani.project1.dao.listDAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gani.project1.dto.listDTO.UserDTO;

@Component
public class ListUserDAOImpl implements ListUserDAOInterface {

	@Autowired
	SessionFactory factory;
	
	@Override
	public List<UserDTO> listUsersfromDB() {
		List<UserDTO> list = new ArrayList<>();
		Session session = factory.openSession();
		list=session.createQuery("select u from UserDTO u").list();
		session.close();
		return list;
	}

	@Override
	public int addUser(UserDTO dto) {
		Session session = factory.openSession();
		session.saveOrUpdate(dto);
		session.close();
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		Session session = factory.openSession();
		Query query = session.createQuery("delete from UserDTO d where d.id=:userId");
		query.setParameter("userId", id);
		query.executeUpdate();
		session.close();
		return 0;
	}

	@Override
	public UserDTO getUser(int userId) {
		Session session = factory.openSession();
		UserDTO dto =  session.get(UserDTO.class,userId);
		session.close();
		return dto;
	}

}
