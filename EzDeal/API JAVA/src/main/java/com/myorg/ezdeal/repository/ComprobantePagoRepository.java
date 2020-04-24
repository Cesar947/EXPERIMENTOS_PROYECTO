package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.ComprobantePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobantePagoRepository extends JpaRepository<ComprobantePago, Long> {
}
