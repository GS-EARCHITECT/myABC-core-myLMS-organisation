package student_mgmt.student_batch_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_STUDENT_BATCH_DETAILS database table.
 * 
 */
@Embeddable
public class LMSStudentBatchDetailsPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1517538163758194764L;

	@Column(name = "STUDENT_SEQ_NO")
	private long studentSeqNo;

	@Column(name = "BATCH_SEQ_NO")
	private long batchSeqNo;

	public LMSStudentBatchDetailsPK() {
	}

	public long getStudentSeqNo() {
		return this.studentSeqNo;
	}

	public void setStudentSeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public long getBatchSeqNo() {
		return this.batchSeqNo;
	}

	public void setBatchSeqNo(long batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSStudentBatchDetailsPK)) {
			return false;
		}
		LMSStudentBatchDetailsPK castOther = (LMSStudentBatchDetailsPK) other;
		return (this.studentSeqNo == castOther.studentSeqNo) && (this.batchSeqNo == castOther.batchSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.studentSeqNo ^ (this.studentSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.batchSeqNo ^ (this.batchSeqNo >>> 32)));

		return hash;
	}

	public LMSStudentBatchDetailsPK(long studentSeqNo, long batchSeqNo) {
		super();
		this.studentSeqNo = studentSeqNo;
		this.batchSeqNo = batchSeqNo;
	}

}