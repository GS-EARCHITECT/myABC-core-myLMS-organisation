package session_mgmt.session_schedule.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import session_mgmt.session_schedule.model.dto.LMSSessionScheduleMasterDTO;
import session_mgmt.session_schedule.model.master.LMSSessionScheduleMaster;
import session_mgmt.session_schedule.model.master.LMSSessionScheduleMasterPK;
import session_mgmt.session_schedule.model.repo.LMSSessionScheduleMasterRepo;

@Service("sessionScheduleServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSessionScheduleMasterService implements I_LMSSessionScheduleMasterService 
{
	private static final Logger logger = LoggerFactory.getLogger(LMSSessionScheduleMasterService.class);
	
	@Autowired
	private LMSSessionScheduleMasterRepo sessionScheduleRepo;

	/*@Scheduled(fixedRate = 3000)
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public void scheduleSession() 
	{
		
		logger.info("BEGIN");
		// currDate = session start date
		// lastdate = currDate+number of days in course
		Date currDate = new Date(System.currentTimeMillis());
		Date frts = null;
		Date tots = null;
		Long ss = (long) 0;
		Long cs = (long) 0;
		DateFormat dtOnly = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat tmOnly = new SimpleDateFormat("HH:mm:ss");
		Long days = (long) 10;
		Integer dow =0;
		Long i = (long) 1;		
		String frTime=null;
		String toTime=null;
		String dt = null;		
		java.util.GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");				
		cal.setTime(currDate);
		
		for(long ctr=0; ctr<days; ctr++)
		 {			  		  
		  dow=cal.get(Calendar.DAY_OF_WEEK)-1;
		  logger.info("DOW IS :"+dow);		  
		  ArrayList<LMSSessionScheduleMaster> lms = sessionScheduleMasterRepo.getSessionsByDOW(i, dow);
		  dt = dtOnly.format(currDate);
		  
		  if(lms!=null)
			{ 
			for (int j = 0; j < lms.size(); j++) 
			{
			frTime=dt + " " +lms.get(j).getId().getFrDttm();
			toTime=dt + " " +lms.get(j).getId().getToDttm();
			cs=lms.get(j).getId().getSubjectSeqNo();
			ss=lms.get(j).getId().getSessionSeqNo();
			try {
				frts = formatter.parse(frTime);
				tots = formatter.parse(toTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Session :"+ss);
			logger.info("Subject :"+cs);
			logger.info("Date :"+dt);
			logger.info("From :"+frts);
			logger.info("To :"+tots);			
			}			
		  }
		  cal.add(Calendar.DATE, 1);
		  currDate=cal.getTime();
		  cal.setTime(currDate);	        
		}
		 logger.info("END");
	return;

	}*/

	public LMSSessionScheduleMasterDTO newLMSSessionSchedule(LMSSessionScheduleMasterDTO lMaster) 
	{
		LMSSessionScheduleMasterPK lmsSessionSchedulePK = new LMSSessionScheduleMasterPK();
		lmsSessionSchedulePK.setSessionSeqNo(lMaster.getSessionSeqNo());
		lmsSessionSchedulePK.setDowNo(lMaster.getDowNo());
		lmsSessionSchedulePK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		LMSSessionScheduleMaster lmsSessionSchedule = null;

		if (!sessionScheduleRepo.existsById(lmsSessionSchedulePK)) 
		{
			lmsSessionSchedule = this.setLMSSessionScheduleMaster(lMaster);
			lmsSessionSchedule.setId(lmsSessionSchedulePK);
			lMaster = getLMSSessionScheduleMasterDTO(sessionScheduleRepo.save(lmsSessionSchedule));
		}

		return lMaster;
	}

	public ArrayList<LMSSessionScheduleMasterDTO> getAllLMSSessionSchedules() 
	{
		ArrayList<LMSSessionScheduleMaster> sessionList = (ArrayList<LMSSessionScheduleMaster>) sessionScheduleRepo.findAll();
		ArrayList<LMSSessionScheduleMasterDTO> lMasters = new ArrayList<LMSSessionScheduleMasterDTO>();
		lMasters = sessionList != null ? this.getLMSSessionScheduleMasterDTOs(sessionList) : null;
		return lMasters;
	}

	public ArrayList<LMSSessionScheduleMasterDTO> getSelectSessions(ArrayList<Long> ids) {
		ArrayList<LMSSessionScheduleMaster> lMasters = sessionScheduleRepo.getSelectSessions(ids);
		ArrayList<LMSSessionScheduleMasterDTO> LMSSessionScheduleMasterDTOs = new ArrayList<LMSSessionScheduleMasterDTO>();
		LMSSessionScheduleMasterDTO LMSSessionScheduleMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSessionScheduleMasterDTO = this.getLMSSessionScheduleMasterDTO(lMasters.get(i));
				LMSSessionScheduleMasterDTOs.add(LMSSessionScheduleMasterDTO);
			}
		}
		return LMSSessionScheduleMasterDTOs;
	}

	public ArrayList<LMSSessionScheduleMasterDTO> getSelectSubjectsForSession(Long id) 
	{
		ArrayList<LMSSessionScheduleMaster> lMasters = sessionScheduleRepo.getSubjectsForSession(id);
		ArrayList<LMSSessionScheduleMasterDTO> LMSSessionScheduleMasterDTOs = new ArrayList<LMSSessionScheduleMasterDTO>();
		LMSSessionScheduleMasterDTO LMSSessionScheduleMasterDTO = null;

		if (lMasters != null) {
			for (int i = 0; i < lMasters.size(); i++) {
				LMSSessionScheduleMasterDTO = this.getLMSSessionScheduleMasterDTO(lMasters.get(i));
				LMSSessionScheduleMasterDTOs.add(LMSSessionScheduleMasterDTO);
			}
		}
		return LMSSessionScheduleMasterDTOs;
	}

	public void updLMSSessionSchedule(LMSSessionScheduleMasterDTO lMaster) 
	{
		LMSSessionScheduleMasterPK lmsSessionSchedulePK = new LMSSessionScheduleMasterPK();
		lmsSessionSchedulePK.setSessionSeqNo(lMaster.getSessionSeqNo());
		lmsSessionSchedulePK.setDowNo(lMaster.getDowNo());
		lmsSessionSchedulePK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		LMSSessionScheduleMaster lmsSessionSchedule = null;
		
		if (sessionScheduleRepo.existsById(lmsSessionSchedulePK)) 
		{
			lmsSessionSchedule = setLMSSessionScheduleMaster(lMaster);
			lmsSessionSchedule.setId(lmsSessionSchedulePK);
			sessionScheduleRepo.save(lmsSessionSchedule);
		}
		return;
	}

	public void delLMSSessionScheduleMaster(LMSSessionScheduleMasterDTO lMaster) 
	{
		LMSSessionScheduleMasterPK lmsSessionSchedulePK = new LMSSessionScheduleMasterPK();
		lmsSessionSchedulePK.setSessionSeqNo(lMaster.getSessionSeqNo());
		lmsSessionSchedulePK.setDowNo(lMaster.getDowNo());
		lmsSessionSchedulePK.setSubjectSeqNo(lMaster.getSubjectSeqNo());
		LMSSessionScheduleMaster lmsSessionSchedule = null;
		
		if (sessionScheduleRepo.existsById(lmsSessionSchedulePK)) {
			sessionScheduleRepo.deleteById(lmsSessionSchedulePK);
		}
		return;
	}

	public void delSelectLMSSessions(ArrayList<Long> sessionSeqNos) 
	{
		sessionScheduleRepo.delSelectLMSSessions(sessionSeqNos);
		return;
	}

	public void delAllLMSSessionSchedules() {
		sessionScheduleRepo.deleteAll();
	}

	private ArrayList<LMSSessionScheduleMasterDTO> getLMSSessionScheduleMasterDTOs(ArrayList<LMSSessionScheduleMaster> lMasters) {
		LMSSessionScheduleMasterDTO lDTO = null;
		ArrayList<LMSSessionScheduleMasterDTO> lMasterDTOs = new ArrayList<LMSSessionScheduleMasterDTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getLMSSessionScheduleMasterDTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private LMSSessionScheduleMasterDTO getLMSSessionScheduleMasterDTO(LMSSessionScheduleMaster lMaster) 
	{
		LMSSessionScheduleMasterDTO lDTO = new LMSSessionScheduleMasterDTO();
		lDTO.setSessionSeqNo(lMaster.getId().getSessionSeqNo());
		lDTO.setDowNo(lMaster.getId().getDowNo());
		lDTO.setSubjectSeqNo(lMaster.getId().getSubjectSeqNo());
		lDTO.setFrDttm(lMaster.getFrDttm());
		lDTO.setToDttm(lMaster.getToDttm());
		return lDTO;
	}

	private LMSSessionScheduleMaster setLMSSessionScheduleMaster(LMSSessionScheduleMasterDTO lDTO) 
	{
		LMSSessionScheduleMaster lMaster = new LMSSessionScheduleMaster();
		LMSSessionScheduleMasterPK lmsSessionSchedulePK = new LMSSessionScheduleMasterPK();
		lmsSessionSchedulePK.setSessionSeqNo(lDTO.getSessionSeqNo());
		lmsSessionSchedulePK.setDowNo(lDTO.getDowNo());
		lmsSessionSchedulePK.setSubjectSeqNo(lDTO.getSubjectSeqNo());
		lMaster.setId(lmsSessionSchedulePK);
		lMaster.setFrDttm(lDTO.getFrDttm());
		lMaster.setToDttm(lDTO.getToDttm());	
		return lMaster;
	}
}