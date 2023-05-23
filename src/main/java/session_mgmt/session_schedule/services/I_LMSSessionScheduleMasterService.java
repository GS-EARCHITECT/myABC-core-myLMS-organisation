package session_mgmt.session_schedule.services;

import java.util.ArrayList;

import session_mgmt.session_schedule.model.dto.LMSSessionScheduleMasterDTO;


public interface I_LMSSessionScheduleMasterService
{
    abstract public LMSSessionScheduleMasterDTO newLMSSessionSchedule(LMSSessionScheduleMasterDTO sessionScheduleDTO);
    abstract public ArrayList<LMSSessionScheduleMasterDTO> getAllLMSSessionSchedules();    
    abstract public ArrayList<LMSSessionScheduleMasterDTO> getSelectSessions(ArrayList<Long> ids);
    abstract public ArrayList<LMSSessionScheduleMasterDTO> getSelectSubjectsForSession(Long id);
    abstract public void updLMSSessionSchedule(LMSSessionScheduleMasterDTO LMSSessionScheduleMasterDTO); 
    abstract public void delSelectLMSSessions(ArrayList<Long> sessionSeqNos);
    abstract public void delAllLMSSessionSchedules();
}