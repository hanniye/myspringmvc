package action;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import loginform.LoginForm;

public class LoginAction extends SimpleFormController
{
	private String failPage;
	private String successPage;
	
	public LoginAction() {
		setCommandClass(LoginForm.class);
	}
    protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
                    throws Exception {
        LoginForm lf = (LoginForm)command;
        if (lf.getAccount().equals("111111") && lf.getPassword().equals("123456")){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("LoginForm", lf);
            List<String> msgList = new LinkedList<String>();
            msgList.add("你好，Spring MVC");
            map.put("msg", msgList);
            System.out.println("登录成功");
            return new ModelAndView(this.getSuccessPage(),map); 
        }else{
            return new ModelAndView(this.getFailPage());
        }
    }

	public String getFailPage() {
		return failPage;
	}

	public void setFailPage(String failPage) {
		this.failPage = failPage;
	}

	public String getSuccessPage() {
		return successPage;
	}

	public void setSuccessPage(String successPage) {
		this.successPage = successPage;
	}
}