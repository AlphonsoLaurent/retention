package mx.edu.desam.retention.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.edu.desam.retention.dto.AnswerDTO;
import mx.edu.desam.retention.dto.CategoryDTO;
import mx.edu.desam.retention.dto.UserPlayDTO;
import mx.edu.desam.retention.entity.UserPlay;
import mx.edu.desam.retention.service.IAnswerService;
import mx.edu.desam.retention.service.ICategoryService;
import mx.edu.desam.retention.service.IUserPlayService;
import mx.edu.desam.retention.util.ResponseDTO;

@Controller
@RequestMapping("/retention")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class HomeController {
	@Autowired
	IUserPlayService iuserPlayService;

	@Autowired
	ICategoryService icategoryService;

	@Autowired
	IAnswerService ianswerService;

	static Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(value = "/home")
	public String apply(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "index.html";
	}

	@GetMapping(path="/getUser")
	public ResponseEntity<ResponseDTO> getUser() throws UnknownHostException { 
		UserPlayDTO userPlayDTO = iuserPlayService.getById(1);
		ResponseDTO response = getResponse(true, "::::::origen peticion:::", userPlayDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); // list
	}
	
	
	@GetMapping(path="/getChild")
	public ResponseEntity<ResponseDTO> getChild(@Param(value = "idParent") Integer idParent) throws UnknownHostException {
		List<CategoryDTO> lstCategory = icategoryService.getCategoryByIdParent(idParent);
		ResponseDTO response = new ResponseDTO(true, "exito", (List)lstCategory);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); // list
	}
	
	
	@RequestMapping(value = "/saveCategory", method = {RequestMethod.POST,RequestMethod.GET })
	public ResponseEntity<ResponseDTO> saveCategory(@Valid CategoryDTO category) {
		icategoryService.save(category);
		ResponseDTO response = getResponse(true, "Éxito" , null);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	
	


	

	
	
	@GetMapping("/getCategories")
	public ResponseEntity<ResponseDTO> getCategories() { 
		List<CategoryDTO> lstCategories = icategoryService.getAll(); 
		ResponseDTO response = new ResponseDTO(true, "Exitoso!!", (List)lstCategories);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); // list
	}
	
	

	@GetMapping("/findAllAnswer")
	public ResponseEntity<ResponseDTO> findAllAnswer() { 
		List<AnswerDTO> lstAnswerDTO = ianswerService.getAll();
		ResponseDTO response = new ResponseDTO(true, "Exitoso!!", (List)lstAnswerDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/saveUserPlay", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> saveUserPlay(@RequestBody UserPlay userPlay){
		List<UserPlayDTO> list = iuserPlayService.getAll();
		ResponseDTO response = getResponse(true, "::::::origen peticion:::", list);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); // list
	}
	
	
	
	
	
	
	
	

	public ResponseDTO getResponse(boolean isSuccessful, String msgFinal, Object... objects) {
		ResponseDTO response = new ResponseDTO(false);
		List<Object> lstResponse = null;
		if (objects != null && objects.length > 0) {
			lstResponse = new ArrayList<Object>();
			for (Object object : objects) {
				lstResponse.add(object);
			}
		}
		response.setSuccessful(isSuccessful);
		response.setMsgSuccess(msgFinal);
		response.setLstResponse(lstResponse);
		return response;
	}

}
