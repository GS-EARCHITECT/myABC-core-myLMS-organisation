package section_mgmt.section_details.model.dto;

import java.io.Serializable;

public class LMSSectionDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2305249079159438093L;
	private long studentSeqNo;
	private long sectionSeqNo;

	public long getStudentSeqNo() {
		return studentSeqNo;
	}

	public void setStudentSeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public long getSectionSeqNo() {
		return sectionSeqNo;
	}

	public void setSectionSeqNo(long sectionSeqNo) {
		this.sectionSeqNo = sectionSeqNo;
	}

	public LMSSectionDetailsDTO(long studentSeqNo, long sectionSeqNo) {
		super();
		this.studentSeqNo = studentSeqNo;
		this.sectionSeqNo = sectionSeqNo;
	}

	public LMSSectionDetailsDTO() {
		super();
	}

}
