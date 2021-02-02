package lk.ijse.dep.api; /**
 * @author : Damika Anupama Nanayakkara <damikaanupama@gmail.com>
 * @since : 01/02/2021
 **/

import lk.ijse.dep.business.BOFactory;
import lk.ijse.dep.business.BOTypes;
import lk.ijse.dep.business.custom.CourseBO;
import lk.ijse.dep.business.custom.StudentBO;
import lk.ijse.dep.dto.CourseDTO;
import lk.ijse.dep.dto.StudentDTO;
import lk.ijse.dep.exception.HttpResponseException;
import lk.ijse.dep.exception.ResponseExceptionUtil;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            super.service(req, res);
        }catch (Throwable t){
            throw new RuntimeException("Error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();

        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {
            response.setContentType("application/json");
            StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            studentBO.setEntityManager(em);
            response.getWriter().println(jsonb.toJson(studentBO.getAllStudents()));

        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, response);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {
            StudentDTO dto = jsonb.fromJson(request.getReader(), StudentDTO.class);

            if (dto.getId() == 0 || dto.getName().trim().isEmpty() || (dto.getAddress() == null) || (dto.getGender() == null)||dto.getContact().trim().isEmpty()||(dto.getDob() == null)) {
                throw new HttpResponseException(400, "Invalid details", null);
            }

            StudentBO studentBO = BOFactory.getInstance().getBO(BOTypes.STUDENT);
            studentBO.setEntityManager(em);
            studentBO.saveStudent(dto);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.setContentType("application/json");
            response.getWriter().println(jsonb.toJson(dto));
        } catch (SQLIntegrityConstraintViolationException exp) {
            throw new HttpResponseException(400, "Duplicate entry", exp);
        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {

            if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid customer id", null);
            }

            String code = req.getPathInfo().replace("/", "");
            Jsonb jsonb = JsonbBuilder.create();
            CourseDTO dto = jsonb.fromJson(req.getReader(), CourseDTO.class);

            if (dto.getCode() != null || dto.getDescription().trim().isEmpty() || (dto.getAudience() == null) || dto.getCourseFee().trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid details", null);
            }

            CourseBO customerBO = BOFactory.getInstance().getBO(BOTypes.COURSE);
            customerBO.setEntityManager(em);
            customerBO.updateCourse(dto);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {

            if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid customer id", null);
            }

            String code = req.getPathInfo().replace("/", "");

            CourseBO courseBO = BOFactory.getInstance().getBO(BOTypes.COURSE);
            courseBO.setEntityManager(em);
            courseBO.deleteCourse(code);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }
}
