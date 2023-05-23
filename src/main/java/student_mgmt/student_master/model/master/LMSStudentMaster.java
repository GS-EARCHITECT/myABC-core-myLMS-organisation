package student_mgmt.student_master.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the LMS_STUDENT_MASTER database table.
 * 
 */
@Entity
@Table(name = "LMS_STUDENT_MASTER")
public class LMSStudentMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LMS_STUDENT_SEQUENCE")
	@SequenceGenerator(name = "LMS_STUDENT_SEQUENCE", sequenceName = "LMS_STUDENT_SEQUENCE", allocationSize = 1)
	@Column(name = "STUDENT_SEQ_NO")
	private Long studentSeqNo;

	@Column(name = "INSTITUTION_SEQ_NO")
	private Long institutionSeqNo;

	@Column(name = "PERSON_SEQ_NO")
	private Long personSeqNo;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS_SEQ_NO")
	private BigDecimal statusSeqNo;

	@Column(name = "STUDENT_ID")
	private String studentId;

	public Long getStudentSeqNo() {
		return studentSeqNo;
	}

	public void setStudentSeqNo(Long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((institutionSeqNo == null) ? 0 : institutionSeqNo.hashCode());
		result = prime * result + ((personSeqNo == null) ? 0 : personSeqNo.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + ((statusSeqNo == null) ? 0 : statusSeqNo.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((studentSeqNo == null) ? 0 : studentSeqNo.hashCode());
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
		LMSStudentMaster other = (LMSStudentMaster) obj;
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
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (studentSeqNo == null) {
			if (other.studentSeqNo != null)
				return false;
		} else if (!studentSeqNo.equals(other.studentSeqNo))
			return false;
		return true;
	}

	public LMSStudentMaster(Long studentSeqNo, Long institutionSeqNo, Long personSeqNo, String remarks,
			BigDecimal statusSeqNo, String studentId) {
		super();
		this.studentSeqNo = studentSeqNo;
		this.institutionSeqNo = institutionSeqNo;
		this.personSeqNo = personSeqNo;
		this.remarks = remarks;
		this.statusSeqNo = statusSeqNo;
		this.studentId = studentId;
	}

	public LMSStudentMaster() {
		super();
	}

}