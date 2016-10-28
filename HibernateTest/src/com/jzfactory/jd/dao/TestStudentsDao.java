package com.jzfactory.jd.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jzfactory.jd.bean.Master;
import com.jzfactory.jd.util.BaseHibernateDAO;

/**
 * 测试Hibernate三种状态
 * 
 * @author 孙超
 *
 */
public class TestStudentsDao extends BaseHibernateDAO {
	/**
	 * 测试临时状态到持久状态的转变
	 */
	public void testT2P() {
		Master master = new Master();
		// 临时太
		master.setName("dema");
		master.setSex(1);
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.save(master);
		trans.commit();
		// 持久太
		master.setSex(0);
		session.close();
		// 游离态
		master.setName("assasa");
		// 临时太
		master.setId(10000);
	}

	/**
	 * 测试临时状态到持久状态后，更改属性提交。
	 */
	public void testT2P2Update() {
		Master master = new Master();
		master.setName("dema");
		master.setSex(0);
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		session.save(master);
		session.save(master);
		master.setSex(0);
		trans.commit();
		session.close();
	}

	/**
	 * 测试持久状态修改后提交
	 */
	public void testP2Update() {
		Session session = getSession();
		Master master = (Master) session.get(Master.class, 1);
		Transaction trans = session.beginTransaction();
		session.save(master);// 该保存无意义
		master.setSex(0);
		master.setName("lll");
		trans.commit();
		session.close();

	}

	/**
	 * 将持久态转换为游离态后更新提交 clear 或 evict 或 session关闭
	 */
	public void testP2D2Update() {
		Session session = getSession();
		//持久化状态
		Master master = (Master) session.get(Master.class, 1);
		session.evict(master);//将持久对象转换为游离对象
		Transaction trans = session.beginTransaction();
		master.setName("一库");//游离态对象
		trans.commit();
		session.close();
	}

	/**
	 * 将持久态转换为临时态
	 */
	public void testP2T() {
		Session session = getSession();
		Master master = (Master) session.get(Master.class,2);
		Transaction trans = session.beginTransaction();
		session.delete(master);
	    master.setName("lu");	
		trans.commit();
		session.close();
	}

	/**
	 * 同步持久化对象
	 */
	public void testRefresh() {
		Session session = getSession();
		Master master = (Master) session.get(Master.class,3);
		System.out.println("before:"+master.getName());
		Transaction trans = session.beginTransaction();
		trans.commit();
		session.refresh(master);	
		System.out.println("after:"+master.getName());
		session.close();
	}

	/**
	 * 将游离态转换成持久态
	 */
	public void testD2P() {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		//临时太
		Master master = new Master();
		//游离态
		master.setId(3);
		master.setName("lloo");
		master.setSex(0);
		session.update(master);
		//持久太
		String name=master.getName();
		trans.commit();
	}

	/**
	 * 持久状态修改id(报错)
	 */
	public void testP2EditId() {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		Master master = (Master) session.get(Master.class,3);
		master.setId(100);
		trans.commit();
		session.close();
	}

	/**
	 * 游离态转换为暂时状态
	 */
	public void testD2S() {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		//临时态
		Master master = new Master();
		//游离态
        master.setId(3);
        session.delete(master);
        trans.commit();
        session.close();
	}

	/**
	 * 测试重复的持久化对象 (报错)
	 */
	public void testDuplicateP() {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		//持久太
		Master master = (Master) session.get(Master.class,4);
		//临时态
		Master master2 = new Master();
		master2.setName("游离");
		session.update(master2);
		System.out.println(master2);
		trans.commit();
		session.close();
	}

	/**
	 * 消除重复的持久化对象
	 */
	public void testRemoveDupli() {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		//持久太
		Master master = (Master) session.get(Master.class,4);
		//临时态
		Master master2 = new Master();
		master2.setId(4);
		master2.setName("游离");
		session.merge(master2);	
		trans.commit();
		System.out.println(master);
		System.out.println(master2);
		session.close();
	}

	public static void main(String[] args) {
		TestStudentsDao tsd = new TestStudentsDao();
		tsd.testRemoveDupli();
	}
}
