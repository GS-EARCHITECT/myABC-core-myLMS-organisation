package course_mgmt.course_details.services;

import java.util.ArrayList;
import course_mgmt.course_details.model.dto.LMSCourseDetailsDTO;

public interface I_LMSCourseDetailsService
{
    abstract public ArrayList<LMSCourseDetailsDTO> getAllCourseDetails();    
    abstract public ArrayList<LMSCourseDetailsDTO> getSelectSubjectsByCourse(ArrayList<Long> ids);
    abstract public ArrayList<LMSCourseDetailsDTO> getSelectCoursesBySubject(ArrayList<Long> ids);
    abstract public void delSelectLMSCourses( ArrayList<Long> ids);
    abstract public LMSCourseDetailsDTO newLMSCourseDetails(LMSCourseDetailsDTO lMasters);
    abstract void updLMSCourseDetails(LMSCourseDetailsDTO lMaster);
    abstract public void delAllCourses();
}