package department_mgmt.deptt_master.controller;

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

import department_mgmt.deptt_master.model.dto.LMSDepttMasterDTO;
import department_mgmt.deptt_master.services.I_LMSDepttMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/depttManagement")
public class LMSDepttMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSDepttMaster_Controller.class);

	@Autowired
	private I_LMSDepttMasterService lmsDepttMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSDepttMasterDTO> newdeptt(@RequestBody LMSDepttMasterDTO depttDTO) {
		LMSDepttMasterDTO depttDTO2 = lmsDepttMasterServ.newLMSDepttMaster(depttDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(depttDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllDeptts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSDepttMasterDTO>> getAllLMSDepttMasters() {
		ArrayList<LMSDepttMasterDTO> depttDTOs = lmsDepttMasterServ.getAllDeptts();
		return new ResponseEntity<>(depttDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDeptts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSDepttMasterDTO>> getSelectLMSMediaBySubjects(
			@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSDepttMasterDTO> depttDTOs = lmsDepttMasterServ.getSelectDeptts(subjectDetailsSeqNos);
		return new ResponseEntity<>(depttDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDepttsbyInst", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSDepttMasterDTO>> getSelectDepttsByInst(
			@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSDepttMasterDTO> depttDTOs = lmsDepttMasterServ.getSelectDepttsByInst(iSeqNos);
		return new ResponseEntity<>(depttDTOs, HttpStatus.OK);
	}

	@PutMapping("/updDeptt")
	public void updatedeptt(@RequestBody LMSDepttMasterDTO depttDTO) {
		lmsDepttMasterServ.updLMSDepttMaster(depttDTO);
		return;
	}

	@DeleteMapping("/delSelectdeptt")
	public void deleteSelectdeptt(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsDepttMasterServ.delSelectDeptts(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAlldeptt")
	public void deleteAllDeptts() {
		lmsDepttMasterServ.delAllLMSDepttMasters();
		;
		return;
	}

	@DeleteMapping("/delSelectdepttbyIn")
	public void delSelectDepttsByInst(@RequestBody ArrayList<Long> ids) {
		lmsDepttMasterServ.delSelectDepttsByInst(ids);
		return;
	}
	
}