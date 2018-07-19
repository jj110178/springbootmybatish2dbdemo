package controller;

import com.example.demo.AdvertiserApplication;
import com.example.demo.controller.AdvertiserController;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdvertiserApplication.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class AdvertiserControllerTest {

  private static final int adId = 10001;
  private static final int adIdNoCredit = 10003;

  private MockMvc mockMvc;

  @Autowired
  AdvertiserController controller;

  @Before
  public void init(){
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @After
  public void tearDown(){}

  @Test
  public void getAdvertiserByIdSuccessTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/api/advertiser/"+adId))
        .andExpect(MockMvcResultMatchers.status().isOk());

  }

  @Test
  public void getAdvertiserByIdFailTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/api/advertiser/10005"))
        .andExpect(MockMvcResultMatchers.status().is4xxClientError());

  }

  @Test
  public void getAdvertiserByIdWithOutCreditLimitTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/api/advertiser/validate/"+adIdNoCredit))
        .andExpect(MockMvcResultMatchers.status().is4xxClientError());
  }

  @Test
  public void getAdvertiserByIdWithCreditLimitTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.get("/api/advertiser/validate/"+adId))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }


  @Test
  public void createNewAdvertiserTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.post("/api/advertiser/")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\"advertiserName\":\"john\",\"advertiserContactName\":\"AJ Bros\",\"creditLimit\":10000}"))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void updateAdvertiserTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.put("/api/advertiser/")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\"advertiserName\":\"johnXXX\",\"advertiserContactName\":\"AJ Bros\",\"creditLimit\":10000}"))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

  @Test
  public void deleteAdvertiserTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.delete("/api/advertiser/10005"))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }

}
