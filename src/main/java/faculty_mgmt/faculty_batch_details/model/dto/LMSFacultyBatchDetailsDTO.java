package faculty_mgmt.faculty_batch_details.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LMSFacultyBatchDetailsDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5461712023204634703L;
	private String remarks;
	private BigDecimal statusSeqNo;
	private long studentSeqNo;
	private long batchSeqNo;

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

	public long getFacultySeqNo() {
		return studentSeqNo;
	}

	public void setFacultySeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}

	public long getBatchSeqNo() {
		return batchSeqNo;
	}

	public void setBatchSeqNo(long batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}

	public LMSFacultyBatchDetailsDTO(String remarks, BigDecimal statusSeqNo, long studentSeqNo, long batchSeqNo) {
		super();
		this.remarks = remarks;
		this.statusSeqNo = statusSeqNo;
		this.studentSeqNo = studentSeqNo;
		this.batchSeqNo = batchSeqNo;
	}

	public LMSFacultyBatchDetailsDTO() {
		super();
	}

}
