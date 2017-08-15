package action;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import registerform.RegisterForm;

@SuppressWarnings("deprecation")
public class RegisterAction extends SimpleFormController{
    private String fapage;
    private String supage;
    
	public RegisterAction() {
		setCommandClass(RegisterForm.class);
	}

    @Override
     protected ModelAndView onSubmit(HttpServletRequest request,
                HttpServletResponse response, Object command, BindException errors)
                throws Exception {
        RegisterForm rf = (RegisterForm)command;
        if (rf.getAccount().equals("111111") && rf.getPassFirst().equals("123456")
                &&rf.getPassSecond().equals("123456")){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("LoginForm", rf);
            List<String> msgList = new LinkedList<String>();
            msgList.add("你好，Spring MVC");
            map.put("msg", msgList);
            return new ModelAndView(this.getSupage(),map);
        }else{
            return new ModelAndView(this.getSupage());
        }
        }
    public String getFapage() {
        return fapage;
    }


    public void setFapage(String fapage) {
        this.fapage = fapage;
    }


    public String getSupage() {
        return supage;
    }


    public void setSupage(String supage) {
        this.supage = supage;
    }
}
