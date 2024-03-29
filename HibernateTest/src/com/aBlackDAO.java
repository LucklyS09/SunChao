package com;

import com.jzfactory.jd.util.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for aBlack entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.aBlack
  * @author MyEclipse Persistence Tools 
 */
public class aBlackDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(aBlackDAO.class);
		//property constants
	public static final String USERNAME = "username";
	public static final String REMOVED = "removed";



    
    public void save(aBlack transientInstance) {
        log.debug("saving aBlack instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(aBlack persistentInstance) {
        log.debug("deleting aBlack instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public aBlack findById( java.lang.Integer id) {
        log.debug("getting aBlack instance with id: " + id);
        try {
            aBlack instance = (aBlack) getSession()
                    .get("com.aBlack", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<aBlack> findByExample(aBlack instance) {
        log.debug("finding aBlack instance by example");
        try {
            List<aBlack> results = (List<aBlack>) getSession()
                    .createCriteria("com.aBlack")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding aBlack instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from aBlack as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<aBlack> findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List<aBlack> findByRemoved(Object removed
	) {
		return findByProperty(REMOVED, removed
		);
	}
	

	public List findAll() {
		log.debug("finding all aBlack instances");
		try {
			String queryString = "from aBlack";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public aBlack merge(aBlack detachedInstance) {
        log.debug("merging aBlack instance");
        try {
            aBlack result = (aBlack) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(aBlack instance) {
        log.debug("attaching dirty aBlack instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(aBlack instance) {
        log.debug("attaching clean aBlack instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}