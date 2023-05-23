package faculty_mgmt.faculty_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import faculty_mgmt.faculty_master.model.master.LMSFacultyMaster;

@Repository("lmsFacultyMasterRepo")
public interface LMSFacultyMasterRepo extends CrudRepository<LMSFacultyMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_FACULTY_MASTER a WHERE a.faculty_SEQ_NO in :ids order by faculty_seq_no", nativeQuery = true)
	ArrayList<LMSFacultyMaster> getSelectFaculties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_FACULTY_MASTER a WHERE a.INSTITUTE_SEQ_NO in :ids order by faculty_seq_no", nativeQuery = true)
	ArrayList<LMSFacultyMaster> getSelectFacultiesByInst(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_FACULTY_MASTER WHERE a.faculty_seq_no in :ids", nativeQuery = true)
	void delSelectFaculties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_FACULTY_MASTER WHERE a.INSTITUTE_SEQ_NO in :ids", nativeQuery = true)
	void delSelectFacultiesByInst(@Param("ids") ArrayList<Long> ids);	
} 

