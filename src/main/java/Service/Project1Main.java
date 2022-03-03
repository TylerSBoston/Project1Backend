package Service;

import io.javalin.Javalin;

public class Project1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Javalin myServer = Javalin.create().start(4040);
		System.out.println("port 4040");
		myServer.get("/hi", ctx -> ctx.result("Hello"));
		
		
		myServer.get("/RequestsPending", (ctx)-> {
			
			
		});
		
		myServer.get("/RequestsResolved", (ctx)-> {
			
			
		});
		myServer.get("/RequestsAll", (ctx)-> {
			
			
		});
		myServer.get("/RequestsEmployee/{bid}", (ctx)-> {
			
			
		});
	}

}
