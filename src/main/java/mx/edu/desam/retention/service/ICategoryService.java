package mx.edu.desam.retention.service;

import java.util.List;

import mx.edu.desam.retention.dto.CategoryDTO;
 

public interface ICategoryService extends IService<CategoryDTO>{ 
	public List<CategoryDTO> getCategoryByIdParent(Integer idParent);
}
