package department_mgmt.deptt_faculty_details.services;

import java.util.ArrayList;
import department_mgmt.deptt_faculty_details.model.dto.LMSDepttFacultyDetailsDTO;

public interface I_LMSDepttFacultyDetailsService
{
    abstract public LMSDepttFacultyDetailsDTO newDepttFacultyDetails(LMSDepttFacultyDetailsDTO lmsDepttFacultyDetailsDTO);
    abstract public ArrayList<LMSDepttFacultyDetailsDTO> getAllDepttFacultyDetails();
    abstract public ArrayList<LMSDepttFacultyDetailsDTO> getFacultiesForDeptt(Long id);
    abstract public ArrayList<LMSDepttFacultyDetailsDTO> getDepttForFaculties(Long id);
    abstract public ArrayList<LMSDepttFacultyDetailsDTO> getSelectFaculties(ArrayList<Long> ids);
    abstract public void updDepttFacultyDetails(LMSDepttFacultyDetailsDTO lMSDepttFacultyDetailsDTO); 
    abstract public void delAllDepttFaculties();    
    abstract public void delSelectDepttFaculties(ArrayList<Long> facultySeqNos);
}