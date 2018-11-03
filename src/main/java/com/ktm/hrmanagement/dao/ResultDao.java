package com.ktm.hrmanagement.dao;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ktm.hrmanagement.entity.CallLetterEntity;
import com.ktm.hrmanagement.entity.CertificateVerificationEntity;

@Service
public interface ResultDao {

	ModelAndView getresultDetail(int candidate_id,int round_id,String date);
	ModelAndView getSelectedCandidatesDetail(int round_id, int round_statusid);
	ModelAndView getSelectedCandidateProfileDetails(int candidate_id);

	ModelAndView setcallLetterAcceptedDetail(int candidate_id);
	ModelAndView getcallLetterAcceptanceInfoStatus(CallLetterEntity callletterentity);
	ModelAndView getAcceptedCandidatesDetail();
	ModelAndView getCallLetterRelease();
	ModelAndView getReleaseCandidateProfileDetails(int candidate_id);
	ModelAndView getemployee();
	ModelAndView getCertificateVerifyDetails(int candidate_id);
	ModelAndView setCertificateVerifyStatusDetails(CertificateVerificationEntity certificateVerifyentity);
	ModelAndView getemployeeProfileDetails(int candidate_id);
	ModelAndView searchSelectedCandidateResultDetails(String date);
	ModelAndView setcallLetterReleaseDetail(int candidate_id, int hr_id);
}
