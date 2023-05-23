package batch_mgmt.batch_student_details.services;

import java.util.ArrayList;

import batch_mgmt.batch_student_details.model.dto.LMSBatchDetailsDTO;

public interface I_LMSBatchDetailsService
{
    abstract public LMSBatchDetailsDTO newLMSBatchDetails(LMSBatchDetailsDTO sessionDetailsDTO);
    abstract public ArrayList<LMSBatchDetailsDTO> getAllLMSBatchDetailss();    
    abstract public ArrayList<LMSBatchDetailsDTO> getSelectBatches(ArrayList<Long> ids);
    abstract public ArrayList<LMSBatchDetailsDTO> getSelectStudents(ArrayList<Long> ids);
	abstract public void updLMSBatchDetails(LMSBatchDetailsDTO LMSBatchDetailsDTO); 
	abstract public void delSelectLMSBatches(ArrayList<Long> ids);
	abstract public void delSelectLMSStudents(ArrayList<Long> ids);
    abstract public void delAllLMSBatchDetailss();
    
}