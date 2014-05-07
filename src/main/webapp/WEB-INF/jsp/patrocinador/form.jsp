<fieldset <c:if test="${action == 'show'}">disabled</c:if>>


	<div class="row">
		<div class="form-group col-lg-4">
			<label>Tema:</label> <input type="text" class="form-control"
				name="patrocinador.tema" placeholder="Ex: Semana Interna da Computação"
				value="${patrocinador.nome}" />
		</div>
	</div>

	<div class="form-group col-lg-4">
		<label>Descricao:</label>
		<textarea class="form-control" rows="6" name="patrocinador.descricao">${patrocinador.descricao}</textarea>
	</div>


</fieldset>

