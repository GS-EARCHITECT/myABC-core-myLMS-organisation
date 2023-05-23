package course_mgmt.course_master.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import course_mgmt.course_master.model.dto.LMSCourseMasterDTO;
import course_mgmt.course_master.services.I_LMSCourseMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/courseManagement")
public class LMSCourseMasterController {

//	private static final Logger logger = LoggerFactory.getLogger(LMSCourseMaster_Controller.class);

	@Autowired
	private I_LMSCourseMasterService lmsCourseMasterServ;
	
	@PostMapping("/new")
	public ResponseEntity<LMSCourseMasterDTO> newcourse(@RequestBody LMSCourseMasterDTO courseDTO) {
		LMSCourseMasterDTO courseDTO2 = lmsCourseMasterServ.newLMSCourseMaster(courseDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(courseDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllCourses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSCourseMasterDTO>> getAllLMSCourseMasters() {
		ArrayList<LMSCourseMasterDTO> courseDTOs = lmsCourseMasterServ.getAllCourses();
		return new ResponseEntity<>(courseDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectCourses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSCourseMasterDTO>> getSelectLMSMediaBySubjects(@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSCourseMasterDTO> courseDTOs = lmsCourseMasterServ.getSelectLMSCourses(subjectDetailsSeqNos);		
		return new ResponseEntity<>(courseDTOs, HttpStatus.OK);
	}	
	
	
	@PutMapping("/updcourse")
	public void updatecourse(@RequestBody LMSCourseMasterDTO courseDTO) 
	{
			lmsCourseMasterServ.updLMSCourseMaster(courseDTO);	
		return;
	}

	@DeleteMapping("/delSelectcourse")
	public void deleteSelectcourse(@RequestBody ArrayList<Long> courseSeqNoList) {
		lmsCourseMasterServ.delSelectLMSCourse(courseSeqNoList);
		return;
	}
	
	@DeleteMapping("/delAllcourse")
	public void deleteAllCourses() {
		lmsCourseMasterServ.delAllLMSCourseMasters();;
		return;
	}
	}