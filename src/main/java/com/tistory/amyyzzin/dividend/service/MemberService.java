package com.tistory.amyyzzin.dividend.service;

import com.tistory.amyyzzin.dividend.exception.impl.AlreadyExistUserException;
import com.tistory.amyyzzin.dividend.exception.impl.NoUserException;
import com.tistory.amyyzzin.dividend.exception.impl.NotMatchPasswordException;
import com.tistory.amyyzzin.dividend.model.Auth;
import com.tistory.amyyzzin.dividend.model.MemberEntity;
import com.tistory.amyyzzin.dividend.persist.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.memberRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("couldn't find user -> " + username));
    }

    public MemberEntity register(Auth.SignUp member) {

        boolean exists = this.memberRepository.existsByUsername(member.getUsername());
        if (exists) {
            throw new AlreadyExistUserException();
        }

        member.setPassword(this.passwordEncoder.encode(member.getPassword()));
        var result = this.memberRepository.save(member.toEntity());
        return result;
    }

    public MemberEntity authenticate(Auth.SignIn member) {
        var user = this.memberRepository.findByUsername(member.getUsername())
            .orElseThrow(() -> new NoUserException());

        if(!this.passwordEncoder.matches(member.getPassword(), user.getPassword())) {
            throw new NotMatchPasswordException();
        }

        return user;
    }
}
