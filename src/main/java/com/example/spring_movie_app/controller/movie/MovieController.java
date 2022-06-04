package com.example.spring_movie_app.controller.movie;

import com.example.spring_movie_app.domain.Genre;
import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.form.MovieForm;
import com.example.spring_movie_app.helper.MessageSourceHelper;
import com.example.spring_movie_app.repository.DuplicateKeyException;
import com.example.spring_movie_app.security.AccountDetails;
import com.example.spring_movie_app.service.genre.GenreService;
import com.example.spring_movie_app.service.movie.MovieService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    private final GenreService genreService;

    private final MessageSourceHelper messageSource;

    /**
     * コンストラクタ
     *
     * @param movieService movieサービス
     * @param genreService genreサービス
     * @param messageSource メッセージソース
     */
    public MovieController (MovieService movieService, GenreService genreService, MessageSourceHelper messageSource) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.messageSource = messageSource;
    }

    /**
     * 映画一覧画面に遷移するコントローラメソッド
     */
    @GetMapping
    public ModelAndView getList(@AuthenticationPrincipal AccountDetails accountDetails,
                                 //@PageableDefault(size=10, page=0) Pageable pageable,
                                 ModelAndView modelAndView) {

        List<Movie> movies = null;
        movies = this.movieService.find(accountDetails.getUserId(), null);
        if(movies.isEmpty()) {
            modelAndView.addObject("movies", null);
        } else {
            for (Movie movie : movies) {
                if(movie.getMovieComment().length() > 15) {
                    movie.setMovieComment(movie.getMovieComment().substring(0, 16) + "...");
                }
                if(movie.getMovieName().length() > 10) {
                    movie.setMovieName(movie.getMovieName().substring(0, 11) + "...");
                }
            }
            modelAndView.addObject("movies", movies);
        }

        Set<String> genreNames = new HashSet<>();
        for (Movie movie : movies) {
            genreNames.add(movie.getMovieGenre());
        }
        modelAndView.addObject("genreNames", genreNames);

        modelAndView.addObject("allMovieCountMsg", "記録した映画：" + movies.size() + "本");

        modelAndView.addObject("loginUserName", accountDetails.getUserName());

        modelAndView.setViewName("movie/index");

        return modelAndView;
    }

    /**
     * 映画検索を行うコントローラメソッド
     */
    @GetMapping("/search")
    public ModelAndView getSearch(@AuthenticationPrincipal AccountDetails accountDetails,
                                 @RequestParam String keyword,
                                 //@PageableDefault(size=10, page=0) Pageable pageable,
                                 ModelAndView modelAndView) {

        List<Movie> movies = null;
        movies = this.movieService.find(accountDetails.getUserId(), keyword);
        if(movies.isEmpty()) {
            modelAndView.addObject("movies", null);
            modelAndView.addObject("searchResultMsg", "検索結果なし");
        } else {
            for (Movie movie : movies) {
                if(movie.getMovieComment().length() > 20) {
                    movie.setMovieComment(movie.getMovieComment().substring(0, 21) + "...");
                }
            }
            modelAndView.addObject("movies", movies);
            modelAndView.addObject("searchResultMsg", "検索結果：" + movies.size() + "本");
        }

        modelAndView.addObject("keyword", keyword);
        modelAndView.addObject("loginUserName", accountDetails.getUserName());

        modelAndView.setViewName("movie/index");

        return modelAndView;
    }

    /**
     * 映画詳細画面に遷移するコントローラメソッド
     */
    @GetMapping("/{movieId}/detail")
    public ModelAndView getDetail(@AuthenticationPrincipal AccountDetails accountDetails,
                                  @PathVariable("movieId") Long movieId,
                                  ModelAndView modelAndView) {

        Movie movie = this.movieService.get(movieId);
        modelAndView.addObject("movie", movie);

        modelAndView.addObject("loginUserName", accountDetails.getUserName());

        modelAndView.setViewName("movie/detail");

        return modelAndView;
    }

    /**
     * 映画登録画面に遷移するコントローラメソッド
     */
    @GetMapping("/add")
    public ModelAndView getAdd(@AuthenticationPrincipal AccountDetails accountDetails,
                               ModelAndView modelAndView) {

        List<Genre> genres = this.genreService.find(null);
        modelAndView.addObject("genres", genres);

        modelAndView.addObject("addForm", new MovieForm());

        modelAndView.addObject("loginUserName", accountDetails.getUserName());

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
                                RedirectAttributes redirectAttributes,
                                ModelAndView modelAndView) {

        if(result.hasErrors()) {
            List<Genre> genres = this.genreService.find(null);
            modelAndView.addObject("genres", genres);
            modelAndView.addObject("addForm", movieForm);
            modelAndView.setViewName("movie/add");
            return modelAndView;
        }

        // MovieFormオブジェクトからMovieオブジェクトへの変換
        Movie movie = movieForm.toEntity();
        movie.setUserId(accountDetails.getUserId());

        try {
            this.movieService.add(movie);
        } catch (DataIntegrityViolationException ex) {
            List<Genre> genres = this.genreService.find(null);
            modelAndView.addObject("genres", genres);
            modelAndView.addObject("addForm", movieForm);
            modelAndView.addObject("errorMsg", messageSource.getMessage("movie.error.duplicate.userName", movieForm.getMovieName()));
            modelAndView.setViewName("movie/add");
            return modelAndView;
        }

        redirectAttributes.addFlashAttribute("add_msg",
                messageSource.getMessage("movie.success.add", movie.getMovieName()));

        modelAndView.setViewName("redirect:/movie");

        return modelAndView;
    }

    /**
     * 映画編集画面に遷移するコントローラメソッド
     */
    @GetMapping("/{movieId}/edit")
    public ModelAndView getEdit(@AuthenticationPrincipal AccountDetails accountDetails,
                                @PathVariable("movieId") Long movieId,
                                ModelAndView modelAndView) {

        List<Genre> genres = this.genreService.find(null);
        modelAndView.addObject("genres", genres);

        Movie movie = this.movieService.get(movieId);
        // MovieオブジェクトからMovieFormオブジェクトへの変換
        MovieForm movieForm = movie.toForm();
        modelAndView.addObject("editForm", movieForm);

        modelAndView.addObject("movieId", movieId);

        modelAndView.addObject("loginUserName", accountDetails.getUserName());

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
                               RedirectAttributes redirectAttributes,
                               ModelAndView modelAndView) {

        if (result.hasErrors()) {
            List<Genre> genres = this.genreService.find(null);
            modelAndView.addObject("genres", genres);
            modelAndView.addObject("editForm", movieForm);
            modelAndView.addObject("movieId", movieId);
            modelAndView.setViewName("movie/edit");
            return modelAndView;
        }

        // MovieFormオブジェクトからMovieオブジェクトへの変換
        Movie movie = movieForm.toEntity();
        movie.setUserId(accountDetails.getUserId());
        movie.setMovieId(movieId);

        this.movieService.updateOne(movie);

        redirectAttributes.addFlashAttribute("edit_msg",
                messageSource.getMessage("movie.success.edit", movie.getMovieName()));

        modelAndView.setViewName("redirect:/movie");

        return modelAndView;
    }

    /**
     * 映画削除を行うコントローラメソッド
     */
    @GetMapping("/{movieId}/delete")
    public ModelAndView delete(@PathVariable("movieId") Long movieId,
                               RedirectAttributes redirectAttributes,
                               ModelAndView modelAndView) {

        Movie movie = this.movieService.get(movieId);

        this.movieService.deleteOne(movieId);

        redirectAttributes.addFlashAttribute("delete_msg",
                messageSource.getMessage("movie.success.delete", movie.getMovieName()));

        modelAndView.setViewName("redirect:/movie");
        return modelAndView;
    }

}
