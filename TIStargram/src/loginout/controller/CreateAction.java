package loginout.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.controller.AbstractAction;

public class CreateAction extends AbstractAction  {

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
      this.setViewPage("/Login/loginend.jsp");
      this.setRedirect(false);
   }
}