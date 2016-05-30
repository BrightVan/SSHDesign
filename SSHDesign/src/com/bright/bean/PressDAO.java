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
 * A data access object (DAO) providing persistence and search support for Press
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.bright.bean.Press
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PressDAO {
	private static final Logger log = LoggerFactory.getLogger(PressDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String POSTCODE = "postcode";
	public static final String LOCATION = "location";

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
	
	public void save(Press transientInstance) {
		log.debug("saving Press instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Press persistentInstance) {
		log.debug("deleting Press instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public List<Press> searchPress(String key,String exact){
		try {
			if(exact==null){
				key = "%" + key + "%";// 模糊查询 
			}
			String queryString = "from Press as model where model.name like \'" + key + "\' ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public Press findById(java.lang.String id) {
		log.debug("getting Press instance with id: " + id);
		try {
			Press instance = (Press) getCurrentSession().get(
					"com.bright.bean.Press", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Press instance) {
		log.debug("finding Press instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.bright.bean.Press")
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
		log.debug("finding Press instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Press as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByPostcode(Object postcode) {
		return findByProperty(POSTCODE, postcode);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List<Press> findAll() {
		log.debug("finding all Press instances");
		try {
			String queryString = "from Press";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Press merge(Press detachedInstance) {
		log.debug("merging Press instance");
		try {
			Press result = (Press) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Press instance) {
		log.debug("attaching dirty Press instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Press instance) {
		log.debug("attaching clean Press instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PressDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PressDAO) ctx.getBean("PressDAO");
	}
}