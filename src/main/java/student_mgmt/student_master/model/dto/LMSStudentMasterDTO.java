package student_mgmt.student_master.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSStudentMasterDTO implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private Long studentSeqNo;
	private Long institutionSeqNo;
	private Long personSeqNo;
	private String remarks;
	private BigDecimal statusSeqNo;
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

	public LMSStudentMasterDTO(Long studentSeqNo, Long institutionSeqNo, Long personSeqNo, String remarks,
			BigDecimal statusSeqNo, String studentId) {
		super();
		this.studentSeqNo = studentSeqNo;
		this.institutionSeqNo = institutionSeqNo;
		this.personSeqNo = personSeqNo;
		this.remarks = remarks;
		this.statusSeqNo = statusSeqNo;
		this.studentId = studentId;
	}

	public LMSStudentMasterDTO() {
		super();
	}

}