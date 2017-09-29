package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.web.WebDelegatingSmartContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
    @ContextConfiguration(loader = WebDelegatingSmartContextLoader.class,locations = "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
   ,@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-security.xml")
    })
@WebAppConfiguration
public class EmployeeControllerTest {

	 @Autowired
	 private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

    }

    @Test
    public void testHome() throws Exception {

        mockMvc.perform(get("/home").param("name", "Test"))
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));

    }

    @Test
    public void testPersistenceStatus() throws Exception {

        mockMvc.perform(get("/register"))
            .andExpect(status().isOk())
            .andExpect(forwardedUrl("/WEB-INF/views/register.jsp"))
            .andExpect(model().attributeExists("emp"));

    }

}
