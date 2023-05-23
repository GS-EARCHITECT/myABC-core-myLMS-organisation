package faculty_mgmt.faculty_batch_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import faculty_mgmt.faculty_batch_details.model.dto.LMSFacultyBatchDetailsDTO;
import faculty_mgmt.faculty_batch_details.model.master.LMSFacultyBatchDetails;
import faculty_mgmt.faculty_batch_details.model.master.LMSFacultyBatchDetailsPK;
import faculty_mgmt.faculty_batch_details.model.repo.LMSFacultyBatchDetailsRepo;

@Service("facultyBatchDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSFacultyBatchDetailsService implements I_LMSFacultyBatchDetailsService 
{
	private static final Logger logger = LoggerFactory.getLogger(LMSFacultyBatchDetailsService.class);
	
	@Autowired
	private LMSFacultyBatchDetailsRepo facultyBatchDetailsRepo;

	public LMSFacultyBatchDetailsDTO newFacultyBatchDetails(LMSFacultyBatchDetailsDTO lMaster) 
	{
		LMSFacultyBatchDetailsPK lmsfacultyBatchDetailsPK = new LMSFacultyBatchDetailsPK();
		lmsfacultyBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsfacultyBatchDetailsPK.setFacultySeqNo(lMaster.getFacultySeqNo());		
		LMSFacultyBatchDetails lmsfacultyBatchDetails = null;

		if (!facultyBatchDetailsRepo.existsById(lmsfacultyBatchDetailsPK)) 
		{
			lmsfacultyBatchDetails = this.setFacultyBatchDetails(lMaster);
			lmsfacultyBatchDetails.setId(lmsfacultyBatchDetailsPK);
			lMaster = getFacultyBatchDetailsDTO(facultyBatchDetailsRepo.save(lmsfacultyBatchDetails));
		}

		return lMaster;
	}

	public ArrayList<LMSFacultyBatchDetailsDTO> getAllFacultyBatchDetails() 
	{
		ArrayList<LMSFacultyBatchDetails> facultyBatchDetailsList = (ArrayList<LMSFacultyBatchDetails>) facultyBatchDetailsRepo.findAll();
		ArrayList<LMSFacultyBatchDetailsDTO> lMasters = new ArrayList<LMSFacultyBatchDetailsDTO>();
		lMasters = facultyBatchDetailsList != null ? this.getFacultyBatchDetailsDTOs(facultyBatchDetailsList) : null;
		return lMasters;
	}

	public ArrayList<LMSFacultyBatchDetailsDTO> getSelectFaculties(ArrayList<Long> ids) {
		ArrayList<LMSFacultyBatchDetails> lMasters = facultyBatchDetailsRepo.delSelectLMSFaculties(ids);
		ArrayList<LMSFacultyBatchDetailsDTO> LMSFacultyBatchDetailsDTOs = new ArrayList<LMSFacultyBatchDetailsDTO>();
		LMSFacultyBatchDetailsDTO LMSFacultyBatchDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSFacultyBatchDetailsDTO = this.getFacultyBatchDetailsDTO(lMasters.get(i));
				LMSFacultyBatchDetailsDTOs.add(LMSFacultyBatchDetailsDTO);
			}
		}
		return LMSFacultyBatchDetailsDTOs;
	}

	public ArrayList<LMSFacultyBatchDetailsDTO> getFacultiesForBatch(Long id) 
	{
		ArrayList<LMSFacultyBatchDetails> lMasters = facultyBatchDetailsRepo.getFacultiesForBatch(id);
		ArrayList<LMSFacultyBatchDetailsDTO> LMSFacultyBatchDetailsDTOs = new ArrayList<LMSFacultyBatchDetailsDTO>();
		LMSFacultyBatchDetailsDTO LMSFacultyBatchDetailsDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSFacultyBatchDetailsDTO = this.getFacultyBatchDetailsDTO(lMasters.get(i));
				LMSFacultyBatchDetailsDTOs.add(LMSFacultyBatchDetailsDTO);
			}
		}
		return LMSFacultyBatchDetailsDTOs;
	}

	public void updFacultyBatchDetails(LMSFacultyBatchDetailsDTO lMaster) 
	{
		LMSFacultyBatchDetailsPK lmsfacultyBatchDetailsPK = new LMSFacultyBatchDetailsPK();
		lmsfacultyBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsfacultyBatchDetailsPK.setFacultySeqNo(lMaster.getFacultySeqNo());		
		LMSFacultyBatchDetails lmsfacultyBatchDetails = null;
		
		if (facultyBatchDetailsRepo.existsById(lmsfacultyBatchDetailsPK)) 
		{
			lmsfacultyBatchDetails = setFacultyBatchDetails(lMaster);
			lmsfacultyBatchDetails.setId(lmsfacultyBatchDetailsPK);
			facultyBatchDetailsRepo.save(lmsfacultyBatchDetails);
		}
		return;
	}

	public void delFacultyBatchDetails(LMSFacultyBatchDetailsDTO lMaster) 
	{
		LMSFacultyBatchDetailsPK lmsfacultyBatchDetailsPK = new LMSFacultyBatchDetailsPK();
		lmsfacultyBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsfacultyBatchDetailsPK.setFacultySeqNo(lMaster.getFacultySeqNo());
		
		if (facultyBatchDetailsRepo.existsById(lmsfacultyBatchDetailsPK)) {
			facultyBatchDetailsRepo.deleteById(lmsfacultyBatchDetailsPK);
		}
		return;
	}

	public void delSelectFacultyBatchDetails(ArrayList<Long> facultySeqNos) 
	{
		facultyBatchDetailsRepo.delSelectLMSFaculties(facultySeqNos);
		return;
	}

	public void delAllFacultyBatchDetails() {
		facultyBatchDetailsRepo.deleteAll();
	}

	private ArrayList<LMSFacultyBatchDetailsDTO> getFacultyBatchDetailsDTOs(ArrayList<LMSFacultyBatchDetails> lMasters) {
		LMSFacultyBatchDetailsDTO lDTO = null;
		ArrayList<LMSFacultyBatchDetailsDTO> lMasterDTOs = new ArrayList<LMSFacultyBatchDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getFacultyBatchDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSFacultyBatchDetailsDTO getFacultyBatchDetailsDTO(LMSFacultyBatchDetails lMaster) 
	{
		LMSFacultyBatchDetailsDTO lDTO = new LMSFacultyBatchDetailsDTO();
		lDTO.setBatchSeqNo(lMaster.getId().getBatchSeqNo());
		lDTO.setRemarks(lMaster.getRemarks());
		lDTO.setStatusSeqNo(lMaster.getStatusSeqNo());
		lDTO.setFacultySeqNo(lMaster.getId().getFacultySeqNo());		
		return lDTO;
	}

	private LMSFacultyBatchDetails setFacultyBatchDetails(LMSFacultyBatchDetailsDTO lDTO) 
	{
		LMSFacultyBatchDetails lMaster = new LMSFacultyBatchDetails();
		LMSFacultyBatchDetailsPK lmsfacultyBatchDetailsPK = new LMSFacultyBatchDetailsPK();
		lmsfacultyBatchDetailsPK.setBatchSeqNo(lDTO.getBatchSeqNo());
		lmsfacultyBatchDetailsPK.setFacultySeqNo(lDTO.getFacultySeqNo());		
		lMaster.setId(lmsfacultyBatchDetailsPK);
		lMaster.setRemarks(lDTO.getRemarks());
		lMaster.setStatusSeqNo(lDTO.getStatusSeqNo());	
		return lMaster;
	}
}