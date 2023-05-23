package department_mgmt.deptt_master.model.dto;

import java.io.Serializable;

public class LMSDepttMasterDTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5378863527784185115L;
	private long depttSeqNo;
	private String deptt;
	private String depttId;
	private Long institutionSeqNo;
	private Long personSeqNo;

	public long getDepttSeqNo() {
		return depttSeqNo;
	}

	public void setDepttSeqNo(long depttSeqNo) {
		this.depttSeqNo = depttSeqNo;
	}

	public String getDeptt() {
		return deptt;
	}

	public void setDeptt(String deptt) {
		this.deptt = deptt;
	}

	public String getDepttId() {
		return depttId;
	}

	public void setDepttId(String depttId) {
		this.depttId = depttId;
	}

	public Long getInstitutionSeqNo() {
		return institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public Long getPersonSeqNo() {
		return personSeqNo;
	}

	public void setPersonSeqNo(Long personSeqNo) {
		this.personSeqNo = personSeqNo;
	}

	public LMSDepttMasterDTO(long depttSeqNo, String deptt, String depttId, Long institutionSeqNo, Long personSeqNo) {
		super();
		this.depttSeqNo = depttSeqNo;
		this.deptt = deptt;
		this.depttId = depttId;
		this.institutionSeqNo = institutionSeqNo;
		this.personSeqNo = personSeqNo;
	}

	public LMSDepttMasterDTO() {
		super();
	}

}