package com.bright.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.bright.bean.User;
import com.bright.bean.UserDAO;
import com.bright.util.App;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class UserAction extends ActionSupport implements ServletRequestAware {
	// 登录时相关
	private User user;
	private String isAdmin;
	private HttpServletRequest request;
	private int loginResult;
	// 修改个人信息相关
	private String userPass;
	private String userUnit;
	//用户管理相关
	private List<User> users;
	private Integer userId; 
	//搜索用户相关
	private String searchKey;
	private String exactFlag;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		UserDAO userDAO = UserDAO.getFromApplicationContext(App.getInstance()
				.getApplicationContext());
		List list = userDAO.findByLogin(user.getUserName(), user.getUserPass(),
				isAdmin);
		if (list.size() > 0) {
			User currentUser = (User) list.get(0);
			App.getInstance().setUser(currentUser);// 设置当前用户
			setUser(currentUser);
			HttpSession session = request.getSession();
			session.setAttribute("CurrentUser", user);
			return "success";
		} else {
			setLoginResult(1);
			return "error";
		}
	}
	
	/**
	 * 注册
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception{
		UserDAO userDAO = UserDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		user.setAdmin(false);
		userDAO.save(user);
		return "success";
	}

	/**
	 * 修改个人信息
	 * @return
	 * @throws Exception
	 */
	public String editMyInfo() throws Exception {
		UserDAO userDAO = UserDAO.getFromApplicationContext(App.getInstance()
				.getApplicationContext());
		User currentUser = App.getInstance().getUser();
		currentUser.setUserPass(userPass);
		currentUser.setUserUnit(userUnit);
		userDAO.update(currentUser);
		boolean isAdmin = App.getInstance().getUser().getAdmin();
		App.getInstance().setUser(currentUser);
		setUser(App.getInstance().getUser());
		if(isAdmin){
			return "admin_main";
		}else{
			return "main";
		}
	}
	
	/**
	 * 跳转到用户信息编辑界面
	 * @return
	 */
	public String goEditUser(){
		UserDAO userDAO = UserDAO.getFromApplicationContext(App.getInstance()
				.getApplicationContext());
		user = userDAO.findById(userId);
		return "success";
	}
	
	/**
	 * 编辑用户信息
	 * @return
	 */
	public String editUserInfo(){
		UserDAO userDAO = UserDAO.getFromApplicationContext(App.getInstance()
				.getApplicationContext());
		userDAO.attachDirty(user);
		return "success";
	}
	
	/**
	 * 获取所有用户信息
	 * @return
	 * @throws Exception
	 */
	public String getAll() throws Exception{
		setUser(App.getInstance().getUser());
		UserDAO userDAO = UserDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		users = userDAO.findAll();
		return "success";
	}
	
	/**
	 * 搜索用户
	 * @return
	 */
	public String searchUser(){
		setUser(App.getInstance().getUser());
		UserDAO userDAO = UserDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		users = userDAO.searchUser(searchKey, exactFlag);
		return "success";
	}
	
	
	public String getUserUnit() {
		return userUnit;
	}

	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(int loginResult) {
		this.loginResult = loginResult;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getExactFlag() {
		return exactFlag;
	}

	public void setExactFlag(String exactFlag) {
		this.exactFlag = exactFlag;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
