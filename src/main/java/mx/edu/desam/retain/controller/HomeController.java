package mx.edu.desam.retain.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import mx.edu.desam.retain.dto.AnswerDTO;
import mx.edu.desam.retain.dto.CategoryDTO;
import mx.edu.desam.retain.dto.UserPlayDTO;
import mx.edu.desam.retain.entity.UserPlay;
import mx.edu.desam.retain.service.IAnswerService;
import mx.edu.desam.retain.service.ICategoryService;
import mx.edu.desam.retain.service.IUserPlayService;
import mx.edu.desam.retain.util.ResponseDTO;
 

@Controller 
@RequestMapping("/toapply")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class HomeController {
	@Autowired
	IUserPlayService iuserPlayService;
	
	@Autowired
	ICategoryService icategoryService;
	
	
	@Autowired
	IAnswerService ianswerService;
	
	static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	
	@GetMapping("/home")
    public String apply(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index.html";
    }
	
	
	
	@RequestMapping(value = "/saveUserPlay", method=RequestMethod.POST) 
	public ResponseEntity<ResponseDTO>  saveUserPlay(@RequestBody UserPlay catalogo) throws UnknownHostException {
		final String serverAddress = InetAddress.getLocalHost().getHostAddress();

		//iuserPlayService.add(catalogo);  
		List<UserPlayDTO> list = iuserPlayService.getAll();
		ResponseDTO response = getResponse(true, "::::::origen peticion:::"+serverAddress, list);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); //list
	}
	
	
	@GetMapping("/findallUsers")
	public ResponseEntity<ResponseDTO> findallUserPlay() throws UnknownHostException{
		 final String serverAddress = InetAddress.getLocalHost().getHostAddress(); 
		 UserPlayDTO list = iuserPlayService.getById(1);
		ResponseDTO response = getResponse(true, "::::::origen peticion:::"+serverAddress, list);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); //list
	}
	
	@GetMapping("/findallCategory")
	public ResponseEntity<ResponseDTO> findallCategory() throws UnknownHostException{
		 final String serverAddress = InetAddress.getLocalHost().getHostAddress(); 
		List<CategoryDTO> list = icategoryService.getAll();
		ResponseDTO response = getResponse(true, "::::::origen peticion:::"+serverAddress, list);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); //list
	}
	
	@GetMapping("/findallAnswer")
	public ResponseEntity<ResponseDTO> findallAnswer() throws UnknownHostException{
		final String serverAddress = InetAddress.getLocalHost().getHostAddress(); 
		AnswerDTO list =ianswerService.getById(1);
		ResponseDTO response = getResponse(true, "::::::origen peticion:::"+serverAddress, list);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); //list
	}
	
	
	public ResponseDTO getResponse(boolean isSuccessful, String msgFinal, Object ...objects) {
		ResponseDTO response = new ResponseDTO(false);
		List<Object> lstResponse = null;
		if(objects != null && objects.length>0) {
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
