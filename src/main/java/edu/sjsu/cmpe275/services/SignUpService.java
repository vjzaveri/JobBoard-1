package edu.sjsu.cmpe275.services;

import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.model.JobSeeker;

@Service
public interface SignUpService {
	public boolean signUpJobSeeker(JobSeeker jobseeker);
}