package faculty_mgmt.faculty_batch_details.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the LMS_FACULTY_BATCH_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_FACULTY_BATCH_DETAILS")
public class LMSFacultyBatchDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSFacultyBatchDetailsPK id;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "STATUS_SEQ_NO")
	private BigDecimal statusSeqNo;

	public LMSFacultyBatchDetails() {
	}

	public LMSFacultyBatchDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSFacultyBatchDetailsPK id) {
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

	public LMSFacultyBatchDetails(LMSFacultyBatchDetailsPK id, String remarks, BigDecimal statusSeqNo) {
		super();
		this.id = id;
		this.remarks = remarks;
		this.statusSeqNo = statusSeqNo;
	}

}