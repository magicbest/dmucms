package com.safewind.dmucms.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.safewind.dmucms.domain.User;
import com.safewind.dmucms.service.IUserLoginService;

@Controller
public class UserLoginControler {

    @Autowired
    private IUserLoginService<User> UserLoginServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String get(@RequestParam(value = "id") Integer id, Model model) {
        User user = UserLoginServiceImpl.getUserInfo(id);
        model.addAttribute(user);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password) {

        Integer loginResult = UserLoginServiceImpl.checkUserLoginInfo(id, password);

        if (loginResult == 0) {
            return "login";
        } else {
            return "index";
        }
    }
}
