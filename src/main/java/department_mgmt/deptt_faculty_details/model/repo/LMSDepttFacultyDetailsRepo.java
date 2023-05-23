package department_mgmt.deptt_faculty_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import department_mgmt.deptt_faculty_details.model.master.LMSDepttFacultyDetails;
import department_mgmt.deptt_faculty_details.model.master.LMSDepttFacultyDetailsPK;

@Repository("depttFacultyDetailsRepo")
public interface LMSDepttFacultyDetailsRepo extends JpaRepository<LMSDepttFacultyDetails, LMSDepttFacultyDetailsPK> 
{
@Query(value = "SELECT * FROM LMS_DEPTT_FACULTY_DETAILS_MASTER a WHERE a.deptt_SEQ_NO = :id order by deptt_seq_no", nativeQuery = true)
ArrayList<LMSDepttFacultyDetails> getFacultiesForDeptt(@Param("id") Long id);

@Query(value = "SELECT * FROM LMS_DEPTT_FACULTY_DETAILS_MASTER a WHERE a.faculty_SEQ_NO = :id order by deptt_seq_no", nativeQuery = true)
ArrayList<LMSDepttFacultyDetails> getDepttForFaculties(@Param("id") Long id);

@Query(value = "SELECT * FROM LMS_DEPTT_FACULTY_DETAILS_MASTER a WHERE a.FACULTY_SEQ_NO in :ids order by deptt_seq_no", nativeQuery = true)
ArrayList<LMSDepttFacultyDetails> getSelectFaculties(@Param("id") ArrayList<Long> ids);

@Query(value = "DELETE FROM LMS_DEPTT_FACULTY_DETAILS_MASTER a WHERE a.FACULTY_SEQ_NO in :depttSeqNos", nativeQuery = true)
ArrayList<LMSDepttFacultyDetails> delSelectLMSFaculties(@Param("depttSeqNos") ArrayList<Long> depttSeqNos);
}