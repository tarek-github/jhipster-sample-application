package fr.cnrs.dsi.sesame.frontend.repository;

import fr.cnrs.dsi.sesame.frontend.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
