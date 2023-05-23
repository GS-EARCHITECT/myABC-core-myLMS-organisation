package institution_mgmt.institution_master.services;

import java.util.ArrayList;
import institution_mgmt.institution_master.model.dto.LMSInstitutionMasterDTO;

public interface I_LMSInstitutionMasterService 
{
	abstract public LMSInstitutionMasterDTO newLMSInstitutionMaster(LMSInstitutionMasterDTO resourceMediaDetailsDTO);
	abstract public ArrayList<LMSInstitutionMasterDTO> getAllInstitutions();
	abstract public ArrayList<LMSInstitutionMasterDTO> getSelectInstitutions(ArrayList<Long> ids);	
	abstract public ArrayList<LMSInstitutionMasterDTO> getSelectInstitutionsByLocations(ArrayList<Long> ids);
	abstract public void updLMSInstitutionMaster(LMSInstitutionMasterDTO LMSInstitutionMasterDTO);	
	abstract public void delAllLMSInstitutionMasters();	
	abstract public void delSelectInstitutions( ArrayList<Long> ids);
	abstract public void delSelectInstitutionsByLocations(ArrayList<Long> ids);
}