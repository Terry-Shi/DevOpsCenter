package com.terry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.terry.contacts.Contact;

/**
 * Ref: http://www.jianshu.com/p/972cd6b93206
 * @author shijie
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:9000")
public class ApplicationTests {
    
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private RestTemplate restTemplate = new TestRestTemplate();
    
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    //@Test
    public void testFormBindingWithGet(){
        String url = "http://localhost:9000/requestparam";
        
        MultiValueMap<String, String> mvm = new LinkedMultiValueMap<String, String>();
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> res = rt.getForEntity(url, String.class, "");
        System.out.println(res.getBody());
//        mockMvc.perform(MockMvcRequestBuilders.get("")).andReturn(MvcResult) //.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(expectedContent))
    }
    
    //@Test
    public void testFormBindingWithPost(){
        String url = "http://localhost:9000/requestparam";
        
        MultiValueMap<String, String> mvm = new LinkedMultiValueMap<String, String>();
        //RestTemplate rt = new RestTemplate();
        mvm.add("firstName", "firstName from UT code");
        mvm.add("lastName", "lastName from UT code");
        HttpHeaders requestHeaders = new HttpHeaders();
        //requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(mvm, requestHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        //System.out.println(response.getBody());
    }
    
    @Test
    public void testRestfulPost(){
        String url = "http://localhost:9000/requestparam/restful";
        
        Contact contact = new Contact();
        contact.setFirstName("firstName in JSON");
        contact.setLastName("lastName in JSON");
        
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Contact> requestEntity = new HttpEntity<Contact>(contact, requestHeaders); // HttpEntity的类型Contact 对应HTTP Body
      
        ResponseEntity<Contact> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Contact.class);
        System.out.println("HttpResponse: " + response.getBody());
    }
}
