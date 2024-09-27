package com.project.bootcamp.service;

import com.project.bootcamp.dto.MovieRequest;

public interface MovieService {
    String save(MovieRequest request);

    String get(Long id);
}
