package com.oliver.book.springbootsample.config.auth;

import com.oliver.book.springbootsample.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정을 활성화시킨다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable()//h2-console 화면을 사용하기 위해 해당 옵션을 disable
                .and()
                        .authorizeRequests()//권한 관리 대상을 지정하는 옵션, URL 및 메소드별 관리 가능
                        .antMatchers("/", "css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //지정된 url들은 permitAll을 통해 전체 열람권한을 줌
                        .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //user만 /api/v1에 접근할 수 있도록 함.
                        .anyRequest().authenticated()//설정값 이외의 url, authenticated를 통해 인증된 사용자들에게만 허용한다.
                .and()
                        .logout()
                                .logoutSuccessUrl("/") //로그아웃 성공시 /주소로 이동
                .and()
                        .oauth2Login()//OAuth2 로그인 기능 설정의 진입점
                                .userInfoEndpoint() //OAuth2 로그인 성공 후 사용자 정보를 가져올때의 설정 담당
                                        .userService(customOAuth2UserService); //사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시
    }
}
