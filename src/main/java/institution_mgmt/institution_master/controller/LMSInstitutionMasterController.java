package institution_mgmt.institution_master.controller;

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
import institution_mgmt.institution_master.model.dto.LMSInstitutionMasterDTO;
import institution_mgmt.institution_master.services.I_LMSInstitutionMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/institutionManagement")
public class LMSInstitutionMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSInstitutionMaster_Controller.class);

	@Autowired
	private I_LMSInstitutionMasterService lmsInstitutionMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSInstitutionMasterDTO> newinstitution(@RequestBody LMSInstitutionMasterDTO institutionDTO) {
		LMSInstitutionMasterDTO institutionDTO2 = lmsInstitutionMasterServ.newLMSInstitutionMaster(institutionDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(institutionDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllInstitutions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSInstitutionMasterDTO>> getAllLMSInstitutionMasters() {
		ArrayList<LMSInstitutionMasterDTO> institutionDTOs = lmsInstitutionMasterServ.getAllInstitutions();
		return new ResponseEntity<>(institutionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectInstitutions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSInstitutionMasterDTO>> getSelectInstitutions(
			@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSInstitutionMasterDTO> institutionDTOs = lmsInstitutionMasterServ.getSelectInstitutions(subjectDetailsSeqNos);
		return new ResponseEntity<>(institutionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectInstitutionsByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSInstitutionMasterDTO>> getSelectInstitutionsByLocations(
			@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSInstitutionMasterDTO> institutionDTOs = lmsInstitutionMasterServ.getSelectInstitutionsByLocations(iSeqNos);
		return new ResponseEntity<>(institutionDTOs, HttpStatus.OK);
	}

	@PutMapping("/updInstitution")
	public void updateinstitution(@RequestBody LMSInstitutionMasterDTO institutionDTO) {
		lmsInstitutionMasterServ.updLMSInstitutionMaster(institutionDTO);
		return;
	}

	@DeleteMapping("/delSelectinstitution")
	public void deleteSelectinstitution(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsInstitutionMasterServ.delSelectInstitutions(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllinstitution")
	public void deleteAllInstitutions() {
		lmsInstitutionMasterServ.delAllLMSInstitutionMasters();
		;
		return;
	}

	@DeleteMapping("/delSelectinstitutionbyLocations")
	public void delSelectInstitutionsByLocations(@RequestBody ArrayList<Long> ids) {
		lmsInstitutionMasterServ.delSelectInstitutionsByLocations(ids);
		return;
	}
	
}