package section_mgmt.section_details.controller;

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
import section_mgmt.section_details.model.dto.LMSSectionDetailsDTO;
import section_mgmt.section_details.services.I_LMSSectionDetailsService;

@RestController
@RequestMapping("/sectionDetails")
public class LMSSectionDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMS_SectionDetails_Controller.class);

	@Autowired
	private I_LMSSectionDetailsService sectionDetailsServ;

	@PostMapping("/addSectionDetails")
	public ResponseEntity<LMSSectionDetailsDTO> addToSectionDetails(
			@RequestBody LMSSectionDetailsDTO lms_SectionDetails_DTO) {
		LMSSectionDetailsDTO lms_SectionDetails_DTO2 = sectionDetailsServ.newSectionDetails(lms_SectionDetails_DTO);

		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(lms_SectionDetails_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllSectionDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSectionDetailsDTO>> getAllSectionDetails() {

		ArrayList<LMSSectionDetailsDTO> lms_SectionDetails_DTOs = sectionDetailsServ.getAllSectionDetails();
		return new ResponseEntity<>(lms_SectionDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getStudentsForSections", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSectionDetailsDTO>> getStudentsForBatch(
			@RequestBody ArrayList<Long> sectionsSeqNos) {
		ArrayList<LMSSectionDetailsDTO> sectionDetails_DTOs = sectionDetailsServ.getStudentsForSections(sectionsSeqNos);
		return new ResponseEntity<>(sectionDetails_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectStudents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSSectionDetailsDTO>> getSelectStudents(
			@RequestBody ArrayList<Long> studentSeqNos) {
		ArrayList<LMSSectionDetailsDTO> sectionDetails_DTOs = sectionDetailsServ.getSelectStudents(studentSeqNos);
		return new ResponseEntity<>(sectionDetails_DTOs, HttpStatus.OK);
	}

	@PutMapping("/sectionDetailsUpdate")
	public void updateSectionDetails(@RequestBody LMSSectionDetailsDTO lms_SectionDetails_DTO) {
		sectionDetailsServ.updSectionDetails(lms_SectionDetails_DTO);
	}

	@DeleteMapping("/deleteSelectSectionDetails")
	public void deleteSectionDetails(@RequestBody ArrayList<Long> sectionSeqNos) {
		sectionDetailsServ.delSelectSections(sectionSeqNos);
	}

	@DeleteMapping("/deleteSelectStudents")
	public void deleteSectionStudents(@RequestBody ArrayList<Long> studentSeqNos) {
		sectionDetailsServ.delSelectStudents(studentSeqNos);
	}

	@DeleteMapping("/deleteAllSectionDetails")
	public void deleteAllSectionDetails() {
		sectionDetailsServ.delAllSectionDetails();
	}

}