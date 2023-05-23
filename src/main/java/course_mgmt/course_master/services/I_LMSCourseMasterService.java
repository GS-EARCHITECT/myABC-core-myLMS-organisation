package course_mgmt.course_master.services;

import java.util.ArrayList;

import course_mgmt.course_master.model.dto.LMSCourseMasterDTO;


public interface I_LMSCourseMasterService 
{

	abstract public LMSCourseMasterDTO newLMSCourseMaster(LMSCourseMasterDTO resourceMediaDetailsDTO);
	abstract public ArrayList<LMSCourseMasterDTO> getAllCourses();
	abstract public ArrayList<LMSCourseMasterDTO> getSelectLMSCourses(ArrayList<Long> ids);	
	abstract public void updLMSCourseMaster(LMSCourseMasterDTO LMSCourseMasterDTO);	
	abstract public void delSelectLMSCourse(ArrayList<Long> DocumentSeqNos);
	abstract public void delAllLMSCourseMasters();	
}