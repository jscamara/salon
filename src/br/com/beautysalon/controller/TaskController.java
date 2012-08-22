/**
 * 
 */
package br.com.beautysalon.controller;

import br.com.beautysalon.model.domain.Specialty;
import br.com.beautysalon.model.domain.Task;
import br.com.beautysalon.model.domain.repository.TaskRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;

/**
 * Controladora reposnsável por {@link Task}
 * @author Jonathan
 */
@Resource
public class TaskController {
	private final Result result;
	private final Validator validator;
	private final Localization localization;
	private final TaskRepository repository;
	
	public TaskController(Result result, Validator validator, Localization localization, TaskRepository repository) {
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.repository = repository;
	}

	@Get
	public void form(){
		result.include("specialties", Specialty.values());
	}
	
	@Path("/task")
	@Post
	public void add(Task task){
		task.validate(this.validator);
		this.validator.onErrorForwardTo(TaskController.class).form();
		
		this.repository.add(task);
		this.result.include("msg", this.localization.getMessage("add.success"));
		this.result.forwardTo(TaskController.class).list();
	}
	
	@Path("/task")
	@Get
	public void list(){
		this.result.include("tasks", this.repository.list());
	}
}
