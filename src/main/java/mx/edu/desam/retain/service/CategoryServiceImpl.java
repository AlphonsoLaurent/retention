package mx.edu.desam.retain.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.desam.retain.dto.CategoryDTO;
import mx.edu.desam.retain.entity.Category;
import mx.edu.desam.retain.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements ICategoryService{

	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	@Override
	public List<CategoryDTO> getAll() {
		List<Category> listCategory =(List<Category>) categoryRepository.findAll();
		Type listType = new TypeToken<List<CategoryDTO>>(){}.getType();
		List<CategoryDTO> lstCategoryDTO = new ModelMapper().map(listCategory, listType);
		return lstCategoryDTO;
	}

	@Override
	public CategoryDTO getById(Integer tId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(CategoryDTO t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(CategoryDTO t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer tId) {
		// TODO Auto-generated method stub
		
	}

}
