package student_mgmt.student_batch_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import student_mgmt.student_batch_details.model.master.LMSStudentBatchDetails;
import student_mgmt.student_batch_details.model.master.LMSStudentBatchDetailsPK;

@Repository("studentBatchDetailsRepo")
public interface LMSStudentBatchDetailsRepo extends JpaRepository<LMSStudentBatchDetails, LMSStudentBatchDetailsPK> 
{
@Query(value = "SELECT * FROM LMS_STUDENT_BATCH_DETAILS_MASTER a WHERE a.batch_SEQ_NO = :id order by student_seq_no", nativeQuery = true)
ArrayList<LMSStudentBatchDetails> getStudentsForBatch(@Param("id") Long id);

@Query(value = "SELECT * FROM LMS_STUDENT_BATCH_DETAILS_MASTER a WHERE a.STUDENT_SEQ_NO in :ids order by student_seq_no", nativeQuery = true)
ArrayList<LMSStudentBatchDetails> getSelectStudents(@Param("id") ArrayList<Long> ids);

@Query(value = "DELETE FROM LMS_STUDENT_BATCH_DETAILS_MASTER a WHERE a.STUDENT_SEQ_NO in :studentSeqNos", nativeQuery = true)
ArrayList<LMSStudentBatchDetails> delSelectLMSStudents(@Param("studentSeqNos") ArrayList<Long> studentSeqNos);
}
