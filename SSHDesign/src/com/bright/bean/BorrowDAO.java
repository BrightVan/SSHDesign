package com.bright.bean;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.bright.util.App;

/**
 * A data access object (DAO) providing persistence and search support for
 * Borrow entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.bright.bean.Borrow
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BorrowDAO {
	private static final Logger log = LoggerFactory.getLogger(BorrowDAO.class);
	// property constants

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Borrow transientInstance) {
		log.debug("saving Borrow instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Borrow persistentInstance) {
		log.debug("deleting Borrow instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Borrow findById(com.bright.bean.BorrowId id) {
		log.debug("getting Borrow instance with id: " + id);
		try {
			Borrow instance = (Borrow) getCurrentSession().get(
					"com.bright.bean.Borrow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Borrow instance) {
		log.debug("finding Borrow instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.bright.bean.Borrow")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Borrow instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Borrow as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MyBorrow> getCurrentUserBorrow(Integer id){
		String hql = "select new com.bright.bean.MyBorrow(user,books,press,borrow.borrowDate,borrow.returnDate) from "
				+ "Borrow borrow,Books books,User user,Press press where borrow.id.user = user and "
				+ "borrow.id.books = books and books.press = press "
				+ "and user.id = ?";
		Query queryObject = getCurrentSession().createQuery(hql);
		queryObject.setInteger(0, id);
		return queryObject.list();
	}
	
	public List<Borrow> findAll() {
		log.debug("finding all Borrow instances");
		try {
			String queryString = "from Borrow";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<MyBorrow> findAllDetail(){
		String hql = "select new com.bright.bean.MyBorrow(user,books,press,borrow.borrowDate,borrow.returnDate) from "
				+ "Borrow borrow,Books books,User user,Press press where borrow.id.user = user and "
				+ "borrow.id.books = books and books.press = press";
		Query queryObject = getCurrentSession().createQuery(hql);
		return queryObject.list();
	}
	
	public List<MyBorrow> searchAllBorrow(String key,String exact){
		try {
			if(exact==null){
				key = "%" + key + "%";// 模糊查询 
			}
			String hql = "select new com.bright.bean.MyBorrow(user,books,press,borrow.borrowDate,borrow.returnDate) from "
					+ "Borrow borrow,Books books,User user,Press press where borrow.id.user = user and "
					+ "borrow.id.books = books and books.press = press and books.bookName like \'" + key + "\' ";
			Query queryObject = getCurrentSession().createQuery(hql);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}
	
	public List<MyBorrow> searchCurrentBorrow(String key,String exact){
		try {
			if(exact==null){
				key = "%" + key + "%";// 模糊查询 
			}
			String hql = "select new com.bright.bean.MyBorrow(user,books,press,borrow.borrowDate,borrow.returnDate) from "
					+ "Borrow borrow,Books books,User user,Press press where borrow.id.user = user and "
					+ "borrow.id.books = books and books.press = press "
					+ "and user.id = ? and books.bookName like \'" + key + "\' ";
			Query queryObject = getCurrentSession().createQuery(hql);
			queryObject.setInteger(0, App.getInstance().getUser().getId());
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
		
	}
	
	public Borrow merge(Borrow detachedInstance) {
		log.debug("merging Borrow instance");
		try {
			Borrow result = (Borrow) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Borrow instance) {
		log.debug("attaching dirty Borrow instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Borrow instance) {
		log.debug("attaching clean Borrow instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BorrowDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BorrowDAO) ctx.getBean("BorrowDAO");
	}
}