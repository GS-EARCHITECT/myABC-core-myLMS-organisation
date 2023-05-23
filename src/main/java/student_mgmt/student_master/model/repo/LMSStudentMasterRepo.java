package student_mgmt.student_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import student_mgmt.student_master.model.master.LMSStudentMaster;

@Repository("lmsStudentMasterRepo")
public interface LMSStudentMasterRepo extends CrudRepository<LMSStudentMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_STUDENT_MASTER a WHERE a.student_SEQ_NO in :ids order by student_seq_no", nativeQuery = true)
	ArrayList<LMSStudentMaster> getSelectStudents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_STUDENT_MASTER a WHERE a.INSTITUTE_SEQ_NO in :ids order by student_seq_no", nativeQuery = true)
	ArrayList<LMSStudentMaster> getSelectStudentsByInst(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_STUDENT_MASTER WHERE a.student_seq_no in :ids", nativeQuery = true)
	void delSelectStudents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_STUDENT_MASTER WHERE a.INSTITUTE_SEQ_NO in :ids", nativeQuery = true)
	void delSelectStudentsByInst(@Param("ids") ArrayList<Long> ids);	
} 

