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

import jakarta.validation.Valid;

@Controller
public class UserController
{
    // URL
    public static final String PAGE_LOGIN = "/myspring/login";
    public static final String PAGE_LOGIN_SUCCESS = "/myspring/login/dashboard";
    public static final String PAGE_LOGIN_FAILED = "/myspring/login/error";
    public static final String PAGE_REGISTER = "/myspring/users/register";
    public static final String PAGE_REGISTER_SUCCESS = "/myspring/users/register_successful";

    // Directory
    public static final String TEMPL_LOGIN = "default/login/login";
    public static final String TEMPL_LOGIN_SUCCESS = "default/login/dashboard";
    public static final String TEMPL_LOGIN_FAILED = "default/login/error";
    public static final String TEMPL_REGISTER_SUCCESS = "default/login/register_success";
    public static final String TEMPL_REGISTER = "default/login/register";

    // log
    private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = PAGE_LOGIN)
    public ModelAndView showLoginPage(final ModelMap model)
    {
        return new ModelAndView(TEMPL_LOGIN, HttpStatus.OK);
    }

    @PostMapping(path = PAGE_LOGIN_SUCCESS, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE) // diese Format ist wegen Request
    public ModelAndView showDashboardPage(@ModelAttribute @Valid final UserLoginRequest user)

    {
        String email = user.getEmail().toString();
        String password = user.getPassword();

        UserEntity UserLoginData = userRepository.findbyEmail(email);

        if (UserLoginData == null || !UserLoginData.getPassword().equals(password))
        {
            return new ModelAndView(TEMPL_LOGIN_FAILED, HttpStatus.NOT_FOUND);
        }
        return new ModelAndView(TEMPL_LOGIN_SUCCESS, HttpStatus.OK);
    }

    // register page
    @GetMapping(path = PAGE_REGISTER)
    public ModelAndView showRegisterForm()
    {
        return new ModelAndView(TEMPL_REGISTER, HttpStatus.OK);
    }

    // register result
    @PostMapping(path = PAGE_REGISTER, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView register(@ModelAttribute @Valid final UserRegisterRequest user, final ModelMap model)
    {
        String email = user.getEmail().toString();
        String password = user.getPassword();

        UserEntity existingEmail = userRepository.findbyEmail(email);
        UserEntity existingPassword = userRepository.findbyPassword(password);

        // check if the email or password already exist
        if (!(existingEmail == null) || !(existingPassword == null))
        {
            // print in console
            log.warn("This email {} is already in use.", existingEmail);
            model.addAttribute("errorInput", true);
            return new ModelAndView(TEMPL_REGISTER, HttpStatus.BAD_REQUEST);

        }
        // transform UserRegisterRequest to UserEntity
        var newUser = new UserEntity();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(password);
        userRepository.save(newUser);

        return new ModelAndView(TEMPL_LOGIN_SUCCESS, HttpStatus.OK);
    }

}
