<fieldset <c:if test="${action == 'show'}">disabled</c:if>>


	<div class="row">
		<div class="form-group col-lg-4">
			<label>Tema:</label> <input type="text" class="form-control"
				name="palestra.tema" placeholder="Ex: Semana Interna da Computação"
				value="${palestra.tema}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Data:</label> <input type="date" class="form-control"
				name="palestra.dataInicio" placeholder="Ex: 26/05/1990"
				value="${palestra.dataInicio.time}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Preco:</label> <input type="text" class="form-control"
				name="palestra.precoMinicurso" placeholder="Ex: R$15,00"
				value="${palestra.precoMinicurso}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Quantidade de vagas:</label> <input type="text"
				class="form-control" name="palestra.vagas" placeholder="Ex: 50"
				value="${palestra.vagas}" />
		</div>
	</div>

	<div class="row">
		<div class="form-group col-lg-4">
			<label>Palestrante:</label> <input type="text" class="form-control"
				name="palestra.palestrante.nome" placeholder="Ex: Joao do Caminhão"
				value="${palestra.palestrante}" />
		</div>
	</div>

	<div class="form-group col-lg-4">
		<label>Descricao:</label>
		<textarea class="form-control" rows="6" name="palestra.descricao">${palestra.descricao}</textarea>
	</div>


</fieldset>

