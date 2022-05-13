package com.example.spring_movie_app.repository;

import com.example.spring_movie_app.domain.Movie;
import com.example.spring_movie_app.repository.movie.MovieRepositoryImpl;
import com.example.spring_movie_app.repository.mybatis.MovieMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieRepositoryImplTest {

    @Mock
    private SqlSessionTemplate sqlSession;

    @Mock
    private MovieMapper mapper;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        Mockito.doReturn(mapper).when(sqlSession).getMapper(MovieMapper.class);
    }

    @AfterEach
    public void after() {
        Mockito.verify(sqlSession, Mockito.times(1)).getMapper(MovieMapper.class);
    }

    @Test
    public void testFindAllWhenSuccess() {

        // setup 対象メソッドの理想的な振る舞いを定義
        Long input = 1L;
        List<Movie> findResult = new ArrayList<>();
        Movie movie = new Movie();
        findResult.add(movie);
        Mockito.doReturn(findResult).when(mapper).findAll(input);

        // when 対象メソッドの呼び出し
        List<Movie> result = new MovieRepositoryImpl(this.sqlSession).findAll(input);

        //then
        assertEquals(findResult, result); // 戻り値の検証
        Mockito.verify(mapper, Mockito.times(1)).findAll(input); // 呼び出し回数と戻り値の検証
    }

//    @Test
//    public void  testFindAllWhenNotFound() {
//
//        // setup 対象メソッドの理想的な振る舞いを定義
//        String input = "testUser";
//        Mockito.doReturn(null).when(mapper).findAll(input);
//
//        // when 対象メソッドの呼び出し
//       assertThrows(ResourceNotFoundException.class, () -> new MovieRepositoryImpl(this.sqlSession).findAll(input));
//    }

    @Test
    public void testFindOneWhenSuccess() {

        // setup
        Long input = 1L;
        Movie findResult = new Movie();
        Mockito.doReturn(findResult).when(mapper).findOne(input);

        // when
        Movie result = new MovieRepositoryImpl(this.sqlSession).findOne(input);

        //then
        assertEquals(findResult, result);
        Mockito.verify(mapper, Mockito.times(1)).findOne(input);
    }

    @Test
    public void testAddWhenSuccess() {

        // setup
        Movie input = new Movie();
        Mockito.doReturn(1).when(mapper).add(input);

        // when
        new MovieRepositoryImpl(this.sqlSession).add(input);

        // then
        Mockito.verify(mapper, Mockito.times(1)).add(input);
    }

    @Test
    public void testUpdateOneWhenSuccess() {

        // setup
        Movie input = new Movie();
        Mockito.doReturn(1).when(mapper).updateOne(input);

        // when
        new MovieRepositoryImpl(this.sqlSession).updateOne(input);

        // then
        Mockito.verify(mapper, Mockito.times(1)).updateOne(input);
    }

    @Test
    public void testDeleteOneWhenSuccess() {

        // setup
        Long input = 1000L;
        Mockito.doReturn(1).when(mapper).deleteOne(input);

        // when
        new MovieRepositoryImpl(this.sqlSession).deleteOne(input);

        // then
        Mockito.verify(mapper, Mockito.times(1)).deleteOne(input);
    }

}
