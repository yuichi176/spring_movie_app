package com.example.spring_movie_app.repository.account;

import com.example.spring_movie_app.domain.Account;

public interface AccountRepository {
    /**
     * ID指定による1件参照処理。
     *
     * @param userId サービスから渡されるユーザID
     * @return 指定されたUSERIDのUserAccountデータ
     */
    Account findOne(String userId);

    /**
     * 新規ユーザ登録処理
     *
     * @param userId サービスから渡されるユーザID
     * @param password サービスから渡されるパスワード
     */
    void add(String userId, String password);
}
