package mx.edu.desam.retain.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.desam.retain.dto.CategoryDTO;
import mx.edu.desam.retain.dto.UserPlayDTO;
import mx.edu.desam.retain.entity.Category;
import mx.edu.desam.retain.entity.UserPlay;
import mx.edu.desam.retain.repository.CategoryRepository;
import mx.edu.desam.retain.repository.UserPlayRepository;
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
		UserPlayDTO orderDto = modelMapper.map(userPlay, UserPlayDTO.class);

		
		List<Category> lstCategory= categoryRepository.findCategoryByUser(tId);
		Type listType = new TypeToken<List<CategoryDTO>>(){}.getType();
		List<CategoryDTO> lstCategoryDTO = new ModelMapper().map(lstCategory, listType);
		orderDto.setCategoryListDTO(lstCategoryDTO);
		
		return orderDto;
	}

	@Override
	public boolean add(UserPlayDTO t) {
		// TODO Auto-generated method stub
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
