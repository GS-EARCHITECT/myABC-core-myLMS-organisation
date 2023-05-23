package batch_mgmt.batch_master.controller;

import java.util.ArrayList;
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
import batch_mgmt.batch_master.model.dto.LMSBatchMasterDTO;
import batch_mgmt.batch_master.services.I_LMSBatchMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/batchManagement")
public class LMSBatchMasterController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSBatchMaster_Controller.class);

	@Autowired
	private I_LMSBatchMasterService lmsBatchMasterServ;

	@PostMapping("/new")
	public ResponseEntity<LMSBatchMasterDTO> newbatch(@RequestBody LMSBatchMasterDTO batchDTO) {
		LMSBatchMasterDTO batchDTO2 = lmsBatchMasterServ.newBatch(batchDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(batchDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllBatches", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSBatchMasterDTO>> getAllLMSBatchMasters() {
		ArrayList<LMSBatchMasterDTO> batchDTOs = lmsBatchMasterServ.getAllBatches();
		return new ResponseEntity<>(batchDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBatches", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSBatchMasterDTO>> getSelectBatches(@RequestBody ArrayList<Long> iSeqNos) {
		ArrayList<LMSBatchMasterDTO> batchDTOs = lmsBatchMasterServ.getSelectBatches(iSeqNos);
		return new ResponseEntity<>(batchDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBatchesBetweenTimes/{fr}/{to)", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSBatchMasterDTO>> getSelectBatchesBetweenTimes(@PathVariable String fr,
			@PathVariable String to) {
		ArrayList<LMSBatchMasterDTO> batchDTOs = lmsBatchMasterServ.getSelectBatchesBetweenTimes(fr, to);
		return new ResponseEntity<>(batchDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectBatchesForCourses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<LMSBatchMasterDTO>> getSelectBatchesForCourses(
			@RequestBody ArrayList<Long> bSeqNos) {
		ArrayList<LMSBatchMasterDTO> batchDTOs = lmsBatchMasterServ.getSelectBatchesForCourses(bSeqNos);
		return new ResponseEntity<>(batchDTOs, HttpStatus.OK);
	}

	@PutMapping("/updBatch")
	public void updateBatch(@RequestBody LMSBatchMasterDTO batchDTO) {
		lmsBatchMasterServ.updBatch(batchDTO);
		return;
	}

	@DeleteMapping("/delSelectBatches")
	public void delSelectBatches(@RequestBody ArrayList<Long> sSeqNoList) {
		lmsBatchMasterServ.delSelectBatches(sSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectBatchesForCourses")
	public void delSelectBatchesForCourses(@RequestBody ArrayList<Long> bSeqNoList) {
		lmsBatchMasterServ.delSelectBatchesForCourses(bSeqNoList);
		return;
	}

	@DeleteMapping("/delSelectBatchesBetweenTimes/{fr}/{to}")
	public void delSelectBatchesBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		lmsBatchMasterServ.delSelectBatchesBetweenTimes(fr, to);
		return;
	}

	@DeleteMapping("/delAllBatches")
	public void deleteAllBatches() {
		lmsBatchMasterServ.delAllBatches();
		return;
	}

}