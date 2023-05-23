package batch_mgmt.batch_master.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import batch_mgmt.batch_master.model.dto.LMSBatchMasterDTO;
import batch_mgmt.batch_master.model.master.LMSBatchMaster;
import batch_mgmt.batch_master.model.repo.LMSBatchMasterRepo;

@Service("lmsBatchMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSBatchMasterService implements I_LMSBatchMasterService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSBatchMaster_Controller.class);

	@Autowired
	private LMSBatchMasterRepo lmsBatchMasterRepo;

	public LMSBatchMasterDTO newBatch(LMSBatchMasterDTO lms_BatchMasterDTO) {
		LMSBatchMaster lms_BatchMaster = lmsBatchMasterRepo.save(setCustomerMaster(lms_BatchMasterDTO));
		LMSBatchMasterDTO batchMasterDTO2 = getBatchMasterDto(lms_BatchMaster);
		return batchMasterDTO2;
	}

	@Override
	public ArrayList<LMSBatchMasterDTO> getAllBatches() {
		ArrayList<LMSBatchMasterDTO> batchMasterDTOs = new ArrayList<LMSBatchMasterDTO>();
		ArrayList<LMSBatchMaster> batchMasterOpts = (ArrayList<LMSBatchMaster>) lmsBatchMasterRepo.findAll();

		if (batchMasterOpts != null) {
			batchMasterDTOs = getBatchMasterDtos(batchMasterOpts);
		} else {
			batchMasterDTOs = null;
		}

		return batchMasterDTOs;
	}

	@Override
	public ArrayList<LMSBatchMasterDTO> getSelectBatches(ArrayList<Long> ids) {
		ArrayList<LMSBatchMaster> lMasters = lmsBatchMasterRepo.getSelectBatches(ids);
		ArrayList<LMSBatchMasterDTO> LMSBatchMasterDTOs = new ArrayList<LMSBatchMasterDTO>();

		if (lMasters != null) {
			LMSBatchMasterDTOs = getBatchMasterDtos(lMasters);
		}

		return LMSBatchMasterDTOs;
	}

	@Override
	public ArrayList<LMSBatchMasterDTO> getSelectBatchesForCourses(ArrayList<Long> ids)
	{
		ArrayList<LMSBatchMaster> lMasters = lmsBatchMasterRepo.getSelectBatchesForCourses(ids);
		ArrayList<LMSBatchMasterDTO> LMSBatchMasterDTOs = new ArrayList<LMSBatchMasterDTO>();

		if (lMasters != null) {
			LMSBatchMasterDTOs = getBatchMasterDtos(lMasters);
		}

		return LMSBatchMasterDTOs;
	}

	
	@Override
	public ArrayList<LMSBatchMasterDTO> getSelectBatchesBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);

		ArrayList<LMSBatchMaster> lMasters = lmsBatchMasterRepo.getSelectBatchesBetweenTimes(ts_Fr, ts_To);
		ArrayList<LMSBatchMasterDTO> LMSBatchMasterDTOs = new ArrayList<LMSBatchMasterDTO>();

		if (lMasters != null) {
			LMSBatchMasterDTOs = getBatchMasterDtos(lMasters);
		}

		return LMSBatchMasterDTOs;
	}

	public void updBatch(LMSBatchMasterDTO lMSBatchMasterDTO) {
		LMSBatchMaster lms_BatchMaster = setCustomerMaster(lMSBatchMasterDTO);
		lmsBatchMasterRepo.save(lms_BatchMaster);
	}

	public void delSelectBatches(ArrayList<Long> batchSeqNos) {
		lmsBatchMasterRepo.delSelectBatches(batchSeqNos);
	}

	public void delSelectBatchesForCourses(ArrayList<Long> ids) {
		lmsBatchMasterRepo.delSelectBatchesForCourses(ids);
	}

	public void delSelectBatchesBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lmsBatchMasterRepo.delSelectBatchesBetweenTimes(ts_Fr, ts_To);
		return;
	}

	public void delAllBatches() {
		lmsBatchMasterRepo.deleteAll();
	}

	private ArrayList<LMSBatchMasterDTO> getBatchMasterDtos(ArrayList<LMSBatchMaster> lms_BatchMasters) {
		LMSBatchMasterDTO batchMasterDTO = null;
		ArrayList<LMSBatchMasterDTO> batchMasterDTOs = new ArrayList<LMSBatchMasterDTO>();

		for (int i = 0; i < lms_BatchMasters.size(); i++) {
			batchMasterDTO = getBatchMasterDto(lms_BatchMasters.get(i));
			batchMasterDTOs.add(batchMasterDTO);
		}
		return batchMasterDTOs;
	}

	private LMSBatchMasterDTO getBatchMasterDto(LMSBatchMaster batchMaster) {
		LMSBatchMasterDTO lDTO = new LMSBatchMasterDTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		lDTO.setFrDttm(formatter.format(batchMaster.getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(batchMaster.getToDttm().toLocalDateTime()));
		lDTO.setBatchSeqNo(batchMaster.getBatchSeqNo());
		lDTO.setBatchId(batchMaster.getBatchId());
		lDTO.setBatchSummary(batchMaster.getBatchSummary());
		lDTO.setBatchTitle(batchMaster.getBatchTitle());
		lDTO.setCourseSeqNo(batchMaster.getCourseSeqNo());
		return lDTO;
	}

	private LMSBatchMaster setCustomerMaster(LMSBatchMasterDTO sMasterDTO) {
		LMSBatchMaster lms_sLmsBatchMaster = new LMSBatchMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateTimeFr = LocalDateTime.parse(sMasterDTO.getFrDttm(), formatter);
		LocalDateTime dateTimeTo = LocalDateTime.parse(sMasterDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateTimeFr);
		Timestamp ts_To = Timestamp.valueOf(dateTimeTo);
		lms_sLmsBatchMaster.setFrDttm(ts_Fr);
		lms_sLmsBatchMaster.setToDttm(ts_To);
		lms_sLmsBatchMaster.setBatchId(sMasterDTO.getBatchId());
		lms_sLmsBatchMaster.setBatchSummary(sMasterDTO.getBatchSummary());
		lms_sLmsBatchMaster.setBatchTitle(sMasterDTO.getBatchTitle());
		lms_sLmsBatchMaster.setCourseSeqNo(sMasterDTO.getCourseSeqNo());
		return lms_sLmsBatchMaster;
	}

}
