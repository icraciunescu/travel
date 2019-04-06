package ro.sda.travel.core.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Integer> {

    T findById(int id);

}
