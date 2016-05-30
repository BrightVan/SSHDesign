package com.bright.action;

import java.util.List;

import javax.mail.internet.PreencodedMimeBodyPart;

import org.springframework.stereotype.Controller;

import com.bright.bean.Press;
import com.bright.bean.PressDAO;
import com.bright.util.App;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class PressAction extends ActionSupport {
	//搜索出版社相关
	private List<Press> presses;
	private String exactFlag;
	private String searchKey;
	//添加出版社相关
	private Press press;
	//编辑出版社相关
	private String pressName;
	/**
	 * 获取所有出版社记录
	 * @return
	 * @throws Exception
	 */
	public String getAll() throws Exception{
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		presses = pressDAO.findAll();
		return "success";
	}
	
	/**
	 * 查找出版社记录
	 * @return
	 */
	public String findByKey(){
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		presses = pressDAO.searchPress(searchKey, exactFlag);
		return "success";
	}
	
	/**
	 * 添加出版社
	 * @return
	 */
	public String addPress(){
		String pressName = press.getName();
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		List<Press> lists = pressDAO.searchPress(pressName, "exact");
		if(lists==null||lists.size()<1){//不存在，可以插入
			pressDAO.save(press);
			return "success";
		}else{
			return "error";
		}
	}
	
	public String goEditPress(){
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		press = pressDAO.findById(pressName);
		return "success";
	}
	
	/**
	 * 编辑出版社
	 * @return
	 */
	public String editPress(){
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		pressDAO.attachDirty(press);
		return "success";
	}
	
	public List<Press> getPresses() {
		return presses;
	}

	public void setPresses(List<Press> presses) {
		this.presses = presses;
	}

	public String getPressName() {
		return pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public String getExactFlag() {
		return exactFlag;
	}

	public void setExactFlag(String exactFlag) {
		this.exactFlag = exactFlag;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Press getPress() {
		return press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

}
