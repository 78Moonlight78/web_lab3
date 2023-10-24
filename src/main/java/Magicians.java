import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// библиотечный класс для работы с потоками вывода
import java.io.PrintWriter;
/**
 * Servlet implementation class BooksList
 */

public class Magicians extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    private static final long serialVersionUID = 1L;
    private Object[][] team;
    private String[] roles;

    public Magicians() {
        super();
        // TODO Auto-generated constructor stub
        team = new Object[][] {
                {"Иванов Антон",  "Москва", 1500},
                {"Петрова Алла",  "Санкт-Петербург", 3000},
                {"Антонов Алексей",  "Красноярск", 2500},
                {"Смирнова Валерия", "Краснодар", 1900}
        };

    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
// Задание типа кодировки для параметров запроса
        request.setCharacterEncoding("utf-8");
        // Чтение параметра name из запроса
        String salary = request.getParameter("salary");
        // Задание типа содержимого для ответа (в том числе кодировки)
        response.setContentType("text/html;charset=UTF-8");
        // Получение потока для вывода ответа
        PrintWriter out = response.getWriter();
        try {
            // Создание HTML-страницы
            out.println("<html>");
            out.println("<head><title>Список Фокусников</title></head>");
            out.println("<body>");
            out.println("<h1>Фокусники" + ((salary ==
                    null)? " ": " с зарплатой >= "
                    + salary + "$") + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Имя фамилия</b></td>"
                    + "<td><b>Город</b></td>"
                    + "<td><b>Зарплата</b></td></tr>");
            for (Object[] temp : team)
                if (salary == null || (int)temp[2] >=
                        Integer.parseInt(salary))
                    out.println("<tr><td>" + temp[0] +
                           "</td><td>"
                            + temp[1] + "</td><td>" +
                            Integer.toString((int)temp[2]) + "</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            // Закрытие потока вывода
            out.close();
        }
    }
/**
 * Handles the HTTP
 * <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}