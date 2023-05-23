package batch_mgmt.batch_master.services;

import java.util.ArrayList;
import batch_mgmt.batch_master.model.dto.LMSBatchMasterDTO;

public interface I_LMSBatchMasterService 
{
	abstract public LMSBatchMasterDTO newBatch(LMSBatchMasterDTO batchDTO);
	abstract public ArrayList<LMSBatchMasterDTO> getAllBatches();
	abstract public ArrayList<LMSBatchMasterDTO> getSelectBatches(ArrayList<Long> ids);
	abstract public ArrayList<LMSBatchMasterDTO> getSelectBatchesBetweenTimes(String fr, String to);
	abstract public ArrayList<LMSBatchMasterDTO> getSelectBatchesForCourses(ArrayList<Long> ids);
	abstract public void updBatch(LMSBatchMasterDTO LMSBatchMasterDTO);
	abstract public void delSelectBatches(ArrayList<Long> ids);
	abstract public void delSelectBatchesForCourses(ArrayList<Long> ids);
	abstract public void delAllBatches();
	abstract public void delSelectBatchesBetweenTimes(String fr, String to);
}