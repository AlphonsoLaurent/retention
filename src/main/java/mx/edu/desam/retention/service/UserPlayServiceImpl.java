package mx.edu.desam.retention.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.desam.retention.dto.CategoryDTO;
import mx.edu.desam.retention.dto.UserPlayDTO;
import mx.edu.desam.retention.entity.Category;
import mx.edu.desam.retention.entity.UserPlay;
import mx.edu.desam.retention.repository.CategoryRepository;
import mx.edu.desam.retention.repository.UserPlayRepository;
@Service
public class UserPlayServiceImpl implements IUserPlayService {
	@Autowired
	UserPlayRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<UserPlayDTO> getAll() {
		List<UserPlay> listUserPlay =(List<UserPlay>) userRepository.findAll();
		Type listType = new TypeToken<List<UserPlayDTO>>(){}.getType();
		List<UserPlayDTO> lstUserPlayDTO = new ModelMapper().map(listUserPlay, listType);
		return lstUserPlayDTO;
	}

	@Override
	public UserPlayDTO getById(Integer tId) {
		//1,-se consulta al usuario
		UserPlay userPlay = (UserPlay)userRepository.findOne(tId);
		ModelMapper modelMapper = new ModelMapper();
//		UserPlayDTO usrPlayDTO = modelMapper.map(userPlay, UserPlayDTO.class);
		UserPlayDTO usrPlayDTO = new UserPlayDTO(); 
		usrPlayDTO.setNameUser(userPlay.getNameUser());
		usrPlayDTO.seteMail(userPlay.getEMail());
		
		List<Category> lstCategory= categoryRepository.findCategoryByParent();
//		Type listType = new TypeToken<List<CategoryDTO>>(){}.getType();
//		List<CategoryDTO> lstCategoryDTO = new ModelMapper().map(lstCategory, listType);
		
		List<CategoryDTO> lstCategoryDTO = new ArrayList<CategoryDTO>();
		CategoryDTO categoryDTO = null;
		for (Category category : lstCategory) {
			categoryDTO = new CategoryDTO();
			categoryDTO.setDescription(category.getDescription());
			categoryDTO.setIdAnswer(category.getIdAnswer().getIdAnswer());
			categoryDTO.setIdCategory(category.getIdCategory());
			categoryDTO.setIdParent(0);
			lstCategoryDTO.add(categoryDTO);
		} 
		usrPlayDTO.setLstCategoryDTO(lstCategoryDTO);
		return usrPlayDTO;
	}

	@Override
	public boolean save(UserPlayDTO t) {
		return false;
	}

	@Override
	public void update(UserPlayDTO t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer tId) {
		// TODO Auto-generated method stub

	}

}
