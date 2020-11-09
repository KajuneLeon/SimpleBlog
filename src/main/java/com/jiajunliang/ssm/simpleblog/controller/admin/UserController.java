package com.jiajunliang.ssm.simpleblog.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiajunliang.ssm.simpleblog.bean.User;
import com.jiajunliang.ssm.simpleblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @project: SimpleBlog
 * @program: UserController
 * @description: Controller for User Service
 * @author: JIAJUN LIANG
 * @create: 2020-10-30 15:12
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"})
    public String loginPage(@CookieValue(value = "username", required = false) String username,
                            @CookieValue(value = "password", required = false) String password,
                            @CookieValue(value = "rememberMe", required = false) String rememberMe,
                            Model model,
                            HttpServletRequest request) {
        // Already login
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/admin";
        }

        // cookies reading
        model.addAttribute("cookieUsername", username);
        model.addAttribute("cookiePassword", password);
        model.addAttribute("cookieRememberMe", rememberMe);
        return "/Admin/User/login";
    }

    /**
     * Login verification
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return homepage if success, login page if fail
     */
    @RequestMapping(value = {"/loginVerify"})
    public String loginVerify(HttpServletRequest request, HttpServletResponse response){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        User loginUser = userService.login(username, password);

        // successful login
        if (loginUser != null) {
            // cookie process
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
            Cookie rememberMeCookie = new Cookie("rememberMe", "checked");
            if (rememberMe != null) {
                // remember username & password
                // save cookie for 7 days
                usernameCookie.setMaxAge(60*60*24*7);
                passwordCookie.setMaxAge(60*60*24*7);
                rememberMeCookie.setMaxAge(60*60*24*7);
            } else {
                // delete username & password cookie
                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
                rememberMeCookie.setMaxAge(0);
            }
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            response.addCookie(rememberMeCookie);
            // session process
            request.getSession().setAttribute("user", loginUser);
            return "redirect:/admin";
        } else {
            // failed login
            request.setAttribute("errorMsg", "用户名不存在或密码错误");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            return "forward:/login";
        }
    }

    /**
     * User logout
     * @param request HttpServletRequest
     * @return homepage
     */
    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    /**
     * Forward to user edit page
     * @return user edit page
     */
    @RequestMapping(value = {"/admin/user"})
    public String userEdit() {
        return "/Admin/User/edit";
    }

    /**
     * Save user update info
     * @param userId id
     * @param user user info
     * @param request HttpServletRequest
     * @return same page
     */
    @RequestMapping(value = "/admin/user/update/{userId}", method = RequestMethod.PUT)
    public String userUpdate(@PathVariable("userId") String userId, User user, HttpServletRequest request) {
        boolean updateSuccess = userService.updateUser(user);
        if (updateSuccess) {
            request.setAttribute("msg", "保存成功！");
            request.getSession().setAttribute("user", user);
        } else {
            request.setAttribute("msg", "保存失败，请稍后再试！");
        }
        return "/Admin/User/edit";
    }

    /**
     * Check username whether exists
     * @return json
     */
    @RequestMapping(value = "/admin/user/checkUserName", method = RequestMethod.GET)
    @ResponseBody
    public String checkUserName(Integer userId, String userName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (userService.existUserName(userName)) {
            User tempUser = userService.getUserByUserName(userName);
            if (tempUser.getUserId() != userId) {
                return objectMapper.writeValueAsString("用户名已存在！");
            }
        }
        return objectMapper.writeValueAsString("用户名可用！");
    }

    @RequestMapping(value = "/admin/user/updatePortrait")
    public String userPortraitUpdate(MultipartFile portrait, HttpServletRequest request) throws IOException {
        // upload
        User user = (User) request.getSession().getAttribute("user");
        String fileName = user.getUserName() + "Portrait-"+ portrait.getOriginalFilename();

        portrait.transferTo(new File("D:\\JavaProject\\SimpleBlog-uploads\\user\\" + fileName));

        user.setUserPortrait("/uploads/user/"+fileName);
        // save
        boolean updateSuccess = userService.updateUser(user);
        if (updateSuccess) {
            request.setAttribute("msg", "保存成功！");
            request.getSession().setAttribute("user", user);
        } else {
            request.setAttribute("msg", "保存失败，请稍后再试！");
        }
        return "/Admin/User/edit";
    }


}
