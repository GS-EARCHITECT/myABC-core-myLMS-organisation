package faculty_mgmt.faculty_master.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the LMS_FACULTY_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_FACULTY_MASTER")
public class LMSFacultyMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LMS_FACULTY_SEQUENCE")
	@SequenceGenerator(name = "LMS_FACULTY_SEQUENCE", sequenceName = "LMS_FACULTY_SEQUENCE", allocationSize = 1)
	@Column(name = "FACULTY_SEQ_NO")
	private long facultySeqNo;

	@Column(name = "FACULTY_ID")
	private String facultyId;

	@Column(name = "INSTITUTION_SEQ_NO")
	private Long institutionSeqNo;

	@Column(name = "PERSON_SEQ_NO")
	private Long personSeqNo;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS_SEQ_NO")
	private BigDecimal statusSeqNo;

	public LMSFacultyMaster() {
	}

	public long getFacultySeqNo() {
		return facultySeqNo;
	}

	public void setFacultySeqNo(long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getStatusSeqNo() {
		return statusSeqNo;
	}

	public void setStatusSeqNo(BigDecimal statusSeqNo) {
		this.statusSeqNo = statusSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
		result = prime * result + (int) (facultySeqNo ^ (facultySeqNo >>> 32));
		result = prime * result + ((institutionSeqNo == null) ? 0 : institutionSeqNo.hashCode());
		result = prime * result + ((personSeqNo == null) ? 0 : personSeqNo.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((statusSeqNo == null) ? 0 : statusSeqNo.hashCode());
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
		LMSFacultyMaster other = (LMSFacultyMaster) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (facultyId == null) {
			if (other.facultyId != null)
				return false;
		} else if (!facultyId.equals(other.facultyId))
			return false;
		if (facultySeqNo != other.facultySeqNo)
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
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (statusSeqNo == null) {
			if (other.statusSeqNo != null)
				return false;
		} else if (!statusSeqNo.equals(other.statusSeqNo))
			return false;
		return true;
	}

	public LMSFacultyMaster(long facultySeqNo, String facultyId, Long institutionSeqNo, Long personSeqNo,
			Long assetSeqNo, String remarks, BigDecimal statusSeqNo) {
		super();
		this.facultySeqNo = facultySeqNo;
		this.facultyId = facultyId;
		this.institutionSeqNo = institutionSeqNo;
		this.personSeqNo = personSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.remarks = remarks;
		this.statusSeqNo = statusSeqNo;
	}

}