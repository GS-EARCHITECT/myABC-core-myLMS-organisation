package student_mgmt.student_master.services;

import java.util.ArrayList;
import student_mgmt.student_master.model.dto.LMSStudentMasterDTO;

public interface I_LMSStudentMasterService 
{
	abstract public LMSStudentMasterDTO newLMSStudentMaster(LMSStudentMasterDTO resourceMediaDetailsDTO);
	abstract public ArrayList<LMSStudentMasterDTO> getAllStudents();
	abstract public ArrayList<LMSStudentMasterDTO> getSelectStudents(ArrayList<Long> ids);	
	abstract public ArrayList<LMSStudentMasterDTO> getSelectStudentsByInst(ArrayList<Long> ids);
	abstract public void updLMSStudentMaster(LMSStudentMasterDTO LMSStudentMasterDTO);	
	abstract public void delAllLMSStudentMasters();	
	abstract public void delSelectStudents( ArrayList<Long> ids);
	abstract public void delSelectStudentsByInst(ArrayList<Long> ids);	
}