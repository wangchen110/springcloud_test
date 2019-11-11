package conf;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <br>Title: LoginFilter
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/8/15:51
 */
public class LoginFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(null!=token || token.trim().equals(""))
        {
            currentContext.setSendZuulResponse(false); //拦截
            currentContext.setResponseStatusCode(HttpStatus.SC_METHOD_FAILURE);
            try {
                currentContext.getResponse().sendRedirect("http://www.baidu.com");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
