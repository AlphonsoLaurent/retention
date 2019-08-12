package mx.edu.desam.retention.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.desam.retention.dto.CategoryDTO;
import mx.edu.desam.retention.entity.Answer;
import mx.edu.desam.retention.entity.Category;
import mx.edu.desam.retention.entity.UserPlay;
import mx.edu.desam.retention.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements ICategoryService{

	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	@Override
	public List<CategoryDTO> getAll() {
		List<Category> listCategory =(List<Category>) categoryRepository.findAll();
//		Type listType = new TypeToken<List<CategoryDTO>>(){}.getType();
//		List<CategoryDTO> lstCategoryDTO = new ModelMapper().map(listCategory, listType);
		
		List<CategoryDTO> lstCategoryDTO = new ArrayList<CategoryDTO>();
		CategoryDTO categoryDTO = null;
		for (Category category : listCategory) {
			categoryDTO = new CategoryDTO();
			categoryDTO.setIdCategory(category.getIdCategory());
			categoryDTO.setDescription(category.getDescription());
			lstCategoryDTO.add(categoryDTO);
		}
		
		return lstCategoryDTO;
	}

	@Override
	public CategoryDTO getById(Integer tId) {
		return null;
	}

	@Override
	public boolean save(CategoryDTO t) {
		Category category = new Category();
		category.setDescription(t.getDescription());
		category.setIdAnswer(new Answer());
		category.getIdAnswer().setIdAnswer(t.getIdAnswer());
		category.setIdParent(new Category());
		category.getIdParent().setIdCategory(t.getIdParent());
		category.setIdUser(new UserPlay());
		category.getIdUser().setIdUserp(1);
		category.setActivo(true);
		category.setDateLastUse(new Date());
		categoryRepository.save(category);
		
		return true;
	}

	@Override
	public void update(CategoryDTO t) {
		
	}

	@Override
	public void delete(Integer tId) {
		
	}

	@Override
	public List<CategoryDTO> getCategoryByIdParent(Integer idParent) {
		 
		List<Category> lstCategory =(List<Category>) categoryRepository.findCategoryByIdParent(idParent);
		List<CategoryDTO> lstCategoryDTO = new ArrayList<CategoryDTO>();
		CategoryDTO categoryDTO = null;
		for (Category category : lstCategory) {
			categoryDTO = new CategoryDTO();
			categoryDTO.setDescription(category.getDescription());
			categoryDTO.setIdAnswer(category.getIdAnswer().getIdAnswer());
			categoryDTO.setIdCategory(category.getIdCategory());
			categoryDTO.setIdParent(category.getIdParent().getIdCategory());
			lstCategoryDTO.add(categoryDTO);
		} 
		return lstCategoryDTO;
		
	}

}
