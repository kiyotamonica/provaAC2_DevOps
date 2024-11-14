package repository_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.ead_gamificada.entity.Aluno;
import com.ead_gamificada.entity.Email;
import com.ead_gamificada.repository.AlunoRepository;

@DataJpaTest
@ActiveProfiles("test")
public class AlunoRepositoryTest {
    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testSaveAndFindAluno() {
        // Vai criar um novo aluno com um email válido
        Aluno aluno = new Aluno();
        aluno.setNome("Alessandro");
        aluno.setEmail(new Email("alessandro@facens.com"));

        // Depois, salva o aluno no banco de dados
        Aluno savedAluno = alunoRepository.save(aluno);
        assertNotNull(savedAluno.getId());

        // Busca o aluno pelo ID
        Optional<Aluno> retrievedAluno = alunoRepository.findById(savedAluno.getId());
        assertThat(retrievedAluno).isPresent();
        assertThat(retrievedAluno.get().getNome()).isEqualTo("Alessandro");
    }
}
