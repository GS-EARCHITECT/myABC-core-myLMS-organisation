package faculty_mgmt.faculty_batch_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import faculty_mgmt.faculty_batch_details.model.master.LMSFacultyBatchDetails;
import faculty_mgmt.faculty_batch_details.model.master.LMSFacultyBatchDetailsPK;

@Repository("facultyBatchDetailsRepo")
public interface LMSFacultyBatchDetailsRepo extends JpaRepository<LMSFacultyBatchDetails, LMSFacultyBatchDetailsPK> 
{
@Query(value = "SELECT * FROM LMS_FACULTY_BATCH_DETAILS_MASTER a WHERE a.batch_SEQ_NO = :id order by faculty_seq_no", nativeQuery = true)
ArrayList<LMSFacultyBatchDetails> getFacultiesForBatch(@Param("id") Long id);

@Query(value = "SELECT * FROM LMS_FACULTY_BATCH_DETAILS_MASTER a WHERE a.FACULTY_SEQ_NO in :ids order by faculty_seq_no", nativeQuery = true)
ArrayList<LMSFacultyBatchDetails> getSelectFaculties(@Param("id") ArrayList<Long> ids);

@Query(value = "DELETE FROM LMS_FACULTY_BATCH_DETAILS_MASTER a WHERE a.FACULTY_SEQ_NO in :facultySeqNos", nativeQuery = true)
ArrayList<LMSFacultyBatchDetails> delSelectLMSFaculties(@Param("facultySeqNos") ArrayList<Long> facultySeqNos);
}