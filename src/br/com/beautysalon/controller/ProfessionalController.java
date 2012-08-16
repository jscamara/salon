/**
 * 
 */
package br.com.beautysalon.controller;

import br.com.beautysalon.model.domain.PhoneType;
import br.com.beautysalon.model.domain.Professional;
import br.com.beautysalon.model.domain.repository.ProfessionalRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

/**
 * Controladora responsável pelo {@link Professional}
 * @author Jonathan
 */

@Resource
public class ProfessionalController {
	private final ProfessionalRepository repository;
	private final Result result;
	
	public ProfessionalController(ProfessionalRepository repository, Result result){
		this.repository = repository;
		this.result = result;
	}

	@Path("/professional")
	@Get
	public void form(){
		result.include("phoneTypes", PhoneType.values());
	}
	
	@Path("/professional")
	@Post
	public void add(Professional professional, UploadedFile photo){
		if(professional.validate()){
			this.repository.add(professional);
			this.result.forwardTo(this).form();
		}
	}
	
	@Path("/professional/list")
	@Get
	public void list(){
		this.result.include("professionals", this.repository.list());
	}
}
