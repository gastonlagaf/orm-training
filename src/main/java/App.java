import com.gastonlagaf.learn.orm.service.Service;
import com.gastonlagaf.learn.orm.service.SimpleService;

public class App {
	
	public static void main(String... args) {
		Service service = SimpleService.getInstance();
		service.performOperation();
	}
	
}
