package student_mgmt.student_batch_details.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the LMS_STUDENT_BATCH_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_STUDENT_BATCH_DETAILS")
public class LMSStudentBatchDetails implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4706851379256616443L;

	@EmbeddedId
	private LMSStudentBatchDetailsPK id;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS_SEQ_NO")
	private BigDecimal statusSeqNo;

	public LMSStudentBatchDetails() {
	}

	public LMSStudentBatchDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSStudentBatchDetailsPK id) {
		this.id = id;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BigDecimal getStatusSeqNo() {
		return this.statusSeqNo;
	}

	public void setStatusSeqNo(BigDecimal statusSeqNo) {
		this.statusSeqNo = statusSeqNo;
	}

	public LMSStudentBatchDetails(LMSStudentBatchDetailsPK id, String remarks, BigDecimal statusSeqNo) {
		super();
		this.id = id;
		this.remarks = remarks;
		this.statusSeqNo = statusSeqNo;
	}
}