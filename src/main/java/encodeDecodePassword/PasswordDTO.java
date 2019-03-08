package encodeDecodePassword;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class PasswordDTO {
	@Id
	String key;
	String pass;
	

	public PasswordDTO(String text, String key) {

		this.pass = text;
		this.key = key;
	}

	public String getText() {
		return pass;
	}

	public void setText(String text) {
		this.pass = text;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Password [text=" + pass + ", key=" + key + "]";
	}

}
