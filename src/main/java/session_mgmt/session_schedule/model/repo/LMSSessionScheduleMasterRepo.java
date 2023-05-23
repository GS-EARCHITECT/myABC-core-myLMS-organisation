package session_mgmt.session_schedule.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import session_mgmt.session_schedule.model.master.LMSSessionScheduleMaster;
import session_mgmt.session_schedule.model.master.LMSSessionScheduleMasterPK;

@Repository("sessionScheduleMasterRepo")
public interface LMSSessionScheduleMasterRepo extends JpaRepository<LMSSessionScheduleMaster, LMSSessionScheduleMasterPK> 
{
@Query(value = "SELECT * FROM LMS_SESSION_SCHEDULE_MASTER a WHERE a.SESSION_SEQ_NO = :id and a.dow_no = :dow order by session_seq_no", nativeQuery = true)
ArrayList<LMSSessionScheduleMaster> getSessionsByDOW(@Param("id") Long id, @Param("dow") Integer dow);

@Query(value = "SELECT * FROM LMS_SESSION_SCHEDULE_MASTER a WHERE a.SESSION_SEQ_NO = :id order by session_seq_no", nativeQuery = true)
ArrayList<LMSSessionScheduleMaster> getSubjectsForSession(@Param("id") Long id);

@Query(value = "SELECT * FROM LMS_SESSION_SCHEDULE_MASTER a WHERE a.SESSION_SEQ_NO in :ids order by session_seq_no", nativeQuery = true)
ArrayList<LMSSessionScheduleMaster> getSelectSessions(@Param("id") ArrayList<Long> ids);

@Query(value = "DELETE FROM LMS_SESSION_SCHEDULE_MASTER a WHERE a.SESSION_SEQ_NO in :sessionSeqNos", nativeQuery = true)
ArrayList<LMSSessionScheduleMaster> delSelectLMSSessions(@Param("sessionSeqNos") ArrayList<Long> sessionSeqNos);

}
