package com.te.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springmvc.beans.EmployeeBean;
import com.te.springmvc.customexception.EmployeeExp;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	//EntityManagerFactory factory = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public EmployeeBean authenticate(int id, String pwd) {

		try {
			//factory = Persistence.createEntityManagerFactory("spring_db");
			entityManager = factory.createEntityManager();
			EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
			if (bean != null) {
				if (bean.getPwd().equals(pwd)) {
					System.out.println("login Successful");
					return bean;
				} else {
					System.out.println("invalid credentials");
					throw new EmployeeExp("not found");
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		 finally {
				
				if (entityManager != null) {
					entityManager.close();
				}
			}

		throw new EmployeeExp("not found");
	}// End of authenticate method

	@Override
	public EmployeeBean getId(int id) {

		//factory = Persistence.createEntityManagerFactory("spring_db");
		entityManager = factory.createEntityManager();
		EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
		return bean;
		
		
	}// end of getId method

	@Override
	public boolean deleteEmp(int id) {
		try {
			//factory = Persistence.createEntityManagerFactory("spring_db");
			entityManager = factory.createEntityManager();
			EmployeeBean bean = entityManager.find(EmployeeBean.class, id);
			transaction = entityManager.getTransaction();

			transaction.begin();
			entityManager.remove(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();

				e.printStackTrace();
			}
		} finally {
			
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return false;

	}// End of deleteEmp method

	@Override
	public List<EmployeeBean> getAllEmployees() {

		try {
			//factory = Persistence.createEntityManagerFactory("spring_db");
			entityManager = factory.createEntityManager();

			String select = "from EmployeeBean";

			Query query = entityManager.createQuery(select);

			List<EmployeeBean> list = query.getResultList();

			if (list != null) {
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return null;

	}// End of getAllEmployees method

	@Override
	public boolean addEmp(EmployeeBean bean) {
		try {
			//factory = Persistence.createEntityManagerFactory("spring_db");
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();
			if (bean!=null) {
				entityManager.persist(bean);
			}
			transaction.commit();
			return true;

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();

			}
			e.printStackTrace();
		} finally {
			
			if (entityManager != null) {
				entityManager.close();
			}
		}

		return false;
	}

	@Override
	public boolean updateEmp(EmployeeBean bean) {
		
		try {
			entityManager = factory.createEntityManager();
			transaction = entityManager.getTransaction();

			transaction.begin();
			EmployeeBean info=entityManager.find(EmployeeBean.class,bean.getId());
			if (bean.getEname() != null && bean.getEname()!="") {
				info.setEname(bean.getEname());
			}
			if (bean.getDob()!=null) {
				info.setDob(bean.getDob());
			}
			if (bean.getPwd()!=null && bean.getPwd()!="") {
				info.setPwd(bean.getPwd());
			}
			transaction.commit();
			return true;
		}  catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();

			}
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return false;
	}
}
