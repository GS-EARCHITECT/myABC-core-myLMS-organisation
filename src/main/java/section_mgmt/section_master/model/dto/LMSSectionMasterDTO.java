package section_mgmt.section_master.model.dto;

import java.io.Serializable;

public class LMSSectionMasterDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8875674384257524809L;
	private long sectionSeqNo;
	private Long courseSeqNo;
	private String sectionId;

	public long getSectionSeqNo() {
		return sectionSeqNo;
	}

	public void setSectionSeqNo(long sectionSeqNo) {
		this.sectionSeqNo = sectionSeqNo;
	}

	public Long getCourseSeqNo() {
		return courseSeqNo;
	}

	public void setCourseSeqNo(Long courseSeqNo) {
		this.courseSeqNo = courseSeqNo;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public LMSSectionMasterDTO(long sectionSeqNo, Long courseSeqNo, String sectionId) {
		super();
		this.sectionSeqNo = sectionSeqNo;
		this.courseSeqNo = courseSeqNo;
		this.sectionId = sectionId;
	}

	public LMSSectionMasterDTO() {
		super();
	}

}