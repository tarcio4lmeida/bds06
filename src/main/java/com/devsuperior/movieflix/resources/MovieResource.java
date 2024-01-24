package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        MovieDTO MovieDTO = service.findbyId(id);
        return ResponseEntity.ok(MovieDTO);
    }

    @Transactional(readOnly = true)
    @GetMapping()
    public  ResponseEntity<Page<MovieDTO>> findMoviesByGenre(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable) {
        Page<MovieDTO> page = service.findMoviesByGenre(genreId, pageable);
        return ResponseEntity.ok(page);

    }

    @GetMapping(value = "/{id}/reviews")
    public ResponseEntity<MovieDTO> findMovieReviews(@PathVariable Long id) {
        MovieDTO MovieDTO = service.findMovieReviews(id);
        return ResponseEntity.ok(MovieDTO);
    }
}
