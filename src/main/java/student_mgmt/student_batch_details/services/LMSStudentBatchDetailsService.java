package student_mgmt.student_batch_details.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import student_mgmt.student_batch_details.model.dto.LMSStudentBatchDetailsDTO;
import student_mgmt.student_batch_details.model.master.LMSStudentBatchDetails;
import student_mgmt.student_batch_details.model.master.LMSStudentBatchDetailsPK;
import student_mgmt.student_batch_details.model.repo.LMSStudentBatchDetailsRepo;

@Service("studentBatchDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSStudentBatchDetailsService implements I_LMSStudentBatchDetailsService 
{
	private static final Logger logger = LoggerFactory.getLogger(LMSStudentBatchDetailsService.class);
	
	@Autowired
	private LMSStudentBatchDetailsRepo studentBatchDetailsRepo;

	public LMSStudentBatchDetailsDTO newStudentBatchDetails(LMSStudentBatchDetailsDTO lMaster) 
	{
		LMSStudentBatchDetailsPK lmsstudentBatchDetailsPK = new LMSStudentBatchDetailsPK();
		lmsstudentBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsstudentBatchDetailsPK.setStudentSeqNo(lMaster.getStudentSeqNo());		
		LMSStudentBatchDetails lmsstudentBatchDetails = null;

		if (!studentBatchDetailsRepo.existsById(lmsstudentBatchDetailsPK)) 
		{
			lmsstudentBatchDetails = this.setStudentBatchDetails(lMaster);
			lmsstudentBatchDetails.setId(lmsstudentBatchDetailsPK);
			lMaster = getStudentBatchDetailsDTO(studentBatchDetailsRepo.save(lmsstudentBatchDetails));
		}

		return lMaster;
	}

	public ArrayList<LMSStudentBatchDetailsDTO> getAllStudentBatchDetails() 
	{
		ArrayList<LMSStudentBatchDetails> studentBatchDetailsList = (ArrayList<LMSStudentBatchDetails>) studentBatchDetailsRepo.findAll();
		ArrayList<LMSStudentBatchDetailsDTO> lMasters = new ArrayList<LMSStudentBatchDetailsDTO>();
		lMasters = studentBatchDetailsList != null ? this.getStudentBatchDetailsDTOs(studentBatchDetailsList) : null;
		return lMasters;
	}

	public ArrayList<LMSStudentBatchDetailsDTO> getSelectStudents(ArrayList<Long> ids) {
		ArrayList<LMSStudentBatchDetails> lMasters = studentBatchDetailsRepo.delSelectLMSStudents(ids);
		ArrayList<LMSStudentBatchDetailsDTO> LMSStudentBatchDetailsDTOs = new ArrayList<LMSStudentBatchDetailsDTO>();
		LMSStudentBatchDetailsDTO LMSStudentBatchDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSStudentBatchDetailsDTO = this.getStudentBatchDetailsDTO(lMasters.get(i));
				LMSStudentBatchDetailsDTOs.add(LMSStudentBatchDetailsDTO);
			}
		}
		return LMSStudentBatchDetailsDTOs;
	}

	public ArrayList<LMSStudentBatchDetailsDTO> getStudentsForBatch(Long id) 
	{
		ArrayList<LMSStudentBatchDetails> lMasters = studentBatchDetailsRepo.getStudentsForBatch(id);
		ArrayList<LMSStudentBatchDetailsDTO> LMSStudentBatchDetailsDTOs = new ArrayList<LMSStudentBatchDetailsDTO>();
		LMSStudentBatchDetailsDTO LMSStudentBatchDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSStudentBatchDetailsDTO = this.getStudentBatchDetailsDTO(lMasters.get(i));
				LMSStudentBatchDetailsDTOs.add(LMSStudentBatchDetailsDTO);
			}
		}
		return LMSStudentBatchDetailsDTOs;
	}

	public void updStudentBatchDetails(LMSStudentBatchDetailsDTO lMaster) 
	{
		LMSStudentBatchDetailsPK lmsstudentBatchDetailsPK = new LMSStudentBatchDetailsPK();
		lmsstudentBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsstudentBatchDetailsPK.setStudentSeqNo(lMaster.getStudentSeqNo());		
		LMSStudentBatchDetails lmsstudentBatchDetails = null;
		
		if (studentBatchDetailsRepo.existsById(lmsstudentBatchDetailsPK)) 
		{
			lmsstudentBatchDetails = setStudentBatchDetails(lMaster);
			lmsstudentBatchDetails.setId(lmsstudentBatchDetailsPK);
			studentBatchDetailsRepo.save(lmsstudentBatchDetails);
		}
		return;
	}

	public void delStudentBatchDetails(LMSStudentBatchDetailsDTO lMaster) 
	{
		LMSStudentBatchDetailsPK lmsstudentBatchDetailsPK = new LMSStudentBatchDetailsPK();
		lmsstudentBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsstudentBatchDetailsPK.setStudentSeqNo(lMaster.getStudentSeqNo());
		
		if (studentBatchDetailsRepo.existsById(lmsstudentBatchDetailsPK)) {
			studentBatchDetailsRepo.deleteById(lmsstudentBatchDetailsPK);
		}
		return;
	}

	public void delSelectStudentBatchDetails(ArrayList<Long> studentSeqNos) 
	{
		studentBatchDetailsRepo.delSelectLMSStudents(studentSeqNos);
		return;
	}

	public void delAllStudentBatchDetails() {
		studentBatchDetailsRepo.deleteAll();
	}

	private ArrayList<LMSStudentBatchDetailsDTO> getStudentBatchDetailsDTOs(ArrayList<LMSStudentBatchDetails> lMasters) {
		LMSStudentBatchDetailsDTO lDTO = null;
		ArrayList<LMSStudentBatchDetailsDTO> lMasterDTOs = new ArrayList<LMSStudentBatchDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getStudentBatchDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSStudentBatchDetailsDTO getStudentBatchDetailsDTO(LMSStudentBatchDetails lMaster) 
	{
		LMSStudentBatchDetailsDTO lDTO = new LMSStudentBatchDetailsDTO();
		lDTO.setBatchSeqNo(lMaster.getId().getBatchSeqNo());
		lDTO.setRemarks(lMaster.getRemarks());
		lDTO.setStatusSeqNo(lMaster.getStatusSeqNo());
		lDTO.setStudentSeqNo(lMaster.getId().getStudentSeqNo());		
		return lDTO;
	}

	private LMSStudentBatchDetails setStudentBatchDetails(LMSStudentBatchDetailsDTO lDTO) 
	{
		LMSStudentBatchDetails lMaster = new LMSStudentBatchDetails();
		LMSStudentBatchDetailsPK lmsstudentBatchDetailsPK = new LMSStudentBatchDetailsPK();
		lmsstudentBatchDetailsPK.setBatchSeqNo(lDTO.getBatchSeqNo());
		lmsstudentBatchDetailsPK.setStudentSeqNo(lDTO.getStudentSeqNo());		
		lMaster.setId(lmsstudentBatchDetailsPK);
		lMaster.setRemarks(lDTO.getRemarks());
		lMaster.setStatusSeqNo(lDTO.getStatusSeqNo());	
		return lMaster;
	}
}