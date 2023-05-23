package faculty_mgmt.faculty_batch_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_FACULTY_BATCH_DETAILS database table.
 * 
 */
@Embeddable
public class LMSFacultyBatchDetailsPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "FACULTY_SEQ_NO")
	private long facultySeqNo;

	@Column(name = "BATCH_SEQ_NO")
	private long batchSeqNo;

	@Column(name = "SUBJECT_SEQ_NO")
	private long subjectSeqNo;

	public LMSFacultyBatchDetailsPK() {
	}

	public long getFacultySeqNo() {
		return this.facultySeqNo;
	}

	public void setFacultySeqNo(long facultySeqNo) {
		this.facultySeqNo = facultySeqNo;
	}

	public long getBatchSeqNo() {
		return this.batchSeqNo;
	}

	public void setBatchSeqNo(long batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}

	public long getSubjectSeqNo() {
		return this.subjectSeqNo;
	}

	public void setSubjectSeqNo(long subjectSeqNo) {
		this.subjectSeqNo = subjectSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSFacultyBatchDetailsPK)) {
			return false;
		}
		LMSFacultyBatchDetailsPK castOther = (LMSFacultyBatchDetailsPK) other;
		return (this.facultySeqNo == castOther.facultySeqNo) && (this.batchSeqNo == castOther.batchSeqNo)
				&& (this.subjectSeqNo == castOther.subjectSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.facultySeqNo ^ (this.facultySeqNo >>> 32)));
		hash = hash * prime + ((int) (this.batchSeqNo ^ (this.batchSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.subjectSeqNo ^ (this.subjectSeqNo >>> 32)));

		return hash;
	}

	public LMSFacultyBatchDetailsPK(long facultySeqNo, long batchSeqNo, long subjectSeqNo) {
		super();
		this.facultySeqNo = facultySeqNo;
		this.batchSeqNo = batchSeqNo;
		this.subjectSeqNo = subjectSeqNo;
	}

}