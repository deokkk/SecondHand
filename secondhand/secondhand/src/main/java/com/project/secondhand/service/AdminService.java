package com.project.secondhand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.AdminMapper;
import com.project.secondhand.vo.Admin;

@Service
public class AdminService {
	@Autowired private AdminMapper adminMapper;
	
	public Admin adminLogin(Admin admin) {
		return adminMapper.adminLogin(admin);
	}
}
