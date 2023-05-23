package batch_mgmt.batch_student_details.model.dto;

import java.io.Serializable;

public class LMSBatchDetailsDTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3399782921666929939L;
	private long batchSeqNo;
	private long studentSeqNo;
	public long getBatchSeqNo() {
		return batchSeqNo;
	}
	public void setBatchSeqNo(long batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}
	public long getStudentSeqNo() {
		return studentSeqNo;
	}
	public void setStudentSeqNo(long studentSeqNo) {
		this.studentSeqNo = studentSeqNo;
	}
	public LMSBatchDetailsDTO(long batchSeqNo, long studentSeqNo) {
		super();
		this.batchSeqNo = batchSeqNo;
		this.studentSeqNo = studentSeqNo;
	}
	public LMSBatchDetailsDTO() {
		super();
	}
	
}