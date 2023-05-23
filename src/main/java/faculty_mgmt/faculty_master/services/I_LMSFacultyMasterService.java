package faculty_mgmt.faculty_master.services;

import java.util.ArrayList;

import faculty_mgmt.faculty_master.model.dto.LMSFacultyMasterDTO;

public interface I_LMSFacultyMasterService 
{
	abstract public LMSFacultyMasterDTO newLMSFacultyMaster(LMSFacultyMasterDTO resourceMediaDetailsDTO);
	abstract public ArrayList<LMSFacultyMasterDTO> getAllFaculties();
	abstract public ArrayList<LMSFacultyMasterDTO> getSelectFaculties(ArrayList<Long> ids);	
	abstract public ArrayList<LMSFacultyMasterDTO> getSelectFacultiesByInst(ArrayList<Long> ids);
	abstract public void updLMSFacultyMaster(LMSFacultyMasterDTO LMSFacultyMasterDTO);	
	abstract public void delAllLMSFacultyMasters();	
	abstract public void delSelectFaculties(ArrayList<Long> ids);
	abstract public void delSelectFacultiesByInst(ArrayList<Long> ids);	
}