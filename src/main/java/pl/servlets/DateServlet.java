package pl.servlets;


import org.joda.time.DateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@WebServlet("/date")
public class DateServlet extends HttpServlet {

    /**
     * Wyświetla w przeglądarce liczbe sekund od konkretnej daty
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LocalDateTime now = LocalDateTime.now(); // zmienna przechowująca date i czas aktualny
        LocalDateTime past = LocalDateTime.of(1990, 8, 2, 12, 0,0); //data od której ma wyświetlić liczbe sekund
        long seconds = ChronoUnit.SECONDS.between(past, now);
        PrintWriter responseOutput = response.getWriter();
        responseOutput.format("<html><body>%s</body></html>", "Seconds from 1990.08.02 to now: " + seconds + " s");
    }
}
