package APITests;

import GroupData.Course;
import GroupData.Faculty;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.get;

public class ApiTests {
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://18.185.249.19/api/commands/";
        RestAssured.requestSpecification = new RequestSpecBuilder().log(LogDetail.ALL).setAccept(ContentType.JSON).setContentType(ContentType.JSON).build();
    }

    @DataProvider
    public Object[][] apiTestData() {
        return new Object[][] {
                {21312}, // Факультет управления, Очная форма обучения, 2 курс, 12 неделя
                //{31411}, // Факультет экономики и финансов, Очная форма обучения, 4 курс, 11 неделя
                //{41111}, // Факультет юридический, Очная форма обучения, 1 курс, 11 неделя
                {11212},  // Факультут информационных технологий, Очная форма обучения, 2 курс, 12 неделя
                {11211}   // Факультут информационных технологий, Очная форма обучения, 2 курс, 11 неделя
        };
    }

    @Test(dataProvider = "apiTestData")
    public void apiTest(Integer timeTableCode) {
        Response response = get(Integer.toString(timeTableCode)).then().statusCode(200).extract().response();
        Assert.assertEquals(JsonResponseParser.parse(response, "faculty"), Faculty.facultyData.get(timeTableCode / 10000));
        Assert.assertEquals(JsonResponseParser.parse(response, "cource"), Course.courseData.get((timeTableCode / 100) % 10));
        Assert.assertEquals(JsonResponseParser.parse(response, "weekId"), (Integer.toString(timeTableCode % 100) + " неделя"));

    }
}
