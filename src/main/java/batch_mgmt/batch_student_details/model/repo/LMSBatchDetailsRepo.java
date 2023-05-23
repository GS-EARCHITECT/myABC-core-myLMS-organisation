package batch_mgmt.batch_student_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import batch_mgmt.batch_student_details.model.details.LMSBatchDetails;
import batch_mgmt.batch_student_details.model.details.LMSBatchDetailsPK;

@Repository("batchDetailsRepo")
public interface LMSBatchDetailsRepo extends JpaRepository<LMSBatchDetails, LMSBatchDetailsPK> {

	@Query(value = "SELECT * FROM LMS_BATCH_DETAILS a WHERE a.BATCH_SEQ_NO in :ids order by batch_seq_no", nativeQuery = true)
	ArrayList<LMSBatchDetails> getSelectBatches(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_BATCH_DETAILS a WHERE a.student_SEQ_NO in :ids order by batch_seq_no", nativeQuery = true)
	ArrayList<LMSBatchDetails> getSelectStudents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_BATCH_DETAILS WHERE a.batch_seq_no in :ids", nativeQuery = true)
	void delSelectLMSBatches(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_BATCH_DETAILS WHERE a.student_seq_no in :ids", nativeQuery = true)
	void delSelectLMSStudents(@Param("ids") ArrayList<Long> ids);
}
