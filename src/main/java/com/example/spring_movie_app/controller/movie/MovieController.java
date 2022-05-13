package com.example.spring_movie_app.controller.movie;

import com.example.spring_movie_app.domain.Account;
import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.form.MovieForm;
import com.example.spring_movie_app.service.account.AccountDetails;
import com.example.spring_movie_app.service.movie.MovieService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController (MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ModelAndView getIndex(ModelAndView modelAndView, Principal principal) {
        List<Movie> movies = null;
        movies = this.movieService.findAll(principal.getName());
        modelAndView.addObject("movies", movies);

        modelAndView.setViewName("movie/index");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView getAdd(ModelAndView modelAndView) {
        modelAndView.addObject("addForm", new MovieForm());

        modelAndView.setViewName("movie/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView postAdd(@AuthenticationPrincipal AccountDetails account,
                                @ModelAttribute("addForm") @Validated MovieForm movieForm,
                                BindingResult result,
                                Principal principal,
                                ModelAndView modelAndView) {
        if(!result.hasErrors()) {
            // MovieFormオブジェクトからMovieオブジェクトへの変換
            Movie movie = movieForm.toEntity();
            movie.setUserName(principal.getName());
            this.movieService.add(movie);

            modelAndView.setViewName("redirect:/movie");
        } else {
            modelAndView.addObject("addForm", movieForm);
            modelAndView.setViewName("movie/add");
        }
        return modelAndView;
    }

    @GetMapping("/{movieId}/edit")
    public ModelAndView getEdit(@PathVariable("movieId") Long movieId,
                                ModelAndView modelAndView) {
        Movie movie = this.movieService.findOne(movieId);
        // MovieオブジェクトからMovieFormオブジェクトへの変換
        MovieForm movieForm = movie.toForm();
        modelAndView.addObject("editForm", movieForm);

        modelAndView.addObject("movieId", movieId);

        modelAndView.setViewName("movie/edit");
        return modelAndView;
    }

    @PostMapping("/{movieId}/update")
    public ModelAndView update(@PathVariable("movieId") Long movieId,
                               @ModelAttribute("editForm") @Validated MovieForm movieForm,
                               BindingResult result,
                               Principal principal,
                               ModelAndView modelAndView) {

        if(!result.hasErrors()) {
            // MovieFormオブジェクトからMovieオブジェクトへの変換
            Movie movie = movieForm.toEntity();
            movie.setUserName(principal.getName());
            movie.setMovieId(movieId);
            this.movieService.updateOne(movie);

            modelAndView.setViewName("redirect:/movie");
        } else {
            modelAndView.addObject("editForm", movieForm);
            modelAndView.addObject("movieId", movieId);
            modelAndView.setViewName("movie/edit");
        }
        return modelAndView;
    }

    @PostMapping("/{movieId}/delete")
    public ModelAndView delete(@PathVariable("movieId") Long movieId,
                               ModelAndView modelAndView) {
        this.movieService.deleteOne(movieId);

        modelAndView.setViewName("redirect:/movie");
        return modelAndView;
    }

}
