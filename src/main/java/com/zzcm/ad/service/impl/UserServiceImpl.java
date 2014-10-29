package com.zzcm.ad.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzcm.ad.common.dao.IbatisBaseDao;
import com.zzcm.ad.common.dao.IbatisDaoReader;
import com.zzcm.ad.common.dao.IbatisDaoWriter;
import com.zzcm.ad.model.User;
import com.zzcm.ad.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private IbatisBaseDao ibatisBaseDao;
	@Resource
	private IbatisDaoWriter ibatisDaoWriter;
	@Resource
	private IbatisDaoReader ibatisDaoReader;

	@Override
	public List<User> findUserList() {
		ibatisDaoReader.queryForObject("findUserList");
		Long result=ibatisBaseDao.queryForObject("findUserList");
		System.out.println(result);
		
		List<User> userList=new ArrayList<User>();
		for (int i = 0; i < 5; i++) {
			User user=new User();
			user.setId(i);
			user.setFirstName("a"+i);
			user.setLastName("b"+i);
			userList.add(user);
		}
		return userList;
	}
}
