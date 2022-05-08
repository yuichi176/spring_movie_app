package com.example.spring_movie_app.service.account;

import com.example.spring_movie_app.domain.Account;
import com.example.spring_movie_app.repository.account.AccountRepository;
import com.example.spring_movie_app.service.account.AccountDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    public AccountDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = null;
        account = accountRepository.findOne(userName);
        if(account == null) {
            throw new UsernameNotFoundException("ユーザIDは存在しません。");
        }
        return new AccountDetails(account);
    }
}
