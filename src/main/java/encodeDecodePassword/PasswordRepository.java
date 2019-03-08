package encodeDecodePassword;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<PasswordDTO, String> {
	List<PasswordDTO> findByText(String pass);

	List<PasswordDTO> findBykey(String key);

	void save(PasswordDTO text, PasswordDTO key);

}
