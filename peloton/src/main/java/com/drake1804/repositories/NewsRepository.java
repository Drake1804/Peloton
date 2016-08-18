package com.drake1804.repositories;


import com.drake1804.domain.News;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Pavel.Shkaran on 7/28/2016.
 */
public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

    @Modifying
    @Transactional
    @Query("update News n set n.views = n.views + 1 where n.id = ?1")
    int incrementNewsViews(long id);

}
