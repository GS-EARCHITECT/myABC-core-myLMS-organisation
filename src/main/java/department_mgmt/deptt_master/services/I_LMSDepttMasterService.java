package department_mgmt.deptt_master.services;

import java.util.ArrayList;
import department_mgmt.deptt_master.model.dto.LMSDepttMasterDTO;

public interface I_LMSDepttMasterService
{
	abstract public LMSDepttMasterDTO newLMSDepttMaster(LMSDepttMasterDTO resourceMediaDetailsDTO);
	abstract public ArrayList<LMSDepttMasterDTO> getAllDeptts();
	abstract public ArrayList<LMSDepttMasterDTO> getSelectDeptts(ArrayList<Long> ids);	
	abstract public ArrayList<LMSDepttMasterDTO> getSelectDepttsByInst(ArrayList<Long> ids);
	abstract public void updLMSDepttMaster(LMSDepttMasterDTO LMSDepttMasterDTO);	
	abstract public void delAllLMSDepttMasters();	
	abstract public void delSelectDeptts(ArrayList<Long> ids);
	abstract public void delSelectDepttsByInst(ArrayList<Long> ids);	
   
}