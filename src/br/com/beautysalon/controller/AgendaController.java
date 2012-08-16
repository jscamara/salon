/**
 * 
 */
package br.com.beautysalon.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.beautysalon.model.domain.Agenda;
import br.com.beautysalon.model.domain.Appointment;
import br.com.beautysalon.model.domain.Client;
import br.com.beautysalon.model.domain.Event;
import br.com.beautysalon.model.domain.Task;
import br.com.beautysalon.model.domain.repository.AgendaRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

/**
 * Controladora reponsável pela {@link Agenda}
 * @author Jonathan
 */
@Resource
public class AgendaController {
	private final Result result;
	private final AgendaRepository repository;
	
	public AgendaController(Result result, AgendaRepository repository){
		this.result = result;
		this.repository = repository;
	}
	
	@Path("/agenda")
	@Get
	public void show(){}
	
	public void getAppointmentsJson(){
		Appointment appointment = new Appointment();
		appointment.setId(1);

		Client client = new Client();
		client.setName("Jonathan");
		appointment.setClient(client);
		
		Task task = new Task();
		task.setName("Cortar Cabelo");
		appointment.setTask(task);
		appointment.setStartAt(new GregorianCalendar(2012, 07, 17, 14, 30));
		
		Appointment appointment1 = new Appointment();
		Client client1 = new Client();
		client1.setName("Jr.");
		appointment1.setClient(client1);
		
		Task task1 = new Task();
		task1.setName("Cortar Cabelo");
		appointment1.setTask(task1);
		appointment1.setStartAt(new GregorianCalendar(2012, 07, 18, 7, 00));
		
		List<Event> events = new ArrayList<>();
		events.add(appointment.asEvent());
		events.add(appointment1.asEvent());
		
		this.result.use(Results.json()).withoutRoot().from(events).serialize();
	}
}