package institution_mgmt.institution_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import institution_mgmt.institution_master.model.dto.LMSInstitutionMasterDTO;
import institution_mgmt.institution_master.model.master.LMSInstitutionMaster;
import institution_mgmt.institution_master.model.repo.LMSInstitutionMasterRepo;

@Service("lmsInstitutionMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSInstitutionMasterService implements I_LMSInstitutionMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSInstitutionMaster_Controller.class);
	
	@Autowired
    private LMSInstitutionMasterRepo lmsInstitutionMasterRepo;

	@Override
    public ArrayList<LMSInstitutionMasterDTO> getAllInstitutions() 
    {
    	ArrayList<LMSInstitutionMasterDTO> studentMasterDTOs = new ArrayList<LMSInstitutionMasterDTO>();
    	ArrayList<LMSInstitutionMaster> studentMasterOpts =  (ArrayList<LMSInstitutionMaster>) lmsInstitutionMasterRepo.findAll();
    	    	
    	if(studentMasterOpts!=null)
    	{
    		studentMasterDTOs = getInstitutionMasterDtos(studentMasterOpts);
    	}
    	else
    	{
    		studentMasterDTOs= null;    	
    	}
            	
        return studentMasterDTOs;
    }
    
    @Override
    public ArrayList<LMSInstitutionMasterDTO> getSelectInstitutions(ArrayList<Long> ids)
	{
		ArrayList<LMSInstitutionMaster> lMasters = lmsInstitutionMasterRepo.getSelectInstitutions(ids);
		ArrayList<LMSInstitutionMasterDTO> LMSInstitutionMasterDTOs = new ArrayList<LMSInstitutionMasterDTO>();
		LMSInstitutionMasterDTO LMSInstitutionMasterDTO = null;

		if (lMasters != null) 
		{
		LMSInstitutionMasterDTOs = getInstitutionMasterDtos(lMasters);				
		}
		
		return LMSInstitutionMasterDTOs;
	}

    @Override
    public ArrayList<LMSInstitutionMasterDTO> getSelectInstitutionsByLocations(ArrayList<Long> ids)
	{
		ArrayList<LMSInstitutionMaster> lMasters = lmsInstitutionMasterRepo.getSelectInstitutionsByLocations(ids);
		ArrayList<LMSInstitutionMasterDTO> LMSInstitutionMasterDTOs = new ArrayList<LMSInstitutionMasterDTO>();
		LMSInstitutionMasterDTO LMSInstitutionMasterDTO = null;

		if (lMasters != null) 
		{
		LMSInstitutionMasterDTOs = getInstitutionMasterDtos(lMasters);				
		}
		
		return LMSInstitutionMasterDTOs;
	}

    public LMSInstitutionMasterDTO newLMSInstitutionMaster(LMSInstitutionMasterDTO lms_InstitutionMasterDTO) 
    {    	
    LMSInstitutionMaster lms_InstitutionMaster = lmsInstitutionMasterRepo.save(setCustomerMaster(lms_InstitutionMasterDTO));
    LMSInstitutionMasterDTO studentMasterDTO2 = getInstitutionMasterDto(lms_InstitutionMaster);
	return studentMasterDTO2;
    }

    public void updLMSInstitutionMaster(LMSInstitutionMasterDTO lMSInstitutionMasterDTO) 
    {
    LMSInstitutionMaster lms_InstitutionMaster = setCustomerMaster(lMSInstitutionMasterDTO);
    lmsInstitutionMasterRepo.save(lms_InstitutionMaster);    
    }
    
    public void delSelectInstitutions(ArrayList<Long> DocumentSeqNos) 
    {
    lmsInstitutionMasterRepo.delSelectInstitutions(DocumentSeqNos);
    }

    public void delSelectInstitutionsByLocations(ArrayList<Long> ids) 
    {
    lmsInstitutionMasterRepo.delSelectInstitutionsByLocations(ids);
    }
    
    public void delAllLMSInstitutionMasters() 
    {
    lmsInstitutionMasterRepo.deleteAll();
    }
    
    private ArrayList<LMSInstitutionMasterDTO> getInstitutionMasterDtos(ArrayList<LMSInstitutionMaster> lms_InstitutionMasters) 
	{
		LMSInstitutionMasterDTO studentMasterDTO = null;
		ArrayList<LMSInstitutionMasterDTO> studentMasterDTOs = new ArrayList<LMSInstitutionMasterDTO>(); 
		
		for(int i=0; i<lms_InstitutionMasters.size();i++)
		{		
		studentMasterDTO = getInstitutionMasterDto(lms_InstitutionMasters.get(i));
		studentMasterDTOs.add(studentMasterDTO);
		}		
		return studentMasterDTOs;
	}
	
	
	private LMSInstitutionMasterDTO getInstitutionMasterDto(LMSInstitutionMaster studentMaster) 
	{
		LMSInstitutionMasterDTO lDTO = new LMSInstitutionMasterDTO();
		lDTO.setInstitutionSeqNo(studentMaster.getInstitutionSeqNo());
		lDTO.setInstitution(studentMaster.getInstitution());
		lDTO.setLocationSeqNo(studentMaster.getLocationSeqNo());
		lDTO.setStatusSeqNo(studentMaster.getStatusSeqNo());		
		return lDTO;
		}
	
	private LMSInstitutionMaster setCustomerMaster(LMSInstitutionMasterDTO sMasterDTO) 
	{
		LMSInstitutionMaster lms_InstitutionMaster	=	new	LMSInstitutionMaster();
		lms_InstitutionMaster.setInstitutionSeqNo(sMasterDTO.getInstitutionSeqNo());
		lms_InstitutionMaster.setInstitution(sMasterDTO.getInstitution());
		lms_InstitutionMaster.setLocationSeqNo(sMasterDTO.getLocationSeqNo());
		lms_InstitutionMaster.setStatusSeqNo(sMasterDTO.getStatusSeqNo());		
		return lms_InstitutionMaster;
	}

}
