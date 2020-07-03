package com.project.secondhand.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Admin;

@Mapper
public interface AdminMapper {
	public Admin adminLogin(Admin admin);
}
