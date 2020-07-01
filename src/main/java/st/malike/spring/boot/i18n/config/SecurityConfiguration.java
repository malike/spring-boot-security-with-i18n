package st.malike.spring.boot.i18n.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import st.malike.spring.boot.i18n.service.UserDetailService;

@Configuration
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


  @Autowired
  private UserDetailService userDetailService;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.antMatcher("/**")
        .authorizeRequests()
        .antMatchers("/login/**").permitAll()
        .anyRequest()
        .fullyAuthenticated()
        .antMatchers("/**").authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/home")
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
        .deleteCookies("JSESSIONID")
        .permitAll()
        .and()
        .exceptionHandling()
        .accessDeniedPage("/login?access_denied")
        .and()
        .csrf()
        .disable().sessionManagement()
        .maximumSessions(1)
        .expiredUrl("/login?expired_session");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService)
        .passwordEncoder(passwordEncoder);
  }


}


