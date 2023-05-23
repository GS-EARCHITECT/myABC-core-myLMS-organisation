package section_mgmt.section_master.controller;

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

import section_mgmt.section_master.model.dto.LMSSectionMasterDTO;
import section_mgmt.section_master.services.I_LMSSectionMasterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/sectionManagement")
public class LMSSectionMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSSectionMaster_Controller.class);

	@Autowired
	private I_LMSSectionMasterService lmsSectionMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSSectionMasterDTO> newsection(@RequestBody LMSSectionMasterDTO sectionDTO) {
		LMSSectionMasterDTO sectionDTO2 = lmsSectionMasterServ.newLMSSectionMaster(sectionDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(sectionDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllSections", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSectionMasterDTO>> getAllLMSSectionMasters() {
		ArrayList<LMSSectionMasterDTO> sectionDTOs = lmsSectionMasterServ.getAllSections();
		return new ResponseEntity<>(sectionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSections", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSectionMasterDTO>> getSelectLMSMediaBySubjects(
			@RequestBody ArrayList<Long> subjectDetailsSeqNos) {
		ArrayList<LMSSectionMasterDTO> sectionDTOs = lmsSectionMasterServ.getSelectSections(subjectDetailsSeqNos);
		return new ResponseEntity<>(sectionDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSectionsbyCourses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSectionMasterDTO>> getSelectSectionsByCourses(
			@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSSectionMasterDTO> sectionDTOs = lmsSectionMasterServ.getSelectSectionsByCourses(iSeqNos);
		return new ResponseEntity<>(sectionDTOs, HttpStatus.OK);
	}

	@PutMapping("/updSection")
	public void updatesection(@RequestBody LMSSectionMasterDTO sectionDTO) {
		lmsSectionMasterServ.updLMSSectionMaster(sectionDTO);
		return;
	}

	@DeleteMapping("/delSelectsection")
	public void deleteSelectsection(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsSectionMasterServ.delSelectSections(sSeqNoList);
		return;
	}

	@DeleteMapping("/delAllsection")
	public void deleteAllSections() {
		lmsSectionMasterServ.delAllLMSSectionMasters();
		;
		return;
	}

	@DeleteMapping("/delSelectsectionbyCourses")
	public void delSelectSectionsByCourses(@RequestBody ArrayList<Long> ids) {
		lmsSectionMasterServ.delSelectSectionsByCourses(ids);
		return;
	}
	
}