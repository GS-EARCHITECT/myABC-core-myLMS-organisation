package student_mgmt.student_batch_details.controller;

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
import student_mgmt.student_batch_details.model.dto.LMSStudentBatchDetailsDTO;
import student_mgmt.student_batch_details.services.I_LMSStudentBatchDetailsService;

@RestController
@RequestMapping("/studentBatchDetails")
public class LMSStudentBatchDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMS_StudentBatchDetails_Controller.class);

	@Autowired
	private I_LMSStudentBatchDetailsService studentBatchDetailsServ;

	@PostMapping("/addStudentBatchDetails")
	public ResponseEntity<LMSStudentBatchDetailsDTO> addToStudentBatchDetails(
			@RequestBody LMSStudentBatchDetailsDTO lms_StudentBatchDetails_DTO) {
		LMSStudentBatchDetailsDTO lms_StudentBatchDetails_DTO2 = studentBatchDetailsServ
				.newStudentBatchDetails(lms_StudentBatchDetails_DTO);

		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(lms_StudentBatchDetails_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllStudentBatchDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSStudentBatchDetailsDTO>> getAllStudentBatchDetails() {

		ArrayList<LMSStudentBatchDetailsDTO> lms_StudentBatchDetails_DTOs = studentBatchDetailsServ
				.getAllStudentBatchDetails();
		return new ResponseEntity<>(lms_StudentBatchDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getStudentsForBatch/{batchSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSStudentBatchDetailsDTO>> getStudentsForBatch(
			@PathVariable Long batchSeqNo) 
	{
		ArrayList<LMSStudentBatchDetailsDTO> studentBatchDetails_DTOs = studentBatchDetailsServ.getStudentsForBatch(batchSeqNo);				
		return new ResponseEntity<>(studentBatchDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getStudentBatchDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSStudentBatchDetailsDTO>> getSelectStudentBatchDetails(
			@RequestBody ArrayList<Long> studentBatchDetailsSeqNos) {
		ArrayList<LMSStudentBatchDetailsDTO> studentBatchDetails_DTOs = studentBatchDetailsServ.getSelectStudents(studentBatchDetailsSeqNos);				
		return new ResponseEntity<>(studentBatchDetails_DTOs, HttpStatus.OK);
	}

	@PutMapping("/studentBatchDetailsUpdate")
	public void updateStudentBatchDetails(@RequestBody LMSStudentBatchDetailsDTO lms_StudentBatchDetails_DTO) {
		studentBatchDetailsServ.updStudentBatchDetails(lms_StudentBatchDetails_DTO);
	}

	@DeleteMapping("/deleteSelectStudentBatchDetails")
	public void deleteStudentBatchDetails(@RequestBody ArrayList<Long> studentBatchDetailsSeqNos) 
	{
		studentBatchDetailsServ.delSelectStudentBatchDetails(studentBatchDetailsSeqNos);
	}

	@DeleteMapping("/deleteAllStudentBatchDetails")
	public void deleteAllStudentBatchDetails() {
		studentBatchDetailsServ.delAllStudentBatchDetails();
	}

}