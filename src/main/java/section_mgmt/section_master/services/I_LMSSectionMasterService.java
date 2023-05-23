package section_mgmt.section_master.services;

import java.util.ArrayList;

import section_mgmt.section_master.model.dto.LMSSectionMasterDTO;

public interface I_LMSSectionMasterService 
{
	abstract public LMSSectionMasterDTO newLMSSectionMaster(LMSSectionMasterDTO sectionMasterDTO);
	abstract public ArrayList<LMSSectionMasterDTO> getAllSections();
	abstract public ArrayList<LMSSectionMasterDTO> getSelectSections(ArrayList<Long> ids);	
	abstract public ArrayList<LMSSectionMasterDTO> getSelectSectionsByCourses(ArrayList<Long> ids);
	abstract public void updLMSSectionMaster(LMSSectionMasterDTO LMSSectionMasterDTO);	
	abstract public void delAllLMSSectionMasters();	
	abstract public void delSelectSections( ArrayList<Long> ids);
	abstract public void delSelectSectionsByCourses(ArrayList<Long> ids);	
}