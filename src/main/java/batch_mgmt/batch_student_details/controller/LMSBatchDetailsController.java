package batch_mgmt.batch_student_details.controller;

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

import batch_mgmt.batch_student_details.model.dto.LMSBatchDetailsDTO;
import batch_mgmt.batch_student_details.services.I_LMSBatchDetailsService;

@RestController
@RequestMapping("/batchDetails")
public class LMSBatchDetailsController {

//private static final Logger logger = LoggerFactory.getLogger(LMS_BatchDetails_Controller.class);
	
	@Autowired
	private I_LMSBatchDetailsService lmsBatchDetailsServ ;
	

	@PostMapping("/addSubject")
	public ResponseEntity<LMSBatchDetailsDTO> addToSubject(@RequestBody LMSBatchDetailsDTO lms_BatchDetails_DTO) 
	{		
		LMSBatchDetailsDTO lms_BatchDetails_DTO2 = lmsBatchDetailsServ.newLMSBatchDetails(lms_BatchDetails_DTO);
		
	    HttpHeaders httpHeaders = new HttpHeaders();
	    return new ResponseEntity<>(lms_BatchDetails_DTO2, httpHeaders, HttpStatus.CREATED);		
	}

	@GetMapping(value="/getAllBatchs", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<LMSBatchDetailsDTO>> getAllBatchs() {
		

		ArrayList<LMSBatchDetailsDTO> lms_BatchDetails_DTOs = lmsBatchDetailsServ.getAllLMSBatchDetailss();
		return new ResponseEntity<>(lms_BatchDetails_DTOs, HttpStatus.OK);
			}
	
	@GetMapping(value="/getSelectBatches", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<LMSBatchDetailsDTO>> getSelectBatches(@RequestBody ArrayList<Long> subjectSeqNos) 
	{
		ArrayList<LMSBatchDetailsDTO> batchDetails_DTOs = lmsBatchDetailsServ.getSelectBatches(subjectSeqNos);
		return new ResponseEntity<>(batchDetails_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="/getSelectStudents", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<LMSBatchDetailsDTO>> getSelectStudents(@RequestBody ArrayList<Long> batchSeqNos) 
	{
		ArrayList<LMSBatchDetailsDTO> batchDetails_DTOs = lmsBatchDetailsServ.getSelectStudents(batchSeqNos);
		return new ResponseEntity<>(batchDetails_DTOs, HttpStatus.OK);
	}

	@PutMapping("/batchUpdate")
	public void updateSubject(@RequestBody LMSBatchDetailsDTO lms_BatchDetails_DTO) {		
		lmsBatchDetailsServ.updLMSBatchDetails(lms_BatchDetails_DTO);
	}

	@DeleteMapping("/deleteSelectBatches")
	public void deleteBatches(@RequestBody ArrayList<Long> batchSeqNos) 
	{	
		lmsBatchDetailsServ.delSelectLMSBatches(batchSeqNos);
	}

	@DeleteMapping("/deleteSelectStudents")
	public void deleteStudents(@RequestBody ArrayList<Long> batchSeqNos) 
	{	
		lmsBatchDetailsServ.delSelectLMSStudents(batchSeqNos);
	}
	
	@DeleteMapping("/deleteAllBatchs")
	public void deleteAllBatchs() 
	{	
		lmsBatchDetailsServ.delAllLMSBatchDetailss();
	}

}