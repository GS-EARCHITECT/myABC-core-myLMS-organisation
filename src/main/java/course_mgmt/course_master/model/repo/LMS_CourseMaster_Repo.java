package course_mgmt.course_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import course_mgmt.course_master.model.master.LMSCourseMaster;

@Repository("lmsCourseMasterRepo")
public interface LMS_CourseMaster_Repo extends CrudRepository<LMSCourseMaster, Long> 
{ 
	@Query(value = "SELECT * FROM LMS_COURSE_MASTER a WHERE a.course_seq_no in :ids order by course_seq_no", nativeQuery = true)
	ArrayList<LMSCourseMaster> getSelectCourses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_COURSE_MASTER WHERE a.course_seq_no in :ids", nativeQuery = true)
	void delSelectCourses(@Param("ids") ArrayList<Long> ids);
	
} 

