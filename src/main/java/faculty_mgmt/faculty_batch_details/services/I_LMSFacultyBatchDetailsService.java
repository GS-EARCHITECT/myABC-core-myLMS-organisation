package faculty_mgmt.faculty_batch_details.services;

import java.util.ArrayList;
import faculty_mgmt.faculty_batch_details.model.dto.LMSFacultyBatchDetailsDTO;

public interface I_LMSFacultyBatchDetailsService
{
    abstract public LMSFacultyBatchDetailsDTO newFacultyBatchDetails(LMSFacultyBatchDetailsDTO lmsFacultyBatchDetailsDTO);
    abstract public ArrayList<LMSFacultyBatchDetailsDTO> getAllFacultyBatchDetails();
    abstract public ArrayList<LMSFacultyBatchDetailsDTO> getFacultiesForBatch(Long id);
    abstract public ArrayList<LMSFacultyBatchDetailsDTO> getSelectFaculties(ArrayList<Long> ids);
    abstract public void updFacultyBatchDetails(LMSFacultyBatchDetailsDTO lMSFacultyBatchDetailsDTO); 
    abstract public void delSelectFacultyBatchDetails(ArrayList<Long> studentSeqNos);    
    abstract public void delAllFacultyBatchDetails();
}