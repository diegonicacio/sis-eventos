<fieldset <c:if test="${action == 'show'}">disabled</c:if>>


	<div class="row">
		<div class="form-group col-lg-4">
			<label>Tema:</label> <input type="text" class="form-control"
				name="minicurso.tema" placeholder="Ex: Semana Interna da Computação"
				value="${minicurso.tema}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Data:</label> <input type="date" class="form-control"
				name="minicurso.dataInicio" placeholder="Ex: 26/05/1990"
				value="${minicurso.dataInicio.time}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Preco:</label> <input type="text" class="form-control"
				name="minicurso.precoMinicurso" placeholder="Ex: R$15,00"
				value="${minicurso.precoMinicurso}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Quantidade de vagas:</label> <input type="text"
				class="form-control" name="minicurso.vagas" placeholder="Ex: 50"
				value="${minicurso.vagas}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Palestrante:</label> <input type="text" class="form-control"
				name="minicurso.palestrante.nome" placeholder="Ex: Joao do Caminhão"
				value="${minicurso.palestrante}" />
		</div>
	</div>

	<div class="form-group col-lg-4">
		<label>Descricao:</label>
		<textarea class="form-control" rows="6" name="minicurso.descricao">${minicurso.descricao}</textarea>
	</div>


</fieldset>

