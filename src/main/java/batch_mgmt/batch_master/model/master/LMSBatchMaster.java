package batch_mgmt.batch_master.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the LMS_BATCH_MASTER database table.
 * 
 */

@Entity
@Table(name = "LMS_BATCH_MASTER")
public class LMSBatchMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lms_batch_seq_no")
	@SequenceGenerator(name = "lms_batch_seq_no", sequenceName = "lms_batch_seq_no", allocationSize = 1)
	@Column(name = "BATCH_SEQ_NO")
	private Long batchSeqNo;

	@Column(name = "BATCH_ID")
	private String batchId;

	@Column(name = "BATCH_TITLE")
	private String batchTitle;

	@Column(name = "BATCH_SUMMARY")
	private String batchSummary;

	@Column(name = "COURSE_SEQ_NO")
	private Long courseSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDttm;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public LMSBatchMaster() {
	}

	public Long getBatchSeqNo() {
		return batchSeqNo;
	}

	public void setBatchSeqNo(Long batchSeqNo) {
		this.batchSeqNo = batchSeqNo;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchSummary() {
		return this.batchSummary;
	}

	public void setBatchSummary(String batchSummary) {
		this.batchSummary = batchSummary;
	}

	public Long getCourseSeqNo() {
		return this.courseSeqNo;
	}

	public void setCourseSeqNo(Long courseSeqNo) {
		this.courseSeqNo = courseSeqNo;
	}

	public Timestamp getFrDttm() {
		return this.frDttm;
	}

	public void setFrDttm(Timestamp frDttm) {
		this.frDttm = frDttm;
	}

	public Timestamp getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	public String getBatchTitle() {
		return batchTitle;
	}

	public void setBatchTitle(String batchTitle) {
		this.batchTitle = batchTitle;
	}

	public LMSBatchMaster(Long batchSeqNo, String batchId, String batchTitle, String batchSummary, Long courseSeqNo,
			Timestamp frDttm, Timestamp toDttm) {
		super();
		this.batchSeqNo = batchSeqNo;
		this.batchId = batchId;
		this.batchTitle = batchTitle;
		this.batchSummary = batchSummary;
		this.courseSeqNo = courseSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchSeqNo == null) ? 0 : batchSeqNo.hashCode());
		result = prime * result + ((batchSummary == null) ? 0 : batchSummary.hashCode());
		result = prime * result + ((batchTitle == null) ? 0 : batchTitle.hashCode());
		result = prime * result + ((courseSeqNo == null) ? 0 : courseSeqNo.hashCode());
		result = prime * result + ((frDttm == null) ? 0 : frDttm.hashCode());
		result = prime * result + ((toDttm == null) ? 0 : toDttm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LMSBatchMaster other = (LMSBatchMaster) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (batchSeqNo == null) {
			if (other.batchSeqNo != null)
				return false;
		} else if (!batchSeqNo.equals(other.batchSeqNo))
			return false;
		if (batchSummary == null) {
			if (other.batchSummary != null)
				return false;
		} else if (!batchSummary.equals(other.batchSummary))
			return false;
		if (batchTitle == null) {
			if (other.batchTitle != null)
				return false;
		} else if (!batchTitle.equals(other.batchTitle))
			return false;
		if (courseSeqNo == null) {
			if (other.courseSeqNo != null)
				return false;
		} else if (!courseSeqNo.equals(other.courseSeqNo))
			return false;
		if (frDttm == null) {
			if (other.frDttm != null)
				return false;
		} else if (!frDttm.equals(other.frDttm))
			return false;
		if (toDttm == null) {
			if (other.toDttm != null)
				return false;
		} else if (!toDttm.equals(other.toDttm))
			return false;
		return true;
	}

}