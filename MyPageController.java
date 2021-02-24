package jp.co.internous.crocus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.crocus.model.domain.MstUser;
import jp.co.internous.crocus.model.mapper.MstUserMapper;
import jp.co.internous.crocus.model.session.LoginSession;

@Controller
@RequestMapping("/crocus/mypage")
public class MyPageController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(),loginSession.getPassword());
		m.addAttribute("user",user);
		m.addAttribute("loginSession",loginSession);
		return "my_page";
	}
}
