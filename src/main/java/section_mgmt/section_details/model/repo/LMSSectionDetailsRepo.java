package section_mgmt.section_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import section_mgmt.section_details.model.details.LMSSectionDetails;
import section_mgmt.section_details.model.details.LMSSectionDetailsPK;

@Repository("sectionDetailsRepo")
public interface LMSSectionDetailsRepo extends JpaRepository<LMSSectionDetails, LMSSectionDetailsPK> 
{
@Query(value = "SELECT * FROM LMS_SECTION_DETAILS a WHERE a.section_SEQ_NO = :id order by section_seq_no", nativeQuery = true)
ArrayList<LMSSectionDetails> getStudentsForSections(@Param("id") ArrayList<Long> id);

@Query(value = "SELECT * FROM LMS_SECTION_DETAILS a WHERE a.STUDENT_SEQ_NO in :ids order by student_seq_no", nativeQuery = true)
ArrayList<LMSSectionDetails> getSelectStudents(@Param("id") ArrayList<Long> ids);

@Query(value = "DELETE FROM LMS_SECTION_DETAILS a WHERE a.STUDENT_SEQ_NO in :studentSeqNos", nativeQuery = true)
void delSelectStudents(@Param("studentSeqNos") ArrayList<Long> studentSeqNos);

@Query(value = "DELETE FROM LMS_SECTION_DETAILS a WHERE a.SECTION_SEQ_NO in :sectionSeqNos", nativeQuery = true)
void delSelectSections(@Param("studentSeqNos") ArrayList<Long> sectionSeqNos);
}
