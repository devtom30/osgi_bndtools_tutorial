package org.example.command;

import org.apache.felix.service.command.CommandProcessor;
import org.example.api.Greeting;
import aQute.bnd.annotation.component.*;

@Component(properties =	{
		/* Felix GoGo Shell Commands */
		CommandProcessor.COMMAND_SCOPE + ":String=example",
		CommandProcessor.COMMAND_FUNCTION + ":String=greet"
	},
	provide = Object.class
)
public class GreetingCommand {
	private Greeting greetingSvc;

	@Reference
	public void setGreeting(Greeting greetingSvc) {
		this.greetingSvc = greetingSvc;
	}

	public void greet(String name) {
		System.out.println(greetingSvc.sayHello(name));
	}
}