package br.com.bandtec.avaliacaocontinuada2arthurcabral;

import br.com.bandtec.avaliacaocontinuada2arthurcabral.Lutadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadoresRepository extends JpaRepository<Lutadores, Integer> {

//    @Query("select l from Lutadores l order by l.forcaGolpe desc")
    List<Lutadores> findAllByOrderByForcaGolpeDesc();

    List<Lutadores> findByVivoTrue();
    List<Lutadores> findByVivoFalse();
}
