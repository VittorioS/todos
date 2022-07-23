package com.example.todos.repository;

import com.example.todos.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component("TodosRepositoryREST")
@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
@CrossOrigin(originPatterns = "*")
public interface TodosRepositoryREST extends PagingAndSortingRepository<Todo, Long> {

    Page<Todo> findByTitle(@Param("title") String title, Pageable pageable);

    @Override
    @RestResource(exported = false)
    <S extends Todo> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported = false)
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Todo> entities);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
