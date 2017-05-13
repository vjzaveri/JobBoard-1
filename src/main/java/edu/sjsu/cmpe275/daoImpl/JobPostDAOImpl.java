package edu.sjsu.cmpe275.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.cmpe275.dao.CompanyDAO;
import edu.sjsu.cmpe275.dao.JobPostDAO;
import edu.sjsu.cmpe275.dao.SignUpDAO;
import edu.sjsu.cmpe275.model.JobPost;
import edu.sjsu.cmpe275.model.JobSeeker;

@Repository
public class JobPostDAOImpl implements JobPostDAO{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	@Transactional
	public boolean addNewJob(JobPost jobPost) {
		
		try{
			em.persist(jobPost);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	@Transactional
	public JobPost getJobDetails(String jobid) {
		
		try{
			JobPost jobPost = em.find(JobPost.class, jobid);
			System.out.println("jobPost1 "+jobPost.getTitle());
			return jobPost;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	@Transactional
	public boolean updateJobDetails(JobPost jobPost) {
		
		try {
			System.out.println("inside "+jobPost.getTitle());
			em.merge(jobPost);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	

}
