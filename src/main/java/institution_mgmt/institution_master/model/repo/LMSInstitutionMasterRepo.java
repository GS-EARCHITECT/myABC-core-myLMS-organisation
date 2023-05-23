package institution_mgmt.institution_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import institution_mgmt.institution_master.model.master.LMSInstitutionMaster;

@Repository("lmsInstitutionMasterRepo")
public interface LMSInstitutionMasterRepo extends CrudRepository<LMSInstitutionMaster, Long> 
{
	@Query(value = "SELECT * FROM LMS_INSTITUTION_MASTER a WHERE a.institution_SEQ_NO in :ids order by institution_seq_no", nativeQuery = true)
	ArrayList<LMSInstitutionMaster> getSelectInstitutions(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM LMS_INSTITUTION_MASTER a WHERE a.location_SEQ_NO in :ids order by institution_seq_no", nativeQuery = true)
	ArrayList<LMSInstitutionMaster> getSelectInstitutionsByLocations(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_INSTITUTION_MASTER WHERE a.institution_seq_no in :ids", nativeQuery = true)
	void delSelectInstitutions(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM LMS_INSTITUTION_MASTER WHERE a.location_SEQ_NO in :ids", nativeQuery = true)
	void delSelectInstitutionsByLocations(@Param("ids") ArrayList<Long> ids);	
} 

