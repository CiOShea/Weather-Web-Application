package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import utils.OpenWeatherAPIUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class WeatherController {
    @RequestMapping("/weather")
    public String getWeather (HttpServletRequest req) throws IOException {

        HttpSession session = req.getSession();
        String city = req.getParameter("city");
        InputStream location = OpenWeatherAPIUtils.requestByLocation(city);
        String details = OpenWeatherAPIUtils.getDetails(location);
        session.setAttribute("city", city);
        session.setAttribute("details", details);
        return "weather.jsp";
    }
}
