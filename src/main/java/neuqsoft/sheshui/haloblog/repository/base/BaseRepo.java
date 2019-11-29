package neuqsoft.sheshui.haloblog.repository.base;

import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.util.List;


/**
 * Base repository interface contains some common methods.
 * 仓库基本模板
 *
 * @param <DOMAIN> domain type
 * @param <ID> id type
 * @author sheshui
 */
@NoRepositoryBean
public interface BaseRepo<DOMAIN,ID> extends JpaRepository<DOMAIN,ID> {
    /**
     *
     * Finds all domain by id list.
     *
     * @param ids id list of domain must not be null
     * @param sort the specified sort must not be null
     * @return a list of domains
     */
    @NonNull
    List<DOMAIN> findAllByIdIn(@NonNull Iterable<ID> ids, @NonNull Sort sort);

    /**
     * Finds all domain by domain id list.
     *
     *
     * @param ids must not be null
     * @param pageable must not be null
     * @return a list of domains
     */
    @NonNull
    Page<DOMAIN> findAllByIdIn(@NonNull Iterable<ID> ids, @NonNull Pageable pageable);

    /**
     * Deletes by id list.
     *
     * @param ids id list of domain must not be null
     * @return number of rows affected
     */
    long deleteByIdIn(@NonNull Iterable<ID> ids);
}
