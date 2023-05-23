package session_mgmt.session_schedule.controller;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import session_mgmt.session_schedule.model.dto.LMSSessionScheduleMasterDTO;
import session_mgmt.session_schedule.services.I_LMSSessionScheduleMasterService;

@RestController
@RequestMapping("/sessionSchedule")
public class LMSSessionScheduleController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMS_SessionSchedule_Controller.class);

	@Autowired
	private I_LMSSessionScheduleMasterService sessionScheduleServ;

	@PostMapping("/addSessionSchedule")
	public ResponseEntity<LMSSessionScheduleMasterDTO> addToSessionSchedule(
			@RequestBody LMSSessionScheduleMasterDTO lms_SessionSchedule_DTO) {
		LMSSessionScheduleMasterDTO lms_SessionSchedule_DTO2 = sessionScheduleServ
				.newLMSSessionSchedule(lms_SessionSchedule_DTO);

		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(lms_SessionSchedule_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllSessionSchedules", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSessionScheduleMasterDTO>> getAllSessionSchedules() {

		ArrayList<LMSSessionScheduleMasterDTO> lms_SessionSchedule_DTOs = sessionScheduleServ
				.getAllLMSSessionSchedules();
		return new ResponseEntity<>(lms_SessionSchedule_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSubjectsForSession/{sessionSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSessionScheduleMasterDTO>> getSubjectsForSession(
			@PathVariable Long sessionSeqNo) 
	{
		ArrayList<LMSSessionScheduleMasterDTO> sessionSchedule_DTOs = sessionScheduleServ.getSelectSubjectsForSession(sessionSeqNo);				
		return new ResponseEntity<>(sessionSchedule_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSessionSchedules", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSessionScheduleMasterDTO>> getSelectSessionSchedules(
			@RequestBody ArrayList<Long> sessionSeqNos) {
		ArrayList<LMSSessionScheduleMasterDTO> sessionSchedule_DTOs = sessionScheduleServ.getSelectSessions(sessionSeqNos);				
		return new ResponseEntity<>(sessionSchedule_DTOs, HttpStatus.OK);
	}

	@PutMapping("/sessionUpdate")
	public void updateSessionSchedule(@RequestBody LMSSessionScheduleMasterDTO lms_SessionSchedule_DTO) {
		sessionScheduleServ.updLMSSessionSchedule(lms_SessionSchedule_DTO);
	}

	@DeleteMapping("/deleteSelectSessionSchedules")
	public void deleteSession(@RequestBody ArrayList<Long> sessionSeqNos) 
	{
		sessionScheduleServ.delSelectLMSSessions(sessionSeqNos);
	}

	@DeleteMapping("/deleteAllSessionSchedules")
	public void deleteAllSessionSchedules() {
		sessionScheduleServ.delAllLMSSessionSchedules();
	}

}