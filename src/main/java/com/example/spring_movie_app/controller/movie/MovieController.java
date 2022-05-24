package com.example.spring_movie_app.controller.movie;

import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.form.MovieForm;
import com.example.spring_movie_app.helper.MessageSourceHelper;
import com.example.spring_movie_app.repository.DuplicateKeyException;
import com.example.spring_movie_app.security.AccountDetails;
import com.example.spring_movie_app.service.movie.MovieService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    private final MessageSourceHelper messageSource;

    /**
     * コンストラクタ
     *
     * @param movieService movieサービス
     * @param messageSource メッセージソース
     */
    public MovieController (MovieService movieService, MessageSourceHelper messageSource) {
        this.movieService = movieService;
        this.messageSource = messageSource;
    }

    /**
     * 映画一覧画面に遷移するコントローラメソッド
     */
    @GetMapping
    public ModelAndView getIndex(@AuthenticationPrincipal AccountDetails accountDetails,
                                 //@PageableDefault(size=10, page=0) Pageable pageable,
                                 ModelAndView modelAndView) {

        List<Movie> movies = null;
        movies = this.movieService.findAll(accountDetails.getUserId());
        if(movies.isEmpty()) {
            modelAndView.addObject("movies", null);
        } else {
            for (Movie movie : movies) {
                if(movie.getMovieComment().length() > 20) {
                    movie.setMovieComment(movie.getMovieComment().substring(0, 21) + "...");
                }
            }
            modelAndView.addObject("movies", movies);
        }

        Integer movieCount = movies.size();
        modelAndView.addObject("movieCount", movieCount);

        modelAndView.setViewName("movie/index");
        return modelAndView;
    }

    /**
     * 映画登録画面に遷移するコントローラメソッド
     */
    @GetMapping("/add")
    public ModelAndView getAdd(ModelAndView modelAndView) {
        modelAndView.addObject("addForm", new MovieForm());

        modelAndView.setViewName("movie/add");
        return modelAndView;
    }

    /**
     * 映画登録を行うコントローラメソッド
     */
    @PostMapping("/add")
    public ModelAndView postAdd(@AuthenticationPrincipal AccountDetails accountDetails,
                                @ModelAttribute("addForm") @Validated MovieForm movieForm,
                                BindingResult result,
                                ModelAndView modelAndView) {

        if(result.hasErrors()) {
            modelAndView.addObject("addForm", movieForm);
            modelAndView.setViewName("movie/add");
            return modelAndView;
        }

        // MovieFormオブジェクトからMovieオブジェクトへの変換
        Movie movie = movieForm.toEntity();
        movie.setUserId(accountDetails.getUserId());
        try {
            this.movieService.add(movie);
        } catch (DuplicateKeyException ex) {
            modelAndView.addObject("errorMsg", messageSource.getMessage("movie.error.duplicate.movieName"));
            modelAndView.addObject("addForm", movieForm);
            modelAndView.setViewName("movie/add");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/movie");
        return modelAndView;
    }

    /**
     * 映画編集画面に遷移するコントローラメソッド
     */
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

    /**
     * 映画編集を行うコントローラメソッド
     */
    @PostMapping("/{movieId}/update")
    public ModelAndView update(@AuthenticationPrincipal AccountDetails accountDetails,
                               @PathVariable("movieId") Long movieId,
                               @ModelAttribute("editForm") @Validated MovieForm movieForm,
                               BindingResult result,
                               ModelAndView modelAndView) {

        if(!result.hasErrors()) {
            // MovieFormオブジェクトからMovieオブジェクトへの変換
            Movie movie = movieForm.toEntity();
            movie.setUserId(accountDetails.getUserId());
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

    /**
     * 映画削除を行うコントローラメソッド
     */
    @PostMapping("/{movieId}/delete")
    public ModelAndView delete(@PathVariable("movieId") Long movieId,
                               ModelAndView modelAndView) {
        this.movieService.deleteOne(movieId);

        modelAndView.setViewName("redirect:/movie");
        return modelAndView;
    }

}
