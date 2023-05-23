package batch_mgmt.batch_master.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import batch_mgmt.batch_master.model.master.LMSBatchMaster;

@Repository("lmsBatchMasterRepo")
public interface LMSBatchMasterRepo extends CrudRepository<LMSBatchMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_BATCH_MASTER a WHERE a.batch_SEQ_NO in :ids order by batch_seq_no", nativeQuery = true)
	ArrayList<LMSBatchMaster> getSelectBatches(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_BATCH_MASTER a WHERE ((:fr BETWEEN FR_DTTM and TO_DTTM) and (:to BETWEEN FR_DTTM and TO_DTTM)) order by course_seq_no", nativeQuery = true)
	ArrayList<LMSBatchMaster> getSelectBatchesBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);

	@Query(value = "SELECT * FROM LMS_BATCH_MASTER a WHERE a.course_SEQ_NO in :ids order by course_seq_no", nativeQuery = true)
	ArrayList<LMSBatchMaster> getSelectBatchesForCourses(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_BATCH_MASTER WHERE a.batch_seq_no in :ids", nativeQuery = true)
	void delSelectBatches(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_BATCH_MASTER WHERE a.course_SEQ_NO in :ids", nativeQuery = true)
	void delSelectBatchesForCourses(@Param("ids") ArrayList<Long> ids);

	@Query(value = "DELETE FROM LMS_BATCH_MASTER a WHERE ((:fr BETWEEN FR_DTTM and TO_DTTM) and (:to BETWEEN FR_DTTM and TO_DTTM))", nativeQuery = true)
	void delSelectBatchesBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);

}
