package faculty_mgmt.faculty_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import faculty_mgmt.faculty_master.model.dto.LMSFacultyMasterDTO;
import faculty_mgmt.faculty_master.model.master.LMSFacultyMaster;
import faculty_mgmt.faculty_master.model.repo.LMSFacultyMasterRepo;

@Service("lmsFacultyMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSFacultyMasterService implements I_LMSFacultyMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSFacultyMaster_Controller.class);
	
	@Autowired
    private LMSFacultyMasterRepo lmsFacultyMasterRepo;

	@Override
    public ArrayList<LMSFacultyMasterDTO> getAllFaculties() 
    {
    	ArrayList<LMSFacultyMasterDTO> studentMasterDTOs = new ArrayList<LMSFacultyMasterDTO>();
    	ArrayList<LMSFacultyMaster> studentMasterOpts =  (ArrayList<LMSFacultyMaster>) lmsFacultyMasterRepo.findAll();
    	    	
    	if(studentMasterOpts!=null)
    	{
    		studentMasterDTOs = getFacultyMasterDtos(studentMasterOpts);
    	}
    	else
    	{
    		studentMasterDTOs= null;    	
    	}
            	
        return studentMasterDTOs;
    }
    
    @Override
    public ArrayList<LMSFacultyMasterDTO> getSelectFaculties(ArrayList<Long> ids)
	{
		ArrayList<LMSFacultyMaster> lMasters = lmsFacultyMasterRepo.getSelectFaculties(ids);
		ArrayList<LMSFacultyMasterDTO> LMSFacultyMasterDTOs = new ArrayList<LMSFacultyMasterDTO>();
		LMSFacultyMasterDTO LMSFacultyMasterDTO = null;

		if (lMasters != null) 
		{
		LMSFacultyMasterDTOs = getFacultyMasterDtos(lMasters);				
		}
		
		return LMSFacultyMasterDTOs;
	}

    @Override
    public ArrayList<LMSFacultyMasterDTO> getSelectFacultiesByInst(ArrayList<Long> ids)
	{
		ArrayList<LMSFacultyMaster> lMasters = lmsFacultyMasterRepo.getSelectFacultiesByInst(ids);
		ArrayList<LMSFacultyMasterDTO> LMSFacultyMasterDTOs = new ArrayList<LMSFacultyMasterDTO>();
		LMSFacultyMasterDTO LMSFacultyMasterDTO = null;

		if (lMasters != null) 
		{
		LMSFacultyMasterDTOs = getFacultyMasterDtos(lMasters);				
		}
		
		return LMSFacultyMasterDTOs;
	}

    public LMSFacultyMasterDTO newLMSFacultyMaster(LMSFacultyMasterDTO lms_FacultyMasterDTO) 
    {    	
    LMSFacultyMaster lms_FacultyMaster = lmsFacultyMasterRepo.save(setCustomerMaster(lms_FacultyMasterDTO));
    LMSFacultyMasterDTO studentMasterDTO2 = getFacultyMasterDto(lms_FacultyMaster);
	return studentMasterDTO2;
    }

    public void updLMSFacultyMaster(LMSFacultyMasterDTO lMSFacultyMasterDTO) 
    {
    LMSFacultyMaster lms_FacultyMaster = setCustomerMaster(lMSFacultyMasterDTO);
    lmsFacultyMasterRepo.save(lms_FacultyMaster);    
    }
    
    public void delSelectFaculties(ArrayList<Long> DocumentSeqNos) 
    {
    lmsFacultyMasterRepo.delSelectFaculties(DocumentSeqNos);
    }

    public void delSelectFacultiesByInst(ArrayList<Long> ids) 
    {
    lmsFacultyMasterRepo.delSelectFacultiesByInst(ids);
    }
    
    public void delAllLMSFacultyMasters() 
    {
    lmsFacultyMasterRepo.deleteAll();
    }
    
    private ArrayList<LMSFacultyMasterDTO> getFacultyMasterDtos(ArrayList<LMSFacultyMaster> lms_FacultyMasters) 
	{
		LMSFacultyMasterDTO studentMasterDTO = null;
		ArrayList<LMSFacultyMasterDTO> studentMasterDTOs = new ArrayList<LMSFacultyMasterDTO>(); 
		
		for(int i=0; i<lms_FacultyMasters.size();i++)
		{		
		studentMasterDTO = getFacultyMasterDto(lms_FacultyMasters.get(i));
		studentMasterDTOs.add(studentMasterDTO);
		}		
		return studentMasterDTOs;
	}
	
	
	private LMSFacultyMasterDTO getFacultyMasterDto(LMSFacultyMaster studentMaster) 
	{
		LMSFacultyMasterDTO lDTO = new LMSFacultyMasterDTO();
		lDTO.setInstitutionSeqNo(studentMaster.getInstitutionSeqNo());
		lDTO.setFacultyId(studentMaster.getFacultyId());
		lDTO.setPersonSeqNo(studentMaster.getPersonSeqNo());
		lDTO.setFacultySeqNo(studentMaster.getFacultySeqNo());
		lDTO.setRemarks(studentMaster.getRemarks());
		lDTO.setStatusSeqNo(studentMaster.getStatusSeqNo());
		lDTO.setAssetSeqNo(studentMaster.getAssetSeqNo());		
		return lDTO;
		}
	
	private LMSFacultyMaster setCustomerMaster(LMSFacultyMasterDTO sMasterDTO) 
	{
		LMSFacultyMaster lms_FacultyMaster	=	new	LMSFacultyMaster();
		lms_FacultyMaster.setInstitutionSeqNo(sMasterDTO.getInstitutionSeqNo());
		lms_FacultyMaster.setFacultyId(sMasterDTO.getFacultyId());
		lms_FacultyMaster.setPersonSeqNo(sMasterDTO.getPersonSeqNo());
		lms_FacultyMaster.setAssetSeqNo(sMasterDTO.getAssetSeqNo());
		lms_FacultyMaster.setRemarks(sMasterDTO.getRemarks());
		lms_FacultyMaster.setStatusSeqNo(sMasterDTO.getStatusSeqNo());		
		return lms_FacultyMaster;
	}

}
