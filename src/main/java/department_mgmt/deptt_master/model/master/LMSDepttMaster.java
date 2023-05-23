package department_mgmt.deptt_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_DEPTT_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_DEPTT_MASTER")
public class LMSDepttMaster implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LMS_DEPTT_SEQ")
	@SequenceGenerator(name = "LMS_DEPTT_SEQ", sequenceName = "LMS_DEPTT_SEQ", allocationSize = 1)
	@Column(name = "DEPTT_SEQ_NO")
	private Long depttSeqNo;

	@Column(name = "DEPTT")
	private String deptt;

	@Column(name = "DEPTT_ID")
	private String depttId;

	@Column(name = "INSTITUTION_SEQ_NO")
	private Long institutionSeqNo;

	@Column(name = "PERSON_SEQ_NO")
	private Long personSeqNo;

	public LMSDepttMaster() {
	}

	public long getDepttSeqNo() {
		return this.depttSeqNo;
	}

	public void setDepttSeqNo(long depttSeqNo) {
		this.depttSeqNo = depttSeqNo;
	}

	public String getDeptt() {
		return this.deptt;
	}

	public void setDeptt(String deptt) {
		this.deptt = deptt;
	}

	public String getDepttId() {
		return this.depttId;
	}

	public void setDepttId(String depttId) {
		this.depttId = depttId;
	}

	public Long getInstitutionSeqNo() {
		return this.institutionSeqNo;
	}

	public void setInstitutionSeqNo(Long institutionSeqNo) {
		this.institutionSeqNo = institutionSeqNo;
	}

	public Long getPersonSeqNo() {
		return this.personSeqNo;
	}

	public void setPersonSeqNo(Long personSeqNo) {
		this.personSeqNo = personSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptt == null) ? 0 : deptt.hashCode());
		result = prime * result + ((depttId == null) ? 0 : depttId.hashCode());
		result = prime * result + (int) (depttSeqNo ^ (depttSeqNo >>> 32));
		result = prime * result + ((institutionSeqNo == null) ? 0 : institutionSeqNo.hashCode());
		result = prime * result + ((personSeqNo == null) ? 0 : personSeqNo.hashCode());
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
		LMSDepttMaster other = (LMSDepttMaster) obj;
		if (deptt == null) {
			if (other.deptt != null)
				return false;
		} else if (!deptt.equals(other.deptt))
			return false;
		if (depttId == null) {
			if (other.depttId != null)
				return false;
		} else if (!depttId.equals(other.depttId))
			return false;
		if (depttSeqNo != other.depttSeqNo)
			return false;
		if (institutionSeqNo == null) {
			if (other.institutionSeqNo != null)
				return false;
		} else if (!institutionSeqNo.equals(other.institutionSeqNo))
			return false;
		if (personSeqNo == null) {
			if (other.personSeqNo != null)
				return false;
		} else if (!personSeqNo.equals(other.personSeqNo))
			return false;
		return true;
	}

	public LMSDepttMaster(long depttSeqNo, String deptt, String depttId, Long institutionSeqNo,
			Long personSeqNo) {
		super();
		this.depttSeqNo = depttSeqNo;
		this.deptt = deptt;
		this.depttId = depttId;
		this.institutionSeqNo = institutionSeqNo;
		this.personSeqNo = personSeqNo;
	}

}