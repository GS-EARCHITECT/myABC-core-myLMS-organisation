package student_mgmt.student_batch_details.services;

import java.util.ArrayList;
import student_mgmt.student_batch_details.model.dto.LMSStudentBatchDetailsDTO;

public interface I_LMSStudentBatchDetailsService
{
    abstract public LMSStudentBatchDetailsDTO newStudentBatchDetails(LMSStudentBatchDetailsDTO lmsStudentBatchDetailsDTO);
    abstract public ArrayList<LMSStudentBatchDetailsDTO> getAllStudentBatchDetails();
    abstract public ArrayList<LMSStudentBatchDetailsDTO> getStudentsForBatch(Long id);
    abstract public ArrayList<LMSStudentBatchDetailsDTO> getSelectStudents(ArrayList<Long> ids);
    abstract public void updStudentBatchDetails(LMSStudentBatchDetailsDTO lMSStudentBatchDetailsDTO); 
    abstract public void delSelectStudentBatchDetails(ArrayList<Long> studentSeqNos);    
    abstract public void delAllStudentBatchDetails();
}