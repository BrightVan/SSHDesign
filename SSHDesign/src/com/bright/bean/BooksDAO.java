package com.bright.bean;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for Books
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.bright.bean.Books
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BooksDAO {
	private static final Logger log = LoggerFactory.getLogger(BooksDAO.class);
	// property constants
	public static final String BOOK_NAME = "bookName";
	public static final String BOOK_NUM = "bookNum";
	public static final String BOOK_POSITION = "bookPosition";

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

	public void save(Books transientInstance) {
		log.debug("saving Books instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Books persistentInstance) {
		log.debug("deleting Books instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Books findById(java.lang.Integer id) {
		log.debug("getting Books instance with id: " + id);
		try {
			Books instance = (Books) getCurrentSession().get(
					"com.bright.bean.Books", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Books instance) {
		log.debug("finding Books instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.bright.bean.Books")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Books> searchByKey(String key,String exact){
		try {
			if(exact==null){
				key = "%" + key + "%";// 模糊查询 
			}
			String queryString = "from Books as model where model.bookName like \'" + key + "\' ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Books> findByProperty(String propertyName, Object value) {
		log.debug("finding Books instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Books as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Books> findByBookName(Object bookName) {
		return findByProperty(BOOK_NAME, bookName);
	}

	public List<Books> findByBookNum(Object bookNum) {
		return findByProperty(BOOK_NUM, bookNum);
	}

	public List<Books> findByBookPosition(Object bookPosition) {
		return findByProperty(BOOK_POSITION, bookPosition);
	}

	public List<Books> findAll() {
		log.debug("finding all Books instances");
		try {
			String queryString = "from Books";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Books merge(Books detachedInstance) {
		log.debug("merging Books instance");
		try {
			Books result = (Books) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Books instance) {
		log.debug("attaching dirty Books instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Books instance) {
		log.debug("attaching clean Books instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BooksDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BooksDAO) ctx.getBean("BooksDAO");
	}
}