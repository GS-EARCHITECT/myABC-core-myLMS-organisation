package student_mgmt.student_master.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import student_mgmt.student_master.model.dto.LMSStudentMasterDTO;
import student_mgmt.student_master.model.master.LMSStudentMaster;
import student_mgmt.student_master.model.repo.LMSStudentMasterRepo;

@Service("lmsStudentMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSStudentMasterService implements I_LMSStudentMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSStudentMaster_Controller.class);
	
	@Autowired
    private LMSStudentMasterRepo lmsStudentMasterRepo;

	@Override
    public ArrayList<LMSStudentMasterDTO> getAllStudents() 
    {
    	ArrayList<LMSStudentMasterDTO> studentMasterDTOs = new ArrayList<LMSStudentMasterDTO>();
    	ArrayList<LMSStudentMaster> studentMasterOpts =  (ArrayList<LMSStudentMaster>) lmsStudentMasterRepo.findAll();
    	    	
    	if(studentMasterOpts!=null)
    	{
    		studentMasterDTOs = getStudentMasterDtos(studentMasterOpts);
    	}
    	else
    	{
    		studentMasterDTOs= null;    	
    	}
            	
        return studentMasterDTOs;
    }
    
    @Override
    public ArrayList<LMSStudentMasterDTO> getSelectStudents(ArrayList<Long> ids)
	{
		ArrayList<LMSStudentMaster> lMasters = lmsStudentMasterRepo.getSelectStudents(ids);
		ArrayList<LMSStudentMasterDTO> LMSStudentMasterDTOs = new ArrayList<LMSStudentMasterDTO>();
		LMSStudentMasterDTO LMSStudentMasterDTO = null;

		if (lMasters != null) 
		{
		LMSStudentMasterDTOs = getStudentMasterDtos(lMasters);				
		}
		
		return LMSStudentMasterDTOs;
	}

    @Override
    public ArrayList<LMSStudentMasterDTO> getSelectStudentsByInst(ArrayList<Long> ids)
	{
		ArrayList<LMSStudentMaster> lMasters = lmsStudentMasterRepo.getSelectStudentsByInst(ids);
		ArrayList<LMSStudentMasterDTO> LMSStudentMasterDTOs = new ArrayList<LMSStudentMasterDTO>();
		LMSStudentMasterDTO LMSStudentMasterDTO = null;

		if (lMasters != null) 
		{
		LMSStudentMasterDTOs = getStudentMasterDtos(lMasters);				
		}
		
		return LMSStudentMasterDTOs;
	}

    public LMSStudentMasterDTO newLMSStudentMaster(LMSStudentMasterDTO lms_StudentMasterDTO) 
    {    	
    LMSStudentMaster lms_StudentMaster = lmsStudentMasterRepo.save(setCustomerMaster(lms_StudentMasterDTO));
    LMSStudentMasterDTO studentMasterDTO2 = getStudentMasterDto(lms_StudentMaster);
	return studentMasterDTO2;
    }

    public void updLMSStudentMaster(LMSStudentMasterDTO lMSStudentMasterDTO) 
    {
    LMSStudentMaster lms_StudentMaster = setCustomerMaster(lMSStudentMasterDTO);
    lmsStudentMasterRepo.save(lms_StudentMaster);    
    }
    
    public void delSelectStudents(ArrayList<Long> DocumentSeqNos) 
    {
    lmsStudentMasterRepo.delSelectStudents(DocumentSeqNos);
    }

    public void delSelectStudentsByInst(ArrayList<Long> ids) 
    {
    lmsStudentMasterRepo.delSelectStudentsByInst(ids);
    }
    
    public void delAllLMSStudentMasters() 
    {
    lmsStudentMasterRepo.deleteAll();
    }
    
    private ArrayList<LMSStudentMasterDTO> getStudentMasterDtos(ArrayList<LMSStudentMaster> lms_StudentMasters) 
	{
		LMSStudentMasterDTO studentMasterDTO = null;
		ArrayList<LMSStudentMasterDTO> studentMasterDTOs = new ArrayList<LMSStudentMasterDTO>(); 
		
		for(int i=0; i<lms_StudentMasters.size();i++)
		{		
		studentMasterDTO = getStudentMasterDto(lms_StudentMasters.get(i));
		studentMasterDTOs.add(studentMasterDTO);
		}		
		return studentMasterDTOs;
	}
	
	
	private LMSStudentMasterDTO getStudentMasterDto(LMSStudentMaster studentMaster) 
	{
		LMSStudentMasterDTO lDTO = new LMSStudentMasterDTO();
		lDTO.setInstitutionSeqNo(studentMaster.getInstitutionSeqNo());
		lDTO.setStudentId(studentMaster.getStudentId());
		lDTO.setPersonSeqNo(studentMaster.getPersonSeqNo());
		lDTO.setStudentSeqNo(studentMaster.getStudentSeqNo());
		lDTO.setRemarks(studentMaster.getRemarks());
		lDTO.setStatusSeqNo(studentMaster.getStatusSeqNo());		
		return lDTO;
		}
	
	private LMSStudentMaster setCustomerMaster(LMSStudentMasterDTO sMasterDTO) 
	{
		LMSStudentMaster lms_StudentMaster	=	new	LMSStudentMaster();
		lms_StudentMaster.setInstitutionSeqNo(sMasterDTO.getInstitutionSeqNo());
		lms_StudentMaster.setStudentId(sMasterDTO.getStudentId());
		lms_StudentMaster.setPersonSeqNo(sMasterDTO.getPersonSeqNo());		
		lms_StudentMaster.setRemarks(sMasterDTO.getRemarks());
		lms_StudentMaster.setStatusSeqNo(sMasterDTO.getStatusSeqNo());		
		return lms_StudentMaster;
	}

}
