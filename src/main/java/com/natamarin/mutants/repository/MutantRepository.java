package com.natamarin.mutants.repository;

import org.springframework.data.repository.CrudRepository;

import com.natamarin.mutants.entity.AdnVerificado;

/**
 * Interfaz encargada del manejo jpa
 * @author nmarin
 *
 */
public interface MutantRepository extends CrudRepository<AdnVerificado, Long> {

	Long countByEsMutante(Boolean esMutante);
}
