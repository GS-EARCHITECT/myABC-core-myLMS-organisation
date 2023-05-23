package course_mgmt.course_master.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import course_mgmt.course_master.model.dto.LMSCourseMasterDTO;
import course_mgmt.course_master.model.master.LMSCourseMaster;
import course_mgmt.course_master.model.repo.LMS_CourseMaster_Repo;

@Service("lmsCourseMasterServ")
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
public class LMSCourseMasterService implements I_LMSCourseMasterService 
{

	//private static final Logger logger = LoggerFactory.getLogger(LMSCourseMaster_Controller.class);
	
	@Autowired
    private LMS_CourseMaster_Repo lmsCourseMasterRepo;

	@Override
    public ArrayList<LMSCourseMasterDTO> getAllCourses() 
    {
    	ArrayList<LMSCourseMasterDTO> courseMasterDTOs = new ArrayList<LMSCourseMasterDTO>();
    	ArrayList<LMSCourseMaster> courseMasterOpts =  (ArrayList<LMSCourseMaster>) lmsCourseMasterRepo.findAll();
    	    	
    	if(courseMasterOpts!=null)
    	{
    		courseMasterDTOs = getCourseMasterDtos(courseMasterOpts);
    	}
    	else
    	{
    		courseMasterDTOs= null;    	
    	}
            	
        return courseMasterDTOs;
    }
    
    @Override
    public ArrayList<LMSCourseMasterDTO> getSelectLMSCourses(ArrayList<Long> ids)
	{
		ArrayList<LMSCourseMaster> lMasters = lmsCourseMasterRepo.getSelectCourses(ids);
		ArrayList<LMSCourseMasterDTO> LMSCourseMasterDTOs = new ArrayList<LMSCourseMasterDTO>();
		LMSCourseMasterDTO LMSCourseMasterDTO = null;

		if (lMasters != null) 
		{
		LMSCourseMasterDTOs = getCourseMasterDtos(lMasters);				
		}
		
		return LMSCourseMasterDTOs;
	}

     
    public LMSCourseMasterDTO newLMSCourseMaster(LMSCourseMasterDTO lms_CourseMasterDTO) 
    {    	
    LMSCourseMaster lms_CourseMaster = lmsCourseMasterRepo.save(setCustomerMaster(lms_CourseMasterDTO));
    LMSCourseMasterDTO courseMasterDTO2 = getCourseMasterDto(lms_CourseMaster);
	return courseMasterDTO2;
    }

    public void updLMSCourseMaster(LMSCourseMasterDTO lMSCourseMasterDTO) 
    {
    LMSCourseMaster lms_CourseMaster = setCustomerMaster(lMSCourseMasterDTO);
    lmsCourseMasterRepo.save(lms_CourseMaster);    
    }
    
    public void delSelectLMSCourse(ArrayList<Long> DocumentSeqNos) 
    {
    lmsCourseMasterRepo.delSelectCourses(DocumentSeqNos);
    }

    public void delAllLMSCourseMasters() 
    {
    lmsCourseMasterRepo.deleteAll();
    }
    
    private ArrayList<LMSCourseMasterDTO> getCourseMasterDtos(ArrayList<LMSCourseMaster> lms_CourseMasters) 
	{
		LMSCourseMasterDTO courseMasterDTO = null;
		ArrayList<LMSCourseMasterDTO> courseMasterDTOs = new ArrayList<LMSCourseMasterDTO>(); 
		
		for(int i=0; i<lms_CourseMasters.size();i++)
		{		
		courseMasterDTO = getCourseMasterDto(lms_CourseMasters.get(i));
		courseMasterDTOs.add(courseMasterDTO);
		}		
		return courseMasterDTOs;
	}
	
	
	private LMSCourseMasterDTO getCourseMasterDto(LMSCourseMaster courseMaster) 
	{
		LMSCourseMasterDTO courseMasterDTO = new LMSCourseMasterDTO();
		courseMasterDTO.setCourse_seq_no(courseMaster.getCourse_seq_no());
		courseMasterDTO.setCourse(courseMaster.getCourse());
		courseMasterDTO.setInstituteSeqNo(courseMaster.getInstituteSeqNo());
		courseMasterDTO.setInternal_refno(courseMaster.getInternal_refno());
		return courseMasterDTO;
		}
	
	private LMSCourseMaster setCustomerMaster(LMSCourseMasterDTO courseMasterDTO) 
	{
		LMSCourseMaster lms_CustomerMaster	=	new	LMSCourseMaster();		
		lms_CustomerMaster.setCourse(courseMasterDTO.getCourse());
		lms_CustomerMaster.setInstituteSeqNo(courseMasterDTO.getInstituteSeqNo());		
		lms_CustomerMaster.setInternal_refno(courseMasterDTO.getInternal_refno());
		return lms_CustomerMaster;
	}

}
