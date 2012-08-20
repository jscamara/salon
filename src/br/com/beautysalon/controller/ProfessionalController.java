/**
 * 
 */
package br.com.beautysalon.controller;

import br.com.beautysalon.model.domain.PhoneType;
import br.com.beautysalon.model.domain.Professional;
import br.com.beautysalon.model.domain.Specialty;
import br.com.beautysalon.model.domain.repository.ProfessionalRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;

/**
 * Controladora responsável pelo {@link Professional}
 * @author Jonathan
 */

@Resource
public class ProfessionalController {
	private final Result result;
	private final Validator validator;
	private final Localization localization;
	private final ProfessionalRepository repository;
	
	public ProfessionalController(Result result, Validator validator, Localization localization, ProfessionalRepository repository){
		this.result = result;
		this.validator = validator;
		this.localization = localization;
		this.repository = repository;
	}

	@Get
	public void form(){
		result.include("phoneTypes", PhoneType.values());
		result.include("specialties", Specialty.values());
	}
	
	@Path("/professional")
	@Post
	public void add(Professional professional, UploadedFile photo){
		professional.validate(this.validator);
		this.validator.onErrorForwardTo(ProfessionalController.class).form();
		
		if(this.repository.add(professional)){
			this.result.forwardTo(this).list();
		}else{
			this.result.include(professional);
			result.include("phoneTypes", PhoneType.values());
			result.include("specialties", Specialty.values());
			this.result.forwardTo(this).form();
		}
	}
	
	@Path("/professional")
	@Get
	public void list(){
		this.result.include("professionals", this.repository.list());
	}
}