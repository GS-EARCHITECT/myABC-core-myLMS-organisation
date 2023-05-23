package faculty_mgmt.faculty_master.controller;

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
import faculty_mgmt.faculty_master.model.dto.LMSFacultyMasterDTO;
import faculty_mgmt.faculty_master.services.I_LMSFacultyMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/facultyManagement")
public class LMSFacultyMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSFacultyMaster_Controller.class);

	@Autowired
	private I_LMSFacultyMasterService lmsFacultyMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSFacultyMasterDTO> newfaculty(@RequestBody LMSFacultyMasterDTO facultyDTO) {
		LMSFacultyMasterDTO facultyDTO2 = lmsFacultyMasterServ.newLMSFacultyMaster(facultyDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(facultyDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllFaculties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSFacultyMasterDTO>> getAllLMSFacultyMasters() {
		ArrayList<LMSFacultyMasterDTO> facultyDTOs = lmsFacultyMasterServ.getAllFaculties();
		return new ResponseEntity<>(facultyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectFaculties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSFacultyMasterDTO>> getSelectLMSMediaBySubjects(
			@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSFacultyMasterDTO> facultyDTOs = lmsFacultyMasterServ.getSelectFaculties(subjectDetailsSeqNos);
		return new ResponseEntity<>(facultyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectFacultiesbyInst", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSFacultyMasterDTO>> getSelectFacultiesByInst(
			@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSFacultyMasterDTO> facultyDTOs = lmsFacultyMasterServ.getSelectFacultiesByInst(iSeqNos);
		return new ResponseEntity<>(facultyDTOs, HttpStatus.OK);
	}

	@PutMapping("/updFaculty")
	public void updatefaculty(@RequestBody LMSFacultyMasterDTO facultyDTO) {
		lmsFacultyMasterServ.updLMSFacultyMaster(facultyDTO);
		return;
	}

	@DeleteMapping("/delSelectfaculty")
	public void deleteSelectfaculty(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsFacultyMasterServ.delSelectFaculties(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllfaculty")
	public void deleteAllFaculties() {
		lmsFacultyMasterServ.delAllLMSFacultyMasters();
		;
		return;
	}

	@DeleteMapping("/delSelectfacultybyIn")
	public void delSelectFacultiesByInst(@RequestBody ArrayList<Long> ids) {
		lmsFacultyMasterServ.delSelectFacultiesByInst(ids);
		return;
	}
	
}