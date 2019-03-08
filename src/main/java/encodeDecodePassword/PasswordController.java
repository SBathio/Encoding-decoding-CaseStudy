package encodeDecodePassword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class PasswordController {
	@Autowired
	private PasswordService passwordService;

	@RequestMapping(method = RequestMethod.POST, value = "/password")
	public void addPassword(@RequestBody PasswordDTO pass, PasswordDTO key) {

		passwordService.addPassword(pass, key);
	}

	@RequestMapping("/encode")
	public List<PasswordDTO> encode(String pass, String key) {
		return passwordService.encode(pass, key);
	}

	@RequestMapping("/decode")
	public List<PasswordDTO> Decode(String pass, String key) {
		return passwordService.decode(pass, key);
	}

}
