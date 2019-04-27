package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.utils.JNDIUtil;

public class UserDaoImpl implements IUserDao {

	private QueryRunner qr = new QueryRunner(JNDIUtil.getDataSource());

	public User selectUserByInfo(String logonName, String logonPwd) {

		try {
			return qr.query("select * from S_User where logonName=? and logonPwd=?", new BeanHandler<User>(User.class),
					logonName, logonPwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public int addUser(User user) {

		try {
			return qr.update(
					"insert into S_User(userID,userName,logonName,logonPwd,gender,birthday,education,telephone,hobby,path,filename,remark)values(?,?,?,?,?,?,?,?,?,?,?,?)",
					user.getUserID(), user.getUserName(), user.getLogonName(), user.getLogonPwd(), user.getGender(),
					user.getBirthday(), user.getEducation(), user.getTelephone(), user.getHobby(), user.getPath(),
					user.getFilename(), user.getRemark());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public int updateUser(User user) {

		try {
			return qr.update(
					"update S_User set userName=?,logonName=?,logonPwd=?,gender=?,birthday=?,education=?,telephone=?,hobby=?,path=?,filename=?,remark=? where userID=?",
					user.getUserName(), user.getLogonName(), user.getLogonPwd(), user.getGender(), user.getBirthday(),
					user.getEducation(), user.getTelephone(), user.getHobby(), user.getPath(), user.getFilename(),
					user.getRemark(), user.getUserID());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteUser(Integer userID) {

		try {
			return qr.update("delete from S_User where userID=?", userID);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userID;
	}

	public User selectUserById(Integer userID) {

		try {
			return qr.query("select * from S_User where userID=?", new BeanHandler<User>(User.class),userID);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public List<User> selectAllUser() {

		try {
			return qr.query("select * from S_User", new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public List<User> selectUserByCondition(String userName, String gender, String education, String isUpload) {
		/*
		 * 多条件查询：
		 * 1.sql语句不定，需要拼接
		 * 2.params不定，需要存放进数组中
		 */
		String sql = " select * from S_User where 1=1 ";
		StringBuffer sb = new StringBuffer(sql);
		List<String> params = new ArrayList<String>();
		
		if(StringUtils.isBlank(userName) && StringUtils.isBlank(gender) && StringUtils.isBlank(education) && StringUtils.isBlank(isUpload)){
			return selectAllUser();
		}else{
			if(StringUtils.isNotBlank(userName)){
				sb.append(" and userName like ?");
				params.add("%" + userName + "%");
			}
			if(StringUtils.isNotBlank(gender)){
				sb.append(" and gender = ? ");
				params.add(gender);
			}
			if(StringUtils.isNotBlank(education)){
				sb.append(" and education = ? ");
				params.add(education);
			}
			if(StringUtils.isNotBlank(isUpload)){
				if("true".equals(isUpload)){
					sb.append(" and filename is not null ");
				}else{
					sb.append(" and filename is null ");
				}
			}
			
			sql = sb.toString();
			try {
				return qr.query(sql, new BeanListHandler<User>(User.class),params.toArray());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
