package section_mgmt.section_details.services;

import java.util.ArrayList;
import section_mgmt.section_details.model.dto.LMSSectionDetailsDTO;

public interface I_LMSSectionDetailsService
{
    abstract public LMSSectionDetailsDTO newSectionDetails(LMSSectionDetailsDTO lmsSectionDetailsDTO);
    abstract public ArrayList<LMSSectionDetailsDTO> getAllSectionDetails();
    abstract public ArrayList<LMSSectionDetailsDTO> getStudentsForSections(ArrayList<Long> id);
    abstract public ArrayList<LMSSectionDetailsDTO> getSelectStudents(ArrayList<Long> ids);
    abstract public void updSectionDetails(LMSSectionDetailsDTO lMSSectionDetailsDTO); 
    abstract public void delSelectStudents( ArrayList<Long> studentSeqNos);
    abstract public void delSelectSections(ArrayList<Long> sectionSeqNos);
    abstract public void delAllSectionDetails();    
}