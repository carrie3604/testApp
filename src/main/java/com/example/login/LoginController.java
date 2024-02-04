package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{
    // URL
    public static final String PAGE_LOGIN = "/myspring/login";
    public static final String PAGE_LOGIN_SUCCESS = "/myspring/login/dashboard";// URL
    public static final String PAGE_LOGIN_FAILED = "/myspring/login/error";

    // Directory
    public static final String TEMPL_LOGIN = "default/login/login";
    public static final String TEMPL_LOGIN_SUCCESS = "default/login/dashboard";
    public static final String TEMPL_LOGIN_FAILED = "default/login/error";

    @Autowired
    private LoginRepository userRepository;

    @GetMapping(path = PAGE_LOGIN)
    public ModelAndView showLoginPage(final ModelMap model)
    {
        return new ModelAndView(TEMPL_LOGIN, HttpStatus.OK);
    }

    @PostMapping(path = PAGE_LOGIN_SUCCESS, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) // diese Format
    public ModelAndView showDashboardPage(@ModelAttribute final UserLoginRequest user)

    {
        String email = user.getEmail().toString();
        String password = user.getPassword();

        LoginEntity UserLoginData = userRepository.findUserbyEmail(email);

        if (UserLoginData == null || !UserLoginData.getPassword().equals(password))
        {
            return new ModelAndView(TEMPL_LOGIN_FAILED, HttpStatus.NOT_FOUND);
        }

        return new ModelAndView(TEMPL_LOGIN_SUCCESS, HttpStatus.OK);
    }

}
