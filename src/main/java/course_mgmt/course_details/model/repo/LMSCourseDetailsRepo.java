package course_mgmt.course_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import course_mgmt.course_details.model.details.LMSCourseDetails;
import course_mgmt.course_details.model.details.LMSCourseDetailsPK;

@Repository("courseDetailsRepo")
public interface LMSCourseDetailsRepo extends JpaRepository<LMSCourseDetails, LMSCourseDetailsPK> {

	@Query(value = "SELECT * FROM LMS_COURSE_DETAILS a WHERE a.COURSE_SEQ_NO in :ids order by course_seq_no", nativeQuery = true)
	ArrayList<LMSCourseDetails> getSelectSubjectsByCourse(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT * FROM LMS_COURSE_DETAILS a WHERE a.subject_SEQ_NO in :ids order by subject_seq_no", nativeQuery = true)
	ArrayList<LMSCourseDetails> getSelectCoursesBySubject(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_COURSE_DETAILS WHERE a.subject_seq_no in :ids", nativeQuery = true)
	void delSelectLMSCourse(@Param("ids") ArrayList<Long> ids);
}
