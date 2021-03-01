import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;


public class HttpReq {

    public static void main(String[] args) throws Exception{


        Unirest.setDefaultHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36");

//            Unirest.setProxy(new HttpHost());  --> SHOULD SET UP A PROXY, AT THE MOMENT NOT HANDLED

        String list = "MyList";

        //making a Http GET request  to yield Json
        HttpResponse<JsonNode> response = Unirest.get("http://httpbin.org/get").queryString("list",list).asJson();

           // getting the reponse body(Json here)
         System.out.println(response.getBody().getObject());


        System.out.println("\n_____________________________________________________________________\n");

         //making a HTTP POST request as a field data
        HttpResponse<JsonNode> postRes = Unirest.post("http://httpbin.org/post").field("PIN",737101).asJson();

        // getting the postRes body(Json here)
        System.out.println(postRes.getBody().getObject());

        System.out.println("\n_____________________________________________________________________\n");
        JSONObject jsonObject = new JSONObject().put("AGE",21);

        //making a HTTP POST request as body data
        HttpResponse<JsonNode> postRes2 = Unirest.post("http://httpbin.org/post").body(jsonObject).asJson();

        // getting the postRes2 body(Json here)
        System.out.println(postRes2.getBody().getObject());


    }
}
