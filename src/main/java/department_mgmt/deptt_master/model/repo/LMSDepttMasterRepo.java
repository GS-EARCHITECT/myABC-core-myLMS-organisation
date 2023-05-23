package department_mgmt.deptt_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import department_mgmt.deptt_master.model.master.LMSDepttMaster;

@Repository("lmsDepttMasterRepo")
public interface LMSDepttMasterRepo extends CrudRepository<LMSDepttMaster, Long> 
{ 
	@Query(value = "SELECT * FROM LMS_DEPTT_MASTER a WHERE a.deptt_SEQ_NO in :ids order by deptt_seq_no", nativeQuery = true)
	ArrayList<LMSDepttMaster> getSelectDeptts(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_DEPTT_MASTER a WHERE a.INSTITUTE_SEQ_NO in :ids order by deptt_seq_no", nativeQuery = true)
	ArrayList<LMSDepttMaster> getSelectDepttsByInst(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_DEPTT_MASTER WHERE a.deptt_seq_no in :ids", nativeQuery = true)
	void delSelectDeptts(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_DEPTT_MASTER WHERE a.INSTITUTE_SEQ_NO in :ids", nativeQuery = true)
	void delSelectDepttsByInst(@Param("ids") ArrayList<Long> ids);	

	
} 

