package mx.edu.desam.retention.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.desam.retention.dto.AnswerDTO;
import mx.edu.desam.retention.entity.Answer;
import mx.edu.desam.retention.repository.AnswerRepository;
@Service
public class AnswerServiceImpl implements IAnswerService {
	@Autowired
	AnswerRepository answerRepository;
	
	@Override
	public List<AnswerDTO> getAll() {
		List<Answer> listAnswer =(List<Answer>) answerRepository.findAll();
		Type listType = new TypeToken<List<AnswerDTO>>(){}.getType();
		List<AnswerDTO> lstAnswerDTO = new ModelMapper().map(listAnswer, listType);
		return lstAnswerDTO;
	}
	
	
	
	
	
	

	@Override
	public AnswerDTO getById(Integer tId) {
		return null;
	}

	@Override
	public boolean save(AnswerDTO t) {
		return false;
	}

	@Override
	public void update(AnswerDTO t) {
		
	}

	@Override
	public void delete(Integer tId) {
		
	}
 

}
