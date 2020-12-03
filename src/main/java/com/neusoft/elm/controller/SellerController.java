package com.neusoft.elm.controller;

import com.neusoft.elm.dataobject.Admin;
import com.neusoft.elm.dataobject.BuyerUser;
import com.neusoft.elm.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author QiutianDog
 * @Date 2020/12/3
 */
@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    AdminServices services;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("seller/login");
    }

    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, Map<String, Object> map) {
        Admin login = services.login(request.getParameter("adminName")
                , request.getParameter("adminPassword"));
        if (login != null) {
            map.put("msg", "ok");
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/success");
        }
        map.put("msg", "error");
        map.put("url", "/seller/login");
        return new ModelAndView("common/error");
    }
}
