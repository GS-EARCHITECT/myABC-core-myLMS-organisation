package section_mgmt.section_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import section_mgmt.section_master.model.dto.LMSSectionMasterDTO;
import section_mgmt.section_master.model.master.LMSSectionMaster;
import section_mgmt.section_master.model.repo.LMSSectionMasterRepo;

@Service("lmsSectionMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class LMSSectionMasterService implements I_LMSSectionMasterService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(LMSSectionMaster_Controller.class);

	@Autowired
	private LMSSectionMasterRepo lmsSectionMasterRepo;

	@Override
	public ArrayList<LMSSectionMasterDTO> getAllSections() {
		ArrayList<LMSSectionMasterDTO> studentMasterDTOs = new ArrayList<LMSSectionMasterDTO>();
		ArrayList<LMSSectionMaster> studentMasterOpts = (ArrayList<LMSSectionMaster>) lmsSectionMasterRepo.findAll();

		if (studentMasterOpts != null) {
			studentMasterDTOs = getSectionMasterDtos(studentMasterOpts);
		} else {
			studentMasterDTOs = null;
		}

		return studentMasterDTOs;
	}

	@Override
	public ArrayList<LMSSectionMasterDTO> getSelectSections(ArrayList<Long> ids) {
		ArrayList<LMSSectionMaster> lMasters = lmsSectionMasterRepo.getSelectSections(ids);
		ArrayList<LMSSectionMasterDTO> LMSSectionMasterDTOs = new ArrayList<LMSSectionMasterDTO>();

		if (lMasters != null) {
			LMSSectionMasterDTOs = getSectionMasterDtos(lMasters);
		}

		return LMSSectionMasterDTOs;
	}

	@Override
	public ArrayList<LMSSectionMasterDTO> getSelectSectionsByCourses(ArrayList<Long> ids) {
		ArrayList<LMSSectionMaster> lMasters = lmsSectionMasterRepo.getSelectSectionsByCourses(ids);
		ArrayList<LMSSectionMasterDTO> LMSSectionMasterDTOs = new ArrayList<LMSSectionMasterDTO>();

		if (lMasters != null) {
			LMSSectionMasterDTOs = getSectionMasterDtos(lMasters);
		}

		return LMSSectionMasterDTOs;
	}

	public LMSSectionMasterDTO newLMSSectionMaster(LMSSectionMasterDTO lms_SectionMasterDTO) {
		LMSSectionMaster lms_SectionMaster = lmsSectionMasterRepo.save(setCustomerMaster(lms_SectionMasterDTO));
		LMSSectionMasterDTO studentMasterDTO2 = getSectionMasterDto(lms_SectionMaster);
		return studentMasterDTO2;
	}

	public void updLMSSectionMaster(LMSSectionMasterDTO lMSSectionMasterDTO) {
		LMSSectionMaster lms_SectionMaster = setCustomerMaster(lMSSectionMasterDTO);
		lmsSectionMasterRepo.save(lms_SectionMaster);
	}

	public void delSelectSections(ArrayList<Long> DocumentSeqNos) {
		lmsSectionMasterRepo.delSelectSections(DocumentSeqNos);
	}

	public void delSelectSectionsByCourses(ArrayList<Long> ids) {
		lmsSectionMasterRepo.delSelectSectionsByCourses(ids);
	}

	public void delAllLMSSectionMasters() {
		lmsSectionMasterRepo.deleteAll();
	}

	private ArrayList<LMSSectionMasterDTO> getSectionMasterDtos(ArrayList<LMSSectionMaster> lms_SectionMasters) {
		LMSSectionMasterDTO studentMasterDTO = null;
		ArrayList<LMSSectionMasterDTO> studentMasterDTOs = new ArrayList<LMSSectionMasterDTO>();

		for (int i = 0; i < lms_SectionMasters.size(); i++) {
			studentMasterDTO = getSectionMasterDto(lms_SectionMasters.get(i));
			studentMasterDTOs.add(studentMasterDTO);
		}
		return studentMasterDTOs;
	}

	private LMSSectionMasterDTO getSectionMasterDto(LMSSectionMaster studentMaster) {
		LMSSectionMasterDTO lDTO = new LMSSectionMasterDTO();
		lDTO.setCourseSeqNo(studentMaster.getCourseSeqNo());
		lDTO.setSectionId(studentMaster.getSectionId());
		lDTO.setSectionSeqNo(studentMaster.getSectionSeqNo());
		return lDTO;
	}

	private LMSSectionMaster setCustomerMaster(LMSSectionMasterDTO sMasterDTO) {
		LMSSectionMaster lms_SectionMaster = new LMSSectionMaster();
		lms_SectionMaster.setCourseSeqNo(sMasterDTO.getCourseSeqNo());
		lms_SectionMaster.setSectionId(sMasterDTO.getSectionId());
		return lms_SectionMaster;
	}

}
