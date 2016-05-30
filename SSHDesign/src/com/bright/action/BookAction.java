package com.bright.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.bright.bean.Books;
import com.bright.bean.BooksDAO;
import com.bright.bean.Press;
import com.bright.bean.PressDAO;
import com.bright.bean.User;
import com.bright.util.App;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class BookAction extends ActionSupport {
	private User user;
	private String searchKey;
	private String exactFlag;
	private List<Books> books;
	private List<Press> presses;
	// 添加图书相关
	private Books book;
	private String pressName;
	private Integer bookId;

	public String getBookByKey() throws Exception {
		BooksDAO booksDAO = BooksDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		books = booksDAO.searchByKey(searchKey, exactFlag);
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		presses = pressDAO.findAll();
		boolean isAdmin = App.getInstance().getUser().getAdmin();
		setUser(App.getInstance().getUser());
		if(isAdmin){
			return "admin_main";
		}else{
			return "main";
		}
	}

	/**
	 * 添加图书
	 * @return
	 * @throws Exception
	 */
	public String addBook() throws Exception{
		Press press = new Press();
		press.setName(pressName);
		book.setPress(press);
		BooksDAO booksDAO = BooksDAO.getFromApplicationContext(App.getInstance().getApplicationContext());
		booksDAO.save(book);
		return "success";
	}
	
	public String getAll(){
		BooksDAO booksDAO = BooksDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		books = booksDAO.findAll();
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		presses = pressDAO.findAll();
		boolean isAdmin = App.getInstance().getUser().getAdmin();
		setUser(App.getInstance().getUser());
		if(isAdmin){
			return "admin_main";
		}else{
			return "main";
		}
	}
	
	/**
	 * 跳转到编辑图书界面
	 * @return
	 */
	public String goEditBook(){
		BooksDAO booksDAO = BooksDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		PressDAO pressDAO = PressDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		presses = pressDAO.findAll();
		book = booksDAO.findById(bookId);
		return "success";
	}
	
	/**
	 * 编辑图书信息
	 * @return
	 */
	public String editBook(){
		Press press = new Press();
		press.setName(pressName);
		book.setPress(press);
		BooksDAO booksDAO = BooksDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		booksDAO.attachDirty(book);
		return "success";
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

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	public String getPressName() {
		return pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public List<Press> getPresses() {
		return presses;
	}

	public void setPresses(List<Press> presses) {
		this.presses = presses;
	}

}
