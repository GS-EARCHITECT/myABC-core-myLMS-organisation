package student_mgmt.student_master.controller;

import java.util.ArrayList;
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
import student_mgmt.student_master.model.dto.LMSStudentMasterDTO;
import student_mgmt.student_master.services.I_LMSStudentMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/studentManagement")
public class LMSStudentMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSStudentMaster_Controller.class);

	@Autowired
	private I_LMSStudentMasterService lmsStudentMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSStudentMasterDTO> newstudent(@RequestBody LMSStudentMasterDTO studentDTO) {
		LMSStudentMasterDTO studentDTO2 = lmsStudentMasterServ.newLMSStudentMaster(studentDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(studentDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllStudents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSStudentMasterDTO>> getAllLMSStudentMasters() {
		ArrayList<LMSStudentMasterDTO> studentDTOs = lmsStudentMasterServ.getAllStudents();
		return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectStudents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSStudentMasterDTO>> getSelectLMSMediaBySubjects(
			@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSStudentMasterDTO> studentDTOs = lmsStudentMasterServ.getSelectStudents(subjectDetailsSeqNos);
		return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectStudentsbyInst", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSStudentMasterDTO>> getSelectStudentsByInst(
			@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSStudentMasterDTO> studentDTOs = lmsStudentMasterServ.getSelectStudentsByInst(iSeqNos);
		return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
	}

	@PutMapping("/updStudent")
	public void updatestudent(@RequestBody LMSStudentMasterDTO studentDTO) {
		lmsStudentMasterServ.updLMSStudentMaster(studentDTO);
		return;
	}

	@DeleteMapping("/delSelectstudent")
	public void deleteSelectstudent(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsStudentMasterServ.delSelectStudents(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllstudent")
	public void deleteAllStudents() {
		lmsStudentMasterServ.delAllLMSStudentMasters();
		;
		return;
	}

	@DeleteMapping("/delSelectstudentbyIn")
	public void delSelectStudentsByInst(@RequestBody ArrayList<Long> ids) {
		lmsStudentMasterServ.delSelectStudentsByInst(ids);
		return;
	}
	
}