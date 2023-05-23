package course_mgmt.course_details.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import course_mgmt.course_details.model.dto.LMSCourseDetailsDTO;
import course_mgmt.course_details.services.I_LMSCourseDetailsService;

@RestController
@RequestMapping("/courseDetails")
public class LMS_CourseDetails_Controller {

private static final Logger logger = LoggerFactory.getLogger(LMS_CourseDetails_Controller.class);
	
	@Autowired
	private I_LMSCourseDetailsService lmsCourseDetailsServ ;
	

	@PostMapping("/addSubject")
	public ResponseEntity<LMSCourseDetailsDTO> addToSubject(@RequestBody LMSCourseDetailsDTO lms_CourseDetails_DTO) 
	{		
		LMSCourseDetailsDTO lms_CourseDetails_DTO2 = lmsCourseDetailsServ.newLMSCourseDetails(lms_CourseDetails_DTO);
		
	    HttpHeaders httpHeaders = new HttpHeaders();
	    return new ResponseEntity<>(lms_CourseDetails_DTO2, httpHeaders, HttpStatus.CREATED);		
	}

	@GetMapping(value="/getAllCourses", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<LMSCourseDetailsDTO>> getAllCourses() {
		

		ArrayList<LMSCourseDetailsDTO> lms_CourseDetails_DTOs = lmsCourseDetailsServ.getAllCourseDetails();
		return new ResponseEntity<>(lms_CourseDetails_DTOs, HttpStatus.OK);
			}
	
	@GetMapping(value="/getCourses", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<LMSCourseDetailsDTO>> getCoursesBySubjects(@RequestBody ArrayList<Long> subjectSeqNos) {
		logger.info("going :");
		ArrayList<LMSCourseDetailsDTO> courseDetails_DTOs = lmsCourseDetailsServ.getSelectCoursesBySubject(subjectSeqNos);
		return new ResponseEntity<>(courseDetails_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="/getSubjects", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<LMSCourseDetailsDTO>> getSubjectsByCourses(@RequestBody ArrayList<Long> courseSeqNos) {
		logger.info("going :");
		ArrayList<LMSCourseDetailsDTO> courseDetails_DTOs = lmsCourseDetailsServ.getSelectCoursesBySubject(courseSeqNos);
		return new ResponseEntity<>(courseDetails_DTOs, HttpStatus.OK);
	}

	@PutMapping("/courseUpdate")
	public void updateSubject(@RequestBody LMSCourseDetailsDTO lms_CourseDetails_DTO) {		
		lmsCourseDetailsServ.updLMSCourseDetails(lms_CourseDetails_DTO);
	}

	@DeleteMapping("/deleteSelectCourses")
	public void deleteCourse(@RequestBody ArrayList<Long> courseSeqNos) 
	{	
		lmsCourseDetailsServ.delSelectLMSCourses(courseSeqNos);
	}
	
	@DeleteMapping("/deleteAllCourses")
	public void deleteAllCourses() 
	{	
		lmsCourseDetailsServ.delAllCourses();
	}

}