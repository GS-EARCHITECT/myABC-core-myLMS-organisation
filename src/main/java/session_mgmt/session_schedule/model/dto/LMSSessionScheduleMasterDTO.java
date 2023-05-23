package session_mgmt.session_schedule.model.dto;

import java.io.Serializable;

public class LMSSessionScheduleMasterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4718314489849482478L;
	private long sessionSeqNo;
	private long dowNo;
	private long subjectSeqNo;
	private String frDttm;
	private String toDttm;

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

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public LMSSessionScheduleMasterDTO(long sessionSeqNo, long dowNo, long subjectSeqNo, String frDttm, String toDttm) {
		super();
		this.sessionSeqNo = sessionSeqNo;
		this.dowNo = dowNo;
		this.subjectSeqNo = subjectSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

	public LMSSessionScheduleMasterDTO() {
		super();
	}

}
