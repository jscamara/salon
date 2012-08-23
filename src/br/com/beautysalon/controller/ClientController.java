/**
 * 
 */
package br.com.beautysalon.controller;

import br.com.beautysalon.model.domain.Client;
import br.com.beautysalon.model.domain.PhoneType;
import br.com.beautysalon.model.domain.repository.ClientRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

/**
 * Controladora responsável pelo {@link Client}
 * @author Jonathan
 *
 */
@Resource
public class ClientController {
	private final Result result;
	private final Validator validator;
	private final Localization localization;
	private final ClientRepository repository;
	
	public ClientController(Result result, Validator validator, Localization localization, ClientRepository repository){
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.repository = repository;
	}
	
	@Get
	public void form(){
		this.result.include("phoneTypes", PhoneType.values());
	}
	
	@Path("/client")
	@Post
	public void add(Client client, UploadedFile file){
		client.validate(this.validator);
		this.validator.onErrorForwardTo(ClientController.class).form();
		
		this.repository.add(client);
		this.result.include("msg", this.localization.getMessage("add.success"));
		this.result.forwardTo(ClientController.class).list();
	}
	
	@Path("/client")
	@Get
	public void list(){
		this.result.include("clients", this.repository.list());
	}
}