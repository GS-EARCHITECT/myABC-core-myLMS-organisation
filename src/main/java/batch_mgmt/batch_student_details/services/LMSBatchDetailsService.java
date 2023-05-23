package batch_mgmt.batch_student_details.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import batch_mgmt.batch_student_details.model.details.LMSBatchDetails;
import batch_mgmt.batch_student_details.model.details.LMSBatchDetailsPK;
import batch_mgmt.batch_student_details.model.dto.LMSBatchDetailsDTO;
import batch_mgmt.batch_student_details.model.repo.LMSBatchDetailsRepo;

@Service("batchDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSBatchDetailsService implements I_LMSBatchDetailsService {

	@Autowired
	private LMSBatchDetailsRepo batchDetailsRepo;

	public LMSBatchDetailsDTO newLMSBatchDetails(LMSBatchDetailsDTO lMasters) {
		LMSBatchDetailsPK lmsBatchDetailsPK = new LMSBatchDetailsPK();
		lmsBatchDetailsPK.setBatchSeqNo(lMasters.getBatchSeqNo());
		lmsBatchDetailsPK.setStudentSeqNo(lMasters.getStudentSeqNo());
		LMSBatchDetails lmsBatchDetails = null;

		if (!batchDetailsRepo.existsById(lmsBatchDetailsPK)) {
			lmsBatchDetails = this.setLMSBatchDetails(lMasters);
			lmsBatchDetails.setId(lmsBatchDetailsPK);
			lMasters = getLMSBatchDetailsDTO(batchDetailsRepo.save(lmsBatchDetails));
		}

		return lMasters;
	}

	public ArrayList<LMSBatchDetailsDTO> getAllLMSBatchDetailss() {
		ArrayList<LMSBatchDetails> subjectList = (ArrayList<LMSBatchDetails>) batchDetailsRepo.findAll();
		ArrayList<LMSBatchDetailsDTO> lMasterss = new ArrayList<LMSBatchDetailsDTO>();
		lMasterss = subjectList != null ? this.getLMSBatchDetailsDTOs(subjectList) : null;
		return lMasterss;
	}

	public ArrayList<LMSBatchDetailsDTO> getSelectBatches(ArrayList<Long> ids) {
		ArrayList<LMSBatchDetails> lMasters = batchDetailsRepo.getSelectBatches(ids);
		ArrayList<LMSBatchDetailsDTO> LMSBatchDetailsDTOs = new ArrayList<LMSBatchDetailsDTO>();
		LMSBatchDetailsDTO LMSBatchDetailsDTO = null;

		if (lMasters != null) {
			LMSBatchDetailsDTOs = this.getLMSBatchDetailsDTOs(lMasters);
			LMSBatchDetailsDTOs.add(LMSBatchDetailsDTO);

		}
		return LMSBatchDetailsDTOs;
	}

	public ArrayList<LMSBatchDetailsDTO> getSelectStudents(ArrayList<Long> ids) {
		ArrayList<LMSBatchDetails> lMasters = batchDetailsRepo.getSelectStudents(ids);
		ArrayList<LMSBatchDetailsDTO> LMSBatchDetailsDTOs = new ArrayList<LMSBatchDetailsDTO>();
		LMSBatchDetailsDTO LMSBatchDetailsDTO = null;

		if (lMasters != null) {
			LMSBatchDetailsDTOs = this.getLMSBatchDetailsDTOs(lMasters);
			LMSBatchDetailsDTOs.add(LMSBatchDetailsDTO);

		}

		return LMSBatchDetailsDTOs;
	}

	public void updLMSBatchDetails(LMSBatchDetailsDTO lMaster) {
		LMSBatchDetailsPK lmsBatchDetailsPK = new LMSBatchDetailsPK();
		lmsBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsBatchDetailsPK.setStudentSeqNo(lMaster.getStudentSeqNo());
		LMSBatchDetails lMSBatchDetails = null;

		if (batchDetailsRepo.existsById(lmsBatchDetailsPK)) {
			lMSBatchDetails = setLMSBatchDetails(lMaster);
			lMSBatchDetails.setId(lmsBatchDetailsPK);
			batchDetailsRepo.save(lMSBatchDetails);
		}
		return;
	}

	public void delLMSBatchDetails(LMSBatchDetailsDTO lMaster) {
		LMSBatchDetailsPK lmsBatchDetailsPK = new LMSBatchDetailsPK();
		lmsBatchDetailsPK.setBatchSeqNo(lMaster.getBatchSeqNo());
		lmsBatchDetailsPK.setStudentSeqNo(lMaster.getStudentSeqNo());

		if (batchDetailsRepo.existsById(lmsBatchDetailsPK)) {
			batchDetailsRepo.deleteById(lmsBatchDetailsPK);
		}
		return;
	}

	public void delSelectLMSBatches(ArrayList<Long> DocumentSeqNos) {
		batchDetailsRepo.delSelectLMSBatches(DocumentSeqNos);
		return;
	}

	
	public void delSelectLMSStudents(ArrayList<Long> DocumentSeqNos) {
		batchDetailsRepo.delSelectLMSStudents(DocumentSeqNos);
		return;
	}
	
	public void delAllLMSBatchDetailss() {
		batchDetailsRepo.deleteAll();
	}

	private ArrayList<LMSBatchDetailsDTO> getLMSBatchDetailsDTOs(ArrayList<LMSBatchDetails> lMasters) {
		LMSBatchDetailsDTO lDTO = null;
		ArrayList<LMSBatchDetailsDTO> lMasterDTOs = new ArrayList<LMSBatchDetailsDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSBatchDetailsDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSBatchDetailsDTO getLMSBatchDetailsDTO(LMSBatchDetails lMaster) {
		LMSBatchDetailsDTO lDTO = new LMSBatchDetailsDTO();
		lDTO.setBatchSeqNo(lMaster.getId().getBatchSeqNo());
		lDTO.setStudentSeqNo(lMaster.getId().getStudentSeqNo());
		return lDTO;
	}

	private LMSBatchDetails setLMSBatchDetails(LMSBatchDetailsDTO lDTO) {
		LMSBatchDetails lMaster = new LMSBatchDetails();
		return lMaster;
	}
}