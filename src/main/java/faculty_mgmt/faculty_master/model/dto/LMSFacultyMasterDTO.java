package faculty_mgmt.faculty_master.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSFacultyMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3125236532621715381L;
	private long facultySeqNo;
	private String facultyId;
	private Long assetSeqNo;
	private Long institutionSeqNo;
	private Long personSeqNo;
	private String remarks;
	private BigDecimal statusSeqNo;

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

	public LMSFacultyMasterDTO(long facultySeqNo, String facultyId, Long assetSeqNo, Long institutionSeqNo,
			Long personSeqNo, String remarks, BigDecimal statusSeqNo) {
		super();
		this.facultySeqNo = facultySeqNo;
		this.facultyId = facultyId;
		this.assetSeqNo = assetSeqNo;
		this.institutionSeqNo = institutionSeqNo;
		this.personSeqNo = personSeqNo;
		this.remarks = remarks;
		this.statusSeqNo = statusSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public LMSFacultyMasterDTO() {
		super();
	}

}