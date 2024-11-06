package SpringWithDB.SpringWithDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
public class SpringWithDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithDBApplication.class, args);
	}


//  use it to confirm hard loading (instead of devTools,it takes the place of devtools)
//	   @GetMapping
//     public String hello(){
//		return "API IS WORKING...";
//    }


}
