package personas.jdbc;

import personas.dto.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDao {
    int insert(PersonaDTO personaDTO) throws SQLException;
    int update(PersonaDTO personaDTO) throws SQLException;
    int delete(PersonaDTO personaDTO) throws SQLException;
    List<PersonaDTO> select() throws SQLException;
}
