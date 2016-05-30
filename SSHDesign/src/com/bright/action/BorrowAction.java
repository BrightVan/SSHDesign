package com.bright.action;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.bright.bean.Books;
import com.bright.bean.BooksDAO;
import com.bright.bean.Borrow;
import com.bright.bean.BorrowDAO;
import com.bright.bean.BorrowId;
import com.bright.bean.MyBorrow;
import com.bright.util.App;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
public class BorrowAction extends ActionSupport {
	private List<Borrow> borrows;
	private Integer bookId;
	private List<MyBorrow> myborrows;
	//搜索相关
	private String exactFlag;
	private String searchKey;
	
	/**
	 * 获取我的借书记录
	 * 
	 * @return
	 */
	public String getMyBorrow() throws Exception {
		BorrowDAO borrowDAO = BorrowDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		myborrows = borrowDAO.getCurrentUserBorrow(App.getInstance().getUser().getId());
		return "success";
	}

	/**
	 * 获取所有借书记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAll() throws Exception {
		BorrowDAO borrowDAO = BorrowDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		setMyborrows(borrowDAO.findAllDetail());
		return "success";
	}
	
	/**
	 * 搜索我的借书记录
	 * @return
	 */
	public String searchMyBorrow(){
		BorrowDAO borrowDAO = BorrowDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		myborrows = borrowDAO.searchCurrentBorrow(searchKey, exactFlag);
		return "success";
	}
	
	/**
	 * 搜索所有借书记录
	 * @return
	 */
	public String searchAllBorrow(){
		BorrowDAO borrowDAO = BorrowDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		myborrows = borrowDAO.searchAllBorrow(searchKey, exactFlag);
		return "success";
	}

	/**
	 * 借书的方法 添加借书记录，相应书的书的数目减一
	 * 
	 * @return
	 */
	public String borrowBook() {
		// 添加借书记录
		BorrowDAO borrowDAO = BorrowDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		BooksDAO booksDAO = BooksDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		BorrowId borrowId = new BorrowId();
		Books book = booksDAO.findById(bookId);
		borrowId.setBooks(book);
		borrowId.setUser(App.getInstance().getUser());
		Borrow borrow = null;
		borrow = borrowDAO.findById(borrowId);
		if(borrow != null){
			return "borrowerror";
		}
		borrow = new Borrow();
		borrow.setId(borrowId);
		borrow.setBorrowDate(new Date());
		borrowDAO.save(borrow);
		// 将相应的书的数目减少1
		int bookNum = book.getBookNum();
		book.setBookNum(--bookNum);
		booksDAO.attachDirty(book);
		return "success";
	}

	/**
	 * 还书 删除borrow的记录 将相应的书的数目加1
	 * 
	 * @return
	 * @throws Exception
	 */
	public String returnBook() throws Exception {
		// 更新借书记录
		BorrowDAO borrowDAO = BorrowDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		BooksDAO booksDAO = BooksDAO.getFromApplicationContext(App
				.getInstance().getApplicationContext());
		BorrowId borrowId = new BorrowId();
		Books book = booksDAO.findById(bookId);
		book.setId(bookId);
		borrowId.setBooks(book);
		borrowId.setUser(App.getInstance().getUser());
		Borrow borrow = borrowDAO.findById(borrowId);
		borrow.setReturnDate(new Date());
		borrowDAO.attachDirty(borrow);
		// 将相应的书的数目加1
		int bookNum = book.getBookNum();
		book.setBookNum(++bookNum);
		booksDAO.attachDirty(book);
		//刷新界面
		//getAll();
		return "success";
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public List<MyBorrow> getMyborrows() {
		return myborrows;
	}

	public void setMyborrows(List<MyBorrow> myborrows) {
		this.myborrows = myborrows;
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

	
}
