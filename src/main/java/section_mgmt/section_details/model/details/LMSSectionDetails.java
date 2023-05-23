package section_mgmt.section_details.model.details;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LMS_SECTIONS_DETAILS database table.
 * 
 */
@Entity
@Table(name = "LMS_SECTION_DETAILS")
public class LMSSectionDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LMSSectionDetailsPK id;

	public LMSSectionDetails() {
	}

	public LMSSectionDetailsPK getId() {
		return this.id;
	}

	public void setId(LMSSectionDetailsPK id) {
		this.id = id;
	}

	public LMSSectionDetails(LMSSectionDetailsPK id) 
	{
		super();
		this.id = id;
	}
	
	

}