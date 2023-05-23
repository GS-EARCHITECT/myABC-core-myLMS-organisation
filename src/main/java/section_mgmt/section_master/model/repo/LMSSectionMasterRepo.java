package section_mgmt.section_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import section_mgmt.section_master.model.master.LMSSectionMaster;

@Repository("lmsSectionMasterRepo")
public interface LMSSectionMasterRepo extends CrudRepository<LMSSectionMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_SECTION_MASTER a WHERE a.section_SEQ_NO in :ids order by section_seq_no", nativeQuery = true)
	ArrayList<LMSSectionMaster> getSelectSections(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_SECTION_MASTER a WHERE a.COURSE_SEQ_NO in :ids order by section_seq_no", nativeQuery = true)
	ArrayList<LMSSectionMaster> getSelectSectionsByCourses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_SECTION_MASTER WHERE a.section_seq_no in :ids", nativeQuery = true)
	void delSelectSections(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_SECTION_MASTER WHERE a.course_SEQ_NO in :ids", nativeQuery = true)
	void delSelectSectionsByCourses(@Param("ids") ArrayList<Long> ids);	
}