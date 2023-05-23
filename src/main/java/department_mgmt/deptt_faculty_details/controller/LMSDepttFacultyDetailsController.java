package department_mgmt.deptt_faculty_details.controller;

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
import department_mgmt.deptt_faculty_details.model.dto.LMSDepttFacultyDetailsDTO;
import department_mgmt.deptt_faculty_details.services.I_LMSDepttFacultyDetailsService;

@RestController
@RequestMapping("/depttFacultyDetails")
public class LMSDepttFacultyDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMS_DepttFacultyDetails_Controller.class);

	@Autowired
	private I_LMSDepttFacultyDetailsService depttFacultyDetailsServ;

	@PostMapping("/addDepttFacultyDetails")
	public ResponseEntity<LMSDepttFacultyDetailsDTO> addToDepttFacultyDetails(
			@RequestBody LMSDepttFacultyDetailsDTO lms_DepttFacultyDetails_DTO) {
		LMSDepttFacultyDetailsDTO lms_DepttFacultyDetails_DTO2 = depttFacultyDetailsServ
				.newDepttFacultyDetails(lms_DepttFacultyDetails_DTO);

		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(lms_DepttFacultyDetails_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllDepttFacultyDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSDepttFacultyDetailsDTO>> getAllDepttFacultyDetails() {

		ArrayList<LMSDepttFacultyDetailsDTO> lms_DepttFacultyDetails_DTOs = depttFacultyDetailsServ
				.getAllDepttFacultyDetails();
		return new ResponseEntity<>(lms_DepttFacultyDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getFacultiesForDeptt/{batchSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSDepttFacultyDetailsDTO>> getFacultiesForDeptt(@PathVariable Long batchSeqNo) {
		ArrayList<LMSDepttFacultyDetailsDTO> depttFacultyDetails_DTOs = depttFacultyDetailsServ
				.getFacultiesForDeptt(batchSeqNo);
		return new ResponseEntity<>(depttFacultyDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getDepttForFaculty/{facultySeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSDepttFacultyDetailsDTO>> getDepttForFaculty(@PathVariable Long facultySeqNo)
	{
		ArrayList<LMSDepttFacultyDetailsDTO> depttFacultyDetails_DTOs = depttFacultyDetailsServ
				.getFacultiesForDeptt(facultySeqNo);
		return new ResponseEntity<>(depttFacultyDetails_DTOs, HttpStatus.OK);
	}
		
	@GetMapping(value = "/getDepttFacultyDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSDepttFacultyDetailsDTO>> getSelectDepttFacultyDetails(
			@RequestBody ArrayList<Long> depttFacultyDetailsSeqNos) {
		ArrayList<LMSDepttFacultyDetailsDTO> depttFacultyDetails_DTOs = depttFacultyDetailsServ
				.getSelectFaculties(depttFacultyDetailsSeqNos);
		return new ResponseEntity<>(depttFacultyDetails_DTOs, HttpStatus.OK);
	}

	@PutMapping("/depttFacultyDetailsUpdate")
	public void updateDepttFacultyDetails(@RequestBody LMSDepttFacultyDetailsDTO lms_DepttFacultyDetails_DTO) {
		depttFacultyDetailsServ.updDepttFacultyDetails(lms_DepttFacultyDetails_DTO);
	}

	@DeleteMapping("/deleteSelectDepttFacultyDetails")
	public void deleteDepttFacultyDetails(@RequestBody ArrayList<Long> depttFacultyDetailsSeqNos) {
		depttFacultyDetailsServ.delSelectDepttFaculties(depttFacultyDetailsSeqNos);
	}

	@DeleteMapping("/deleteAllDepttFacultyDetails")
	public void deleteAllDepttFacultyDetails() {
		depttFacultyDetailsServ.delAllDepttFaculties();
	}

}