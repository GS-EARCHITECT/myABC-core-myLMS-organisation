package faculty_mgmt.faculty_batch_details.controller;

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
import faculty_mgmt.faculty_batch_details.model.dto.LMSFacultyBatchDetailsDTO;
import faculty_mgmt.faculty_batch_details.services.I_LMSFacultyBatchDetailsService;

@RestController
@RequestMapping("/facultyBatchDetails")
public class LMSFacultyBatchDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMS_FacultyBatchDetails_Controller.class);

	@Autowired
	private I_LMSFacultyBatchDetailsService facultyBatchDetailsServ;

	@PostMapping("/addFacultyBatchDetails")
	public ResponseEntity<LMSFacultyBatchDetailsDTO> addToFacultyBatchDetails(
			@RequestBody LMSFacultyBatchDetailsDTO lms_FacultyBatchDetails_DTO) {
		LMSFacultyBatchDetailsDTO lms_FacultyBatchDetails_DTO2 = facultyBatchDetailsServ
				.newFacultyBatchDetails(lms_FacultyBatchDetails_DTO);

		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(lms_FacultyBatchDetails_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllFacultyBatchDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSFacultyBatchDetailsDTO>> getAllFacultyBatchDetails() {

		ArrayList<LMSFacultyBatchDetailsDTO> lms_FacultyBatchDetails_DTOs = facultyBatchDetailsServ
				.getAllFacultyBatchDetails();
		return new ResponseEntity<>(lms_FacultyBatchDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getFacultiesForBatch/{batchSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSFacultyBatchDetailsDTO>> getFacultiesForBatch(
			@PathVariable Long batchSeqNo) 
	{
		ArrayList<LMSFacultyBatchDetailsDTO> facultyBatchDetails_DTOs = facultyBatchDetailsServ.getFacultiesForBatch(batchSeqNo);				
		return new ResponseEntity<>(facultyBatchDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getFacultyBatchDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSFacultyBatchDetailsDTO>> getSelectFacultyBatchDetails(
			@RequestBody ArrayList<Long> facultyBatchDetailsSeqNos) {
		ArrayList<LMSFacultyBatchDetailsDTO> facultyBatchDetails_DTOs = facultyBatchDetailsServ.getSelectFaculties(facultyBatchDetailsSeqNos);				
		return new ResponseEntity<>(facultyBatchDetails_DTOs, HttpStatus.OK);
	}

	@PutMapping("/facultyBatchDetailsUpdate")
	public void updateFacultyBatchDetails(@RequestBody LMSFacultyBatchDetailsDTO lms_FacultyBatchDetails_DTO) {
		facultyBatchDetailsServ.updFacultyBatchDetails(lms_FacultyBatchDetails_DTO);
	}

	@DeleteMapping("/deleteSelectFacultyBatchDetails")
	public void deleteFacultyBatchDetails(@RequestBody ArrayList<Long> facultyBatchDetailsSeqNos) 
	{
		facultyBatchDetailsServ.delSelectFacultyBatchDetails(facultyBatchDetailsSeqNos);
	}

	@DeleteMapping("/deleteAllFacultyBatchDetails")
	public void deleteAllFacultyBatchDetails() {
		facultyBatchDetailsServ.delAllFacultyBatchDetails();
	}

}