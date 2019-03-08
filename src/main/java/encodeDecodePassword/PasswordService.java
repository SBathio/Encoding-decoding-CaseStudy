package encodeDecodePassword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
	@Autowired
	private PasswordRepository passwordRepository;

	public void addPassword(PasswordDTO pass, PasswordDTO key) {

		passwordRepository.save(pass, key);
	}

	public List<PasswordDTO> encode(String pass, final String key) {

		pass = pass.toUpperCase();
		int N = pass.length();
		String ans = "";
		for (int i = 0, j = 0; i < N; i++) {
			char c = pass.charAt(i);
			if (c < 'A' || c > 'Z')
				continue;
			ans += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % key.length();
		}
		return passwordRepository.findByText(ans);
	}

	public List<PasswordDTO> decode(String pass, final String key) {

		pass = pass.toUpperCase();
		int N = pass.length();
		String ans = "";
		for (int i = 0, j = 0; i < N; i++) {
			char c = pass.charAt(i);
			if (c < 'A' || c > 'Z')
				continue;
			ans += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
			j = ++j % key.length();
		}
		return passwordRepository.findByText(ans);
	}
}
