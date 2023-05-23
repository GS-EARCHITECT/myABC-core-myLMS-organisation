package section_mgmt.section_details.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_SECTIONS_DETAILS database table.
 * 
 */
@Embeddable
public class LMSSectionDetailsPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "STUDENT_SEQ_NO")
	private long studentSeqNo;

	@Column(name = "SECTION_SEQ_NO")
	private long sectionSeqNo;

	public LMSSectionDetailsPK() 
	{
	}

	public long getStudentSeqNo() {
		return this.studentSeqNo;
	}

	public void setStudentSeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public long getSectionSeqNo() {
		return this.sectionSeqNo;
	}

	public void setSectionSeqNo(long sectionSeqNo) {
		this.sectionSeqNo = sectionSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSSectionDetailsPK)) {
			return false;
		}
		LMSSectionDetailsPK castOther = (LMSSectionDetailsPK) other;
		return (this.studentSeqNo == castOther.studentSeqNo) && (this.sectionSeqNo == castOther.sectionSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.studentSeqNo ^ (this.studentSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.sectionSeqNo ^ (this.sectionSeqNo >>> 32)));

		return hash;
	}

	public LMSSectionDetailsPK(long studentSeqNo, long sectionSeqNo) {
		super();
		this.studentSeqNo = studentSeqNo;
		this.sectionSeqNo = sectionSeqNo;
	}

}