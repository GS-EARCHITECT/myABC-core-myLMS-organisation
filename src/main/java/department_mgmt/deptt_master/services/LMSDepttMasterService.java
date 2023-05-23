package department_mgmt.deptt_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import department_mgmt.deptt_master.model.dto.LMSDepttMasterDTO;
import department_mgmt.deptt_master.model.master.LMSDepttMaster;
import department_mgmt.deptt_master.model.repo.LMSDepttMasterRepo;

@Service("lmsDepttMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSDepttMasterService implements I_LMSDepttMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSDepttMaster_Controller.class);
	
	@Autowired
    private LMSDepttMasterRepo lmsDepttMasterRepo;

	@Override
    public ArrayList<LMSDepttMasterDTO> getAllDeptts() 
    {
    	ArrayList<LMSDepttMasterDTO> studentMasterDTOs = new ArrayList<LMSDepttMasterDTO>();
    	ArrayList<LMSDepttMaster> studentMasterOpts =  (ArrayList<LMSDepttMaster>) lmsDepttMasterRepo.findAll();
    	    	
    	if(studentMasterOpts!=null)
    	{
    		studentMasterDTOs = getDepttMasterDtos(studentMasterOpts);
    	}
    	else
    	{
    		studentMasterDTOs= null;    	
    	}
            	
        return studentMasterDTOs;
    }
    
    @Override
    public ArrayList<LMSDepttMasterDTO> getSelectDeptts(ArrayList<Long> ids)
	{
		ArrayList<LMSDepttMaster> lMasters = lmsDepttMasterRepo.getSelectDeptts(ids);
		ArrayList<LMSDepttMasterDTO> LMSDepttMasterDTOs = new ArrayList<LMSDepttMasterDTO>();
		LMSDepttMasterDTO LMSDepttMasterDTO = null;

		if (lMasters != null) 
		{
		LMSDepttMasterDTOs = getDepttMasterDtos(lMasters);				
		}
		
		return LMSDepttMasterDTOs;
	}

    @Override
    public ArrayList<LMSDepttMasterDTO> getSelectDepttsByInst(ArrayList<Long> ids)
	{
		ArrayList<LMSDepttMaster> lMasters = lmsDepttMasterRepo.getSelectDepttsByInst(ids);
		ArrayList<LMSDepttMasterDTO> LMSDepttMasterDTOs = new ArrayList<LMSDepttMasterDTO>();
		LMSDepttMasterDTO LMSDepttMasterDTO = null;

		if (lMasters != null) 
		{
		LMSDepttMasterDTOs = getDepttMasterDtos(lMasters);				
		}
		
		return LMSDepttMasterDTOs;
	}

    public LMSDepttMasterDTO newLMSDepttMaster(LMSDepttMasterDTO lms_DepttMasterDTO) 
    {    	
    LMSDepttMaster lms_DepttMaster = lmsDepttMasterRepo.save(setCustomerMaster(lms_DepttMasterDTO));
    LMSDepttMasterDTO studentMasterDTO2 = getDepttMasterDto(lms_DepttMaster);
	return studentMasterDTO2;
    }

    public void updLMSDepttMaster(LMSDepttMasterDTO lMSDepttMasterDTO) 
    {
    LMSDepttMaster lms_DepttMaster = setCustomerMaster(lMSDepttMasterDTO);
    lmsDepttMasterRepo.save(lms_DepttMaster);    
    }
    
    public void delSelectDeptts(ArrayList<Long> DocumentSeqNos) 
    {
    lmsDepttMasterRepo.delSelectDeptts(DocumentSeqNos);
    }

    public void delSelectDepttsByInst(ArrayList<Long> ids) 
    {
    lmsDepttMasterRepo.delSelectDepttsByInst(ids);
    }
    
    public void delAllLMSDepttMasters() 
    {
    lmsDepttMasterRepo.deleteAll();
    }
    
    private ArrayList<LMSDepttMasterDTO> getDepttMasterDtos(ArrayList<LMSDepttMaster> lms_DepttMasters) 
	{
		LMSDepttMasterDTO studentMasterDTO = null;
		ArrayList<LMSDepttMasterDTO> studentMasterDTOs = new ArrayList<LMSDepttMasterDTO>(); 
		
		for(int i=0; i<lms_DepttMasters.size();i++)
		{		
		studentMasterDTO = getDepttMasterDto(lms_DepttMasters.get(i));
		studentMasterDTOs.add(studentMasterDTO);
		}		
		return studentMasterDTOs;
	}
	
	
	private LMSDepttMasterDTO getDepttMasterDto(LMSDepttMaster studentMaster) 
	{
		LMSDepttMasterDTO lDTO = new LMSDepttMasterDTO();
		lDTO.setInstitutionSeqNo(studentMaster.getInstitutionSeqNo());
		lDTO.setDepttId(studentMaster.getDepttId());
		lDTO.setPersonSeqNo(studentMaster.getPersonSeqNo());
		lDTO.setDepttSeqNo(studentMaster.getDepttSeqNo());
		lDTO.setPersonSeqNo(studentMaster.getPersonSeqNo());		
		return lDTO;
		}
	
	private LMSDepttMaster setCustomerMaster(LMSDepttMasterDTO sMasterDTO) 
	{
		LMSDepttMaster lms_DepttMaster	=	new	LMSDepttMaster();
		lms_DepttMaster.setInstitutionSeqNo(sMasterDTO.getInstitutionSeqNo());
		lms_DepttMaster.setDepttId(sMasterDTO.getDepttId());
		lms_DepttMaster.setPersonSeqNo(sMasterDTO.getPersonSeqNo());
		lms_DepttMaster.setDeptt(sMasterDTO.getDeptt());
		return lms_DepttMaster;
	}

}
