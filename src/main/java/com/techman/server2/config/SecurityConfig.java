package com.techman.server2.config;

//import com.techman.server2.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//                .and()
//                .csrf().disable()
//                .exceptionHandling()
//                .and()
//                .authorizeRequests()
//                .antMatchers( "/login", "/signUp**").permitAll() //tells us where we don't have to be loged in to view these pages.
//                .antMatchers(
//                        "/favicon.ico",
//                        "/**/*.png",
//                        "/**/*.gif",
//                        "/**/*.svg",
//                        "/**/*.jpg",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js"
//                )
//                .permitAll()
//                .antMatchers("/users", "/addUser", "/editUser/**", "/updateUser").hasRole("ADMIN")
//                .antMatchers("/editTest/**", "/updateTest", "/userBookings/**", "/vaccine", "/editVaccine/**", "/updateVaccine").hasAnyRole("ADMIN", "SECRETARY")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
//                .and()
//                .logout().invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserDetailsServiceImpl();
//    } // The UserDetailsService interface is used to retrieve user-related data
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    } // PasswordEncoder interface that uses the BCrypt strong hashing function to encode the password.
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();  //The super keyword in Java is a reference variable which is used to refer immediate parent class object.
//    }
//}
