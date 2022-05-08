package com.example.spring_movie_app.service.signup;

import com.example.spring_movie_app.repository.account.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public SignupServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void add(String userName, String password) {
        // パスワードのハッシュ化
        String encodedPassword = this.passwordEncoder.encode(password);
        this.accountRepository.add(userName, encodedPassword);
    }
}
