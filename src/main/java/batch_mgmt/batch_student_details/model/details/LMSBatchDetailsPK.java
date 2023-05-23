package batch_mgmt.batch_student_details.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LMS_BATCH_DETAILS database table.
 * 
 */
@Embeddable
public class LMSBatchDetailsPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BATCH_SEQ_NO")
	private long batchSeqNo;

	@Column(name="STUDENT_SEQ_NO")
	private long studentSeqNo;

	public LMSBatchDetailsPK() {
	}
	public long getBatchSeqNo() {
		return this.batchSeqNo;
	}
	public void setBatchSeqNo(long batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}
	public long getStudentSeqNo() {
		return this.studentSeqNo;
	}
	public void setStudentSeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LMSBatchDetailsPK)) {
			return false;
		}
		LMSBatchDetailsPK castOther = (LMSBatchDetailsPK)other;
		return 
			(this.batchSeqNo == castOther.batchSeqNo)
			&& (this.studentSeqNo == castOther.studentSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.batchSeqNo ^ (this.batchSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.studentSeqNo ^ (this.studentSeqNo >>> 32)));
		
		return hash;
	}
	public LMSBatchDetailsPK(long batchSeqNo, long studentSeqNo) {
		super();
		this.batchSeqNo = batchSeqNo;
		this.studentSeqNo = studentSeqNo;
	}
	
	
}