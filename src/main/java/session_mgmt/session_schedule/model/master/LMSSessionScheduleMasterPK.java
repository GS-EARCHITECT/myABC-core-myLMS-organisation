package session_mgmt.session_schedule.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_SESSION_SCHEDULE_MASTER database table.
 * 
 */
@Embeddable
public class LMSSessionScheduleMasterPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "SESSION_SEQ_NO")
	private long sessionSeqNo;

	@Column(name = "DOW_NO")
	private long dowNo;

	@Column(name = "SUBJECT_SEQ_NO")
	private long subjectSeqNo;

	public long getSessionSeqNo() {
		return sessionSeqNo;
	}

	public void setSessionSeqNo(long sessionSeqNo) {
		this.sessionSeqNo = sessionSeqNo;
	}

	public long getDowNo() {
		return dowNo;
	}

	public void setDowNo(long dowNo) {
		this.dowNo = dowNo;
	}

	public long getSubjectSeqNo() {
		return subjectSeqNo;
	}

	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dowNo ^ (dowNo >>> 32));
		result = prime * result + (int) (sessionSeqNo ^ (sessionSeqNo >>> 32));
		result = prime * result + (int) (subjectSeqNo ^ (subjectSeqNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSSessionScheduleMasterPK other = (LMSSessionScheduleMasterPK) obj;
		if (dowNo != other.dowNo)
			return false;
		if (sessionSeqNo != other.sessionSeqNo)
			return false;
		if (subjectSeqNo != other.subjectSeqNo)
			return false;
		return true;
	}

	public LMSSessionScheduleMasterPK(long sessionSeqNo, long dowNo, long subjectSeqNo) {
		super();
		this.sessionSeqNo = sessionSeqNo;
		this.dowNo = dowNo;
		this.subjectSeqNo = subjectSeqNo;
	}

	public LMSSessionScheduleMasterPK() {
		super();
	}

}